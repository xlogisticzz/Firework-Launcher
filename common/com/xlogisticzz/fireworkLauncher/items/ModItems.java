package com.xlogisticzz.fireworkLauncher.items;

import net.minecraft.item.ItemStack;

import com.xlogisticzz.fireworkLauncher.lib.Constants;
import com.xlogisticzz.fireworkLauncher.lib.Ids;

import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ModItems {
    
    public static ItemCard card;
    
    public static void init() {
    
        card = new ItemCard(Ids.CARD);
        
    }
    
    public static void initLang() {
    
        for (int j = 0; j < Constants.ItemNames.FIREWORK_CARD_NAME.length; j++){
            LanguageRegistry.addName(new ItemStack(card, 1, j), Constants.ItemNames.FIREWORK_CARD_NAME[j]);
        }
        
    }
}
