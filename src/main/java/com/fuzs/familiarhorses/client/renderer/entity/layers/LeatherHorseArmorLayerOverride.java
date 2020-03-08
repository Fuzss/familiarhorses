package com.fuzs.familiarhorses.client.renderer.entity.layers;

import com.fuzs.familiarhorses.client.renderer.entity.model.HorseOverrideModel;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.item.DyeableHorseArmorItem;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LeatherHorseArmorLayerOverride extends LayerRenderer<HorseEntity, HorseOverrideModel<HorseEntity>> {

    private final HorseOverrideModel<HorseEntity> model = new HorseOverrideModel<>(0.1F);

    public LeatherHorseArmorLayerOverride(IEntityRenderer<HorseEntity, HorseOverrideModel<HorseEntity>> p_i50937_1_) {
        super(p_i50937_1_);
    }

    public void render(HorseEntity entityIn, float p_212842_2_, float p_212842_3_, float p_212842_4_, float p_212842_5_, float p_212842_6_, float p_212842_7_, float p_212842_8_) {
        ItemStack itemstack = entityIn.func_213803_dV();
        if (itemstack.getItem() instanceof HorseArmorItem) {
            HorseArmorItem horsearmoritem = (HorseArmorItem) itemstack.getItem();
            this.getEntityModel().setModelAttributes(this.model);
            this.model.setLivingAnimations(entityIn, p_212842_2_, p_212842_3_, p_212842_4_);
            this.bindTexture(horsearmoritem.func_219976_d());
            if (horsearmoritem instanceof DyeableHorseArmorItem) {
                int i = ((DyeableHorseArmorItem) horsearmoritem).getColor(itemstack);
                float f = (float) (i >> 16 & 255) / 255.0F;
                float f1 = (float) (i >> 8 & 255) / 255.0F;
                float f2 = (float) (i & 255) / 255.0F;
                GlStateManager.color4f(f, f1, f2, 1.0F);
                this.model.render(entityIn, p_212842_2_, p_212842_3_, p_212842_5_, p_212842_6_, p_212842_7_, p_212842_8_);
                return;
            }

            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.model.render(entityIn, p_212842_2_, p_212842_3_, p_212842_5_, p_212842_6_, p_212842_7_, p_212842_8_);
        }

    }

    public boolean shouldCombineTextures() {
        return false;
    }

}