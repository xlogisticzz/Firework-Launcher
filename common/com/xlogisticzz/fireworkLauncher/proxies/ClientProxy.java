package com.xlogisticzz.fireworkLauncher.proxies;

import com.xlogisticzz.fireworkLauncher.client.RenderRocket;
import com.xlogisticzz.fireworkLauncher.entities.EntityRocket;

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
    
    }
    
    /*
     * (non-Javadoc)
     * @see com.xlogisticzz.fireworkLauncher.proxies.CommonProxy#initRenderers()
     */
    @Override
    public void initRenderers() {
    
        RenderingRegistry.registerEntityRenderingHandler(EntityRocket.class, new RenderRocket());
        
    }
    
}
