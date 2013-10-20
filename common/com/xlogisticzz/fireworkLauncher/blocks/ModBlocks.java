package com.xlogisticzz.fireworkLauncher.blocks;

import net.minecraftforge.common.MinecraftForge;

import com.xlogisticzz.fireworkLauncher.lib.Constants;
import com.xlogisticzz.fireworkLauncher.lib.Ids;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

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
        LanguageRegistry.addName(launcherBlock, Constants.BlockNames.FIREWORK_LAUNCHER_NAME);
        MinecraftForge.setBlockHarvestLevel(launcherBlock, "pickaxe", 2);
        GameRegistry.registerBlock(launcherBlock, Constants.UnLocalisedNames.BOX);
        
    }
}
