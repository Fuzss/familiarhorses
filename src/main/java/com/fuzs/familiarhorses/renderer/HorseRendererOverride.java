package com.fuzs.familiarhorses.renderer;

import com.fuzs.familiarhorses.renderer.layer.LeatherHorseArmorLayerOverride;
import com.fuzs.familiarhorses.renderer.model.HorseModelOverride;
import com.google.common.collect.Maps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.LayeredTexture;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Arrays;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class HorseRendererOverride extends MobRenderer<HorseEntity, HorseModelOverride<HorseEntity>> {

    private static final Map<String, ResourceLocation> LAYERED_LOCATION_CACHE = Maps.newHashMap();

    public HorseRendererOverride(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HorseModelOverride<>(), 0.75f);
        this.addLayer(new LeatherHorseArmorLayerOverride(this));
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(HorseEntity entity)
    {
        String s = entity.getHorseTexture();
        ResourceLocation resourcelocation = LAYERED_LOCATION_CACHE.get(s);

        if (resourcelocation == null)
        {
            resourcelocation = new ResourceLocation(s);

            String[] resources = Arrays.stream(entity.getVariantTexturePaths()).map(it -> {
                if (it != null) {
                    return it.replaceFirst("horse", "horse2");
                }
                return null;
            }).toArray(String[]::new);

            Minecraft.getInstance().getTextureManager().loadTexture(resourcelocation, new LayeredTexture(resources));
            LAYERED_LOCATION_CACHE.put(s, resourcelocation);
        }

        return resourcelocation;
    }

}