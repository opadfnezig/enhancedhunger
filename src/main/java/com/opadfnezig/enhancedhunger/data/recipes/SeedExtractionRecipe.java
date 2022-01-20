package com.opadfnezig.enhancedhunger.data.recipes;

import com.google.gson.JsonObject;
import com.opadfnezig.enhancedhunger.item.ModItems;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class SeedExtractionRecipe implements  ISeedExtractionRecipe{

    private final Ingredient recipeItem;
    private final ItemStack output;
    private final ResourceLocation id;

    public SeedExtractionRecipe(ResourceLocation id, Ingredient recipeItem, ItemStack output){
        this.recipeItem = recipeItem;
        this.output = output;
        this.id = id;
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        for(int i = 0; i < 4;++i)
            if(recipeItem.test(inv.getStackInSlot(i)))
                break;
            else if(i == 3)
                return false;
        for(int i = 0; i < 4;++i)
            if(inv.getStackInSlot(i).getItem().equals(ModItems.SEED_EXTRACTOR))
                return true;
        return false;
    }

    @Override
    public ItemStack getCraftingResult(IInventory inv) {
        return output;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return null;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipeTypes.SEEDEXTRACTOR_SERIALIZER.get();
    }

    public static class SeedExtractionRecipeType implements IRecipeType<SeedExtractionRecipe> {
        @Override
        public String toString(){
            return SeedExtractionRecipe.TYPE_ID.toString();
        }
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements  IRecipeSerializer<SeedExtractionRecipe>
    {

        @Override
        public SeedExtractionRecipe read(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json,"output"));
            Ingredient recipeItem = Ingredient.deserialize(JSONUtils.getJsonObject(json,"ingredient"));
            return new SeedExtractionRecipe(recipeId,recipeItem,output);
        }

        @Nullable
        @Override
        public SeedExtractionRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
            Ingredient input = Ingredient.EMPTY;
            input = Ingredient.read(buffer);
            ItemStack output = buffer.readItemStack();
            return new SeedExtractionRecipe(recipeId,input,output);
        }

        @Override
        public void write(PacketBuffer buffer, SeedExtractionRecipe recipe) {
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.write(buffer);
            }
            buffer.writeItemStack(recipe.getRecipeOutput(), false);
        }
    }

}
