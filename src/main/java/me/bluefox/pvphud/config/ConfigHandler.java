package me.bluefox.pvphud.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ConfigHandler {
    private String configFilePath = FabricLoader.getInstance().getConfigDir().toString() + "\\pvphud.json";
    public void createConfig() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject mainJson = new JsonObject();

        mainJson.add("fpsHud", fpsHud());
        mainJson.add("pingHud", pingHud());

        if (!new File(configFilePath).exists()) {
            try (Writer writer = new FileWriter(configFilePath)) {
                writer.write(gson.toJson(mainJson));

                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public JsonObject fpsHud() {
        JsonObject fpsJson = new JsonObject();
        fpsJson.addProperty("EnableHud", false);
        fpsJson.addProperty("TextShadow", false);
        fpsJson.addProperty("Scale", 1.0);

        return fpsJson;
    }

    public JsonObject pingHud() {
        JsonObject fpsJson = new JsonObject();
        fpsJson.addProperty("EnableHud", false);
        fpsJson.addProperty("TextShadow", false);
        fpsJson.addProperty("Scale", 1.0);

        return fpsJson;
    }
}