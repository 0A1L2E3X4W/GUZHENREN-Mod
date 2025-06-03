package com.alex.guzhenren.network;

import com.alex.guzhenren.utils.ModPlayerImpl;
import com.alex.guzhenren.utils.enums.*;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class ModMessages {

    public static final Identifier SYNC_CURRENT_ESSENCE = new Identifier("guzhenren", "sync_current_essence");
    public static final Identifier SYNC_MAX_ESSENCE = new Identifier("guzhenren", "sync_max_essence");

    public static final Identifier SYNC_MORAL = new Identifier("guzhenren", "sync_moral");
    public static final Identifier SYNC_SOUL = new Identifier("guzhenren", "sync_soul");
    public static final Identifier SYNC_RANK = new Identifier("guzhenren", "sync_rank");
    public static final Identifier SYNC_TALENT = new Identifier("guzhenren", "sync_talent");
    public static final Identifier SYNC_EXTREME_PHYSIQUE = new Identifier("guzhenren", "sync_extreme_physique");
    public static final Identifier SYNC_APERTURE_STATUS = new Identifier("guzhenren", "sync_aperture_status");

    public static final Identifier SYNC_PATH_ATTAINMENT = new Identifier("guzhenren", "sync_path_attainment");
    public static final Identifier SYNC_PATH_REALM      = new Identifier("guzhenren", "sync_path_realm");


    public static void syncCurrentEssence(PlayerEntity player, float v) {
        if (player instanceof ServerPlayerEntity serverPlayer) { // 安全类型检查
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeFloat(v);
            ServerPlayNetworking.send(serverPlayer, SYNC_CURRENT_ESSENCE, buf);
        }
    }

    public static void syncMaxEssence(PlayerEntity player, int v) {
        if (player instanceof ServerPlayerEntity serverPlayer) { // 安全类型检查
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(v);
            ServerPlayNetworking.send(serverPlayer, SYNC_MAX_ESSENCE, buf);
        }
    }

    public static void syncMoral(PlayerEntity player, int v) {
        if (player instanceof ServerPlayerEntity serverPlayer) { // 安全类型检查
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(v);
            ServerPlayNetworking.send(serverPlayer, SYNC_MORAL, buf);
        }
    }

    public static void syncSoul(PlayerEntity player, int v) {
        if (player instanceof ServerPlayerEntity serverPlayer) { // 安全类型检查
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeInt(v);
            ServerPlayNetworking.send(serverPlayer, SYNC_SOUL, buf);
        }
    }

    public static void syncRank(PlayerEntity player, ModGuMasterRank v) {
        if (player instanceof ServerPlayerEntity serverPlayer) { // 安全类型检查
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeString(v.getNameKey());
            ServerPlayNetworking.send(serverPlayer, SYNC_RANK, buf);
        }
    }

    public static void syncTalent(PlayerEntity player, ModGuMasterTalent v) {
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

    public static void syncPathAttainment(PlayerEntity player, ModPath path, int attainment) {
        if (player instanceof ServerPlayerEntity serverPlayer) {
            PacketByteBuf buf = PacketByteBufs.create();
            // 将 path 的唯一标识写入（这里用 name()，也可以改为 writeInt(path.ordinal()) 或者 writeString(path.getNameKey())）
            buf.writeString(path.name());
            // 再写该路径对应的数值
            buf.writeInt(attainment);
            ServerPlayNetworking.send(serverPlayer, SYNC_PATH_ATTAINMENT, buf);
        }
    }

    public static void syncPathRealm(PlayerEntity player, ModPath path, ModPathRealm realm) {
        if (player instanceof ServerPlayerEntity serverPlayer) {
            PacketByteBuf buf = PacketByteBufs.create();
            // 先写 path 的唯一标识
            buf.writeString(path.name());
            // 再写该路径对应的境界的 nameKey
            buf.writeString(realm.getNameKey());
            ServerPlayNetworking.send(serverPlayer, SYNC_PATH_REALM, buf);
        }
    }

    public static void registerClientReceivers() {

        ClientPlayNetworking.registerGlobalReceiver(SYNC_CURRENT_ESSENCE, (client, handler, buf, responseSender) -> {
            float v = buf.readFloat();
            client.execute(() -> {
                if (client.player instanceof ModPlayerImpl playerImpl) {
                    playerImpl.setCurrentEssence(v);
                }
            });
        });

        ClientPlayNetworking.registerGlobalReceiver(SYNC_MAX_ESSENCE, (client, handler, buf, responseSender) -> {
            int v = buf.readInt();
            client.execute(() -> {
                if (client.player instanceof ModPlayerImpl playerImpl) {
                    playerImpl.setMaxEssence(v);
                }
            });
        });

        ClientPlayNetworking.registerGlobalReceiver(SYNC_MORAL, (client, handler, buf, responseSender) -> {
            int moral = buf.readInt();
            client.execute(() -> {
                if (client.player instanceof ModPlayerImpl playerImpl) {
                    playerImpl.setMoral(moral);
                }
            });
        });

        ClientPlayNetworking.registerGlobalReceiver(SYNC_SOUL, (client, handler, buf, responseSender) -> {
            int soul = buf.readInt();
            client.execute(() -> {
                if (client.player instanceof ModPlayerImpl playerImpl) {
                    playerImpl.setSoul(soul);
                }
            });
        });

        ClientPlayNetworking.registerGlobalReceiver(SYNC_TALENT, (client, handler, buf, responseSender) -> {
            String talent = buf.readString();
            client.execute(() -> {
                if (client.player instanceof ModPlayerImpl playerImpl) {
                    playerImpl.setTalent(ModGuMasterTalent.fromNameKey(talent));
                }
            });
        });

        ClientPlayNetworking.registerGlobalReceiver(SYNC_RANK, (client, handler, buf, responseSender) -> {
            String rank = buf.readString();
            client.execute(() -> {
                if (client.player instanceof ModPlayerImpl playerImpl) {
                    playerImpl.setRank(ModGuMasterRank.fromNameKey(rank));
                }
            });
        });

        ClientPlayNetworking.registerGlobalReceiver(SYNC_EXTREME_PHYSIQUE, (client, handler, buf, responseSender) -> {
            String physique = buf.readString();
            client.execute(() -> {
                if (client.player instanceof ModPlayerImpl playerImpl) {
                    playerImpl.setExtremePhysique(ModTenExtremePhysique.fromNameKey(physique));
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

        ClientPlayNetworking.registerGlobalReceiver(SYNC_PATH_ATTAINMENT, (client, handler, buf, responseSender) -> {
            // 先读 path 枚举名
            String pathName = buf.readString();
            int newAttainment = buf.readInt();
            client.execute(() -> {
                if (client.player instanceof ModPlayerImpl playerImpl) {
                    // 把字符串转换回枚举
                    ModPath path = ModPath.valueOf(pathName);
                    playerImpl.setAttainment(path, newAttainment);
                }
            });
        });

        ClientPlayNetworking.registerGlobalReceiver(SYNC_PATH_REALM, (client, handler, buf, responseSender) -> {
            String pathName = buf.readString();
            String realmKey = buf.readString();
            client.execute(() -> {
                if (client.player instanceof ModPlayerImpl playerImpl) {
                    ModPath path = ModPath.valueOf(pathName);
                    ModPathRealm realm = ModPathRealm.fromNameKey(realmKey);
                    playerImpl.setRealm(path, realm);
                }
            });
        });

    }
}
