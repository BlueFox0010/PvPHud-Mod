package me.bluefox.pvphud.gui;

import me.bluefox.pvphud.event.KeyInputHandler;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class ToggleSprintHud implements HudRenderCallback {
    private final MinecraftClient client = MinecraftClient.getInstance();

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {

        drawContext.drawText(client.textRenderer, "[Sprint " + (KeyInputHandler.toggleSprint ? "Toggled]" : "Holded]"), 100, 0, 0xffffff, true);
    }
}
