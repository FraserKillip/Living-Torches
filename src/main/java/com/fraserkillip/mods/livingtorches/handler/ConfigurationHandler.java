package com.fraserkillip.mods.livingtorches.handler;

import com.fraserkillip.mods.livingtorches.reference.Messages;
import com.fraserkillip.mods.livingtorches.reference.Reference;
import com.fraserkillip.mods.livingtorches.reference.Settings;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by fraserkillip on 5/02/15.
 */
public class ConfigurationHandler {
    public static Configuration configuration;

    public static void init(File configFile)
    {
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        Settings.General.doRandomMove = configuration.getBoolean(Messages.Configuration.GENERAL_DO_RANDOM_MOVE, Configuration.CATEGORY_GENERAL, true, StatCollector.translateToLocal(Messages.Configuration.GENERAL_DO_RANDOM_MOVE_COMMENT), Messages.Configuration.GENERAL_DO_RANDOM_MOVE_LABEL);
        Settings.General.movementFrequency = configuration.getInt(Messages.Configuration.GENERAL_MOVEMENT_FREQUENCY, Configuration.CATEGORY_GENERAL, 5, 0, 100, StatCollector.translateToLocal(Messages.Configuration.GENERAL_MOVEMENT_FREQUENCY_COMMENT), Messages.Configuration.GENERAL_MOVEMENT_FREQUENCY_LABEL);


        Settings.General.doSetOnFire = configuration.getBoolean(Messages.Configuration.GENERAL_DO_SET_ON_FIRE, Configuration.CATEGORY_GENERAL, true, StatCollector.translateToLocal(Messages.Configuration.GENERAL_DO_SET_ON_FIRE_COMMENT), Messages.Configuration.GENERAL_DO_SET_ON_FIRE_LABEL);
        Settings.General.setFireChance = configuration.getFloat(Messages.Configuration.GENERAL_SET_FIRE_CHANCE, Configuration.CATEGORY_GENERAL, 0.5f, 0f, 1f, StatCollector.translateToLocal(Messages.Configuration.GENERAL_SET_FIRE_CHANCE_COMMENT), Messages.Configuration.GENERAL_SET_FIRE_CHANCE_LABEL)/50;
        Settings.General.setFireLength = configuration.getInt(Messages.Configuration.GENERAL_SET_FIRE_LENGTH, Configuration.CATEGORY_GENERAL, 2, 0, Integer.MAX_VALUE, StatCollector.translateToLocal(Messages.Configuration.GENERAL_SET_FIRE_LENGTH_COMMENT), Messages.Configuration.GENERAL_SET_FIRE_LENGTH_LABEL);

        Settings.General.doGrow = configuration.getBoolean(Messages.Configuration.GENERAL_DO_GROW, Configuration.CATEGORY_GENERAL, true, StatCollector.translateToLocal(Messages.Configuration.GENERAL_DO_GROW_COMMENT), Messages.Configuration.GENERAL_DO_GROW_LABEL);
        Settings.General.lifetime = configuration.getInt(Messages.Configuration.GENERAL_LIFETIME, Configuration.CATEGORY_GENERAL, 5, 0, 100, StatCollector.translateToLocal(Messages.Configuration.GENERAL_LIFETIME_COMMENT), Messages.Configuration.GENERAL_LIFETIME_LABEL);

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MODID))
        {
            loadConfiguration();
        }
    }
}
