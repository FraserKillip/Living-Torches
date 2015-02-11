package com.fraserkillip.mods.livingtorches.init;

import com.fraserkillip.mods.livingtorches.LivingTorches;
import com.fraserkillip.mods.livingtorches.entity.EntityLivingTorch;
import cpw.mods.fml.common.registry.EntityRegistry;

/**
 * Created by fraserkillip on 11/02/15.
 */
public class ModEntities {
    public static void init() {
        EntityRegistry.registerModEntity(EntityLivingTorch.class, "livingTorch", 0, LivingTorches.instance, 80, 1, true);//id is an internal mob id, you can start at 0 and continue adding them up.
    }
}
