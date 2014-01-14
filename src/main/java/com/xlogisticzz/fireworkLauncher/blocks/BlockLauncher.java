package com.xlogisticzz.fireworkLauncher.blocks;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
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
    private Icon botIcon;
    @SideOnly(Side.CLIENT)
    private Icon topIcon;
    @SideOnly(Side.CLIENT)
    private Icon[] sideIcons;
    
    public BlockLauncher(int par1) {
    
        super(par1, Material.circuits);
        this.setCreativeTab(CreativeTabFireworkLauncher.tabFireworkLauncher);
        this.setHardness(3F);
        this.setResistance(3F);
        this.setUnlocalizedName(Constants.UnLocalisedNames.BOX);
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#registerIcons(net.minecraft.client.renderer.texture.IconRegister)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister reg) {
    
        this.botIcon = reg.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.BOX_BOT);
        this.topIcon = reg.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.BOX_TOP);
        
        this.sideIcons = new Icon[Constants.Icons.BOX_SIDE.length];
        for (int i = 0; i < Constants.Icons.BOX_SIDE.length; i++){
            this.sideIcons[i] = reg.registerIcon(Constants.Mod.MODID + ":" + Constants.Icons.BOX_SIDE[i]);
        }
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#getIcon(int, int)
     */
    @Override
    public Icon getIcon(int side, int meta) {
    
        switch (side) {
        
            case 0 :
                return this.botIcon;
                
            case 1 :
                return this.topIcon;
                
            default :
                return this.sideIcons[meta];
                
        }
        
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#damageDropped(int)
     */
    @Override
    public int damageDropped(int metadata) {
    
        return metadata;
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#getSubBlocks(int, net.minecraft.creativetab.CreativeTabs, java.util.List)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubBlocks(int id, CreativeTabs par2CreativeTabs, List par3List) {
    
        for (int i = 0; i < Constants.Icons.BOX_SIDE.length; i++){
            par3List.add(new ItemStack(id, 1, i));
        }
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.Block#onBlockActivated(net.minecraft.world.World, int, int, int, net.minecraft.entity.player.EntityPlayer, int, float, float, float)
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
    
        if (player.isSneaking()){
            return false;
        }else{
            if (world.getBlockId(x, y, z) == ModBlocks.launcherBlock.blockID){
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
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.block.ITileEntityProvider#createNewTileEntity(net.minecraft.world.World)
     */
    @Override
    public TileEntity createNewTileEntity(World world) {
    
        TileEntityLauncher tile = new TileEntityLauncher();
        return tile;
    }
}
