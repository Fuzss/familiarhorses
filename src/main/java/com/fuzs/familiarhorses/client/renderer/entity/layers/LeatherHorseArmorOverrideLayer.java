package com.fuzs.familiarhorses.client.renderer.entity.layers;

import com.fuzs.familiarhorses.client.renderer.entity.model.HorseOverrideModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.item.DyeableHorseArmorItem;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public final class LeatherHorseArmorOverrideLayer extends LayerRenderer<HorseEntity, HorseOverrideModel<HorseEntity>> {

    private final HorseModel<HorseEntity> field_215341_a = new HorseOverrideModel<>(0.1F);

    public LeatherHorseArmorOverrideLayer(IEntityRenderer<HorseEntity, HorseOverrideModel<HorseEntity>> p_i50937_1_) {
        super(p_i50937_1_);
    }

    @Override
    public void render(@Nonnull MatrixStack p_225628_1_, @Nonnull IRenderTypeBuffer p_225628_2_, int p_225628_3_, HorseEntity p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
        ItemStack lvt_11_1_ = p_225628_4_.func_213803_dV();
        if (lvt_11_1_.getItem() instanceof HorseArmorItem) {
            HorseArmorItem lvt_12_1_ = (HorseArmorItem) lvt_11_1_.getItem();
            this.getEntityModel().copyModelAttributesTo(this.field_215341_a);
            this.field_215341_a.setLivingAnimations(p_225628_4_, p_225628_5_, p_225628_6_, p_225628_7_);
            this.field_215341_a.setRotationAngles(p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_);
            float lvt_13_2_;
            float lvt_14_2_;
            float lvt_15_2_;
            if (lvt_12_1_ instanceof DyeableHorseArmorItem) {
                int lvt_16_1_ = ((DyeableHorseArmorItem) lvt_12_1_).getColor(lvt_11_1_);
                lvt_13_2_ = (float) (lvt_16_1_ >> 16 & 255) / 255.0F;
                lvt_14_2_ = (float) (lvt_16_1_ >> 8 & 255) / 255.0F;
                lvt_15_2_ = (float) (lvt_16_1_ & 255) / 255.0F;
            } else {
                lvt_13_2_ = 1.0F;
                lvt_14_2_ = 1.0F;
                lvt_15_2_ = 1.0F;
            }

            IVertexBuilder lvt_16_2_ = p_225628_2_.getBuffer(RenderType.getEntityCutoutNoCull(lvt_12_1_.func_219976_d()));
            this.field_215341_a.render(p_225628_1_, lvt_16_2_, p_225628_3_, OverlayTexture.NO_OVERLAY, lvt_13_2_, lvt_14_2_, lvt_15_2_, 1.0F);
        }
    }

}