package com.fraserkillip.mods.livingtorches.entity;

import com.fraserkillip.mods.livingtorches.init.ModBlocks;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.world.World;

/**
 * Created by fraserkillip on 11/02/15.
 */
public class EntityLivingTorch extends EntityAmbientCreature {
    public EntityLivingTorch(World p_i1595_1_) {
        super(p_i1595_1_);
        this.isImmuneToFire = true;
        setSize(0.1f, 0.6f);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if(!worldObj.isRemote){
            if (this.onGround && worldObj.isAirBlock((int) this.posX, (int) this.posY, (int) this.posZ) && ModBlocks.livingTorchBlock.canPlaceBlockAt(worldObj, (int) this.posX, (int) this.posY, (int) this.posZ)) {
                worldObj.setBlock((int)this.posX, (int)this.posY, (int)this.posZ, ModBlocks.livingTorchBlock, 5, 3);
                this.setDead();
            }

            if(this.onGround && this.motionX == 0 && this.motionZ == 0) {
                setVelocity(Math.random() - 0.5f, 0.0, Math.random() - 0.5f);
            }

            if(this.ticksExisted > 3600) this.setDead();
        }
    }
}
