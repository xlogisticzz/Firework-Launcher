package com.xlogisticzz.fireworkLauncher.network;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

/**
 * Firework Launcher
 * 
 * @author xLoGisTicZz. Some code may be from tutorials.
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PacketHandler implements IPacketHandler {
    
    /*
     * (non-Javadoc)
     * @see cpw.mods.fml.common.network.IPacketHandler#onPacketData(net.minecraft.network.INetworkManager, net.minecraft.network.packet.Packet250CustomPayload, cpw.mods.fml.common.network.Player)
     */
    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
    
    }
    
}
