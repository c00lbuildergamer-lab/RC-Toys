package com.rctoys;

import net.fabricmc.api.ModInitializer;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import java.util.function.UnaryOperator;

public class RCToysMod implements ModInitializer {
    public static final String MOD_ID = "rc-toys";
    
    // Modern 26.3 Data Components to replace the broken NBT tags
    public static final ComponentType<Integer> TOY_COLOR = registerComponent("toy_color", builder -> builder.codec(net.minecraft.util.dynamic.Codecs.NON_NEGATIVE_INT));
    public static final ComponentType<String> TOY_FREQUENCY = registerComponent("toy_frequency", builder -> builder.codec(com.mojang.serialization.codecs.RecordCodecBuilder.string(0, 256)));

    @Override
    public void onInitialize() {
        // Initialization logic for 26.3 content goes here
    }

    private static <T> ComponentType<T> registerComponent(String path, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(
            Registries.DATA_COMPONENT_TYPE, 
            Identifier.of(MOD_ID, path), 
            builderOperator.apply(ComponentType.builder()).build()
        );
    }
}
