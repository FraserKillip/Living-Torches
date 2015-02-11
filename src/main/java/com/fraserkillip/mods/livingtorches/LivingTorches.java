package com.fraserkillip.mods.livingtorches;

import com.fraserkillip.mods.livingtorches.handler.ConfigurationHandler;
import com.fraserkillip.mods.livingtorches.init.ModBlocks;
import com.fraserkillip.mods.livingtorches.init.ModItems;
import com.fraserkillip.mods.livingtorches.proxy.IProxy;
import com.fraserkillip.mods.livingtorches.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class LivingTorches
{
    @Mod.Instance(Reference.MODID)
    public static LivingTorches instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        ModBlocks.init();
        ModItems.init();
        proxy.initRenderingAndTextures();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    }
}