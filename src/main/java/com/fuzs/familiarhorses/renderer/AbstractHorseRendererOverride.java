package com.fuzs.familiarhorses.renderer;

import com.fuzs.familiarhorses.renderer.model.HorseModelOverride;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.passive.horse.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class AbstractHorseRendererOverride extends MobRenderer<AbstractHorseEntity, HorseModelOverride<AbstractHorseEntity>> {

    private static final Map < Class<?>, ResourceLocation > MAP = Maps. < Class<?>, ResourceLocation > newHashMap();
    private final float scale;

    public AbstractHorseRendererOverride(EntityRendererManager renderManagerIn)
    {
        this(renderManagerIn, 1.0F);
    }

    public AbstractHorseRendererOverride(EntityRendererManager p_i47213_1_, float scale)
    {
        super(p_i47213_1_, new HorseModelOverride<>(), 0.75F);
        this.scale = scale;
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(AbstractHorseEntity entitylivingbaseIn, float partialTickTime)
    {
        GlStateManager.scalef(this.scale, this.scale, this.scale);
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(AbstractHorseEntity entity)
    {
        return MAP.get(entity.getClass());
    }

    static
    {
        MAP.put(DonkeyEntity.class, new ResourceLocation("textures/entity/horse2/donkey.png"));
        MAP.put(MuleEntity.class, new ResourceLocation("textures/entity/horse2/mule.png"));
        MAP.put(ZombieHorseEntity.class, new ResourceLocation("textures/entity/horse2/horse_zombie.png"));
        MAP.put(SkeletonHorseEntity.class, new ResourceLocation("textures/entity/horse2/horse_skeleton.png"));
    }

}