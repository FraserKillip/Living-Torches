package com.fraserkillip.mods.livingtorches.client.render;

import com.fraserkillip.mods.livingtorches.client.model.ModelLivingTorch;
import com.fraserkillip.mods.livingtorches.tileentity.TileEntityLivingTorch;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by fraserkillip on 9/02/15.
 */
public class TileRendererLivingTorch extends TileEntitySpecialRenderer {

    public static final ResourceLocation txLivingtorch = new ResourceLocation("livingtorches", "textures/model/livingtorch.png");

    public ModelLivingTorch modelLivingTorch;

    public TileRendererLivingTorch() {
        modelLivingTorch = new ModelLivingTorch();
    }
    @Override
    public void renderTileEntityAt(TileEntity tileentity, double d0, double d1,	double d2, float f)
    {
        this.renderLivingTorch((TileEntityLivingTorch) tileentity, d0, d1, d2, f);
    }

    public void renderLivingTorch(TileEntityLivingTorch tm, double d, double d1, double d2, float f){
        GL11.glPushMatrix();

        GL11.glTranslated(d + 0.525D, d1 + 1.5, d2 + 0.475D);
        GL11.glScalef(-1F, -1F, 1F);

        if(tm != null) {
            int meta = tm.getBlockMetadata();

            switch (meta) {
                case 1:
                    GL11.glRotatef(-25F, 0, 0, 1);
                    GL11.glScalef(0.8f, 0.9f, 0.8f);
                    GL11.glTranslatef(-0.08f, -0.05f, 0);
                    break;
                case 2:
                    GL11.glRotatef(180F, 0, 1, 0);
                    GL11.glRotatef(-25F, 0, 0, 1);
                    GL11.glScalef(0.8f, 0.9f, 0.8f);
                    GL11.glTranslatef(-0.15f, -0.05f, 0);
                    break;
                case 3:
                    GL11.glRotatef(90F, 0, 1, 0);
                    GL11.glRotatef(-25F, 0, 0, 1);
                    GL11.glScalef(0.8f, 0.9f, 0.8f);
                    GL11.glTranslatef(-0.15f, -0.05f, 0);
                    break;
                case 4:
                    GL11.glRotatef(270F, 0, 1, 0);
                    GL11.glRotatef(-25F, 0, 0, 1);
                    GL11.glScalef(0.8f, 0.9f, 0.8f);
                    GL11.glTranslatef(-0.08f, -0.05f, 0);
                    break;
            }
        }
        Minecraft.getMinecraft().renderEngine.bindTexture(txLivingtorch);
        modelLivingTorch.renderTile(0.0625F, tm);


        GL11.glPopMatrix();
    }
}
