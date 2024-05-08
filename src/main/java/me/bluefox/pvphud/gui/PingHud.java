package me.bluefox.pvphud.gui;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class PingHud implements HudRenderCallback {
    private final MinecraftClient client = MinecraftClient.getInstance();

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        assert client.player != null;
        int ping = client.player.networkHandler.getPlayerListEntry(MinecraftClient.getInstance().player.getUuid()).getLatency();
        drawContext.drawText(client.textRenderer, "Ping: " + ping, 200, 100, 0xffffff, true);
    }
}
