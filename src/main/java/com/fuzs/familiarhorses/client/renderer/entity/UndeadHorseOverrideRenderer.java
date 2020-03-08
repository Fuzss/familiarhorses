package com.fuzs.familiarhorses.client.renderer.entity;

import com.fuzs.familiarhorses.client.renderer.entity.model.HorseOverrideModel;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.passive.horse.SkeletonHorseEntity;
import net.minecraft.entity.passive.horse.ZombieHorseEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class UndeadHorseOverrideRenderer extends AbstractHorseRenderer<AbstractHorseEntity, HorseOverrideModel<AbstractHorseEntity>> {

    private static final Map<Class<?>, ResourceLocation> field_195638_a = Maps.newHashMap(ImmutableMap.of(ZombieHorseEntity.class, new ResourceLocation("textures/entity/horse/horse_zombie.png"), SkeletonHorseEntity.class, new ResourceLocation("textures/entity/horse/horse_skeleton.png")));

    public UndeadHorseOverrideRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HorseOverrideModel<>(), 1.0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(AbstractHorseEntity entity) {
        return field_195638_a.get(entity.getClass());
    }

}