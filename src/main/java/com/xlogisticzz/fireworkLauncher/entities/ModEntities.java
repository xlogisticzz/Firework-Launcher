package com.xlogisticzz.fireworkLauncher.entities;

import com.xlogisticzz.fireworkLauncher.FireworkLauncher;

import cpw.mods.fml.common.registry.EntityRegistry;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModEntities {
    
    public static void init() {
    
        EntityRegistry.registerModEntity(EntityRedRocket.class, "EntityRedRocket", 1, FireworkLauncher.instance, 80, 3, true);
        EntityRegistry.registerModEntity(EntityGreenRocket.class, "EntityGreenRocket", 2, FireworkLauncher.instance, 80, 3, true);
        EntityRegistry.registerModEntity(EntityBlueRocket.class, "EntityBlueRocket", 3, FireworkLauncher.instance, 80, 3, true);

    }
    
    public static void initInfo() {
    
    }
}
