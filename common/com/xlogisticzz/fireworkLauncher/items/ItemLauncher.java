package com.xlogisticzz.fireworkLauncher.items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.xlogisticzz.fireworkLauncher.lib.Constants;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ItemLauncher extends ItemBlock {
    
    public ItemLauncher(int id) {
    
        super(id);
        this.setHasSubtypes(true);
    }
    
    @Override
    public int getMetadata(int dammage) {
    
        return dammage;
    }
    
    @Override
    public String getItemDisplayName(ItemStack par1ItemStack) {
    
        return Constants.BlockNames.FIREWORK_LAUNCHER_NAME[par1ItemStack.getItemDamage()];
    }
    
}
