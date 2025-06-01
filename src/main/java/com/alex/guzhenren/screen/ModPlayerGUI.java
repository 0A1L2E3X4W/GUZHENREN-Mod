package com.alex.guzhenren.screen;

import com.alex.guzhenren.api.ModPlayerImpl;
import com.alex.guzhenren.api.enums.ModPlayerTalent;
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

        int moral = modPlayer.getMoral();

        context.drawCenteredTextWithShadow(this.textRenderer,
                Text.translatable("guzhenren.screen.moral").copy().append(": " + moral),
                this.width / 2 - 40, this.height / 2, 0xFFFFFF
        );

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
