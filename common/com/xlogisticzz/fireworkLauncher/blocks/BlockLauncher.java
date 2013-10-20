package com.xlogisticzz.fireworkLauncher.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

import com.xlogisticzz.fireworkLauncher.CreativeTabFireworkLauncher;
import com.xlogisticzz.fireworkLauncher.lib.Constants;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockLauncher extends Block {
    
    @SideOnly(Side.CLIENT)
    Icon botIcon;
    
    @SideOnly(Side.CLIENT)
    Icon topIcon;
    
    @SideOnly(Side.CLIENT)
    Icon[] sideIcons;
    
    public BlockLauncher(int par1) {
    
        super(par1, Material.circuits);
        this.setCreativeTab(CreativeTabFireworkLauncher.tabFireworkLauncher);
        this.setHardness(3F);
        this.setResistance(3F);
        this.setUnlocalizedName(Constants.UnLocalisedNames.BOX);
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#registerIcons(net.minecraft.client.renderer.texture.IconRegister)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg) {
    
        this.botIcon = reg.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.BOX_BOT);
        this.topIcon = reg.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.BOX_TOP);
        
        this.sideIcons = new Icon[Constants.Icons.BOX_SIDE.length];
        for (int i = 0; i < Constants.Icons.BOX_SIDE.length; i++){
            this.sideIcons[i] = reg.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.BOX_SIDE[i]);
        }
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#getIcon(int, int)
     */
    @Override
    public Icon getIcon(int side, int meta) {
    
        switch (side) {
        
            case 0 :
                return this.botIcon;
                
            case 1 :
                return this.topIcon;
                
            default :
                return this.sideIcons[meta];
                
        }
        
    }
}
