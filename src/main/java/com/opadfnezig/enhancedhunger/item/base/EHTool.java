package com.opadfnezig.enhancedhunger.item.base;

import net.minecraft.block.BlockState;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;

import javax.annotation.Nonnull;

public class EHTool extends ToolItem {
        public EHTool(IItemTier tier,float attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(attackDamageIn, attackSpeedIn, tier, null, builderIn);
    }

    @Override
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
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return super.getDestroySpeed(stack, state);
    }
}

