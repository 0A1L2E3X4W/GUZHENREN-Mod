package com.alex.guzhenren.mixin;

import com.alex.guzhenren.utils.ModPlayerImpl;
import com.alex.guzhenren.utils.enums.*;
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

    @Unique private int moral;
    @Unique private float lifespan;
    @Unique private int soul;

    @Unique private float currentEssences;
    @Unique private int maxEssences;

    @Unique private ModGuMasterRank rank;
    @Unique private ModGuMasterTalent talent;
    @Unique private ModTenExtremePhysique extremePhysique;
    @Unique private EnumMap<ModPath, Integer> attainments = new EnumMap<>(ModPath.class);
    @Unique private EnumMap<ModPath, ModPathRealm> realms = new EnumMap<>(ModPath.class);

    @Unique private boolean apertureStatus = false;

    @Inject(method = "tick", at = @At("TAIL"))
    private void onTick(CallbackInfo info) {
        recoverEssencePerTick();
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void initDefaults(World world, BlockPos pos, float yaw, GameProfile gameProfile, CallbackInfo ci) {
        this.moral = 100;
        this.lifespan = 0F;

        this.currentEssences = 0F;
        this.maxEssences = 0;

        this.rank = ModGuMasterRank.MORTAL;
        this.talent = ModGuMasterTalent.NULL;
        this.extremePhysique = ModTenExtremePhysique.NULL;

        this.apertureStatus = false;

        for (ModPath path: ModPath.values()) {
            this.attainments.put(path, 0);
        }

        for (ModPath path: ModPath.values()) {
            this.realms.put(path, ModPathRealm.ORDINARY);
        }
    }

    @Inject(method = "writeCustomDataToNbt", at = @At("RETURN"))
    public void writeCustomDataFromNbt(NbtCompound nbt, CallbackInfo callbackInfo) {
        NbtCompound att = new NbtCompound();
        nbt.putFloat("guzhenren.player.current_essence", this.currentEssences);
        nbt.putInt("guzhenren.player.max_essence", this.maxEssences);

        nbt.putInt("guzhenren.player.moral", this.moral);
        nbt.putInt("guzhenren.player.soul", this.soul);
        nbt.putString("guzhenren.player.talent", this.talent.getNameKey());
        nbt.putString("guzhenren.player.extreme_physique", this.extremePhysique.getNameKey());
        nbt.putString("guzhenren.player.rank", this.rank.getNameKey());

        nbt.putBoolean("guzhenren.player.unblocked", this.apertureStatus);
    }

    @Inject(method = "readCustomDataFromNbt", at = @At("RETURN"))
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo callbackInfo) {
        this.currentEssences = nbt.getFloat("guzhenren.player.current_essence");
        this.maxEssences = nbt.getInt("guzhenren.player.max_essence");

        this.moral = nbt.getInt("guzhenren.player.moral");
        this.soul = nbt.getInt("guzhenren.player.soul");
        this.talent = ModGuMasterTalent.fromNameKey(nbt.getString("guzhenren.player.talent"));
        this.extremePhysique = ModTenExtremePhysique.fromNameKey(nbt.getString("guzhenren.player.extreme_physique"));
        this.rank = ModGuMasterRank.fromNameKey(nbt.getString("guzhenren.player.rank"));

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
        return this.rank;
    }

    @Override
    public void setRank(ModGuMasterRank value) {
        this.rank = value;
        ModMessages.syncRank((PlayerEntity) (Object) this, this.rank);
    }

    @Override
    public float getCurrentEssence() {
        return this.currentEssences;
    }

    @Override
    public void setCurrentEssence(float v) {
        this.currentEssences = v;
        ModMessages.syncCurrentEssence((PlayerEntity) (Object) this, this.currentEssences);
    }

    @Override
    public void changeCurrentEssence(float v) {

        this.currentEssences += v;
        ModMessages.syncCurrentEssence((PlayerEntity) (Object) this, this.currentEssences);
    }

    @Override
    public int getMaxEssence() {
        return this.maxEssences;
    }

    @Override
    public void setMaxEssence(int v) {
        this.maxEssences = v;
        ModMessages.syncMaxEssence((PlayerEntity) (Object) this, this.maxEssences);
    }

    @Override
    public ModGuMasterTalent getTalent() {
        return this.talent;
    }

    @Override
    public void setTalent(ModGuMasterTalent v) {
        this.talent = v;
        ModMessages.syncTalent((PlayerEntity) (Object) this, this.talent);
    }

    @Override
    public ModTenExtremePhysique getExtremePhysique() {
        return this.extremePhysique;
    }

    @Override
    public void setExtremePhysique(ModTenExtremePhysique v) {
        this.extremePhysique = v;
        ModMessages.syncExtremePhysique((PlayerEntity) (Object) this, this.extremePhysique);
    }

    @Override
    public int getMoral() {
        return this.moral;
    }

    @Override
    public void setMoral(int v) {
        this.moral = v;
        ModMessages.syncMoral((PlayerEntity) (Object) this, this.moral);
    }

    @Override
    public void changeMoral(int v) {
        this.moral += v;
        ModMessages.syncMoral((PlayerEntity) (Object) this, this.moral);
    }

    @Override
    public int getSoul() {
        return this.soul;
    }

    @Override
    public void setSoul(int v) {
        this.soul = v;
        ModMessages.syncSoul((PlayerEntity) (Object) this, this.soul);
    }

    @Override
    public void changeSoul(int v) {
        this.soul += v;
        ModMessages.syncSoul((PlayerEntity) (Object) this, this.soul);
    }

    @Override
    public int getAttainment(ModPath path) {
        return this.attainments.getOrDefault(path, 0);
    }

    @Override
    public void setAttainment(ModPath thePath, int theAttainment) {
        this.attainments.put(thePath, theAttainment);
        ModMessages.syncPathAttainment((PlayerEntity)(Object)this, thePath, theAttainment);
    }

    @Override
    public void changeAttainment(ModPath thePath, int theAttainment) {
        int result = getAttainment(thePath) + theAttainment;
        this.attainments.put(thePath, result);
        ModMessages.syncPathAttainment((PlayerEntity)(Object)this, thePath, result);
    }

    @Override
    public ModPathRealm getRealm(ModPath thePath) {
        return this.realms.getOrDefault(thePath, ModPathRealm.ORDINARY);
    }

    @Override
    public void setRealm(ModPath thePath, ModPathRealm theRealm) {
        this.realms.put(thePath, theRealm);
        ModMessages.syncPathRealm((PlayerEntity)(Object)this, thePath, theRealm);
    }

    @Override
    public boolean getApertureStatus() {
        return this.apertureStatus;
    }

    @Override
    public void setApertureStatus(boolean v) {
        this.apertureStatus = v;

        if (!this.getWorld().isClient()) {
            ModMessages.syncApertureStatus((PlayerEntity)(Object)this, this.apertureStatus);
        }
    }
}
