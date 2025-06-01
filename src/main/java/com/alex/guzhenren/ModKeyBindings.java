package com.alex.guzhenren;

import com.alex.guzhenren.screen.ModPlayerGUI;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ModKeyBindings {

    private static KeyBinding openGuiKey;

    public static void register() {
        openGuiKey = new KeyBinding(
                "key.guzhenren.open_gui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_G, "category.guzhenren"
        );

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (openGuiKey.wasPressed()) {
                if (client.player != null) {
                    client.setScreen(new ModPlayerGUI(client.player));
                }
            }
        });

        KeyBindingHelper.registerKeyBinding(openGuiKey);
    }
}
