package com.xlogisticzz.fireworkLauncher;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class CreativeTabFireworkLauncher {
    
    public static CreativeTabs tabFireworkLauncher = new CreativeTabs("tabFireworkLauncher") {
        
        /* Tab Icon */
        @Override
        public ItemStack getIconItemStack() {
        
            return new ItemStack(Item.firework, 1, 0);
        }
    };
}
