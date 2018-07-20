package fuzs.simplifiedhorses;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityHorse;
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
    public static final String AVERSIONS = "[1.9.4,1.10.2]";
    public static final boolean CLIENT = true;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityHorse.class, new IRenderFactory<EntityHorse>() {
            public Render<? super EntityHorse> createRenderFor(RenderManager manager) {
                return new RenderHorseOverride(manager);
            }
        });
    }
}
