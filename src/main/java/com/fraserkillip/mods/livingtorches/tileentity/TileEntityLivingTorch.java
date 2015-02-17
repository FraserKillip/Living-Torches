package com.fraserkillip.mods.livingtorches.tileentity;

import com.fraserkillip.mods.livingtorches.entity.EntityLivingTorch;
import com.fraserkillip.mods.livingtorches.reference.Settings;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by fraserkillip on 6/02/15.
 */
public class TileEntityLivingTorch extends TileEntity {

    public long movement = Math.round(Math.random()*100.0);
    private float renderYaw = Math.round(Math.random()*360.0);

    @Override
    public void updateEntity() {
        movement++;

        if(((getBlockMetadata() == 5 && Math.random() > 0.99) || (Settings.General.doFallOfWalls && Math.random() < Settings.General.fallChance && getBlockMetadata() != 5)) && !worldObj.isRemote) {
            worldObj.setBlockToAir(this.xCoord, this.yCoord, this.zCoord);
            worldObj.removeTileEntity(this.xCoord, this.yCoord, this.zCoord);

            EntityLivingTorch entity = new EntityLivingTorch(worldObj);
            entity.setPosition(this.xCoord + 0.5, this.yCoord, this.zCoord + 0.5);
            entity.renderYawOffset = getRenderYaw();
            if(!worldObj.spawnEntityInWorld(entity)) {
                entity.setDead();
                return;
            }
        }
    }

    public Packet getDescriptionPacket() {
        NBTTagCompound tagCompound = new NBTTagCompound();
        writeToNBT(tagCompound);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tagCompound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        super.onDataPacket(net, pkt);
        readFromNBT(pkt.func_148857_g());
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        compound.setFloat("renderYaw", renderYaw);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        renderYaw = compound.getFloat("renderYaw");
    }

    public float getRenderYaw() {
        return renderYaw;
    }

    public void setRenderYaw(float renderYaw) {
        this.renderYaw = renderYaw;
    }
}
