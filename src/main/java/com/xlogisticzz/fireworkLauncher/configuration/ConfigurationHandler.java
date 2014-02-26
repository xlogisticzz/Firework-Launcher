package com.xlogisticzz.fireworkLauncher.configuration;

import java.io.File;


import net.minecraftforge.common.config.Configuration;

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


        configuration.save();
        
    }
    
}
