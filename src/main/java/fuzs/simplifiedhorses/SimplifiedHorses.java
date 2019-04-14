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
    public static final String VERSION = "1.2.1";
    public static final String AVERSIONS = "[1.11,1.12.2]";
    public static final boolean CLIENT = true;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityHorse.class, RenderHorseOverride::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDonkey.class, RenderAbstractHorseOverride::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMule.class, RenderAbstractHorseOverride::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonHorse.class, RenderAbstractHorseOverride::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieHorse.class, RenderAbstractHorseOverride::new);
    }
}
