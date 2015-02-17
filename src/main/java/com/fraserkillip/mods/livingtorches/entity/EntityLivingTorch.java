package com.fraserkillip.mods.livingtorches.entity;

import com.fraserkillip.mods.livingtorches.init.ModBlocks;
import com.fraserkillip.mods.livingtorches.tileentity.TileEntityLivingTorch;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.item.Item;
import net.minecraft.world.World;

/**
 * Created by fraserkillip on 11/02/15.
 */
public class EntityLivingTorch extends EntityCreature {
    public EntityLivingTorch(World p_i1595_1_) {
        super(p_i1595_1_);
        this.isImmuneToFire = true;
        setSize(0.1f, 0.6f);
        this.getNavigator().setEnterDoors(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAIWander(this, 0.3D));
//        this.tasks.addTask(1, new EntityAILookIdle(this));
//        this.tasks.addTask(0, new EntityAIWatchClosest(this, EntityPlayer.class, 80000000000000.0F));
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if(!worldObj.isRemote){
            if (this.onGround && this.getRNG().nextDouble() > 0.99f && worldObj.isAirBlock((int) this.posX, (int) this.posY, (int) this.posZ) && ModBlocks.livingTorchBlock.canPlaceBlockAt(worldObj, (int) this.posX, (int) this.posY, (int) this.posZ)) {
                this.setDead();
                worldObj.setBlock((int) this.posX, (int) this.posY, (int) this.posZ, ModBlocks.livingTorchBlock, 5, 3);
                ((TileEntityLivingTorch)worldObj.getTileEntity((int) this.posX, (int) this.posY, (int) this.posZ)).setRenderYaw(this.renderYawOffset);
                worldObj.markBlockForUpdate((int) this.posX, (int) this.posY, (int) this.posZ);
            }

            if(this.ticksExisted > 3600) this.setDead();
        }

        if(worldObj.isRemote && this.getRNG().nextDouble() > 0.85) {
            double d0 = (double)((float)this.posX);
            double d1 = (double)((float)this.posY + 0.7F);
            double d2 = (double)((float)this.posZ);
            worldObj.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
            worldObj.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }

    protected boolean isAIEnabled()
    {
        return true;
    }

    /**
     * Takes a coordinate in and returns a weight to determine how likely this creature will try to path to the block.
     * Args: x, y, z
     */
    public float getBlockPathWeight(int p_70783_1_, int p_70783_2_, int p_70783_3_)
    {
        return 0.5F - this.worldObj.getLightBrightness(p_70783_1_, p_70783_2_, p_70783_3_);
    }

    protected Item getDropItem()
    {
        return Item.getItemFromBlock(ModBlocks.livingTorchBlock);
    }

    protected boolean canDespawn()
    {
        return false;
    }
}
