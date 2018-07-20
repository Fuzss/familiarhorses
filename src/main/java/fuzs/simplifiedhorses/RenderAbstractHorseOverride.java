package fuzs.simplifiedhorses;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntityZombieHorse;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAbstractHorseOverride extends RenderLiving<AbstractHorse> {
    private static final Map<Class<?>, ResourceLocation> MAP = Maps.newHashMap();
    private float scale;

    public RenderAbstractHorseOverride(RenderManager p_i47212_1_) {
        this(p_i47212_1_, 1.0F);
    }

    public RenderAbstractHorseOverride(RenderManager p_i47213_1_, float p_i47213_2_) {
        super(p_i47213_1_, new ModelHorseOverride(), 0.75F);
        this.scale = p_i47213_2_;
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(AbstractHorse entitylivingbaseIn, float partialTickTime) {
        boolean donkey = entitylivingbaseIn instanceof EntityDonkey;
        boolean mule = entitylivingbaseIn instanceof EntityMule;
        if (donkey) {
            this.scale = 0.87F;
        } else if (mule) {
            this.scale = 0.92F;
        }

        GlStateManager.scale(this.scale, this.scale, this.scale);
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(AbstractHorse entity) {
        return (ResourceLocation)MAP.get(entity.getClass());
    }

    static {
        MAP.put(EntityDonkey.class, new ResourceLocation("textures/entity/horse/donkey.png"));
        MAP.put(EntityMule.class, new ResourceLocation("textures/entity/horse/mule.png"));
        MAP.put(EntityZombieHorse.class, new ResourceLocation("textures/entity/horse/horse_zombie.png"));
        MAP.put(EntitySkeletonHorse.class, new ResourceLocation("textures/entity/horse/horse_skeleton.png"));
    }
}