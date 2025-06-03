package com.alex.guzhenren.effect;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ActionResult;

public class ModEvents {

    public static void registerAttackEvent() {
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (!world.isClient && entity instanceof LivingEntity target) {
                // 判断效果
                int multiplier = 1;
                if (player.hasStatusEffect(ModEffects.WHITE_BOAR_POWER)) multiplier *= 2;
                if (player.hasStatusEffect(ModEffects.BLACK_BOAR_POWER)) multiplier *= 2;
                if (multiplier > 1) {
                    float baseDamage = (float)player.getAttributeValue(net.minecraft.entity.attribute.EntityAttributes.GENERIC_ATTACK_DAMAGE);
                    // 重新设置伤害
                    float extra = baseDamage * (multiplier - 1);
                    target.damage(player.getDamageSources().playerAttack(player), extra);
                }
            }
            return ActionResult.PASS;
        });
    }
}
