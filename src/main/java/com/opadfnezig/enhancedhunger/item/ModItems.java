package com.opadfnezig.enhancedhunger.item;

import com.opadfnezig.enhancedhunger.ModItemGroup;
import com.opadfnezig.enhancedhunger.item.base.DurableFoodItem;
import com.opadfnezig.enhancedhunger.item.base.DurableItem;
import com.opadfnezig.enhancedhunger.EnhancedHunger;
import com.opadfnezig.enhancedhunger.item.base.EHTool;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Properties;

public class ModItems {


    static Item.Properties DEFAULT_PROPERTIES;
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EnhancedHunger.MOD_ID);

    public static final RegistryObject<Item> SHEET = ITEMS.register("crap", () -> {
        Item.Properties prop = new Item.Properties();
        prop.food(new Food.Builder().saturation(1f).hunger(-20).setAlwaysEdible().build());
        return new Item(prop);
    });

    //RAW

    public static final RegistryObject<Item> APPLE = Utils.regVanillaFoodAnalog("apple", Items.APPLE.getFood().getSaturation(), Items.APPLE);
    //public static final RegistryObject<Item> BEETROOT = Utils.regVanillaFoodAnalog("beetroot",Items.BEETROOT.getFood().getSaturation(),Items.BEETROOT);
    public static final RegistryObject<Item> CARROT = Utils.regVanillaFoodAnalog("carrot", Items.CARROT.getFood().getSaturation(), Items.CARROT);
    //no chorus
    public static final RegistryObject<Item> MELON_SLICE = Utils.regVanillaFoodAnalog("melon_slice", Items.MELON_SLICE.getFood().getSaturation(), Items.MELON_SLICE);
    public static final RegistryObject<Item> POTATO = Utils.regRawVanillaFoodAnalog("potato", Items.POTATO.getFood().getSaturation(), Items.POTATO);
    public static final RegistryObject<Item> SWEET_BERRIES = Utils.regVanillaFoodAnalog("sweet_berries", Items.SWEET_BERRIES.getFood().getSaturation(), Items.SWEET_BERRIES);

    //PROCEEDED
    public static final RegistryObject<Item> BREAD = Utils.regVanillaFoodAnalog("bread", Items.BREAD.getFood().getSaturation(), Items.BREAD);
    public static final RegistryObject<Item> COOKIE = Utils.regVanillaFoodAnalog("cookie", Items.COOKIE.getFood().getSaturation(), Items.COOKIE);
    public static final RegistryObject<Item> GOLDEN_CARROT = Utils.regVanillaFoodAnalog("golden_carrot", Items.GOLDEN_CARROT.getFood().getSaturation(), Items.GOLDEN_CARROT);
    //actually,should i?
    public static final RegistryObject<Item> HONEY_BOTTLE = Utils.regVanillaFoodAnalog("honey_bottle", Items.HONEY_BOTTLE.getFood().getSaturation(), Items.HONEY_BOTTLE);
    public static final RegistryObject<Item> PUMPKIN_PIE = Utils.regVanillaFoodAnalog("pumpkin_pie", Items.PUMPKIN_PIE.getFood().getSaturation(), Items.PUMPKIN_PIE);


    //COOKED
    public static final RegistryObject<Item> BAKED_POTATO = Utils.regVanillaFoodAnalog("baked_potato", Items.BAKED_POTATO.getFood().getSaturation(), Items.BAKED_POTATO);
    //u just shouldn't do this
    //public static final RegistryObject<Item> DRIED_KELP = Utils.regVanillaFoodAnalog(Items.DRIED_KELP);

    //SOUPS AND STEWS
    //actually,should we register this?
    //public static final RegistryObject<Item> BEETROOT_SOUP = registerVanillaFoodAnalog(Items.BEETROOT_SOUP);
    //public static final RegistryObject<Item> MUSHROOM_STEW = registerVanillaFoodAnalog(Items.MUSHROOM_STEW);
    //public static final RegistryObject<Item> RABBIT_STEW = registerVanillaFoodAnalog(Items.RABBIT_STEW);

    //RAW_MEAT
    public static final RegistryObject<Item> BEEF = Utils.regRawVanillaFoodAnalog("beef", Items.BEEF.getFood().getSaturation(), Items.BEEF);
    public static final RegistryObject<Item> CHICKEN = Utils.regRawVanillaFoodAnalog("chicken", Items.CHICKEN.getFood().getSaturation(), Items.CHICKEN);
    public static final RegistryObject<Item> MUTTON = Utils.regRawVanillaFoodAnalog("mutton", Items.MUTTON.getFood().getSaturation(), Items.MUTTON);
    //TODO:SUETA + smoked suet
    public static final RegistryObject<Item> PORKCHOP = Utils.regRawVanillaFoodAnalog("porkchop", Items.PORKCHOP.getFood().getSaturation(), Items.PORKCHOP);
    public static final RegistryObject<Item> RABBIT = Utils.regRawVanillaFoodAnalog("rabbit", Items.RABBIT.getFood().getSaturation(), Items.RABBIT);

    //COOKED_MEAT
    public static final RegistryObject<Item> COOKED_BEEF = Utils.regVanillaFoodAnalog("cooked_beef", Items.COOKED_BEEF.getFood().getSaturation(), Items.COOKED_BEEF);
    public static final RegistryObject<Item> COOKED_CHICKEN = Utils.regVanillaFoodAnalog("cooked_chicken", Items.COOKED_CHICKEN.getFood().getSaturation(), Items.COOKED_CHICKEN);
    public static final RegistryObject<Item> COOKED_MUTTON = Utils.regVanillaFoodAnalog("cooked_mutton", Items.COOKED_MUTTON.getFood().getSaturation(), Items.COOKED_MUTTON);
    public static final RegistryObject<Item> COOKED_PORKCHOP = Utils.regVanillaFoodAnalog("cooked_porkchop", Items.COOKED_PORKCHOP.getFood().getSaturation(), Items.COOKED_PORKCHOP);
    public static final RegistryObject<Item> COOKED_RABBIT = Utils.regVanillaFoodAnalog("cooked_rabbit", Items.COOKED_RABBIT.getFood().getSaturation(), Items.COOKED_RABBIT);

    //FISH
    public static final RegistryObject<Item> COD = Utils.regRawVanillaFoodAnalog("cod", Items.COD.getFood().getSaturation(), Items.COD);
    public static final RegistryObject<Item> SALMON = Utils.regRawVanillaFoodAnalog("salmon", Items.SALMON.getFood().getSaturation(), Items.SALMON);
    //public static final RegistryObject<Item> TROPICAL_FISH = registerVanillaFoodAnalog(Items.TROPICAL_FISH);

    //COOKED_FISH
    public static final RegistryObject<Item> COOKED_COD = Utils.regVanillaFoodAnalog("cooked_cod", Items.COOKED_COD.getFood().getSaturation(), Items.COOKED_COD);
    public static final RegistryObject<Item> COOKED_SALMON = Utils.regVanillaFoodAnalog("cooked_salmon", Items.COOKED_SALMON.getFood().getSaturation(), Items.COOKED_SALMON);

    //SEEDS
    public static final RegistryObject<Item> CARROT_SEEDS = ITEMS.register("carrot_seeds",()-> new BlockNamedItem(Blocks.CARROTS,new Item.Properties().group(ModItemGroup.MOD_GROUP)));
    public static final RegistryObject<Item> POTATO_SEEDS = ITEMS.register("potato_seeds",()-> new BlockNamedItem(Blocks.POTATOES,new Item.Properties().group(ModItemGroup.MOD_GROUP)));
    //TOOLS
    public static final RegistryObject<EHTool> SEED_EXTRACTOR = ITEMS.register("seed_extractor", () -> new EHTool(ItemTier.WOOD, 5f, -2.4f, new Item.Properties().group(ModItemGroup.MOD_GROUP).maxDamage(1024)));
    public static final RegistryObject<EHTool> KNIFE = ITEMS.register("knife", () -> new EHTool(ItemTier.WOOD, 5f, -2.4f, new Item.Properties().group(ModItemGroup.MOD_GROUP).maxDamage(1024)));

    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour", () -> {
        Item.Properties properties = new Item.Properties();
        properties.maxStackSize(16);
        properties.maxDamage(DurableFoodItem.DIVIDER * DurableFoodItem.MAX_DURABILITY);
        properties.group(ModItemGroup.MOD_GROUP);
        return new Item(Utils.getDefaultProp(1, DurableFoodItem.DIVIDER * DurableFoodItem.MAX_DURABILITY, ModItemGroup.MOD_GROUP));
    });

    private static class Utils {
        private static RegistryObject<Item> regVanillaFoodAnalog(String name, float saturation, Item item) {
            return ITEMS.register(name, () -> {
                return new DurableFoodItem(getDefaultFoodProp(
                        new Food.Builder().hunger(1).saturation(saturation).build()));
            });
        }

        private static RegistryObject<Item> regRawVanillaFoodAnalog(String name, float saturation, Item item) {
            return ITEMS.register(name, () -> {
                return new DurableItem(getDefaultProp(1, DurableItem.MAX_DURABILITY, ModItemGroup.MOD_GROUP));
            });
        }

        private static Item.Properties getDefaultFoodProp(Food food) {
            Item.Properties properties = new Item.Properties();
            properties.maxStackSize(1);
            properties.maxDamage(DurableFoodItem.DIVIDER * DurableFoodItem.MAX_DURABILITY);
            properties.group(ModItemGroup.MOD_GROUP);
            properties.food(food);
            properties.setNoRepair();
            //properties.containerItem(Items.ROTTEN_FLESH);
            return properties;
        }

        private static Item.Properties getDefaultProp(int maxStackSize, int maxDamage, ItemGroup group) {
            Item.Properties properties = new Item.Properties();
            properties.maxStackSize(maxStackSize);
            properties.maxDamage(maxDamage);
            properties.group(group);
            properties.setNoRepair();
            //properties.containerItem(new Item(null))
            return properties;
        }
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
