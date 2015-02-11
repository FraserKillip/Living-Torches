package com.fraserkillip.mods.livingtorches.client.model;

import com.fraserkillip.mods.livingtorches.tileentity.TileEntityLivingTorch;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import org.lwjgl.opengl.GL11;

/**
 * LivingTorch - FraserK
 * Created using Tabula 4.1.1
 */
public class ModelLivingTorch extends ModelBase {
    public double[] modelScale = new double[] { 2.0D, 2.0D, 2.0D };
    public ModelRenderer Torch;
    public ModelRenderer LeftEyebrow;
    public ModelRenderer RightEyebrow;
    public ModelRenderer lefteye;
    public ModelRenderer righteye;
    public ModelRenderer rightarm;
    public ModelRenderer leftarm;
    public ModelRenderer rightforear;
    public ModelRenderer leftforearm;

    public ModelLivingTorch() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.rightforear = new ModelRenderer(this, 0, 29);
        this.rightforear.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.rightforear.addBox(-0.5F, -0.5F, -0.51F, 4, 1, 1, 0.0F);
        this.setRotateAngle(rightforear, 0.0F, 0.0F, 0.5462880558742251F);
        this.righteye = new ModelRenderer(this, 0, 0);
        this.righteye.setRotationPoint(-1.2F, -2.1F, -0.5F);
        this.righteye.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(righteye, 0.7853981633974483F, 0.0F, 0.0F);
        this.RightEyebrow = new ModelRenderer(this, 0, 24);
        this.RightEyebrow.setRotationPoint(-2.0F, -3.9F, 0.4F);
        this.RightEyebrow.addBox(0.0F, 0.0F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(RightEyebrow, -0.593411945678072F, 0.0F, 0.0F);
        this.LeftEyebrow = new ModelRenderer(this, 0, 24);
        this.LeftEyebrow.setRotationPoint(-2.0F, -3.9F, 1.5F);
        this.LeftEyebrow.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(LeftEyebrow, 0.593411945678072F, 0.0F, 0.0F);
        this.Torch = new ModelRenderer(this, 0, 0);
        this.Torch.setRotationPoint(0.0F, 38.0F, 0.0F);
        this.Torch.addBox(-1.0F, -10.0F, -1.0F, 4, 20, 4, 0.0F);
        this.leftarm = new ModelRenderer(this, 0, 27);
        this.leftarm.setRotationPoint(0.7F, 0.0F, 3.5F);
        this.leftarm.addBox(-0.5F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(leftarm, 0.0F, 0.0F, 2.41309222380736F);
        this.rightarm = new ModelRenderer(this, 0, 27);
        this.rightarm.setRotationPoint(0.7F, 0.0F, -1.5F);
        this.rightarm.addBox(-0.5F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
        this.setRotateAngle(rightarm, 0.0F, 0.0F, 2.41309222380736F);
        this.lefteye = new ModelRenderer(this, 0, 0);
        this.lefteye.setRotationPoint(-1.2F, -2.1F, 1.1F);
        this.lefteye.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(lefteye, 0.7853981633974483F, 0.0F, 0.0F);
        this.leftforearm = new ModelRenderer(this, 0, 29);
        this.leftforearm.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.leftforearm.addBox(-0.5F, -0.5F, -0.49F, 4, 1, 1, 0.0F);
        this.setRotateAngle(leftforearm, 0.0F, 0.0F, 0.5462880558742251F);
        this.rightarm.addChild(this.rightforear);
        this.Torch.addChild(this.righteye);
        this.Torch.addChild(this.RightEyebrow);
        this.Torch.addChild(this.LeftEyebrow);
        this.Torch.addChild(this.leftarm);
        this.Torch.addChild(this.rightarm);
        this.Torch.addChild(this.lefteye);
        this.leftarm.addChild(this.leftforearm);
    }

    public void render(float f5, TileEntityLivingTorch tm) {
        GL11.glPushMatrix();
        GL11.glScaled(1D / modelScale[0], 1D / modelScale[1], 1D / modelScale[2]);
        this.Torch.render(f5);
        GL11.glPopMatrix();
        this.setRotateAngle(rightarm, 0.0F, 0.0F, 2.41309222380736F + (float)Math.sin(tm.movement/50.0)/3);
        this.setRotateAngle(leftarm, 0.0F, 0.0F, 2.41309222380736F + (float)Math.sin(tm.movement/50.0 - 180)/3);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
