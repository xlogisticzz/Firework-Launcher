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
    
    private int startPosY;
    public int fireworkAge = 0;
    public int type = 0;
    
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
    
    public void setlaunchPos(double x, double y, double z) {
        
        this.startPosY = (int) y;
        
        this.setPosition(x, y, z);
    }
    /*
     * (non-Javadoc)
     * @see net.minecraft.entity.Entity#readEntityFromNBT(net.minecraft.nbt.NBTTagCompound)
     */
    @Override
    protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
    
        this.startPosY = nbttagcompound.getInteger("StartPosY");
        
    }
    
    /*
     * (non-Javadoc)
     * @see net.minecraft.entity.Entity#writeEntityToNBT(net.minecraft.nbt.NBTTagCompound)
     */
    @Override
    protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        nbttagcompound.setInteger("StartPosY", this.startPosY);

    }
    
    /* (non-Javadoc)
     * @see net.minecraft.entity.Entity#onUpdate()
     */
    @Override
    public void onUpdate() {
        
        super.onUpdate();
        
        
        if (!this.worldObj.isRemote){
                this.motionY = 0.4F;
            if ((int)this.posY == (this.startPosY + 40)){
                worldObj.createExplosion(this, posX, posY, posZ, 3.0F, true);
                this.setDead();
            }
            
        }
        if (this.worldObj.isRemote && this.fireworkAge % 2 < 2)
        {
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY - 0.3D, this.posZ, this.rand.nextGaussian() * 0.05D, -this.motionY * 0.5D, this.rand.nextGaussian() * 0.05D);
        }
        ++fireworkAge;
        setPosition(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
        
    }
    
    public void spawnParticles(){
        for(int i = 0; i < 2; i++){
            float partX = (float) (posX + rand.nextFloat());
            float partY = (float) (posY + rand.nextFloat());
            float partZ = (float) (posZ + rand.nextFloat());
            
            float partMotionX = -0.5F + rand.nextFloat();
            float partMotionY = -0.5F + rand.nextFloat();
            float partMotionZ = -0.5F + rand.nextFloat();
            
            worldObj.spawnParticle("explosion", partX, partY, partZ, partMotionX / 4 , partMotionY / 4, partMotionZ / 4);
        }
    }
}
