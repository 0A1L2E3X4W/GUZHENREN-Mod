package com.alex.guzhenren.mixin;

import com.alex.guzhenren.api.ModPlayerImpl;
import com.alex.guzhenren.api.enums.*;
import com.alex.guzhenren.network.ModMessages;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.EnumMap;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements ModPlayerImpl {

    @Shadow public abstract void playSound(SoundEvent sound, float volume, float pitch);

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    private int playerMoral;
    private float playerLifespan;

    private float currentEssences;
    private int maxEssences;

    private ModRank playerRank;
    private ModPlayerTalent playerTalent;
    private ModTenExtremePhysique playerExtremePhysique;
    private EnumMap<ModPath, Integer> attainments = new EnumMap<>(ModPath.class);
    private EnumMap<ModPath, ModRealm> realm = new EnumMap<>(ModPath.class);

    @Inject(method = "<init>", at = @At("RETURN"))
    private void initDefaults(World world, BlockPos pos, float yaw, GameProfile gameProfile, CallbackInfo ci) {
        this.playerMoral = 100;
        this.playerLifespan = 0F;

        this.currentEssences = 0F;
        this.maxEssences = 0;

        this.playerRank = ModRank.MORTAL;
        this.playerTalent = ModPlayerTalent.NULL;
        this.playerExtremePhysique = ModTenExtremePhysique.NULL;
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("RETURN"))
    public void writeCustomDataFromNbt(NbtCompound nbt, CallbackInfo callbackInfo) {
        NbtCompound att = new NbtCompound();
        nbt.putInt("guzhenren.player.moral", this.playerMoral);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("RETURN"))
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo callbackInfo) {
        this.playerMoral = nbt.getInt("guzhenren.player.moral");
    }

    @Override
    public ModRank getRank() {
        return this.playerRank;
    }

    @Override
    public void setRank(ModRank value) {
        this.playerRank = value;
    }

    @Override
    public ModPlayerTalent getTalent() {
        return this.playerTalent;
    }

    @Override
    public void setTalent(ModPlayerTalent v) {
        this.playerTalent = v;
    }

    @Override
    public ModTenExtremePhysique getSpecialPhysique() {
        return this.playerExtremePhysique;
    }

    @Override
    public void setSpecialPhysique(ModTenExtremePhysique v) {
        this.playerExtremePhysique = v;
    }

    @Override
    public int getMoral() {
        return this.playerMoral;
    }

    @Override
    public void setMoral(int v) {
        this.playerMoral = v;

        if (!this.getWorld().isClient()) {
            ModMessages.syncMoral((PlayerEntity) (Object) this, this.playerMoral);
        }
    }

    @Override
    public void changeMoral(int v) {
        this.playerMoral += v;

        if (!this.getWorld().isClient()) {
            ModMessages.syncMoral((PlayerEntity) (Object) this, this.playerMoral);
        }
    }

    @Override
    public int getAttainment(ModPath path) {
        return this.attainments.getOrDefault(path, 0);
    }

    @Override
    public void setAttainment(ModPath thePath, int theAttainment) {
        this.attainments.put(thePath, theAttainment);
    }

    @Override
    public void changeAttainment(ModPath thePath, int theAttainment) {
        int result = getAttainment(thePath) + theAttainment;
        this.attainments.put(thePath, result);
    }
}
