package com.opadfnezig.enhancedhunger.item.base;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DurableItem extends Item {
    public static int DIVIDER = 1;
    public static int MAX_DURABILITY = 40;

    public DurableItem(Properties properties) {
        super(properties);
    }

   /* @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack stack = itemStack.copy();
        stack.setDamage(stack.getDamage()+1);
        if(stack.getDamage() > stack.getMaxDamage())
            stack.setCount(0);
        return stack;
    }*/
}
