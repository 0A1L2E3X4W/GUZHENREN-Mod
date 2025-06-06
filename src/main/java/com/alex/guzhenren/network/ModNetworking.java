package com.alex.guzhenren.network;

import com.alex.guzhenren.utils.ModPlayerImpl;
import com.alex.guzhenren.utils.enums.*;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class ModNetworking {

    public static final Identifier CHANNEL_REQUEST_DATA = new Identifier("guzhenren", "request_player_data");
    public static final Identifier CHANNEL_SEND_DATA    = new Identifier("guzhenren", "send_player_data");

    public static void init() {
        // 1. 当收到客户端请求时，往回发玩家数据
        ServerPlayNetworking.registerGlobalReceiver(CHANNEL_REQUEST_DATA,
                (server, player, handler, buf, responseSender) -> {
                    // 读取玩家的自定义数据
                    ModPlayerImpl modPlayer = (ModPlayerImpl) player;
                    PacketByteBuf resp = new PacketByteBuf(io.netty.buffer.Unpooled.buffer());

                    resp.writeFloat(modPlayer.getCurrentEssence());
                    resp.writeInt(modPlayer.getMaxEssence());

                    resp.writeInt(modPlayer.getMoral());
                    resp.writeInt(modPlayer.getSoul());
                    resp.writeString(modPlayer.getTalent().getNameKey());
                    resp.writeString(modPlayer.getExtremePhysique().getNameKey());
                    resp.writeString(modPlayer.getRank().getNameKey());

                    resp.writeBoolean(modPlayer.getApertureStatus());

                    for (ModPath path : ModPath.values()) {
                        resp.writeInt(modPlayer.getAttainment(path));
                        resp.writeString(modPlayer.getRealm(path).getNameKey());
                    }

                    // 发送回客户端
                    responseSender.sendPacket(CHANNEL_SEND_DATA, resp);
                }
        );

        // （可选）在玩家复制（跨维度／重生）时，保持数据
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
            // 这里视情况而定是否需要清理或缓存
        });
    }

    public static void ClientDataInitialize() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            PacketByteBuf buf = new PacketByteBuf(io.netty.buffer.Unpooled.buffer());
            ClientPlayNetworking.send(CHANNEL_REQUEST_DATA, buf);
        });

        ClientPlayNetworking.registerGlobalReceiver(CHANNEL_SEND_DATA,
                (client, handler, buf, responseSender) -> {
                    float currentEssence = buf.readFloat();
                    int maxEssence = buf.readInt();

                    int moral = buf.readInt();
                    int soul = buf.readInt();
                    String talent = buf.readString();
                    String extremePhysique = buf.readString();
                    String rank = buf.readString();
                    boolean apertureStatus = buf.readBoolean();

                    int pathCount = ModPath.values().length;
                    int[] tmpAttainments = new int[pathCount];
                    String[] tmpRealmKeys = new String[pathCount];
                    for (int i = 0; i < pathCount; i++) {
                        tmpAttainments[i] = buf.readInt();
                        tmpRealmKeys[i]   = buf.readString();
                    }

                    client.execute(() -> {
                        PlayerEntity player = MinecraftClient.getInstance().player;
                        if (player instanceof ModPlayerImpl modPlayer) {
                            modPlayer.setMoral(moral);
                            modPlayer.setSoul(soul);
                            modPlayer.setTalent(ModGuMasterTalent.fromNameKey(talent));
                            modPlayer.setExtremePhysique(ModTenExtremePhysique.fromNameKey(extremePhysique));
                            modPlayer.setRank(ModGuMasterRank.fromNameKey(rank));
                            modPlayer.setMaxEssence(maxEssence);
                            modPlayer.setCurrentEssence(currentEssence);
                            modPlayer.setApertureStatus(apertureStatus);

                            ModPath[] allPaths = ModPath.values();
                            for (int i = 0; i < pathCount; i++) {
                                ModPath path = allPaths[i];
                                modPlayer.setAttainment(path, tmpAttainments[i]);
                                modPlayer.setRealm(path, ModPathRealm.fromNameKey(tmpRealmKeys[i]));
                            }
                        }
                    });
                });
    }
}
