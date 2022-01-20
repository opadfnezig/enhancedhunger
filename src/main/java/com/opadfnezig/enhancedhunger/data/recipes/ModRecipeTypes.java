package com.opadfnezig.enhancedhunger.data.recipes;

import com.opadfnezig.enhancedhunger.EnhancedHunger;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipeTypes {
    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, EnhancedHunger.MOD_ID);

    public static final RegistryObject<SeedExtractionRecipe.Serializer> SEEDEXTRACTOR_SERIALIZER = RECIPE_SERIALIZER.register("seed_extractor", SeedExtractionRecipe.Serializer::new);
    public static final RegistryObject<FoodRepairRecipe.Serializer> FOODREPAIR_SERIALIZER = RECIPE_SERIALIZER.register("food_repair",FoodRepairRecipe.Serializer::new);

    public static IRecipeType<SeedExtractionRecipe> SEEDEXTRACTOR_RECIPE= new SeedExtractionRecipe.SeedExtractionRecipeType();
    public static IRecipeType<FoodRepairRecipe> FOODREPAIR_RECIPE = new FoodRepairRecipe.FoodRepairRecipeType();

    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZER.register(eventBus);

        /*Registry.register(Registry.RECIPE_TYPE, SeedExtractionRecipe.TYPE_ID,SEEDEXTRACTOR_RECIPE);*/
        Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(EnhancedHunger.MOD_ID, "food_repair"),FOODREPAIR_RECIPE);
    }
}
