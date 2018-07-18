package fuzs.simplifiedhorses.overrides;

import fuzs.simplifiedhorses.config.ConfigurationHandler;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.AbstractChestHorse;
import net.minecraft.entity.passive.AbstractHorse;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelHorseOverride extends ModelBase {
    private final ModelRenderer neck;
    private final ModelRenderer head;
    private final ModelRenderer mane;
    private final ModelRenderer snout;
    private final ModelRenderer horseLeftEar;
    private final ModelRenderer horseRightEar;
    private final ModelRenderer body;
    private final ModelRenderer tailBase;
    private final ModelRenderer backLeftLeg;
    private final ModelRenderer backRightLeg;
    private final ModelRenderer frontLeftLeg;
    private final ModelRenderer frontRightLeg;
    private final ModelRenderer horseSaddle;
    private final ModelRenderer horseLeftFaceMetal;
    private final ModelRenderer horseRightFaceMetal;
    private final ModelRenderer horseLeftRein;
    private final ModelRenderer horseRightRein;
    private final ModelRenderer horseFaceRopes;
    private final ModelRenderer muleLeftEar;
    private final ModelRenderer muleRightEar;
    private final ModelRenderer muleLeftChest;
    private final ModelRenderer muleRightChest;

    public ModelHorseOverride() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.body = new ModelRenderer(this, 0, 32);
        this.body.addBox(-5.0F, -8.0F, -17.0F, 10, 10, 22);
        this.body.setRotationPoint(0.0F, 11.0F, 5.0F);
        this.neck = new ModelRenderer(this, 0, 27);
        this.neck.addBox(-2.05F, -5.0F, -2.0F, 4, 10, 7);
        this.neck.setRotationPoint(0.0F, 4.0F, -12.0F);
        this.neck.rotateAngleX = 0.5235988F;
        this.head = new ModelRenderer(this, 0, 13);
        this.head.addBox(-3.0F, -11.0F, -3.0F, 6, 6, 8);
        this.neck.addChild(this.head);
        this.mane = new ModelRenderer(this, 56, 40);
        this.mane.addBox(-1.0F, -11.5F, 5.0F, 2, 12, 2);
        this.neck.addChild(this.mane);
        this.snout = new ModelRenderer(this, 29, 22);
        this.snout.addBox(-2.0F, -11.0F, -8.0F, 4, 5, 5);
        this.neck.addChild(this.snout);
        this.horseLeftEar = new ModelRenderer(this, 0, 0);
        this.horseLeftEar.addBox(0.45F, -13.0F, 4.0F, 2, 3, 1);
        this.neck.addChild(this.horseLeftEar);
        this.horseRightEar = new ModelRenderer(this, 0, 0);
        this.horseRightEar.addBox(-2.45F, -13.0F, 4.0F, 2, 3, 1);
        this.neck.addChild(this.horseRightEar);
        this.backLeftLeg = new ModelRenderer(this, 48, 25);
        this.backLeftLeg.mirror = true;
        this.backLeftLeg.addBox(-3.1F, -1.0F, -1.0F, 4, 11, 4);
        this.backLeftLeg.setRotationPoint(4.0F, 14.0F, 7.0F);
        this.backRightLeg = new ModelRenderer(this, 48, 25);
        this.backRightLeg.addBox(-0.9F, -1.0F, -1.0F, 4, 11, 4);
        this.backRightLeg.setRotationPoint(-4.0F, 14.0F, 7.0F);
        this.frontLeftLeg = new ModelRenderer(this, 48, 25);
        this.frontLeftLeg.mirror = true;
        this.frontLeftLeg.addBox(-3.1F, -1.0F, -1.9F, 4, 11, 4);
        this.frontLeftLeg.setRotationPoint(4.0F, 14.0F, -10.0F);
        this.frontRightLeg = new ModelRenderer(this, 48, 25);
        this.frontRightLeg.addBox(-0.9F, -1.0F, -1.9F, 4, 11, 4);
        this.frontRightLeg.setRotationPoint(-4.0F, 14.0F, -10.0F);
        this.tailBase = new ModelRenderer(this, 42, 40);
        this.tailBase.addBox(-1.5F, 0.0F, 0.0F, 3, 10, 4);
        this.tailBase.setRotationPoint(0.0F, -5.0F, 2.0F);
        this.tailBase.rotateAngleX = 0.5235988F;
        this.body.addChild(this.tailBase);
        this.horseSaddle = new ModelRenderer(this, 26, 0);
        this.horseSaddle.addBox(-5.0F, -8.0F, -9.0F, 10, 9, 9, 0.5F);
        this.body.addChild(this.horseSaddle);
        this.horseLeftFaceMetal = new ModelRenderer(this, 28, 23);
        this.horseLeftFaceMetal.addBox(2.0F, -9.0F, -6.0F, 1, 2, 2);
        this.neck.addChild(this.horseLeftFaceMetal);
        this.horseRightFaceMetal = new ModelRenderer(this, 28, 23);
        this.horseRightFaceMetal.addBox(-3.0F, -9.0F, -6.0F, 1, 2, 2);
        this.neck.addChild(this.horseRightFaceMetal);
        this.horseLeftRein = new ModelRenderer(this, 32, 2);
        this.horseLeftRein.addBox(3.1F, -6.0F, -8.0F, 0, 3, 16);
        this.horseLeftRein.rotateAngleX = -0.5235988F;
        this.neck.addChild(this.horseLeftRein);
        this.horseRightRein = new ModelRenderer(this, 32, 2);
        this.horseRightRein.addBox(-3.1F, -6.0F, -8.0F, 0, 3, 16);
        this.horseRightRein.rotateAngleX = -0.5235988F;
        this.neck.addChild(this.horseRightRein);
        this.horseFaceRopes = new ModelRenderer(this, 0, 0);
        this.horseFaceRopes.addBox(-2.5F, -10.5F, -5.0F, 5, 5, 8, 0.55F);
        this.head.addChild(this.horseFaceRopes);
        this.muleLeftEar = new ModelRenderer(this, 0, 13);
        this.muleLeftEar.addBox(-1.0F, -7.0F, 0.0F, 2, 7, 1);
        this.muleLeftEar.setRotationPoint(1.25F, -10.0F, 4.0F);
        this.muleLeftEar.rotateAngleX = 0.2617994F;
        this.muleLeftEar.rotateAngleZ = 0.2617994F;
        this.neck.addChild(this.muleLeftEar);
        this.muleRightEar = new ModelRenderer(this, 0, 13);
        this.muleRightEar.addBox(-1.0F, -7.0F, 0.0F, 2, 7, 1);
        this.muleRightEar.setRotationPoint(-1.25F, -10.0F, 4.0F);
        this.muleRightEar.rotateAngleX = 0.2617994F;
        this.muleRightEar.rotateAngleZ = -0.2617994F;
        this.neck.addChild(this.muleRightEar);
        this.muleLeftChest = new ModelRenderer(this, 0, 44);
        this.muleLeftChest.addBox(-4.0F, 0.0F, -2.0F, 8, 8, 2);
        this.muleLeftChest.setRotationPoint(5.0F, -8.0F, 0.0F);
        this.muleLeftChest.rotateAngleY = -1.5707964F;
        this.body.addChild(this.muleLeftChest);
        this.muleRightChest = new ModelRenderer(this, 0, 44);
        this.muleRightChest.addBox(-4.0F, 0.0F, -2.0F, 8, 8, 2);
        this.muleRightChest.setRotationPoint(-5.0F, -8.0F, 0.0F);
        this.muleRightChest.rotateAngleY = 1.5707964F;
        this.body.addChild(this.muleRightChest);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        AbstractHorse abstracthorse = (AbstractHorse)entityIn;
        float f = abstracthorse.getGrassEatingAmount(0.0F);
        boolean flag = abstracthorse.isChild();
        float f1 = abstracthorse.getHorseSize();
        boolean flag1 = !flag && abstracthorse.isHorseSaddled();
        boolean flag2 = abstracthorse instanceof AbstractChestHorse;
        boolean flag3 = !flag && flag2 && ((AbstractChestHorse)abstracthorse).hasChest();
        boolean flag4 = abstracthorse.isBeingRidden();
        if (!flag1) {
            this.horseSaddle.isHidden = true;
            this.horseLeftFaceMetal.isHidden = true;
            this.horseRightFaceMetal.isHidden = true;
            this.horseFaceRopes.isHidden = true;
            this.horseLeftRein.isHidden = true;
            this.horseRightRein.isHidden = true;
        } else {
            this.horseSaddle.isHidden = false;
            this.horseLeftFaceMetal.isHidden = false;
            this.horseRightFaceMetal.isHidden = false;
            if (ConfigurationHandler.useImprovements) {
                this.horseFaceRopes.isHidden = false;
                if (flag4) {
                    this.horseLeftRein.isHidden = false;
                    this.horseRightRein.isHidden = false;
                }
            } else {
                this.horseLeftRein.isHidden = false;
                this.horseRightRein.isHidden = false;
            }
        }

        if (flag) {
            GlStateManager.pushMatrix();
            GlStateManager.scale(f1, 0.5F + f1 * 0.5F, f1);
            GlStateManager.translate(0.0F, 0.95F * (1.0F - f1), 0.0F);
        }

        this.backLeftLeg.render(scale);
        this.backRightLeg.render(scale);
        this.frontLeftLeg.render(scale);
        this.frontRightLeg.render(scale);
        if (flag) {
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(f1, f1, f1);
            GlStateManager.translate(0.0F, 2.3F * (1.0F - f1), 0.0F);
        }

        if (!flag3) {
            this.muleLeftChest.isHidden = true;
            this.muleRightChest.isHidden = true;
        } else {
            this.muleLeftChest.isHidden = false;
            this.muleRightChest.isHidden = false;
        }

        this.body.render(scale);
        if (flag) {
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            float f2 = 0.5F + f1 * f1 * 0.5F;
            GlStateManager.scale(f2, f2, f2);
            GlStateManager.translate(0.0F, 1.8F * (1.0F - f1), 0.2F * (1.0F - f1));
        }

        if (flag2) {
            this.horseLeftEar.isHidden = true;
            this.horseRightEar.isHidden = true;
        } else {
            this.muleLeftEar.isHidden = true;
            this.muleRightEar.isHidden = true;
        }

        this.neck.render(scale);
        if (flag) {
            GlStateManager.popMatrix();
        }

    }

    /**
     * Fixes and offsets a rotation in the ModelHorse class.
     */
    private float updateHorseRotation(float p_110683_1_, float p_110683_2_, float p_110683_3_) {
        float f;
        
        for(f = p_110683_2_ - p_110683_1_; f < -180.0F; f += 360.0F) {
            ;
        }

        while(f >= 180.0F) {
            f -= 360.0F;
        }

        return p_110683_1_ + p_110683_3_ * f;
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
        super.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);
        float var5 = this.updateHorseRotation(entitylivingbaseIn.prevRenderYawOffset, entitylivingbaseIn.renderYawOffset, partialTickTime);
        float var6 = this.updateHorseRotation(entitylivingbaseIn.prevRotationYawHead, entitylivingbaseIn.rotationYawHead, partialTickTime);
        float var7 = entitylivingbaseIn.prevRotationPitch + (entitylivingbaseIn.rotationPitch - entitylivingbaseIn.prevRotationPitch) * partialTickTime;
        float var8 = var6 - var5;
        float var9 = var7 * 0.017453292F;
        if (var8 > 20.0F) {
            var8 = 20.0F;
        }

        if (var8 < -20.0F) {
            var8 = -20.0F;
        }

        if (limbSwingAmount > 0.2F) {
            var9 += MathHelper.cos(limbSwing * 0.4F) * 0.15F * limbSwingAmount;
        }

        AbstractHorse var10 = (AbstractHorse)entitylivingbaseIn;
        float var11 = var10.getGrassEatingAmount(partialTickTime);
        float var12 = var10.getRearingAmount(partialTickTime);
        float var13 = 1.0F - var12;
        float var14 = var10.getMouthOpennessAngle(partialTickTime);
        boolean var15 = var10.tailCounter != 0;
        float var16 = (float)((AbstractHorse)entitylivingbaseIn).ticksExisted + partialTickTime;
        this.neck.rotationPointY = 4.0F;
        this.neck.rotationPointZ = -12.0F;
        this.body.rotateAngleX = 0.0F;
        this.neck.rotateAngleX = 0.5235988F + var9;
        this.neck.rotateAngleY = var8 * 0.017453292F;
        float var17 = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F);
        float var18 = var17 * 0.8F * limbSwingAmount;
        float var19 = (1.0F - Math.max(var12, var11)) * (0.5235988F + var9 + var14 * MathHelper.sin(var16) * 0.05F);
        this.neck.rotateAngleX = var12 * (0.2617994F + var9) + var11 * (2.1816616F + MathHelper.sin(var16) * 0.05F) + var19;
        this.neck.rotateAngleY = var12 * var8 * 0.017453292F + (1.0F - Math.max(var12, var11)) * this.neck.rotateAngleY;
        this.neck.rotationPointY = var12 * -4.0F + var11 * 11.0F + (1.0F - Math.max(var12, var11)) * this.neck.rotationPointY;
        this.neck.rotationPointZ = var12 * -4.0F + var11 * -12.0F + (1.0F - Math.max(var12, var11)) * this.neck.rotationPointZ;
        this.body.rotateAngleX = var12 * -0.7853982F + var13 * this.body.rotateAngleX;
        var19 = 0.2617994F * var12;
        float var20 = MathHelper.cos(var16 * 0.6F + 3.1415927F);
        this.frontLeftLeg.rotationPointY = 2.0F * var12 + 14.0F * var13;
        this.frontLeftLeg.rotationPointZ = -6.0F * var12 + -10.0F * var13;
        this.frontRightLeg.rotationPointY = this.frontLeftLeg.rotationPointY;
        this.frontRightLeg.rotationPointZ = this.frontLeftLeg.rotationPointZ;
        float var21 = (-1.0471976F + var20) * var12 + var18 * var13;
        float var22 = (-1.0471976F - var20) * var12 + -var18 * var13;
        this.backLeftLeg.rotateAngleX = var19 + -var17 * 0.5F * limbSwingAmount * var13;
        this.backRightLeg.rotateAngleX = var19 + var17 * 0.5F * limbSwingAmount * var13;
        this.frontLeftLeg.rotateAngleX = var21;
        this.frontRightLeg.rotateAngleX = var22;
        this.tailBase.rotateAngleX = 0.5235988F + limbSwingAmount * 0.75F;
        this.tailBase.rotationPointY = -5.0F + limbSwingAmount;
        this.tailBase.rotationPointZ = 2.0F + limbSwingAmount * 2.0F;
        if (var15) {
            this.tailBase.rotateAngleY = MathHelper.cos(var16 * 0.7F);
        } else {
            this.tailBase.rotateAngleY = 0.0F;
        }

    }
}
