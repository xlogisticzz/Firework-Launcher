package com.xlogisticzz.fireworkLauncher.blocks;

import net.minecraftforge.common.MinecraftForge;

import com.xlogisticzz.fireworkLauncher.items.ItemLauncher;
import com.xlogisticzz.fireworkLauncher.lib.Constants;
import com.xlogisticzz.fireworkLauncher.lib.Ids;
import com.xlogisticzz.fireworkLauncher.tileEntities.TileEntityLauncher;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModBlocks {
    
    public static BlockLauncher launcherBlock;
    
    public static void init() {
    
        launcherBlock = new BlockLauncher(Ids.BLOCKLAUNCHER);
        
    }
    
    public static void initInfo() {
    
        // Titanium Ore Details
        MinecraftForge.setBlockHarvestLevel(launcherBlock, "pickaxe", 2);
        GameRegistry.registerBlock(launcherBlock, ItemLauncher.class, Constants.UnLocalisedNames.BOX);
        GameRegistry.registerTileEntity(TileEntityLauncher.class, Constants.UnLocalisedNames.BOX + "TileEntity");
        
    }
}
