package com.xlogisticzz.fireworkLauncher.client;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class RenderRocketBlue extends RenderRocket {
    
    public RenderRocketBlue() {
    
    }
    
    /*
     * (non-Javadoc)
     * @see com.xlogisticzz.fireworkLauncher.client.RenderRocket#getEntityTexture(net.minecraft.entity.Entity)
     */
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
    
        return RenderRocket.textures[2];
    }
    
}
