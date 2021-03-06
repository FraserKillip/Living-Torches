package com.fraserkillip.mods.livingtorches.item;

import com.fraserkillip.mods.livingtorches.client.model.ModelFiremansHelmet;
import com.fraserkillip.mods.livingtorches.creativetab.CreativeTab;
import com.fraserkillip.mods.livingtorches.reference.Names;
import com.fraserkillip.mods.livingtorches.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;

/**
 * Created by fraserkillip on 10/02/15.
 */
public class ItemFiremansHelmet extends ItemArmor implements ISpecialArmor {
    private static ModelFiremansHelmet model = new ModelFiremansHelmet();

    public ItemFiremansHelmet() {
        super(ItemArmor.ArmorMaterial.CHAIN, 0, 0);
        setUnlocalizedName(Names.Items.FiremansHelmet);
    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
        return new ArmorProperties(0, 0, 0);
    }

    @Override
    public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
        return 1;
    }

    @Override
    public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
        if(!source.isFireDamage()) stack.damageItem(damage, entity);
    }

    @Override
    public CreativeTabs[] getCreativeTabs() {
        return new CreativeTabs[] {CreativeTab.tab}; //This lets me put my armor in as many create tabs as I want, pretty cool right?
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister reg)
    {
        this.itemIcon = reg.registerIcon(Reference.MODID + ":" + Names.Items.FiremansHelmet);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return Reference.MODID + ":textures/armour/firemansHelmet.png";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, int armorSlot) {
        return model;
    }
}
