package me.bluefox.pvphud;

import me.bluefox.pvphud.config.ConfigHandler;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PvPHud implements ModInitializer {
    public static final String MOD_ID = "pvp-hud";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("PvP Hud is now starting!");

        ConfigHandler configHandler = new ConfigHandler();

        configHandler.createConfig();
    }
}

