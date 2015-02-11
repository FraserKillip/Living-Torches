package com.fraserkillip.mods.livingtorches.init;

import com.fraserkillip.mods.livingtorches.item.ItemFiremansHelmet;
import com.fraserkillip.mods.livingtorches.item.ItemReinforcedFiremansHelmet;
import com.fraserkillip.mods.livingtorches.reference.Names;
import com.fraserkillip.mods.livingtorches.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemArmor;

/**
 * Created by fraserkillip on 10/02/15.
 */
public class ModItems {

    public static final ItemArmor FiremansHelmet = new ItemFiremansHelmet(ItemArmor.ArmorMaterial.CHAIN, 0, 0);
    public static final ItemArmor ReinforcedFiremansHelmet = new ItemReinforcedFiremansHelmet(ItemArmor.ArmorMaterial.CHAIN, 0, 0);

    public static void init() {
        GameRegistry.registerItem(FiremansHelmet, Names.Items.FiremansHelmet, Reference.MODID);
        GameRegistry.registerItem(ReinforcedFiremansHelmet, Names.Items.ReinforcedFiremansHelmet, Reference.MODID);
    }
}
