package com.opadfnezig.enhancedhunger;

import com.opadfnezig.enhancedhunger.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup MOD_GROUP = new ItemGroup("customModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.KNIFE.get());
        }
    };
}
