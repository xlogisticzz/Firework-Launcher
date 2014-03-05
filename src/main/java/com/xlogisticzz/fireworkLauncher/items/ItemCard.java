package com.xlogisticzz.fireworkLauncher.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.xlogisticzz.fireworkLauncher.CreativeTabFireworkLauncher;
import com.xlogisticzz.fireworkLauncher.blocks.ModBlocks;
import com.xlogisticzz.fireworkLauncher.lib.Constants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemCard extends Item {
    
    @SideOnly(Side.CLIENT)
    private IIcon[] icons;
    
    public ItemCard() {
    
        super();
        setCreativeTab(CreativeTabFireworkLauncher.tabFireworkLauncher);
        setHasSubtypes(true);
        
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
    
        return "item." + Constants.UnLocalisedNames.FIREWORK_CARD + itemstack.getItemDamage();
    }

    @Override
    public void registerIcons(IIconRegister par1IconRegister) {
    
        icons = new IIcon[Constants.Icons.FIREWORK_CARD.length];
        
        for (int i = 0; i < Constants.Icons.FIREWORK_CARD.length; i++){
            icons[i] = par1IconRegister.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.FIREWORK_CARD[i]);
        }
        
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int par1) {
        return icons[par1];
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
    
        for (int i = 0; i < Constants.Icons.FIREWORK_CARD.length; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
    
        if (!world.isRemote && world.getBlock(x, y, z) == ModBlocks.launcherBlock){
            int meta = world.getBlockMetadata(x, y, z);
            int type = stack.getItemDamage() + 1;
            if (type == meta){
                return false;
            }
            world.setBlockMetadataWithNotify(x, y, z, type, 3);
            
            if (!player.capabilities.isCreativeMode){
                stack.stackSize--;
            }
            return true;
        }else{
            return false;
        }
    }
}
