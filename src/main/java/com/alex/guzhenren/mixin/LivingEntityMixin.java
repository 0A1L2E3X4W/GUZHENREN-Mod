package com.alex.guzhenren.mixin;

import com.alex.guzhenren.utils.ModPlayerImpl;
import com.alex.guzhenren.utils.enums.ModPath;
import com.alex.guzhenren.utils.enums.ModPathRealm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    protected LivingEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "onDeath", at = @At("HEAD"))
    public void onDeath(DamageSource source, CallbackInfo callbackInfo) {
        Entity attacker = source.getAttacker();
        LivingEntity entity = (LivingEntity) (Object) this;
        if (attacker instanceof PlayerEntity && (
                entity instanceof VillagerEntity || entity instanceof IronGolemEntity || entity instanceof SnowGolemEntity)) {
            ((ModPlayerImpl) attacker).changeMoral(-1);
            ((ModPlayerImpl) attacker).changeAttainment(ModPath.KILLING, 1);
            ((ModPlayerImpl) attacker).changeAttainment(ModPath.HEAVEN, 120);
            ((ModPlayerImpl) attacker).changeAttainment(ModPath.HUMAN, 400);
            ((ModPlayerImpl) attacker).setRealm(ModPath.HUMAN, ModPathRealm.GRANDMASTER);
            ((ModPlayerImpl) attacker).setRealm(ModPath.POWER, ModPathRealm.SUPREME_GRANDMASTER);
        }
    }
}
