package com.fuzs.familiarhorses;

import com.fuzs.familiarhorses.client.HorseHudHandler;
import com.fuzs.familiarhorses.client.renderer.entity.ChestedHorseOverrideRenderer;
import com.fuzs.familiarhorses.client.renderer.entity.HorseOverrideRenderer;
import com.fuzs.familiarhorses.client.renderer.entity.UndeadHorseOverrideRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.NativeImage;
import net.minecraft.client.resources.ClientResourcePackInfo;
import net.minecraft.entity.EntityType;
import net.minecraft.resources.*;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.moddiscovery.ModFileInfo;
import net.minecraftforge.fml.packs.ModFileResourcePack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"WeakerAccess", "unused"})
@Mod(FamiliarHorses.MODID)
public class FamiliarHorses {

    public static final String MODID = "familiarhorses";
    public static final String NAME = "Familiar Horses";
    public static final String DESCRIPTION = "Restoring the horse model to its former glory!";
    public static final Logger LOGGER = LogManager.getLogger(FamiliarHorses.NAME);

    private ResourcePack internalResourcePack;

    public FamiliarHorses() {

        DistExecutor.runWhenOn(Dist.CLIENT, () -> this::registerEntityRenderers);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent evt) {

        MinecraftForge.EVENT_BUS.register(new HorseHudHandler());
    }

    private void registerEntityRenderers() {

        RenderingRegistry.registerEntityRenderingHandler(EntityType.HORSE, HorseOverrideRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityType.DONKEY, renderManagerIn -> new ChestedHorseOverrideRenderer<>(renderManagerIn, 0.87F));
        RenderingRegistry.registerEntityRenderingHandler(EntityType.MULE, renderManagerIn -> new ChestedHorseOverrideRenderer<>(renderManagerIn, 0.92F));
        RenderingRegistry.registerEntityRenderingHandler(EntityType.SKELETON_HORSE, UndeadHorseOverrideRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityType.ZOMBIE_HORSE, UndeadHorseOverrideRenderer::new);
    }

}
