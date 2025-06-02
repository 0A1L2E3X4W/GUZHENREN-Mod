package com.alex.guzhenren.network;

import com.alex.guzhenren.api.ModPlayerImpl;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
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
                    ModPlayerImpl mod = (ModPlayerImpl) player;
                    PacketByteBuf resp = new PacketByteBuf(io.netty.buffer.Unpooled.buffer());

                    resp.writeInt(mod.getMoral());
                    resp.writeString(mod.getTalent().getNameKey());
                    resp.writeString(mod.getSpecialPhysique().getNameKey());
                    resp.writeString(mod.getRank().getNameKey());

                    resp.writeBoolean(mod.getApertureStatus());

                    // 发送回客户端
                    responseSender.sendPacket(CHANNEL_SEND_DATA, resp);
                }
        );

        // （可选）在玩家复制（跨维度／重生）时，保持数据
        ServerPlayConnectionEvents.DISCONNECT.register((handler, server) -> {
            // 这里视情况而定是否需要清理或缓存
        });
    }
}
