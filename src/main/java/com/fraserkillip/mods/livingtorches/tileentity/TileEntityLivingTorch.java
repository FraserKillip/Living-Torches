package com.fraserkillip.mods.livingtorches.tileentity;

import net.minecraft.tileentity.TileEntity;

/**
 * Created by fraserkillip on 6/02/15.
 */
public class TileEntityLivingTorch extends TileEntity {

    public long movement = Math.round(Math.random()*100.0);

    @Override
    public void updateEntity() {
        movement++;
    }
}
