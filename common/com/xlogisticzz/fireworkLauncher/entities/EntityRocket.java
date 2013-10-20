package com.xlogisticzz.fireworkLauncher.entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Learning Modding Mod
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityRocket extends Entity {
    
    public EntityRocket(World par1World) {
    
        super(par1World);
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.entity.Entity#entityInit()
     */
    @Override
    protected void entityInit() {
    
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.entity.Entity#readEntityFromNBT(net.minecraft.nbt.NBTTagCompound)
     */
    @Override
    protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
    
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.entity.Entity#writeEntityToNBT(net.minecraft.nbt.NBTTagCompound)
     */
    @Override
    protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
    
    }
    
}
