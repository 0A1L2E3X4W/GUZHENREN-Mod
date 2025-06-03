package com.alex.guzhenren.item.custom.gu;

import com.alex.guzhenren.api.ModPlayerImpl;
import com.alex.guzhenren.api.enums.ModPath;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Gu_WhiteBoar_1 extends Item {

    public Gu_WhiteBoar_1(Settings settings) {
        super(settings);
    }

    public static final int ESSENCE_REQUIRE = -5000;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        ModPlayerImpl modPlayer = (ModPlayerImpl)user;

        if (!world.isClient()) {

            int modifier = modPlayer.getRank().getEssenceModifier();
            int result = ESSENCE_REQUIRE / modifier;

            if (modPlayer.getCurrentEssence() < -result) {
                return TypedActionResult.fail(itemStack);
            }

            modPlayer.changeCurrentEssence(result);
            modPlayer.changeAttainment(ModPath.POWER, 1);
            user.getItemCooldownManager().set(this,  4);
            itemStack.damage(1, user, player -> player.sendToolBreakStatus(hand));
            return TypedActionResult.success(itemStack);
        }

        return TypedActionResult.fail(itemStack);
    }
}
