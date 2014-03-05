package com.xlogisticzz.fireworkLauncher.client.sounds;

import com.xlogisticzz.fireworkLauncher.lib.Constants;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SoundHandler {

    public static void playOnEntity(Entity entity, String soundName, float volume, float pitch){
        entity.worldObj.playSoundAtEntity(entity, (Constants.Mod.MODID + ":" + soundName), volume, pitch);
    }

    public static void playSoundInWorld(World world, double x, double y, double z, String soundName, float volume, float pitch){
        world.playSoundEffect(x, y, z, (Constants.Mod.MODID + ":" + soundName), volume, pitch);
    }
    
}
