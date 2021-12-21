package com.opadfnezig.enhancedhunger;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import java.lang.reflect.Field;

public class VanillaModifier {
    public static void modify(){

        //RAW
        removeFood(Items.APPLE);
        removeFood(Items.BEETROOT);
        removeFood(Items.CARROT);
        removeFood(Items.CHORUS_FRUIT);
        removeFood(Items.MELON_SLICE);
        removeFood(Items.POTATO);
        removeFood(Items.SWEET_BERRIES);

        //PROCEEDED
        removeFood(Items.BREAD);
        removeFood(Items.COOKIE);
        removeFood(Items.GOLDEN_CARROT);
        removeFood(Items.HONEY_BOTTLE);
        removeFood(Items.PUMPKIN_PIE);

        //COOKED
        removeFood(Items.BAKED_POTATO);
        removeFood(Items.DRIED_KELP);

        //SOUPS AND STEWS
        //let it be?
        //removeFood(Items.BEETROOT_SOUP);
        //removeFood(Items.MUSHROOM_STEW);
        //removeFood(Items.RABBIT_STEW);
        //removeFood(Items.SUSPICIOUS_STEW);

        //RAW_MEAT
        removeFood(Items.BEEF);
        removeFood(Items.CHICKEN);
        removeFood(Items.MUTTON);
        removeFood(Items.PORKCHOP);
        removeFood(Items.RABBIT);

        //COOKED_MEAT

        removeFood(Items.COOKED_BEEF);
        removeFood(Items.COOKED_CHICKEN);
        removeFood(Items.COOKED_MUTTON);
        removeFood(Items.COOKED_PORKCHOP);
        removeFood(Items.COOKED_RABBIT);

        //FISH
        removeFood(Items.COD);
        removeFood(Items.SALMON);
        removeFood(Items.TROPICAL_FISH);

        //COOKED_FISH
        removeFood(Items.COOKED_COD);
        removeFood(Items.COOKED_SALMON);


    }

    private static void removeFood(Item i) {
        try {
            Item item = ForgeRegistries.ITEMS.getValue(ForgeRegistries.ITEMS.getKey(i));
            Field a = item.getClass().getDeclaredField("food");
            a.setAccessible(true);
            a.set(item,null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
