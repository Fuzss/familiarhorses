package fuzs.simplifiedhorses;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntityZombieHorse;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(SimplifiedHorses.MODID)
public class SimplifiedHorses {
    public static final String MODID = "familiarhorses";

    public SimplifiedHorses() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityHorse.class, new IRenderFactory<EntityHorse>() {
            public Render<? super EntityHorse> createRenderFor(RenderManager manager) {
                return new RenderHorseOverride(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityDonkey.class, new IRenderFactory<EntityDonkey>() {
            public Render<? super EntityDonkey> createRenderFor(RenderManager manager) {
                return new RenderAbstractHorseOverride(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityMule.class, new IRenderFactory<EntityMule>() {
            public Render<? super EntityMule> createRenderFor(RenderManager manager) {
                return new RenderAbstractHorseOverride(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonHorse.class, new IRenderFactory<EntitySkeletonHorse>() {
            public Render<? super EntitySkeletonHorse> createRenderFor(RenderManager manager) {
                return new RenderAbstractHorseOverride(manager);
            }
        });
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieHorse.class, new IRenderFactory<EntityZombieHorse>() {
            public Render<? super EntityZombieHorse> createRenderFor(RenderManager manager) {
                return new RenderAbstractHorseOverride(manager);
            }
        });
    }
}
