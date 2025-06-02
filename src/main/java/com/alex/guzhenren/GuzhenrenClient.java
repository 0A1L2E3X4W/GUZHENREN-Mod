package com.alex.guzhenren;

import com.alex.guzhenren.api.ModPlayerImpl;
import com.alex.guzhenren.api.enums.ModPlayerTalent;
import com.alex.guzhenren.api.enums.ModRank;
import com.alex.guzhenren.api.enums.ModTenExtremePhysique;
import com.alex.guzhenren.network.ModMessages;
import com.alex.guzhenren.network.ModNetworking;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;

public class GuzhenrenClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModKeyBindings.register();
        ClientDataInitialize();
        ModMessages.registerClientReceivers();
    }

    private static void ClientDataInitialize() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            PacketByteBuf buf = new PacketByteBuf(io.netty.buffer.Unpooled.buffer());
            ClientPlayNetworking.send(ModNetworking.CHANNEL_REQUEST_DATA, buf);
        });

        ClientPlayNetworking.registerGlobalReceiver(ModNetworking.CHANNEL_SEND_DATA,
                (client, handler, buf, responseSender) -> {
                    int moral = buf.readInt();
                    String talent = buf.readString();
                    String extremePhysique = buf.readString();
                    String rank = buf.readString();

                    boolean apertureStatus = buf.readBoolean();

                    client.execute(() -> {
                        PlayerEntity player = MinecraftClient.getInstance().player;
                        if (player instanceof ModPlayerImpl mod) {
                            mod.setMoral(moral);
                            mod.setTalent(ModPlayerTalent.fromNameKey(talent));
                            mod.setSpecialPhysique(ModTenExtremePhysique.fromNameKey(extremePhysique));
                            mod.setRank(ModRank.fromNameKey(rank));
                            mod.setApertureStatus(apertureStatus);
                        }
                    });
                }
        );
    }
}
