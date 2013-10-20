package com.xlogisticzz.fireworkLauncher.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
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
    private Icon[] icons;
    
    public ItemCard(int par1) {
    
        super(par1);
        this.setCreativeTab(CreativeTabFireworkLauncher.tabFireworkLauncher);
        this.setHasSubtypes(true);
        
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.item.Item#getUnlocalizedName(net.minecraft.item.ItemStack)
     */
    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
    
        return Constants.UnLocalisedNames.FIREWORK_CARD + itemstack.getItemDamage();
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.item.Item#registerIcons(net.minecraft.client.renderer.texture.IconRegister)
     */
    @Override
    public void registerIcons(IconRegister par1IconRegister) {
    
        this.icons = new Icon[Constants.Icons.FIREWORK_CARD.length];
        
        for (int i = 0; i < Constants.Icons.FIREWORK_CARD.length; i++){
            this.icons[i] = par1IconRegister.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.FIREWORK_CARD[i]);
        }
        
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.item.Item#getIconFromDamage(int)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int par1) {
    
        return this.icons[par1];
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.item.Item#getSubItems(int, net.minecraft.creativetab.CreativeTabs, java.util.List)
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void getSubItems(int id, CreativeTabs tab, List list) {
    
        for (int i = 0; i < Constants.ItemNames.FIREWORK_CARD_NAME.length; i++){
            list.add(new ItemStack(id, 1, i));
        }
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.item.Item#onItemUseFirst(net.minecraft.item.ItemStack, net.minecraft.entity.player.EntityPlayer, net.minecraft.world.World, int, int, int, int, float, float, float)
     */
    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
    
        if (!world.isRemote && world.getBlockId(x, y, z) == ModBlocks.launcherBlock.blockID){
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
