package com.fraserkillip.mods.livingtorches.proxy;

/**
 * Created by fraserkillip on 5/02/15.
 */
public interface IProxy {
    public abstract ClientProxy getClientProxy();

    public abstract void initRenderingAndTextures();

    public abstract void registerEventHandlers();

    public abstract void registerKeybindings();

    public abstract void playSound(String soundName, float xCoord, float yCoord, float zCoord, float volume, float pitch);
}
