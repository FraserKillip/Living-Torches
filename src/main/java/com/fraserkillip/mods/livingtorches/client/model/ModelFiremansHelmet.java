package com.fraserkillip.mods.livingtorches.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;

/**
 * Created by fraserkillip on 12/02/15.
 */
public class ModelFiremansHelmet extends ModelBiped {
    public ModelRenderer helmetTop;
    public ModelRenderer leftSide;
    public ModelRenderer rightSide;
    public ModelRenderer frontSide;
    public ModelRenderer backSide;
    public ModelRenderer ridge;
    public ModelRenderer badge;

    public ModelFiremansHelmet() {
        super(1.0F, 0, 64, 64);

        this.bipedBody.showModel = false;
        this.bipedRightArm.showModel = false;
        this.bipedLeftArm.showModel = false;
        this.bipedHead.showModel = false;
        this.bipedHeadwear.showModel = true;
        this.bipedRightLeg.showModel = false;
        this.bipedLeftLeg.showModel = false;

        this.textureWidth = 64;
        this.textureHeight = 128;
        this.backSide = new ModelRenderer(this, 0, 109);
        this.backSide.setRotationPoint(-5.0F, -9.0F, 4.0F);
        this.backSide.addBox(0.0F, 0.0F, 0.0F, 10, 6, 1, 0.0F);
        this.helmetTop = new ModelRenderer(this, 0, 117);
        this.helmetTop.setRotationPoint(-5.0F, -9.0F, -5.0F);
        this.helmetTop.addBox(0.0F, 0.0F, 0.0F, 10, 1, 10, 0.0F);
        this.leftSide = new ModelRenderer(this, 34, 96);
        this.leftSide.setRotationPoint(4.0F, -9.0F, -5.0F);
        this.leftSide.addBox(0.0F, 0.0F, 0.0F, 1, 5, 10, 0.0F);
        this.rightSide = new ModelRenderer(this, 34, 96);
        this.rightSide.setRotationPoint(-5.0F, -9.0F, -5.0F);
        this.rightSide.addBox(0.0F, 0.0F, 0.0F, 1, 5, 10, 0.0F);
        this.badge = new ModelRenderer(this, 0, 96);
        this.badge.setRotationPoint(-1.5F, -11.5F, -6.0F);
        this.badge.addBox(0.0F, 0.0F, 0.0F, 3, 4, 1, 0.0F);
        this.ridge = new ModelRenderer(this, 0, 97);
        this.ridge.setRotationPoint(-1.0F, -10.0F, 0.0F);
        this.ridge.addBox(0.0F, 0.0F, -5.0F, 2, 1, 10, 0.0F);
        this.frontSide = new ModelRenderer(this, 0, 110);
        this.frontSide.setRotationPoint(-5.0F, -9.0F, -5.0F);
        this.frontSide.addBox(0.0F, 0.0F, 0.0F, 10, 5, 1, 0.0F);
        this.bipedHeadwear.addChild(this.backSide);
        this.bipedHeadwear.addChild(this.helmetTop);
        this.bipedHeadwear.addChild(this.leftSide);
        this.bipedHeadwear.addChild(this.rightSide);
        this.bipedHeadwear.addChild(this.badge);
        this.bipedHeadwear.addChild(this.ridge);
        this.bipedHeadwear.addChild(this.frontSide);
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

