package com.alex.guzhenren.item.custom.gu;

import com.alex.guzhenren.api.ModPlayerImpl;
import com.alex.guzhenren.api.enums.ModPath;
import com.alex.guzhenren.effect.ModEffects;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class Gu_BlackBoar_1 extends Item {

    public Gu_BlackBoar_1(Settings settings) {
        super(settings);
    }

    private static final int ESSENCE_REQUIRE = -5000;
    private static final String USED_COUNT = "blackboar1_used_count";

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        ModPlayerImpl modPlayer = (ModPlayerImpl)user;

        if (!world.isClient())

            if (!modPlayer.getApertureStatus()) {
                return TypedActionResult.fail(itemStack);
            }
            else {
                int modifier = modPlayer.getRank().getEssenceModifier();
                int result = ESSENCE_REQUIRE / modifier;

                if (modPlayer.getCurrentEssence() < -result) {
                    return TypedActionResult.fail(itemStack);
                }

                int count = itemStack.getOrCreateNbt().getInt(USED_COUNT);

                if (count >= 19) {
                    user.addStatusEffect(new StatusEffectInstance(ModEffects.BLACK_BOAR_POWER, StatusEffectInstance.INFINITE, 0));
                }
                else {
                    count ++;
                    itemStack.getOrCreateNbt().putInt(USED_COUNT, count);

                    modPlayer.changeCurrentEssence(result);
                    modPlayer.changeAttainment(ModPath.POWER, 1);
                    user.getItemCooldownManager().set(this,  4);
                    itemStack.damage(1, user, player -> player.sendToolBreakStatus(hand));
                }
                return TypedActionResult.success(itemStack);
            }

        return TypedActionResult.fail(itemStack);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        int count = stack.getOrCreateNbt().getInt(USED_COUNT);
        tooltip.add(Text.literal("Used Cound: " + count));
    }
}
