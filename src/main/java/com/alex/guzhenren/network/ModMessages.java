package com.alex.guzhenren.network;

import com.alex.guzhenren.api.ModPlayerImpl;
import com.alex.guzhenren.api.enums.ModPlayerTalent;
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

    public static void syncMoral(PlayerEntity player, int moral) {
        if (player instanceof ServerPlayerEntity serverPlayer) { // 安全类型检查
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(moral);
            ServerPlayNetworking.send(serverPlayer, SYNC_MORAL, buf);
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
    }
}
