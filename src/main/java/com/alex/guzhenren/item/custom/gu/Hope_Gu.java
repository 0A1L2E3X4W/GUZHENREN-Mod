package com.alex.guzhenren.item.custom.gu;

import com.alex.guzhenren.api.ModPlayerImpl;
import com.alex.guzhenren.api.enums.ModGuMasterTalent;
import com.alex.guzhenren.api.enums.ModGuMasterRank;
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
        ModPlayerImpl modPlayer = (ModPlayerImpl)user;

        if (!world.isClient()) {

            if (!modPlayer.getApertureStatus()) {
                modPlayer.setRank(ModGuMasterRank.RANK_ONE_INIT);

                ModGuMasterTalent talent = getRandomTalent();
                modPlayer.setTalent(talent);

                if (talent == ModGuMasterTalent.TEN_EXTREME) {
                    ModTenExtremePhysique extremePhysique = getRandomPhysique();
                    modPlayer.setSpecialPhysique(extremePhysique);
                }
                else {
                    modPlayer.setSpecialPhysique(ModTenExtremePhysique.NULL);
                }

                modPlayer.setMaxEssence(getRandomMaxEssence(talent));
                modPlayer.setCurrentEssence(modPlayer.getMaxEssence());

                itemStack.decrement(1);
                return TypedActionResult.success(itemStack);
            }
        }

        return TypedActionResult.fail(itemStack);
    }

    private ModGuMasterTalent getRandomTalent() {
        Random rand = new Random();
        double r = rand.nextDouble() * 100;

        if (r < 25) return ModGuMasterTalent.D;
        if (r < 50) return ModGuMasterTalent.C;
        if (r < 70) return ModGuMasterTalent.B;
        if (r < 90) return ModGuMasterTalent.A;
        return ModGuMasterTalent.TEN_EXTREME;
    }

    private ModTenExtremePhysique getRandomPhysique() {
        ModTenExtremePhysique[] values = ModTenExtremePhysique.values();
        int index = new Random().nextInt(values.length - 1) + 1; // 跳过NULL
        return values[index];
    }

    private int getRandomMaxEssence(ModGuMasterTalent talent) {
        Random rand = new Random();
        int max = 100000;
        int min = 10000;

        if (talent == ModGuMasterTalent.A) { min = 80000; max = 99000; }
        if (talent == ModGuMasterTalent.B) { min = 60000; max = 79999; }
        if (talent == ModGuMasterTalent.C) { min = 40000; max = 59999; }
        if (talent == ModGuMasterTalent.D) { min = 20000; max = 39999; }
        if (talent == ModGuMasterTalent.TEN_EXTREME) { return 100000; }

        return rand.nextInt(max - min + 1) + min;
    }
}
