package com.alex.guzhenren.screen;

import com.alex.guzhenren.api.ModPlayerImpl;
import com.alex.guzhenren.api.enums.ModGuMasterTalent;
import com.alex.guzhenren.api.enums.ModGuMasterRank;
import com.alex.guzhenren.api.enums.ModTenExtremePhysique;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class ModPlayerGUI extends Screen {

    private final ModPlayerImpl modPlayer;

    public ModPlayerGUI(PlayerEntity player) {
        super(Text.translatable("guzhenren.screen.title"));
        this.modPlayer = (ModPlayerImpl) player;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);

        int maxEssence = modPlayer.getMaxEssence();
        float currentEssence = modPlayer.getCurrentEssence();

        int moral = modPlayer.getMoral();
        ModGuMasterTalent talent = modPlayer.getTalent();
        ModTenExtremePhysique extremePhysique = modPlayer.getSpecialPhysique();
        ModGuMasterRank rank = modPlayer.getRank();

        context.drawTextWithShadow(this.textRenderer,
                Text.translatable("guzhenren.screen.rank").append(": ").append(Text.translatable(rank.getNameKey())),
                20, 20, 0xFFFFFF
        );

        context.drawTextWithShadow(this.textRenderer,
                Text.translatable("guzhenren.screen.essence").append(": ").append(String.format("%.2f", currentEssence)).append(" / " + maxEssence),
                20,40, 0xFFFFFF
        );

        context.drawTextWithShadow(this.textRenderer,
                Text.translatable("guzhenren.screen.moral").copy().append(": " + moral),
                20, 60, 0xFFFFFF
        );

        context.drawTextWithShadow(this.textRenderer,
                Text.translatable("guzhenren.screen.talent").append(": ").append(Text.translatable(talent.getNameKey())),
                20, 80, 0xFFFFFF
        );

        context.drawTextWithShadow(this.textRenderer,
                Text.translatable("guzhenren.screen.extreme_physique").append(": ").append(Text.translatable(extremePhysique.getNameKey())),
                20, 100, 0xFFFFFF
        );

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
