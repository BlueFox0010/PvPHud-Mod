package me.bluefox.pvphud.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static MinecraftClient client = MinecraftClient.getInstance();

    public static String KEY_CATEGORY = "key.category.pvphud";
    public static String KEY_OPEN_CONFIG = "key.pvphud.open_config";
    public static String KEY_TOGGLE_SPRINT = "key.pvphud.toggle_sprint";

    public static boolean toggleSprint = false;

    public static KeyBinding openConfig;
    public static KeyBinding toggleSprintKey;
    public static void regsterKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (toggleSprintKey.wasPressed()) {
                if (toggleSprint) toggleSprint = false;
                else toggleSprint = true;
            }

            if (client.options.forwardKey.wasPressed() && toggleSprint)
                client.player.setSprinting(true);
        });
    }

    public static void register() {
        openConfig = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_OPEN_CONFIG,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                KEY_CATEGORY
        ));

        toggleSprintKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_TOGGLE_SPRINT,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_I,
                KEY_CATEGORY
        ));

        regsterKeyInputs();
    }
}
