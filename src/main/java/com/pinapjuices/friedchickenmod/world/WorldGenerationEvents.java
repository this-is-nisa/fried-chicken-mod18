package com.pinapjuices.friedchickenmod.world.features;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.pinapjuices.friedchickenmod.FriedChickenMod;
import com.pinapjuices.friedchickenmod.world.gen.ModFlowerGeneration;


@Mod.EventBusSubscriber(modid = FriedChickenMod.MOD_ID)
public class WorldGenerationEvents {
    @SubscribeEvent
    public static void ModWorldGeneration(final BiomeLoadingEvent event) {
        ModFlowerGeneration.generateFlowers(event);
    }
}