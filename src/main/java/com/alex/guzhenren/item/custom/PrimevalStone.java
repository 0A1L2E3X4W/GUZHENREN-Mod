package com.alex.guzhenren.item.custom;

import com.alex.guzhenren.api.ModPlayerImpl;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PrimevalStone extends Item {

    public PrimevalStone(Settings settings) {
        super(settings);
    }

    private final int ESSENCE = 5000;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        ModPlayerImpl modPlayer = (ModPlayerImpl)user;
        float currentEssence = modPlayer.getCurrentEssence();
        int maxEssence = modPlayer.getMaxEssence();

        if (currentEssence >= maxEssence) {
            return super.use(world, user, hand);
        }
        else {
            if ((maxEssence - currentEssence) >= ESSENCE) {
                modPlayer.setCurrentEssence(maxEssence);
            }
            else {
                modPlayer.changeCurrentEssence(ESSENCE);
            }
        }

        user.getItemCooldownManager().set(this, 3);
        itemStack.decrement(1);

        return super.use(world, user, hand);
    }
}
