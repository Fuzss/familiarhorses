package com.fuzs.familiarhorses.client.renderer.entity;

import com.fuzs.familiarhorses.client.renderer.entity.layers.LeatherHorseArmorLayerOverride;
import com.fuzs.familiarhorses.client.renderer.entity.model.HorseOverrideModel;
import com.google.common.collect.Maps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.LayeredTexture;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public final class HorseOverrideRenderer extends AbstractHorseRenderer<HorseEntity, HorseOverrideModel<HorseEntity>> {

    private static final Map<String, ResourceLocation> LAYERED_LOCATION_CACHE = Maps.newHashMap();

    public HorseOverrideRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HorseOverrideModel<>(), 1.0F);
        this.addLayer(new LeatherHorseArmorLayerOverride(this));
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(HorseEntity entity) {
        String s = entity.getHorseTexture();
        ResourceLocation resourcelocation = LAYERED_LOCATION_CACHE.get(s);
        if (resourcelocation == null) {
            resourcelocation = new ResourceLocation(s);
            Minecraft.getInstance().getTextureManager().loadTexture(resourcelocation, new LayeredTexture(entity.getVariantTexturePaths()));
            LAYERED_LOCATION_CACHE.put(s, resourcelocation);
        }

        return resourcelocation;
    }

}