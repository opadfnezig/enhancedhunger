package com.opadfnezig.enhancedhunger.item.base;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.function.Consumer;

public class DurableItem extends Item {
    public static int DIVIDER = 1;
    public static int MAX_DURABILITY = 40;

    public DurableItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
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

}
