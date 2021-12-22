package com.opadfnezig.enhancedhunger.item;

import com.opadfnezig.enhancedhunger.DurableFoodItem;
import com.opadfnezig.enhancedhunger.EnhancedHunger;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    static ItemGroup FOOD_ITEM_GROUP = ItemGroup.FOOD;

    static Item.Properties DEFAULT_PROPERTIES;


    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EnhancedHunger.MOD_ID);

    public static final RegistryObject<Item> SHEET =  ITEMS.register("crap",()->{
        Item.Properties prop = new Item.Properties();
        prop.food(new Food.Builder().saturation(1f).hunger(-20).setAlwaysEdible().build());
        return new Item(prop);
    });

    //RAW

    public static final RegistryObject<Item> APPLE = registerVanillaFoodAnalog("apple",Items.APPLE.getFood().getSaturation(),Items.APPLE);
    public static final RegistryObject<Item> BEETROOT = registerVanillaFoodAnalog("beetroot",Items.BEETROOT.getFood().getSaturation(),Items.BEETROOT);
    public static final RegistryObject<Item> CARROT = registerVanillaFoodAnalog("carrot",Items.CARROT.getFood().getSaturation(),Items.CARROT);
    //no chorus
    public static final RegistryObject<Item> MELON_SLICE = registerVanillaFoodAnalog("melon_slice",Items.MELON_SLICE.getFood().getSaturation(),Items.MELON_SLICE);
    public static final RegistryObject<Item> POTATO = registerRawVanillaFoodAnalog("potato",Items.POTATO.getFood().getSaturation(),Items.POTATO);
    public static final RegistryObject<Item> SWEET_BERRIES = registerVanillaFoodAnalog("sweet_berries",Items.SWEET_BERRIES.getFood().getSaturation(),Items.SWEET_BERRIES);

    //PROCEEDED
    public static final RegistryObject<Item> BREAD = registerVanillaFoodAnalog("bread",Items.BREAD.getFood().getSaturation(),Items.BREAD);
    public static final RegistryObject<Item> COOKIE = registerVanillaFoodAnalog("cookie",Items.COOKIE.getFood().getSaturation(),Items.COOKIE);
    public static final RegistryObject<Item> GOLDEN_CARROT = registerVanillaFoodAnalog("golden_carrot",Items.GOLDEN_CARROT.getFood().getSaturation(),Items.GOLDEN_CARROT);
    //actually,should i?
    public static final RegistryObject<Item> HONEY_BOTTLE = registerVanillaFoodAnalog("honey_bottle",Items.HONEY_BOTTLE.getFood().getSaturation(),Items.HONEY_BOTTLE);
    public static final RegistryObject<Item> PUMPKIN_PIE = registerVanillaFoodAnalog("pumpkin_pie",Items.PUMPKIN_PIE.getFood().getSaturation(),Items.PUMPKIN_PIE);

    //COOKED
    public static final RegistryObject<Item> BAKED_POTATO = registerVanillaFoodAnalog("baked_potato",Items.BAKED_POTATO.getFood().getSaturation(),Items.BAKED_POTATO);
    //u just shouldn't do this
    //public static final RegistryObject<Item> DRIED_KELP = registerVanillaFoodAnalog(Items.DRIED_KELP);

    //SOUPS AND STEWS
    //actually,should we register this?
    //public static final RegistryObject<Item> BEETROOT_SOUP = registerVanillaFoodAnalog(Items.BEETROOT_SOUP);
    //public static final RegistryObject<Item> MUSHROOM_STEW = registerVanillaFoodAnalog(Items.MUSHROOM_STEW);
    //public static final RegistryObject<Item> RABBIT_STEW = registerVanillaFoodAnalog(Items.RABBIT_STEW);

    //RAW_MEAT
    public static final RegistryObject<Item> BEEF = registerRawVanillaFoodAnalog("beef",Items.BEEF.getFood().getSaturation(),Items.BEEF);
    public static final RegistryObject<Item> CHICKEN = registerRawVanillaFoodAnalog("chicken",Items.CHICKEN.getFood().getSaturation(),Items.CHICKEN);
    public static final RegistryObject<Item> MUTTON = registerRawVanillaFoodAnalog("mutton",Items.MUTTON.getFood().getSaturation(),Items.MUTTON);
    //TODO:SUETA + smoked suet
    public static final RegistryObject<Item> PORKCHOP = registerRawVanillaFoodAnalog("porkchop",Items.PORKCHOP.getFood().getSaturation(),Items.PORKCHOP);
    public static final RegistryObject<Item> RABBIT = registerRawVanillaFoodAnalog("rabbit",Items.RABBIT.getFood().getSaturation(),Items.RABBIT);

    //COOKED_MEAT
    public static final RegistryObject<Item> COOKED_BEEF = registerVanillaFoodAnalog("cooked_beef",Items.COOKED_BEEF.getFood().getSaturation(),Items.COOKED_BEEF);
    public static final RegistryObject<Item> COOKED_CHICKEN = registerVanillaFoodAnalog("cooked_chicken",Items.COOKED_CHICKEN.getFood().getSaturation(),Items.COOKED_CHICKEN);
    public static final RegistryObject<Item> COOKED_MUTTON = registerVanillaFoodAnalog("cooked_mutton",Items.COOKED_MUTTON.getFood().getSaturation(),Items.COOKED_MUTTON);
    public static final RegistryObject<Item> COOKED_PORKCHOP = registerVanillaFoodAnalog("cooked_porkchop",Items.COOKED_PORKCHOP.getFood().getSaturation(),Items.COOKED_PORKCHOP);
    public static final RegistryObject<Item> COOKED_RABBIT = registerVanillaFoodAnalog("cooked_rabbit",Items.COOKED_RABBIT.getFood().getSaturation(),Items.COOKED_RABBIT);

    //FISH
    public static final RegistryObject<Item> COD = registerRawVanillaFoodAnalog("cod",Items.COD.getFood().getSaturation(),Items.COD);
    public static final RegistryObject<Item> SALMON = registerRawVanillaFoodAnalog("salmon",Items.SALMON.getFood().getSaturation(),Items.SALMON);
