package com.xlogisticzz.fireworkLauncher;

import java.io.File;

import com.xlogisticzz.fireworkLauncher.blocks.ModBlocks;
import com.xlogisticzz.fireworkLauncher.configuration.ConfigurationHandler;
import com.xlogisticzz.fireworkLauncher.crafting.Recipies;
import com.xlogisticzz.fireworkLauncher.entities.ModEntities;
import com.xlogisticzz.fireworkLauncher.items.ModItems;
import com.xlogisticzz.fireworkLauncher.lib.Constants;
import com.xlogisticzz.fireworkLauncher.network.PacketHandler;
import com.xlogisticzz.fireworkLauncher.proxies.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */

@Mod(modid = Constants.Mod.MODID, name = Constants.Mod.MODID, version = Constants.Mod.VERSION, certificateFingerprint = Constants.Mod.FINGERPRINT)
@NetworkMod(channels = Constants.Mod.CHANNEL_NAME, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class)
public class FireworkLauncher {
    
    @Instance(Constants.Mod.MODID)
    public static FireworkLauncher instance;
    
    @SidedProxy(clientSide = Constants.Proxies.CLIENT, serverSide = Constants.Proxies.COMMON)
    public static CommonProxy proxy;
    
    /* PreInitialization */
    @EventHandler
    public void PreInt(FMLPreInitializationEvent event) {
    
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Constants.Mod.CHANNEL_NAME + File.separator + Constants.Mod.MODID + ".cfg"));
        
        ModItems.init();
        ModBlocks.init();
        
        proxy.initSounds();
        proxy.initRenderers();
        
    }
    
    /* Initialisation */
    @EventHandler
    public void load(FMLInitializationEvent event) {
    
        ModEntities.init();
        ModItems.initLang();
        ModBlocks.initInfo();
        Recipies.initVanilla();
        ModEntities.initInfo();
        
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabFireworkLauncher", "en_US", "Firework Launcher");
        
    }
    
    /* PostInitialization */
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    
    }
    
    /* When the server starts */
    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
    
    }
    
}
