package com.fraserkillip.mods.livingtorches.tileentity;

import com.fraserkillip.mods.livingtorches.entity.EntityLivingTorch;
import com.fraserkillip.mods.livingtorches.reference.Settings;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by fraserkillip on 6/02/15.
 */
public class TileEntityLivingTorch extends TileEntity {

    public long movement = Math.round(Math.random()*100.0);

    @Override
    public void updateEntity() {
//        if(worldObj.isRemote) worldObj.setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
        movement++;

        if(Settings.General.doFallOfWalls && Math.random() < Settings.General.fallChance && getBlockMetadata() != 5 && !worldObj.isRemote) {
            EntityLivingTorch entity = new EntityLivingTorch(worldObj);
            entity.setPosition(this.xCoord + 0.5, this.yCoord + 0.5, this.zCoord + 0.5);
            if(!worldObj.spawnEntityInWorld(entity)) {
                entity.setDead();
                return;
            }

            worldObj.setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
            worldObj.removeTileEntity(this.xCoord, this.yCoord, this.zCoord);
        }
    }
}
