package me.bluefox.pvphud;

import me.bluefox.pvphud.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;

public class PvPHudClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
