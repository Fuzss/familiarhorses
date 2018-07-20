package fuzs.simplifiedhorses;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.LayeredTexture;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.HorseType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHorseOverride extends RenderLiving<EntityHorse> {
    private static final Map<String, ResourceLocation> LAYERED_LOCATION_CACHE = Maps.newHashMap();

    public RenderHorseOverride(RenderManager p_i47205_1_) {
        super(p_i47205_1_, new ModelHorseOverride(), 0.75F);
    }

    protected void preRenderCallback(EntityHorse p_preRenderCallback_1_, float p_preRenderCallback_2_) {
        HorseType lvt_4_1_ = p_preRenderCallback_1_.getType();
        float size;
        if (lvt_4_1_ == HorseType.DONKEY) {
            size = 0.87F;
        } else if (lvt_4_1_ == HorseType.MULE) {
            size = 0.92F;
        } else if (lvt_4_1_ == HorseType.HORSE) {
            size = 1.1F;
        } else {
            size = 1.0F;
        }

        GlStateManager.scale(size, size, size);
        super.preRenderCallback(p_preRenderCallback_1_, p_preRenderCallback_2_);
    }

    protected ResourceLocation getEntityTexture(EntityHorse p_getEntityTexture_1_) {
        return !p_getEntityTexture_1_.hasLayeredTextures() ? p_getEntityTexture_1_.getType().getTexture() : this.getOrCreateLayeredResourceLoc(p_getEntityTexture_1_);
    }

    protected ResourceLocation getOrCreateLayeredResourceLoc(EntityHorse entity) {
        String s = entity.getHorseTexture();
        ResourceLocation resourcelocation = (ResourceLocation)LAYERED_LOCATION_CACHE.get(s);
        if (resourcelocation == null) {
            resourcelocation = new ResourceLocation(s);
            Minecraft.getMinecraft().getTextureManager().loadTexture(resourcelocation, new LayeredTexture(entity.getVariantTexturePaths()));
            LAYERED_LOCATION_CACHE.put(s, resourcelocation);
        }

        return resourcelocation;
    }
}