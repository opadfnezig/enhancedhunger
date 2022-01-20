package com.opadfnezig.enhancedhunger.item.base;

import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class DurableFoodItem extends DurableFood {

    public DurableFoodItem(Properties properties) {
        super(properties);
    }
/*
    @Override
    public ItemStack getContainerItem(@Nonnull ItemStack stack) {
        stack.damageItem(1, null, livingEntity -> stack.setCount(0));
        return stack;
    }

    @Override
    public boolean hasContainerItem(){
        return  true;
    }*/
}