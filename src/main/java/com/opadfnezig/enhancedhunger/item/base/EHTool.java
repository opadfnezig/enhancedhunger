package com.opadfnezig.enhancedhunger.item.base;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

public class EHTool extends ToolItem {
        public EHTool(IItemTier tier,float attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(attackDamageIn, attackSpeedIn, tier, null, builderIn);
    }

    @Override
    public ItemStack getContainerItem(@Nonnull ItemStack stack) {
        stack.damageItem(1, null, new Consumer<LivingEntity>() {
            @Override
            public void accept(LivingEntity livingEntity) {
                stack.setCount(0);
            }
        });
        return stack;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return super.getDestroySpeed(stack, state);
    }
}
