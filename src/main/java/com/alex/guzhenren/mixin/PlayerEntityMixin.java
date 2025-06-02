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
import org.spongepowered.asm.mixin.Unique;
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

    private ModGuMasterRank playerRank;
    private ModGuMasterTalent playerTalent;
    private ModTenExtremePhysique playerExtremePhysique;
    private EnumMap<ModPath, Integer> attainments = new EnumMap<>(ModPath.class);
    private EnumMap<ModPath, ModPathRealm> realm = new EnumMap<>(ModPath.class);

    private boolean apertureStatus = false;

    @Inject(method = "tick", at = @At("TAIL"))
    private void onTick(CallbackInfo info) {
        recoverEssencePerTick();
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void initDefaults(World world, BlockPos pos, float yaw, GameProfile gameProfile, CallbackInfo ci) {
        this.playerMoral = 100;
        this.playerLifespan = 0F;

        this.currentEssences = 0F;
        this.maxEssences = 0;

        this.playerRank = ModGuMasterRank.MORTAL;
        this.playerTalent = ModGuMasterTalent.NULL;
        this.playerExtremePhysique = ModTenExtremePhysique.NULL;

        this.apertureStatus = false;
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("RETURN"))
    public void writeCustomDataFromNbt(NbtCompound nbt, CallbackInfo callbackInfo) {
        NbtCompound att = new NbtCompound();
        nbt.putFloat("guzhenren.player.current_essence", this.currentEssences);
        nbt.putInt("guzhenren.player.max_essence", this.maxEssences);

        nbt.putInt("guzhenren.player.moral", this.playerMoral);
        nbt.putString("guzhenren.player.talent", this.playerTalent.getNameKey());
        nbt.putString("guzhenren.player.extreme_physique", this.playerExtremePhysique.getNameKey());
        nbt.putString("guzhenren.player.rank", this.playerRank.getNameKey());

        nbt.putBoolean("guzhenren.player.unblocked", this.apertureStatus);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("RETURN"))
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo callbackInfo) {
        this.currentEssences = nbt.getFloat("guzhenren.player.current_essence");
        this.maxEssences = nbt.getInt("guzhenren.player.max_essence");

        this.playerMoral = nbt.getInt("guzhenren.player.moral");
        this.playerTalent = ModGuMasterTalent.fromNameKey(nbt.getString("guzhenren.player.talent"));
        this.playerExtremePhysique = ModTenExtremePhysique.fromNameKey(nbt.getString("guzhenren.player.extreme_physique"));
        this.playerRank = ModGuMasterRank.fromNameKey(nbt.getString("guzhenren.player.rank"));

        this.apertureStatus = nbt.getBoolean("guzhenren.player.unblocked");
    }

    @Unique
    private void recoverEssencePerTick() {
        float tickRecovery = maxEssences / 1728000f;
        if (currentEssences < maxEssences) {
            this.setCurrentEssence(Math.min(currentEssences + tickRecovery, maxEssences));
        }
    }

    @Override
    public ModGuMasterRank getRank() {
        return this.playerRank;
    }

    @Override
    public void setRank(ModGuMasterRank value) {
        this.playerRank = value;

        if (!this.getWorld().isClient()) {
            ModMessages.syncRank((PlayerEntity) (Object) this, this.playerRank);
        }
    }

    @Override
    public float getCurrentEssence() {
        return this.currentEssences;
    }

    @Override
    public void setCurrentEssence(float v) {
        this.currentEssences = v;

        if (!this.getWorld().isClient()) {
            ModMessages.syncCurrentEssence((PlayerEntity) (Object) this, this.currentEssences);
        }
    }

    @Override
    public void changeCurrentEssence(float v) {
        this.currentEssences += v;

        if (!this.getWorld().isClient()) {
            ModMessages.syncCurrentEssence((PlayerEntity) (Object) this, this.currentEssences);
        }
    }

    @Override
    public int getMaxEssence() {
        return this.maxEssences;
    }

    @Override
    public void setMaxEssence(int v) {
        this.maxEssences = v;

        if (!this.getWorld().isClient()) {
            ModMessages.syncMaxEssence((PlayerEntity) (Object) this, this.maxEssences);
        }
    }

    @Override
    public ModGuMasterTalent getTalent() {
        return this.playerTalent;
    }

    @Override
    public void setTalent(ModGuMasterTalent v) {
        this.playerTalent = v;

        if (!this.getWorld().isClient()) {
            ModMessages.syncTalent((PlayerEntity) (Object) this, this.playerTalent);
        }
    }

    @Override
    public ModTenExtremePhysique getSpecialPhysique() {
        return this.playerExtremePhysique;
    }

    @Override
    public void setSpecialPhysique(ModTenExtremePhysique v) {
        this.playerExtremePhysique = v;

        if (!this.getWorld().isClient()) {
            ModMessages.syncExtremePhysique((PlayerEntity) (Object) this, this.playerExtremePhysique);
        }
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

    @Override
    public boolean getApertureStatus() {
        return this.apertureStatus;
    }

    @Override
    public void setApertureStatus(boolean v) {
        this.apertureStatus = v;

        if (!this.getWorld().isClient()) {
            ModMessages.syncApertureStatus((PlayerEntity) (Object) this, this.apertureStatus);
        }
    }
}
