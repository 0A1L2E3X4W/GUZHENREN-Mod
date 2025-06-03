package com.alex.guzhenren.item.custom.gu;

import com.alex.guzhenren.utils.ModPlayerImpl;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Gu_FlowerBoar_1 extends Item {

    public Gu_FlowerBoar_1(Settings settings) {
        super(settings);
    }

    public static final int ESSENCE_REQUIRE = -10000;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        ModPlayerImpl modPlayer = (ModPlayerImpl)user;

        if (!world.isClient()) {

            int modifier = modPlayer.getRank().getEssenceModifier();
            int result = ESSENCE_REQUIRE / modifier;

            if (modPlayer.getCurrentEssence() < -result) {
                return TypedActionResult.fail(itemStack);
            }

            // 添加30秒力量II效果
            user.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.STRENGTH,
                    30 * 20, 1
            ));

            modPlayer.changeCurrentEssence(result);

            // 设置10秒冷却
            user.getItemCooldownManager().set(this, 10 * 20);

            // 扣除耐久（参数1：扣除量，参数2：实体，参数3：损坏回调）
            itemStack.damage(1, user, player -> player.sendToolBreakStatus(hand));

            return TypedActionResult.success(itemStack);
        }

        return TypedActionResult.fail(itemStack);
    }
}
