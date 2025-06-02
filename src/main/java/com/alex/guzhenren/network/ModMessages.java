package com.alex.guzhenren.network;

import com.alex.guzhenren.api.ModPlayerImpl;
import com.alex.guzhenren.api.enums.ModPlayerTalent;
import com.alex.guzhenren.api.enums.ModRank;
import com.alex.guzhenren.api.enums.ModTenExtremePhysique;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class ModMessages {

    public static final Identifier SYNC_MORAL = new Identifier("guzhenren", "sync_moral");
    public static final Identifier SYNC_RANK = new Identifier("guzhenren", "sync_rank");
    public static final Identifier SYNC_TALENT = new Identifier("guzhenren", "sync_talent");
    public static final Identifier SYNC_EXTREME_PHYSIQUE = new Identifier("guzhenren", "sync_extreme_physique");

    public static final Identifier SYNC_APERTURE_STATUS = new Identifier("guzhenren", "sync_aperture_status");

    public static void syncMoral(PlayerEntity player, int v) {
        if (player instanceof ServerPlayerEntity serverPlayer) { // 安全类型检查
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(v);
            ServerPlayNetworking.send(serverPlayer, SYNC_MORAL, buf);
        }
    }

    public static void syncRank(PlayerEntity player, ModRank v) {
        if (player instanceof ServerPlayerEntity serverPlayer) { // 安全类型检查
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeString(v.getNameKey());
            ServerPlayNetworking.send(serverPlayer, SYNC_RANK, buf);
        }
    }

    public static void syncTalent(PlayerEntity player, ModPlayerTalent v) {
        if (player instanceof ServerPlayerEntity serverPlayer) { // 安全类型检查
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeString(v.getNameKey());
            ServerPlayNetworking.send(serverPlayer, SYNC_TALENT, buf);
        }
    }

    public static void syncExtremePhysique(PlayerEntity player, ModTenExtremePhysique v) {
        if (player instanceof ServerPlayerEntity serverPlayer) { // 安全类型检查
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeString(v.getNameKey());
            ServerPlayNetworking.send(serverPlayer, SYNC_EXTREME_PHYSIQUE, buf);
        }
    }

    public static void syncApertureStatus(PlayerEntity player, boolean v) {
        if (player instanceof ServerPlayerEntity serverPlayer) { // 安全类型检查
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeBoolean(v);
            ServerPlayNetworking.send(serverPlayer, SYNC_APERTURE_STATUS, buf);
        }
    }

    public static void registerClientReceivers() {
        ClientPlayNetworking.registerGlobalReceiver(SYNC_MORAL, (client, handler, buf, responseSender) -> {
            int moral = buf.readInt();
            client.execute(() -> {
                if (client.player instanceof ModPlayerImpl playerImpl) {
                    playerImpl.setMoral(moral);
                }
            });
        });

        ClientPlayNetworking.registerGlobalReceiver(SYNC_TALENT, (client, handler, buf, responseSender) -> {
            String talent = buf.readString();
            client.execute(() -> {
                if (client.player instanceof ModPlayerImpl playerImpl) {
                    playerImpl.setTalent(ModPlayerTalent.fromNameKey(talent));
                }
            });
        });

        ClientPlayNetworking.registerGlobalReceiver(SYNC_RANK, (client, handler, buf, responseSender) -> {
            String rank = buf.readString();
            client.execute(() -> {
                if (client.player instanceof ModPlayerImpl playerImpl) {
                    playerImpl.setRank(ModRank.fromNameKey(rank));
                }
            });
        });

        ClientPlayNetworking.registerGlobalReceiver(SYNC_EXTREME_PHYSIQUE, (client, handler, buf, responseSender) -> {
            String physique = buf.readString();
            client.execute(() -> {
                if (client.player instanceof ModPlayerImpl playerImpl) {
                    playerImpl.setSpecialPhysique(ModTenExtremePhysique.fromNameKey(physique));
                }
            });
        });

        ClientPlayNetworking.registerGlobalReceiver(SYNC_APERTURE_STATUS, (client, handler, buf, responseSender) -> {
            boolean status = buf.readBoolean();
            client.execute(() -> {
                if (client.player instanceof ModPlayerImpl playerImpl) {
                    playerImpl.setApertureStatus(status);
                }
            });
        });
    }
}
