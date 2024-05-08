package me.bluefox.pvphud.gui;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class FPSHud implements HudRenderCallback {
    private final MinecraftClient client = MinecraftClient.getInstance();
    //Color: https://convertingcolors.com/
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        drawContext.drawText(client.textRenderer, "FPS: " + client.getCurrentFps(), 0, 0, 0xffffff, true);
    }
}
