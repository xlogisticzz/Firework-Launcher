package com.xlogisticzz.fireworkLauncher.entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityRocket extends Entity {
    
    private int startPosY;
    public int fireworkAge = 0;
    
    public EntityRocket(World par1World) {
    
        super(par1World);
                
    }

    @Override
    protected void entityInit() {
    
    }
    
    public void setlaunchPos(double x, double y, double z) {
    
        this.startPosY = (int) y;
        this.setPosition(x, y, z);
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
    
        this.startPosY = nbttagcompound.getInteger("StartPosY");
        this.fireworkAge = nbttagcompound.getInteger("Age");
        
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
    
        nbttagcompound.setInteger("StartPosY", this.startPosY);
        nbttagcompound.setInteger("Age", this.startPosY);
        
    }

    @Override
    public void onUpdate() {
    
        super.onUpdate();
        
        if (!this.worldObj.isRemote){
            this.motionY = 0.4F;
            if ((int) this.posY == this.startPosY + 10){
                this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3.0F, true);
                this.setDead();
            }
            
        }
        if (this.worldObj.isRemote && this.fireworkAge % 2 < 2){
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY - 0.3D, this.posZ, this.rand.nextGaussian() * 0.05D, -this.motionY * 0.5D, this.rand.nextGaussian() * 0.05D);
        }
        ++this.fireworkAge;
        setPosition(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        
    }
    
    public void spawnParticles() {
    
        for (int i = 0; i < 2; i++){
            float partX = (float) (this.posX + this.rand.nextFloat());
            float partY = (float) (this.posY + this.rand.nextFloat());
            float partZ = (float) (this.posZ + this.rand.nextFloat());
            
            float partMotionX = -0.5F + this.rand.nextFloat();
            float partMotionY = -0.5F + this.rand.nextFloat();
            float partMotionZ = -0.5F + this.rand.nextFloat();
            
            this.worldObj.spawnParticle("explosion", partX, partY, partZ, partMotionX / 4, partMotionY / 4, partMotionZ / 4);
        }
    }
    
}
