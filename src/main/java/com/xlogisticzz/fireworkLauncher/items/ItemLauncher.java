package com.xlogisticzz.fireworkLauncher.items;

import com.xlogisticzz.fireworkLauncher.blocks.ModBlocks;
import net.minecraft.block.Block;
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
    
    public ItemLauncher(Block block) {
        super(ModBlocks.launcherBlock);
        setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int dammage) {
        return dammage;
    }
    
    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack) {
        return "tile." + Constants.UnLocalisedNames.BOX + par1ItemStack.getItemDamage();
    }
}
