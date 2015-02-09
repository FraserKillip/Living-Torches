package com.fraserkillip.mods.livingtorches.proxy;

import com.fraserkillip.mods.livingtorches.client.render.TileRendererLivingTorch;
import com.fraserkillip.mods.livingtorches.tileentity.TileEntityLivingTorch;
import cpw.mods.fml.client.registry.ClientRegistry;

/**
 * Created by fraserkillip on 5/02/15.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public ClientProxy getClientProxy() {
        return null;
    }

    @Override
    public void initRenderingAndTextures() {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLivingTorch.class, new TileRendererLivingTorch());
    }

    @Override
    public void registerKeybindings() {

    }

    @Override
    public void playSound(String soundName, float xCoord, float yCoord, float zCoord, float volume, float pitch) {

    }
}
