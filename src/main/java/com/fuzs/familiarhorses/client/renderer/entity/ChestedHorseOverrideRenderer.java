package com.fuzs.familiarhorses.client.renderer.entity;

import com.fuzs.familiarhorses.client.renderer.entity.model.HorseOverrideModel;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.client.renderer.entity.AbstractHorseRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.passive.horse.AbstractChestedHorseEntity;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.passive.horse.MuleEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public final class ChestedHorseOverrideRenderer<T extends AbstractChestedHorseEntity> extends AbstractHorseRenderer<T, HorseOverrideModel<T>> {

    private static final Map<Class<?>, ResourceLocation> field_195635_a = Maps.newHashMap(ImmutableMap.of(DonkeyEntity.class, new ResourceLocation("textures/entity/horse/donkey.png"), MuleEntity.class, new ResourceLocation("textures/entity/horse/mule.png")));

    public ChestedHorseOverrideRenderer(EntityRendererManager renderManagerIn, float scale) {
        super(renderManagerIn, new HorseOverrideModel<>(), scale);
    }

    @Override
    @Nonnull
    public ResourceLocation getEntityTexture(T entity) {
        return field_195635_a.get(entity.getClass());
    }

}