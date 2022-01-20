package com.opadfnezig.enhancedhunger.data.recipes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.opadfnezig.enhancedhunger.EnhancedHunger;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class FoodRepairRecipe extends ShapelessRecipe {
    public FoodRepairRecipe(ResourceLocation idIn, String groupIn, ItemStack recipeOutputIn, NonNullList<Ingredient> recipeItemsIn) {
        super(idIn, groupIn, recipeOutputIn, recipeItemsIn);
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(final CraftingInventory inv) {

        ItemStack buff = new ItemStack(null);
        ItemStack item = new ItemStack(null);
        int damageCounter = 0;
        for(int i = 0; i < inv.getSizeInventory(); ++i) {
            buff = inv.getStackInSlot(i);
            if(buff.getItem() != Items.AIR) {
                item = buff.copy();
                damageCounter += buff.getDamage();
            }
        }

        final NonNullList<ItemStack> remainingItems = NonNullList.withSize(inv.getSizeInventory(), ItemStack.EMPTY);
        int durabilityLeft = item.getMaxDamage() - damageCounter;
        if(durabilityLeft > 0)
        {
            item = new ItemStack(item.getItem());
            item.setDamage(item.getMaxDamage() - durabilityLeft);
            remainingItems.set(0,item);
        }
        return remainingItems;
    }

    @Override
    public ItemStack getCraftingResult(CraftingInventory inv)
    {
        ItemStack stack = getRecipeOutput().copy();
        ItemStack buff = new ItemStack(null);
        int damageCounter = 0;
        for(int i = 0; i < inv.getSizeInventory(); ++i) {
            buff = inv.getStackInSlot(i);
            if(buff.getItem() != Items.AIR)
                damageCounter += buff.getDamage();
        }

        int durabilityLeft = stack.getMaxDamage()*2 - damageCounter;
        if(durabilityLeft > getRecipeOutput().getMaxDamage())
            stack.setDamage(0);
        else
            stack.setDamage(stack.getMaxDamage() - durabilityLeft);

        return stack;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.FOODREPAIR_SERIALIZER.get();
    }

    public static class Serializer extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<FoodRepairRecipe> {
        private static final ResourceLocation NAME = new ResourceLocation(EnhancedHunger.MOD_ID, "food_repair");
        public FoodRepairRecipe read(ResourceLocation recipeId, JsonObject json) {
            String s = JSONUtils.getString(json, "group", "");
            NonNullList<Ingredient> nonnulllist = readIngredients(JSONUtils.getJsonArray(json, "ingredients"));
            if (nonnulllist.isEmpty()) {
                throw new JsonParseException("No ingredients for shapeless recipe");
            } else if (nonnulllist.size() > 3 * 3) {
                throw new JsonParseException("Too many ingredients for shapeless recipe the max is " + (3 * 3));
            } else {
                ItemStack itemstack = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));
                return new FoodRepairRecipe(recipeId, s, itemstack, nonnulllist);
            }
        }

        private static NonNullList<Ingredient> readIngredients(JsonArray ingredientArray) {
            NonNullList<Ingredient> nonnulllist = NonNullList.create();

            for(int i = 0; i < ingredientArray.size(); ++i) {
                Ingredient ingredient = Ingredient.deserialize(ingredientArray.get(i));
                if (!ingredient.hasNoMatchingItems()) {
                    nonnulllist.add(ingredient);
                }
            }

            return nonnulllist;
        }

        public FoodRepairRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            String s = buffer.readString(32767);
            int i = buffer.readVarInt();
            NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);

            for(int j = 0; j < nonnulllist.size(); ++j) {
                nonnulllist.set(j, Ingredient.read(buffer));
            }

            ItemStack itemstack = buffer.readItemStack();
            return new FoodRepairRecipe(recipeId, s, itemstack, nonnulllist);
        }

        @Override
        public void write(PacketBuffer buffer, FoodRepairRecipe recipe) {
            buffer.writeString(recipe.getGroup());
            buffer.writeVarInt(recipe.getIngredients().size());

            for(Ingredient ingredient : recipe.getIngredients()) {
                ingredient.write(buffer);
            }

            buffer.writeItemStack(recipe.getRecipeOutput());
        }
    }
    public static class FoodRepairRecipeType implements IRecipeType<FoodRepairRecipe> {
        @Override
        public String toString(){
            return new ResourceLocation(EnhancedHunger.MOD_ID, "food_repair").toString();
        }
    }
}