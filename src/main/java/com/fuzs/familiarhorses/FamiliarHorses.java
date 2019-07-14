package com.fuzs.familiarhorses;

import com.fuzs.familiarhorses.handler.HorseHUDHandler;
import com.fuzs.familiarhorses.renderer.AbstractHorseRendererOverride;
import com.fuzs.familiarhorses.renderer.HorseRendererOverride;
import net.minecraft.entity.passive.horse.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"WeakerAccess", "unused"})
@Mod(FamiliarHorses.MODID)
public class FamiliarHorses {

    public static final String MODID = "familiarhorses";
    public static final String NAME = "Familiar Horses";
    public static final Logger LOGGER = LogManager.getLogger(FamiliarHorses.NAME);

    public FamiliarHorses() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

    }

    private void clientSetup(final FMLClientSetupEvent evt) {

        RenderingRegistry.registerEntityRenderingHandler(HorseEntity.class, HorseRendererOverride::new);
        RenderingRegistry.registerEntityRenderingHandler(DonkeyEntity.class, AbstractHorseRendererOverride::new);
        RenderingRegistry.registerEntityRenderingHandler(MuleEntity.class, AbstractHorseRendererOverride::new);
        RenderingRegistry.registerEntityRenderingHandler(SkeletonHorseEntity.class, AbstractHorseRendererOverride::new);
        RenderingRegistry.registerEntityRenderingHandler(ZombieHorseEntity.class, AbstractHorseRendererOverride::new);

        MinecraftForge.EVENT_BUS.register(new HorseHUDHandler());

    }

}
