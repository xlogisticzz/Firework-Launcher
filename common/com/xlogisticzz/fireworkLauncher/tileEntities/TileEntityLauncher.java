package com.xlogisticzz.fireworkLauncher.tileEntities;

import java.util.Random;

import com.xlogisticzz.fireworkLauncher.entities.EntityRocket;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityLauncher extends TileEntity{
    
    private int timer;
    private Random rand = new Random();
    
    /* (non-Javadoc)
     * @see net.minecraft.tileentity.TileEntity#updateEntity()
     */
    @Override
    public void updateEntity() {
        
        if(!worldObj.isRemote){
            timer++;
            if(timer % 240 == 0){
                
                EntityRocket rocket = new EntityRocket(worldObj);
                
                rocket.setlaunchPos(xCoord + 0.5F, yCoord, zCoord +0.5F);
                
                worldObj.spawnEntityInWorld(rocket);
                
                
                timer = 0;
            }  
        }
        if(timer % 60 == 0){
            spawnParticles();                  
        }
    }
    
    
    public void spawnParticles(){
        for(int i = 0; i < 2; i++){
            float partX = xCoord + rand.nextFloat();
            float partY = yCoord + rand.nextFloat();
            float partZ = zCoord + rand.nextFloat();
            
            float partMotionX = -0.5F + rand.nextFloat();
            float partMotionY = -0.5F + rand.nextFloat();
            float partMotionZ = -0.5F + rand.nextFloat();
            
            worldObj.spawnParticle("smoke", partX, partY, partZ, partMotionX / 4 , partMotionY / 4, partMotionZ / 4);
        }
    }
    /* (non-Javadoc)
     * @see net.minecraft.tileentity.TileEntity#readFromNBT(net.minecraft.nbt.NBTTagCompound)
     */
    @Override
    public void readFromNBT(NBTTagCompound comp) {
        
        super.readFromNBT(comp);
        
        timer = comp.getByte("Timer");
    }
    
    /* (non-Javadoc)
     * @see net.minecraft.tileentity.TileEntity#writeToNBT(net.minecraft.nbt.NBTTagCompound)
     */
    @Override
    public void writeToNBT(NBTTagCompound comp) {
        
        super.writeToNBT(comp);
        
        comp.setByte("Timer", (byte) timer);
        
    }
    
}