//    public static final RegistryObject<Item> TROPICAL_FISH = registerVanillaFoodAnalog(Items.TROPICAL_FISH);

    //COOKED_FISH
    public static final RegistryObject<Item> COOKED_COD = registerVanillaFoodAnalog("cooked_cod",Items.COOKED_COD.getFood().getSaturation(),Items.COOKED_COD);
    public static final RegistryObject<Item> COOKED_SALMON = registerVanillaFoodAnalog("cooked_salmon",Items.COOKED_SALMON.getFood().getSaturation(),Items.COOKED_SALMON);

    public static final RegistryObject<Item> FLOUR = ITEMS.register("flour",()->{

        Item.Properties properties = new Item.Properties();
        properties.maxStackSize(16);
        properties.maxDamage(DurableFoodItem.DIVIDER*DurableFoodItem.MAX_FOOD_DURABILITY);
        properties.group(FOOD_ITEM_GROUP);
        return new Item(getDefaultProp(1,DurableFoodItem.DIVIDER*DurableFoodItem.MAX_FOOD_DURABILITY,FOOD_ITEM_GROUP));
    });

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }


    private static RegistryObject<Item> registerVanillaFoodAnalog(String name, float saturation, Item item) {
        return ITEMS.register(name,()->{
                return new DurableFoodItem(getDefaultFoodProp(
                        new Food.Builder().hunger(1).saturation(saturation).build()));});
    }

    private static RegistryObject<Item> registerRawVanillaFoodAnalog(String name, float saturation, Item item) {
        return ITEMS.register(name,()->{
            return new DurableFoodItem(getDefaultFoodProp(
                    new Food.Builder().hunger(1).saturation(saturation).effect(new EffectInstance(Effects.HUNGER,10,0),1F).build()));});
    }

    private static Item.Properties getDefaultFoodProp(Food food)
    {
        Item.Properties properties = new Item.Properties();
        properties.maxStackSize(1);
        properties.maxDamage(DurableFoodItem.DIVIDER*DurableFoodItem.MAX_FOOD_DURABILITY);
        properties.group(FOOD_ITEM_GROUP);
        properties.food(food);
        return properties;
    }

    private static Item.Properties getDefaultProp(int maxStackSize,int maxDamage,ItemGroup group)
    {
        Item.Properties properties = new Item.Properties();
        properties.maxStackSize(maxStackSize);
        properties.maxDamage(maxDamage);
        properties.group(group);
        return properties;
    }

}
