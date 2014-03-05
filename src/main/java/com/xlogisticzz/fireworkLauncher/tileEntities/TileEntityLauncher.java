package com.xlogisticzz.fireworkLauncher.tileEntities;

import java.util.Random;

import com.xlogisticzz.fireworkLauncher.client.sounds.SoundHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.xlogisticzz.fireworkLauncher.entities.EntityBlueRocket;
import com.xlogisticzz.fireworkLauncher.entities.EntityGreenRocket;
import com.xlogisticzz.fireworkLauncher.entities.EntityRedRocket;
import com.xlogisticzz.fireworkLauncher.entities.EntityRocket;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityLauncher extends TileEntity {
    
    private int timer;
    private Random rand = new Random();
    public int type;
    public EntityRocket rocket;

    @Override
    public void updateEntity() {
    
        if (this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) > 0){
            if (!this.worldObj.isRemote){
                this.timer++;
                if (this.timer % 240 == 0){
                    
                    this.type = (this.worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) - 1);
                    switch (this.type) {
                        case 0 :
                            rocket = new EntityRedRocket(worldObj);
                            break;
                        
                        case 1 :
                            rocket = new EntityGreenRocket(worldObj);
                            break;
                        
                        case 2 :
                            rocket = new EntityBlueRocket(worldObj);
                            break;
                        
                        default :
                            rocket = new EntityRedRocket(worldObj);
                            break;
                    }
                    rocket.setlaunchPos(this.xCoord + 0.5F, this.yCoord, this.zCoord + 0.5F);
                    
                    this.worldObj.spawnEntityInWorld(rocket);
                    SoundHandler.playSoundInWorld(worldObj, (double) xCoord, (double) yCoord, (double) zCoord, "launch", 1, 0);

                    this.timer = 0;
                }
            }
            if (this.timer % 60 == 0){
                spawnParticles();
            }
        }
    }
    
    public void spawnParticles() {
    
        for (int i = 0; i < 2; i++){
            float partX = this.xCoord + this.rand.nextFloat();
            float partY = this.yCoord + this.rand.nextFloat();
            float partZ = this.zCoord + this.rand.nextFloat();
            
            float partMotionX = -0.5F + this.rand.nextFloat();
            float partMotionY = -0.5F + this.rand.nextFloat();
            float partMotionZ = -0.5F + this.rand.nextFloat();
            
            worldObj.spawnParticle("smoke", partX, partY, partZ, partMotionX / 4, partMotionY / 4, partMotionZ / 4);
        }
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.tileentity.TileEntity#readFromNBT(net.minecraft.nbt.NBTTagCompound)
     */
    @Override
    public void readFromNBT(NBTTagCompound comp) {
    
        super.readFromNBT(comp);
        
        this.timer = comp.getByte("Timer");
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.tileentity.TileEntity#writeToNBT(net.minecraft.nbt.NBTTagCompound)
     */
    @Override
    public void writeToNBT(NBTTagCompound comp) {
    
        super.writeToNBT(comp);
        
        comp.setByte("Timer", (byte) this.timer);
        
    }
    
}
