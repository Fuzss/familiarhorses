package com.fuzs.familiarhorses;

import com.fuzs.familiarhorses.client.HorseHudHandler;
import com.fuzs.familiarhorses.client.renderer.entity.ChestedHorseOverrideRenderer;
import com.fuzs.familiarhorses.client.renderer.entity.HorseOverrideRenderer;
import com.fuzs.familiarhorses.client.renderer.entity.UndeadHorseOverrideRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.NativeImage;
import net.minecraft.client.resources.ClientResourcePackInfo;
import net.minecraft.entity.passive.horse.*;
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
        DistExecutor.runWhenOn(Dist.CLIENT, () -> this::addResourcePack);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
    }

    private void clientSetup(final FMLClientSetupEvent evt) {

        MinecraftForge.EVENT_BUS.register(new HorseHudHandler());
    }

    private void registerEntityRenderers() {

        RenderingRegistry.registerEntityRenderingHandler(HorseEntity.class, HorseOverrideRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(DonkeyEntity.class, renderManagerIn -> new ChestedHorseOverrideRenderer<>(renderManagerIn, 0.87F));
        RenderingRegistry.registerEntityRenderingHandler(MuleEntity.class, renderManagerIn -> new ChestedHorseOverrideRenderer<>(renderManagerIn, 0.92F));
        RenderingRegistry.registerEntityRenderingHandler(SkeletonHorseEntity.class, UndeadHorseOverrideRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ZombieHorseEntity.class, UndeadHorseOverrideRenderer::new);
    }

    private void addResourcePack() {

        List<ModFileInfo> modFiles = ModList.get().getModFiles();
        for (ModFileInfo modFileInfo : modFiles) {

            if (modFileInfo.getMods().get(0).getModId().equals(MODID)) {

                this.internalResourcePack = new ModFileResourcePack(modFileInfo.getFile());
                break;
            }
        }

        ResourcePackList<ClientResourcePackInfo> packList = Minecraft.getInstance().getResourcePackList();
        packList.addPackFinder(new IPackFinder() {

            @SuppressWarnings("unchecked")
            @Override
            public <T extends ResourcePackInfo> void addPackInfosToMap(@Nonnull Map<String, T> nameToPackMap, @Nonnull ResourcePackInfo.IFactory<T> packInfoFactory) {

                NativeImage nativeimage = null;

                try (InputStream inputstream = FamiliarHorses.this.internalResourcePack.getRootResourceStream("pack.png")) {
                    nativeimage = NativeImage.read(inputstream);
                } catch (IllegalArgumentException | IOException ioexception) {
                    LOGGER.info("Could not read pack.png: {}", ioexception.getMessage());
                }

                T pack = (T) new ClientResourcePackInfo(MODID, true, () -> FamiliarHorses.this.internalResourcePack, new StringTextComponent(NAME),
                        new StringTextComponent(DESCRIPTION), PackCompatibility.COMPATIBLE, ResourcePackInfo.Priority.TOP, false, nativeimage, false);

                nameToPackMap.put(MODID, pack);
            }

        });
    }

}
