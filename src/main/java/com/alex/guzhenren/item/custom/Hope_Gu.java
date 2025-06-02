package com.alex.guzhenren.item.custom;

import com.alex.guzhenren.api.ModPlayerImpl;
import com.alex.guzhenren.api.enums.ModPlayerTalent;
import com.alex.guzhenren.api.enums.ModRank;
import com.alex.guzhenren.api.enums.ModTenExtremePhysique;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Random;

public class Hope_Gu extends Item {

    public Hope_Gu(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient()) {

            if (!((ModPlayerImpl) user).getApertureStatus()) {
                ((ModPlayerImpl) user).setRank(ModRank.RANK_ONE);

                ModPlayerTalent talent = getRandomTalent();
                ((ModPlayerImpl) user).setTalent(talent);

                if (talent == ModPlayerTalent.TEN_EXTREME) {
                    ModTenExtremePhysique extremePhysique = getRandomPhysique();
                    ((ModPlayerImpl) user).setSpecialPhysique(extremePhysique);
                }
                else {
                    ((ModPlayerImpl) user).setSpecialPhysique(ModTenExtremePhysique.NULL);
                }

                ((ModPlayerImpl) user).setApertureStatus(true);

                itemStack.decrement(1);
            }
        }

        return TypedActionResult.success(itemStack);
    }

    private ModPlayerTalent getRandomTalent() {
        Random rand = new Random();
        double r = rand.nextDouble() * 100;

        if (r < 25) return ModPlayerTalent.D;
        if (r < 50) return ModPlayerTalent.C;
        if (r < 70) return ModPlayerTalent.B;
        if (r < 90) return ModPlayerTalent.A;
        return ModPlayerTalent.TEN_EXTREME;
    }

    private ModTenExtremePhysique getRandomPhysique() {
        ModTenExtremePhysique[] values = ModTenExtremePhysique.values();
        int index = new Random().nextInt(values.length - 1) + 1; // 跳过NULL
        return values[index];
    }
}
