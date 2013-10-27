package com.xlogisticzz.fireworkLauncher.proxies;

import com.xlogisticzz.fireworkLauncher.client.RenderRocketBlue;
import com.xlogisticzz.fireworkLauncher.client.RenderRocketGreen;
import com.xlogisticzz.fireworkLauncher.client.RenderRocketRed;
import com.xlogisticzz.fireworkLauncher.client.sounds.SoundHandler;
import com.xlogisticzz.fireworkLauncher.entities.EntityBlueRocket;
import com.xlogisticzz.fireworkLauncher.entities.EntityGreenRocket;
import com.xlogisticzz.fireworkLauncher.entities.EntityRedRocket;

import cpw.mods.fml.client.registry.RenderingRegistry;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ClientProxy extends CommonProxy {
    
    /*
     * (non-Javadoc)
     * @see com.xlogisticzz.fireworkLauncher.proxies.CommonProxy#initSounds()
     */
    @Override
    public void initSounds() {
    
        new SoundHandler();
    }
    
    /*
     * (non-Javadoc)
     * @see com.xlogisticzz.fireworkLauncher.proxies.CommonProxy#initRenderers()
     */
    @Override
    public void initRenderers() {
    
        RenderingRegistry.registerEntityRenderingHandler(EntityRedRocket.class, new RenderRocketRed());
        RenderingRegistry.registerEntityRenderingHandler(EntityGreenRocket.class, new RenderRocketGreen());
        RenderingRegistry.registerEntityRenderingHandler(EntityBlueRocket.class, new RenderRocketBlue());

        
    }
    
}
