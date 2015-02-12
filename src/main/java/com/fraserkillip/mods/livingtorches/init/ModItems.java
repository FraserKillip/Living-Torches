package com.fraserkillip.mods.livingtorches.init;

import com.fraserkillip.mods.livingtorches.item.ItemFiremansHelmet;
import com.fraserkillip.mods.livingtorches.item.ItemReinforcedFiremansHelmet;
import com.fraserkillip.mods.livingtorches.reference.Names;
import com.fraserkillip.mods.livingtorches.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by fraserkillip on 10/02/15.
 */
public class ModItems {

    public static final ItemArmor FiremansHelmet = new ItemFiremansHelmet();
    public static final ItemArmor ReinforcedFiremansHelmet = new ItemReinforcedFiremansHelmet();

    public static void init() {
        GameRegistry.registerItem(FiremansHelmet, Names.Items.FiremansHelmet, Reference.MODID);
        GameRegistry.registerItem(ReinforcedFiremansHelmet, Names.Items.ReinforcedFiremansHelmet, Reference.MODID);
    }

    public static void registerRecipes() {
        GameRegistry.addRecipe(new ItemStack(FiremansHelmet),
                " I ",
                "WHW",
                'I', Items.iron_ingot,
                'H', Items.leather_helmet,
                'W', new ItemStack(Items.dye, 1, 1));

        GameRegistry.addRecipe(new ItemStack(ReinforcedFiremansHelmet),
                "IDI",
                "IHI",
                'I', Items.iron_ingot,
                'H', FiremansHelmet,
                'D', Items.diamond);
    }
}
