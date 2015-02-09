package com.fraserkillip.mods.livingtorches.init;

import com.fraserkillip.mods.livingtorches.block.BlockLivingTorch;
import com.fraserkillip.mods.livingtorches.reference.Names;
import com.fraserkillip.mods.livingtorches.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * Created by fraserkillip on 6/02/15.
 */
@GameRegistry.ObjectHolder(Reference.MODID)
public class ModBlocks {
    public static final Block livingTorchBlock = new BlockLivingTorch();

    public static void init() {
        GameRegistry.registerBlock(livingTorchBlock, Names.Blocks.livingTorch);
    }
}
