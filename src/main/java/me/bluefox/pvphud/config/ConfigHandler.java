package me.bluefox.pvphud.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.nio.file.Path;

public class ConfigHandler {
    private static File configFile;
    private static Path configPath = Path.of(FabricLoader.getInstance().getConfigDir() + "\\PvPHudConfig.json");
    public void createConfig() {
        FileWriter writer = null;
        JsonObject mainJson = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        jsonArray.add(fpsJson());

        mainJson.add("fpsHud", jsonArray);

        configFile = new File(String.valueOf(configPath));

        String json = gson.toJson(mainJson);
        if (!configFile.exists()) {
            try {
                writer = new FileWriter(configPath.toString());
                writer.write(json);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean fpsEnableHud = false;
    private boolean fpsTextShadow = false;
    private float fpsScale = 1;
    private JsonObject fpsJson() {
        JsonObject fpsJson = new JsonObject();

        fpsJson.addProperty("fpsEnableHud", fpsEnableHud);
        fpsJson.addProperty("fpsTextShadow", fpsTextShadow);
        fpsJson.addProperty("fpsScale", fpsScale);

        return fpsJson;
    }
}