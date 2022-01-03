package com.opadfnezig.enhancedhunger.item.base;

import net.minecraft.block.BlockState;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;

import javax.annotation.Nonnull;

public class EHTool extends ToolItem {
        public EHTool(IItemTier tier,float attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(attackDamageIn, attackSpeedIn, tier, null, builderIn);
    }

    @Override
    public ItemStack getContainerItem(@Nonnull ItemStack stack) {
        stack.damageItem(1, null, livingEntity -> stack.setCount(0));
        return stack;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return super.getDestroySpeed(stack, state);
    }
}
