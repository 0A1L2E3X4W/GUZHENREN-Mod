package com.alex.guzhenren.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HuaShi_Gu_1 extends Item {

    public HuaShi_Gu_1(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient()) {
            // 添加30秒力量II效果
            user.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.STRENGTH,
                    30 * 20,  // 持续时间（30秒 * 20 tick/秒）
                    1         // 效果等级（0为I级，1为II级）
            ));

            // 设置10秒冷却
            user.getItemCooldownManager().set(this, 10 * 20);



            // 扣除耐久（参数1：扣除量，参数2：实体，参数3：损坏回调）
            itemStack.damage(1, user,
                    player -> player.sendToolBreakStatus(hand));
        }

        return TypedActionResult.success(itemStack);
    }
}
