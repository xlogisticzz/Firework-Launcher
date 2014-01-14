package com.xlogisticzz.fireworkLauncher.configuration;

import java.io.File;

import net.minecraftforge.common.Configuration;

import com.xlogisticzz.fireworkLauncher.lib.Ids;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ConfigurationHandler {
    
    public static Configuration configuration;
    
    public static void init(File file) {
    
        configuration = new Configuration(file);
        
        configuration.load();
        
        // Blocks
        Ids.BLOCKLAUNCHER = configuration.getBlock(Configuration.CATEGORY_BLOCK, "Firework Launcher ID", Ids.BLOCKLAUNCHER_DEFAULT).getInt();
        
        // Item IDs
        Ids.CARD = configuration.getItem(Configuration.CATEGORY_ITEM, "Card ID", Ids.CARD_DEFAULT).getInt() - 256;
        
        configuration.save();
        
    }
    
}
