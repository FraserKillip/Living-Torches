package com.fraserkillip.mods.livingtorches.block;

import com.fraserkillip.mods.livingtorches.creativetab.CreativeTab;
import com.fraserkillip.mods.livingtorches.init.ModItems;
import com.fraserkillip.mods.livingtorches.reference.Names;
import com.fraserkillip.mods.livingtorches.reference.Reference;
import com.fraserkillip.mods.livingtorches.reference.Settings;
import com.fraserkillip.mods.livingtorches.tileentity.TileEntityLivingTorch;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

/**
 * Created by fraserkillip on 6/02/15.
 */
public class BlockLivingTorch extends BlockTorch implements ITileEntityProvider {

    public BlockLivingTorch() {
        super();
        setCreativeTab(CreativeTab.tab);
        this.setBlockName(Names.Blocks.livingTorch);
        setLightLevel(0.9375F);
        this.isBlockContainer = true;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityLivingTorch();
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public int onBlockPlaced(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
        return super.onBlockPlaced(p_149660_1_, p_149660_2_, p_149660_3_, p_149660_4_, p_149660_5_, p_149660_6_, p_149660_7_, p_149660_8_, p_149660_9_);
    }

//    @Override
//    public String getItemIconName() {
//        return Reference.MODID + ":" + Names.Blocks.livingTorch;
//    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(Reference.MODID + ":" + Names.Blocks.livingTorch);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if(entity instanceof EntityLivingBase && !(entity.isImmuneToFire() || ((EntityLivingBase) entity).isPotionActive(Potion.fireResistance))&& Settings.General.doSetOnFire) {
            if(Math.random() < Settings.General.setFireChance) {
                if(entity instanceof EntityLivingBase && ((EntityLivingBase) entity).getEquipmentInSlot(4) != null && ((EntityLivingBase) entity).getEquipmentInSlot(4).getItem() == ModItems.FiremansHelmet) return;

                entity.setFire(Settings.General.setFireLength);
                if (entity instanceof EntityPlayer) {
                    ((EntityPlayer) entity).addChatMessage(new ChatComponentStyle() {
                        @Override
                        public String getUnformattedTextForChat() {
                            return EnumChatFormatting.RED + "The torch you are standing on sets you on fire!" + EnumChatFormatting.RESET;
                        }

                        @Override
                        public IChatComponent createCopy() {
                            return null;
                        }
                    });
                }
            }
        }
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
    }

    public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
    {
        super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
        p_149749_1_.removeTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);
    }

    public boolean onBlockEventReceived(World p_149696_1_, int p_149696_2_, int p_149696_3_, int p_149696_4_, int p_149696_5_, int p_149696_6_)
    {
        super.onBlockEventReceived(p_149696_1_, p_149696_2_, p_149696_3_, p_149696_4_, p_149696_5_, p_149696_6_);
        TileEntity tileentity = p_149696_1_.getTileEntity(p_149696_2_, p_149696_3_, p_149696_4_);
        return tileentity != null ? tileentity.receiveClientEvent(p_149696_5_, p_149696_6_) : false;
    }
}
