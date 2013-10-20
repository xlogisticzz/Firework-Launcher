package com.xlogisticzz.fireworkLauncher.client.sounds;

import net.minecraft.client.Minecraft;

public enum Sounds {
    LAUNCH("fire");
    
    public static final String SOUNDS_LOCATION = "fireworkLauncher";
    private String name;
    
    Sounds(String name) {
    
        this.name = name;
    }
    
    public String getName() {
    
        return this.name;
    }
    
    public void play(double x, double y, double z, float volume, float pitch) {
    
        Minecraft.getMinecraft().sndManager.playSound(SOUNDS_LOCATION + ":" + this.name, (float) x, (float) y, (float) z, volume, pitch);
    }
}
