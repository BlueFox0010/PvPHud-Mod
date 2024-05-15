package me.bluefox.pvphud.config;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionGroup;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.FloatSliderControllerBuilder;
import dev.isxander.yacl3.impl.controller.BooleanControllerBuilderImpl;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class PvPHudConfig {
    public static boolean fpsEnableHud = false;
    public static boolean fpsTextShadow = false;
    public static float fpsScale = 1F;

    public static boolean pingEnableHud = false;
    public static boolean pingTextShadow = false;

    public static Screen createGui(Screen parent) {
        return YetAnotherConfigLib.createBuilder()
                .title(Text.translatable("config.title"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.of("PvPHud Config"))
                        //FPS hud
                        .group(OptionGroup.createBuilder()
                                .name(Text.translatable("config.category.fpsDisplay.title"))
                                .option(Option.createBuilder(Boolean.class)
                                        .name(Text.translatable("config.option.fpsDisplay.enableHud"))
                                        .binding(
                                                false,
                                                () -> fpsEnableHud,
                                                newValue -> fpsEnableHud = newValue
                                        )
                                        .controller(BooleanControllerBuilderImpl::new)
                                        .build())
                                .option(Option.createBuilder(Boolean.class)
                                        .name(Text.translatable("config.option.fpsDisplay.textShadow"))
                                        .binding(
                                                false,
                                                () -> fpsTextShadow,
                                                newValue -> fpsTextShadow = newValue
                                        )
                                        .controller(BooleanControllerBuilderImpl::new)
                                        .build())
                                .option(Option.createBuilder(Float.class)
                                        .name(Text.translatable("config.option.fpsDisplay.hudScale"))
                                        .binding(
                                                1F,
                                                () -> fpsScale,
                                                newValue -> fpsScale = newValue
                                        )
                                        .controller(opt -> FloatSliderControllerBuilder.create(opt)
                                                .range(1F, 2F)
                                                .step(0.1F)
                                        )
                                        .build())
                                .build())

                        //Ping Hud
                        .group(OptionGroup.createBuilder()
                                .name(Text.translatable("config.category.pingDisplay.title"))
                                .option(Option.createBuilder(Boolean.class)
                                        .name(Text.translatable("config.option.pingDisplay.enableHud"))
                                        .binding(
                                                false,
                                                () -> pingEnableHud,
                                                newValue -> pingEnableHud = newValue
                                        )
                                        .controller(BooleanControllerBuilderImpl::new)
                                        .build())
                                .option(Option.createBuilder(Boolean.class)
                                        .name(Text.translatable("config.option.pingDisplay.textShadow"))
                                        .binding(
                                                false,
                                                () -> pingTextShadow,
                                                newValue -> pingTextShadow = newValue
                                        )
                                        .controller(BooleanControllerBuilderImpl::new)
                                        .build())
                                .build())
                        .build())
                .save(PvPHudConfig::save)
                .build()
                .generateScreen(parent);
    }

    public static void save() {

    }
}
