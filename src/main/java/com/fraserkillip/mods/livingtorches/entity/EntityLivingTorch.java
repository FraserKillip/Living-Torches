package com.fraserkillip.mods.livingtorches.entity;

import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.world.World;

/**
 * Created by fraserkillip on 11/02/15.
 */
public class EntityLivingTorch extends EntityAmbientCreature {
    public EntityLivingTorch(World p_i1595_1_) {
        super(p_i1595_1_);
        this.isImmuneToFire = true;

    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if(worldObj.isRemote){
            if (this.onGround && worldObj.isAirBlock((int) this.posX, (int) this.posY, (int) this.posZ)) {
//                worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, ModBlocks.livingTorchBlock, 5, 3);
//                this.setDead();
            }

            if(this.onGround) {
                System.out.println(this.motionZ);
                this.getNavigator().setPath(this.getNavigator().getPathToXYZ(this.posX, this.posY, this.posZ + 10), 1);
            }

            if(this.ticksExisted > 500) this.setDead();
        }
    }
}
