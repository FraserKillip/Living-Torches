package com.fraserkillip.mods.livingtorches.init;

import com.fraserkillip.mods.livingtorches.block.BlockLivingTorch;
import com.fraserkillip.mods.livingtorches.reference.Names;
import com.fraserkillip.mods.livingtorches.reference.Reference;
import com.fraserkillip.mods.livingtorches.tileentity.TileEntityLivingTorch;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by fraserkillip on 6/02/15.
 */
@GameRegistry.ObjectHolder(Reference.MODID)
public class ModBlocks {
    public static final Block livingTorchBlock = new BlockLivingTorch();

    public static void init() {
        GameRegistry.registerBlock(livingTorchBlock, Names.Blocks.livingTorch);
        GameRegistry.registerTileEntity(TileEntityLivingTorch.class, "name");
    }

    public static void registerRecipies() {
        GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(livingTorchBlock)),
                "S  ",
                "C  ",
                'S', Items.stick,
                'C', Items.coal);
    }
}
