package fuzs.simplifiedhorses;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntityZombieHorse;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SimplifiedHorses.MODID, name = SimplifiedHorses.NAME, version = SimplifiedHorses.VERSION, acceptedMinecraftVersions = SimplifiedHorses.AVERSIONS, clientSideOnly = SimplifiedHorses.CLIENT)
public class SimplifiedHorses {
    public static final String MODID = "simplifiedhorses";
    public static final String NAME = "simplifiedhorses";
    public static final String VERSION = "1.2";
    public static final String AVERSIONS = "[1.11,1.12.2]";
    public static final boolean CLIENT = true;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
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
