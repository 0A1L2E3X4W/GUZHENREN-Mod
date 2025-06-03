package com.alex.guzhenren.screen;

import com.alex.guzhenren.utils.ModPlayerImpl;
import com.alex.guzhenren.utils.enums.*;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class ModPlayerGUI extends Screen {

    private final ModPlayerImpl modPlayer;
    private int currentPage = 0; // 0 = 主页, 1 = 第二页, 2 = 第三页

    public ModPlayerGUI(PlayerEntity player) {
        super(Text.translatable("guzhenren.screen.title"));
        this.modPlayer = (ModPlayerImpl) player;
    }

    @Override
    protected void init() {
        int buttonWidth = 80;
        int buttonHeight = 20;
        int marginRight = 10;
        int spacing = 5;

        // 计算按钮的 x 坐标：屏幕宽度 - 按钮宽度 - 右边距
        int xPos = this.width - buttonWidth - marginRight;
        // 按钮从 y = 10 开始，向下依次排列
        int yStart = 10;

        this.addDrawableChild(ButtonWidget.builder(
                Text.translatable("guzhenren.screen.main_page_btn"),
                        (button) -> {
                            this.currentPage = 0;
                        })
                .dimensions(xPos, yStart, buttonWidth, buttonHeight)
                .build()
        );

        this.addDrawableChild(ButtonWidget.builder(
                Text.translatable("guzhenren.screen.path_page_btn"),
                        (button) -> {
                            this.currentPage = 1;
                        })
                .dimensions(xPos, yStart + (buttonHeight + spacing), buttonWidth, buttonHeight)
                .build()
        );

        this.addDrawableChild(ButtonWidget.builder(
                Text.translatable("guzhenren.screen.realm_page_btn"),
                        (button) -> {
                            this.currentPage = 2;
                        })
                .dimensions(xPos, yStart + 2 * (buttonHeight + spacing), buttonWidth, buttonHeight)
                .build()
        );
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);

        if (currentPage == 0) {
            renderMainPage(context);
        } else if (currentPage == 1) {
            renderPathPage(context);
        } else {
            renderRealmPage(context);
        }

        super.render(context, mouseX, mouseY, delta);
    }

    private void renderMainPage(DrawContext context) {
        int maxEssence = modPlayer.getMaxEssence();
        float currentEssence = modPlayer.getCurrentEssence();

        int moral = modPlayer.getMoral();
        int soul = modPlayer.getSoul();
        ModGuMasterTalent talent = modPlayer.getTalent();
        ModTenExtremePhysique extremePhysique = modPlayer.getExtremePhysique();
        ModGuMasterRank rank = modPlayer.getRank();

        context.drawTextWithShadow(this.textRenderer,
                Text.translatable("guzhenren.screen.rank").append(": ").append(Text.translatable(rank.getNameKey())),
                20, 20, 0xFFFFFF
        );

        context.drawTextWithShadow(this.textRenderer,
                Text.translatable("guzhenren.screen.essence").append(": ").append(String.format("%.0f", currentEssence)).append(" / " + maxEssence),
                20,40, 0xFFFFFF
        );

        context.drawTextWithShadow(this.textRenderer,
                Text.translatable("guzhenren.screen.talent").append(": ").append(Text.translatable(talent.getNameKey())),
                20, 60, 0xFFFFFF
        );

        context.drawTextWithShadow(this.textRenderer,
                Text.translatable("guzhenren.screen.extreme_physique").append(": ").append(Text.translatable(extremePhysique.getNameKey())),
                20, 80, 0xFFFFFF
        );

        context.drawTextWithShadow(this.textRenderer,
                Text.translatable("guzhenren.screen.moral").copy().append(": " + moral),
                20, 100, 0xFFFFFF
        );

        context.drawTextWithShadow(this.textRenderer,
                Text.translatable("guzhenren.screen.soul").copy().append(": " + soul),
                20, 120, 0xFFFFFF
        );
    }

    private void renderPathPage(DrawContext context) {
        int baseX = 20;
        int baseY = 20;
        int lineHeight = 20;
        int columnWidth = 100;

        int i = 0;
        for (ModPath path : ModPath.values()) {
            int attainment = modPlayer.getAttainment(path);
            int column = i / 11;
            int row = i % 11;

            int x = baseX + column * columnWidth;
            int y = baseY + row * lineHeight;

            context.drawTextWithShadow(
                    this.textRenderer,
                    Text.translatable(path.getNameKey()).append(Text.literal(": " + attainment)),
                    x, y, 0xFFFFFF
            );
            i++;
        }
    }

    private void renderRealmPage(DrawContext context) {
        int baseX = 20;
        int baseY = 20;
        int lineHeight = 20;
        int columnWidth = 100;

        int i = 0;
        for (ModPath path : ModPath.values()) {
            ModPathRealm realm = modPlayer.getRealm(path);

            int column = i / 11;
            int row = i % 11;

            int x = baseX + column * columnWidth;
            int y = baseY + row * lineHeight;

            context.drawTextWithShadow(
                    this.textRenderer,
                    Text.translatable(path.getNameKey()).append(Text.literal(": ")).append(Text.translatable(realm.getNameKey())),
                    x, y, 0xFFFFFF
            );
            i++;
        }
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
