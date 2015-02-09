package com.fraserkillip.mods.livingtorches.creativetab;

import com.fraserkillip.mods.livingtorches.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

/**
 * Created by fraserkillip on 6/02/15.
 */
public class CreativeTab
{
    public static final CreativeTabs tab = new CreativeTabs(Reference.MODID)
    {
        @Override
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(Blocks.torch);
        }
    };
}
