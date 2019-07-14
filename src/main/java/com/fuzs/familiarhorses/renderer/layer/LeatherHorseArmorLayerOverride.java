package com.fuzs.familiarhorses.renderer.layer;

import com.fuzs.familiarhorses.renderer.model.HorseModelOverride;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.item.DyeableHorseArmorItem;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class LeatherHorseArmorLayerOverride extends LayerRenderer<HorseEntity, HorseModelOverride<HorseEntity>> {
   private final HorseModelOverride<HorseEntity> model = new HorseModelOverride<>(0.1f);

   public LeatherHorseArmorLayerOverride(IEntityRenderer<HorseEntity, HorseModelOverride<HorseEntity>> p_i50937_1_) {
      super(p_i50937_1_);
   }

   public void render(HorseEntity entityIn, float p_212842_2_, float p_212842_3_, float p_212842_4_, float p_212842_5_, float p_212842_6_, float p_212842_7_, float p_212842_8_) {
      ItemStack itemstack = entityIn.func_213803_dV();
      if (itemstack.getItem() instanceof HorseArmorItem) {
         HorseArmorItem horsearmoritem = (HorseArmorItem)itemstack.getItem();
         this.getEntityModel().setModelAttributes(this.model);
         this.model.setLivingAnimations(entityIn, p_212842_2_, p_212842_3_, p_212842_4_);
         this.bindTexture(new ResourceLocation(horsearmoritem.func_219976_d().getPath().replaceFirst("horse", "horse2")));
         if (horsearmoritem instanceof DyeableHorseArmorItem) {
            int i = ((DyeableHorseArmorItem)horsearmoritem).getColor(itemstack);
            float f = (float)(i >> 16 & 255) / 255.0F;
            float f1 = (float)(i >> 8 & 255) / 255.0F;
            float f2 = (float)(i & 255) / 255.0F;
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