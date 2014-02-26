package com.xlogisticzz.fireworkLauncher.blocks;

import com.xlogisticzz.fireworkLauncher.items.ItemLauncher;
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
        launcherBlock = new BlockLauncher();
        GameRegistry.registerBlock(launcherBlock, ItemLauncher.class, "launcherBlock");
        GameRegistry.registerTileEntity(TileEntityLauncher.class, "tileLauncher");
    }

}
