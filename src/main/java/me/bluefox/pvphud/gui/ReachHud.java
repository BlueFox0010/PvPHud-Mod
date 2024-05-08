package me.bluefox.pvphud.gui;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.ActionResult;

import java.text.DecimalFormat;

public class ReachHud implements HudRenderCallback {
    private final MinecraftClient client = MinecraftClient.getInstance();
    private double distance = 0;
    private DecimalFormat dc = new DecimalFormat("0.00");
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {

        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {

            double distance = Math.sqrt(getSquare(player.getX() - entity.getX()) + getSquare(player.getY() - entity.getY()) + getSquare(player.getZ() - entity.getZ()));
            this.distance = distance;

            return ActionResult.PASS;
        });

        if (distance > 3) distance = 3;
        drawContext.drawText(client.textRenderer, dc.format(distance) + " blocks", 300, 0, 0xffffff, true);
    }

    public static double getSquare(double number) {
        return number * number;
    }
}
