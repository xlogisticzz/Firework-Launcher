package com.xlogisticzz.fireworkLauncher.blocks;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.xlogisticzz.fireworkLauncher.CreativeTabFireworkLauncher;
import com.xlogisticzz.fireworkLauncher.items.ModItems;
import com.xlogisticzz.fireworkLauncher.lib.Constants;
import com.xlogisticzz.fireworkLauncher.tileEntities.TileEntityLauncher;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockLauncher extends BlockContainer {
    
    @SideOnly(Side.CLIENT)
    private IIcon botIcon;
    @SideOnly(Side.CLIENT)
    private IIcon topIcon;
    @SideOnly(Side.CLIENT)
    private IIcon[] sideIcons = new IIcon[Constants.Icons.BOX_SIDE.length];;
    
    public BlockLauncher() {
        super(Material.circuits);
        setCreativeTab(CreativeTabFireworkLauncher.tabFireworkLauncher);
        setHardness(3F);
        setResistance(3F);
        setBlockName(Constants.UnLocalisedNames.BOX);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg) {
        botIcon = reg.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.BOX_BOT);
        topIcon = reg.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.BOX_TOP);

        for (int i = 0; i < Constants.Icons.BOX_SIDE.length; i++){
            sideIcons[i] = reg.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.BOX_SIDE[i]);
        }
    }



    @Override
    public IIcon getIcon(int side, int meta) {
        switch (side) {
            case 0 :
                return botIcon;
            case 1 :
                return topIcon;
            default :
                return sideIcons[meta];
        }
    }

    @Override
    public int damageDropped(int metadata) {
        return metadata;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubBlocks(Item item, CreativeTabs par2CreativeTabs, List par3List) {
        for (int i = 0; i < Constants.Icons.BOX_SIDE.length; i++){
            par3List.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        if (player.isSneaking()){
            return false;
        }else{
            if (world.getBlock(x, y, z) == ModBlocks.launcherBlock){
                int meta = world.getBlockMetadata(x, y, z);
                if (meta == 0){
                    return false;
                }
                if (player.inventory.getCurrentItem() != null){
                    if (player.inventory.getCurrentItem().getItemDamage() + 1 == meta){
                        return false;
                    }
                }
                ItemStack item = new ItemStack(ModItems.card, 1, meta - 1);
                player.inventory.addItemStackToInventory(item);
                world.setBlockMetadataWithNotify(x, y, z, 0, 3);
            }
            
            return true;
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityLauncher();
    }
}
