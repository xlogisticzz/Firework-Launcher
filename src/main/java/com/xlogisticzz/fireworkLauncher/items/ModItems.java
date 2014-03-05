package com.xlogisticzz.fireworkLauncher.items;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModItems {
    
    public static ItemCard card;
    
    public static void init() {
        card = new ItemCard();
        GameRegistry.registerItem(card , "card");
    }
}
