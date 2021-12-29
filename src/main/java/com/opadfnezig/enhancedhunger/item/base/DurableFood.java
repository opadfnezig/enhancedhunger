package com.opadfnezig.enhancedhunger.item.base;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.lang.reflect.Field;
import java.util.function.Consumer;

public class DurableFood extends DurableItem {
    public static int DIVIDER = 1;
    public static int MAX_DURABILITY = 40;
    private short CONSUME_MAX = 4;


    public DurableFood(Properties p_i48487_1_,short consumeMax)
    {
        super(p_i48487_1_);
        CONSUME_MAX = consumeMax;
    }

    public DurableFood(Properties p_i48487_1_)  { super(p_i48487_1_); }

    //this is absolute rubbish, but can't do anything with it
    private short restoreAmount = 0;



    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        //TODO: FIX NULL
        if (this.isFood()) {
            ItemStack itemstack = playerIn.getHeldItem(handIn);
            if(playerIn.canEat(this.getFood().canEatWhenFull())) {
                if(20 - playerIn.getFoodStats().getFoodLevel() < CONSUME_MAX)
                    restoreAmount = (short) (20 - playerIn.getFoodStats().getFoodLevel());
                else if(20 - playerIn.getFoodStats().getFoodLevel() >= CONSUME_MAX)
                    restoreAmount = CONSUME_MAX;
                playerIn.setActiveHand(handIn);
                return ActionResult.resultSuccess(itemstack);
            }
        }
        return ActionResult.resultPass(playerIn.getHeldItem(handIn));
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        //get DAMAGE!111
        if((stack.getMaxDamage() - stack.getDamage())/DIVIDER <  restoreAmount)
            restoreAmount = (short)((stack.getMaxDamage() - stack.getDamage())/DIVIDER);

        entityLiving.onFoodEaten(worldIn, new ItemStack(()->{
            Item.Properties properties = new Properties();
            Food food = this.getFood();
            try {
                Field hunger = food.getClass().getDeclaredField("value");
                hunger.setAccessible(true);
                hunger.set(food, (int) restoreAmount);
            } catch (Exception e){}
            properties.food(this.getFood());
            Item item = new Item(properties);
            return item;
        }));
        stack.damageItem(DIVIDER*restoreAmount, entityLiving, new Consumer<LivingEntity>() {
            @Override
            public void accept(LivingEntity livingEntity) {
                stack.setCount(0);
            }
        });
        return stack;
    }
}