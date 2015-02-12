package com.fraserkillip.mods.livingtorches.client.render;

import com.fraserkillip.mods.livingtorches.client.model.ModelLivingTorch;
import com.fraserkillip.mods.livingtorches.entity.EntityLivingTorch;
import com.fraserkillip.mods.livingtorches.reference.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by fraserkillip on 11/02/15.
 */
public class RenderLivingTorch extends Render {

    private static ResourceLocation texture = new ResourceLocation(Reference.MODID+":textures/model/livingtorch.png");

    private ModelLivingTorch model;

    public RenderLivingTorch() {
        model = new ModelLivingTorch();
    }

    @Override
    public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTickTime)  {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y + 1.5f, (float)z);
        GL11.glScalef(-1, -1, 1);

        bindTexture(texture);

        model.renderEntity(0.0625F, (EntityLivingTorch) entity);

        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return texture;
    }
}
