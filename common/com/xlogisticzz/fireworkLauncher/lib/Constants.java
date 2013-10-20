package com.xlogisticzz.fireworkLauncher.lib;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Constants {
    
    public class Mod {
        
        public static final String MODID = "fireworkLauncher";
        public static final String NAME = "Firework Launcher";
        public static final String VERSION = "@VERSION@ (build @BUILD_NUMBER@)";
        public static final String FINGERPRINT = "@FINGERPRINT@";
        public static final String CHANNEL_NAME = MODID;
    }
    
    public class Proxies {
        
        public static final String CLIENT = "com.xlogisticzz.fireworkLauncher.proxies.ClientProxy";
        public static final String COMMON = "com.xlogisticzz.fireworkLauncher.proxies.CommonProxy";
        
    }
    
    public static class BlockNames {
        
        public static final String[] FIREWORK_LAUNCHER_NAME = { "Disabled Firework Launcher", "Red Firework Launcher", "Green Firework Launcher", "Blue Firework Launcher" };
        
    }
    
    public static class ItemNames {
        
        public static final String[] FIREWORK_CARD_NAME = { "Red Firework", "Green Firework", "Blue Firework" };
        
    }
    
    public static class Icons {
        
        // Items
        public static final String[] FIREWORK_CARD = { "card1", "card2", "card3" };
        
        // Blocks
        public static final String BOX_TOP = "box_top";
        public static final String BOX_BOT = "box_bot";
        public static final String[] BOX_SIDE = { "box_side_type0", "box_side_type1", "box_side_type2", "box_side_type3" };
        
    }
    
    public class UnLocalisedNames {
        
        // Items
        public static final String FIREWORK_CARD = "fireworkCard";
        
        // Blocks
        public static final String BOX = "box";
    }
    
    public class Particles {
        
    }
}
