package com.github.Gamecube762.IDT;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;


public class PlayerEventHandler implements Listener {
	
	
	static int TeleportBlock = 35;
	static String warnPerm = "idt.warn";
	static String debugPerm = "idt.debug";
	static String usePerm = "idt.use";
			
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		Player p = event.getPlayer();
		String useDoor = usePerm;
		
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(event.getClickedBlock().getTypeId() == 330 |event.getClickedBlock().getTypeId() == 71) {
			
				Block Door = event.getClickedBlock();
			
				Location pLoc = p.getLocation();
			
				Block DoorHold = Door.getRelative(BlockFace.DOWN);
				if (DoorHold.getTypeId() == 330 |DoorHold.getTypeId() == 71) {DoorHold = DoorHold.getRelative(BlockFace.DOWN);}
				
				Block DoorTop = DoorHold.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getRelative(BlockFace.UP);
				debug(p, Integer.toString(DoorTop.getTypeId()));/////////////////////////////////
				boolean foundSign = false;
				Sign sign = null;
				
				Block DoorSign = DoorTop.getRelative(BlockFace.NORTH);  
				
				
				if (!foundSign & (DoorSign.getTypeId()==63|DoorSign.getTypeId()==68|DoorSign.getTypeId()==323)) {
						sign = (Sign) DoorSign.getState();
						if (sign.getLine(0).equalsIgnoreCase("[IDT]")) {foundSign = true;} else {foundSign = false;}
				}DoorSign = DoorTop.getRelative(BlockFace.SOUTH);
				if (!foundSign & (DoorSign.getTypeId()==63|DoorSign.getTypeId()==68|DoorSign.getTypeId()==323)) {
					sign = (Sign) DoorSign.getState();
					if (sign.getLine(0).equalsIgnoreCase("[IDT]")) {foundSign = true;} else {foundSign = false;}
				}DoorSign = DoorTop.getRelative(BlockFace.EAST);
				if (!foundSign & (DoorSign.getTypeId()==63|DoorSign.getTypeId()==68|DoorSign.getTypeId()==323)) {
					sign = (Sign) DoorSign.getState();
					if (sign.getLine(0).equalsIgnoreCase("[IDT]")) {foundSign = true;} else {foundSign = false;}
				}DoorSign = DoorTop.getRelative(BlockFace.WEST);
				if (!foundSign & (DoorSign.getTypeId()==63|DoorSign.getTypeId()==68|DoorSign.getTypeId()==323)) {
					sign = (Sign) DoorSign.getState();
					if (sign.getLine(0).equalsIgnoreCase("[IDT]")) {foundSign = true;} else {foundSign = false;}
				}DoorSign = DoorHold.getRelative(BlockFace.NORTH);
				if (!foundSign & (DoorSign.getTypeId()==63|DoorSign.getTypeId()==68|DoorSign.getTypeId()==323)) {
					sign = (Sign) DoorSign.getState();
					if (sign.getLine(0).equalsIgnoreCase("[IDT]")) {foundSign = true;} else {foundSign = false;}
				}DoorSign = DoorHold.getRelative(BlockFace.SOUTH);
				if (!foundSign & (DoorSign.getTypeId()==63|DoorSign.getTypeId()==68|DoorSign.getTypeId()==323)) {
					sign = (Sign) DoorSign.getState();
					if (sign.getLine(0).equalsIgnoreCase("[IDT]")) {foundSign = true;} else {foundSign = false;}
				}DoorSign = DoorHold.getRelative(BlockFace.EAST);
				if (!foundSign & (DoorSign.getTypeId()==63|DoorSign.getTypeId()==68|DoorSign.getTypeId()==323)) {
					sign = (Sign) DoorSign.getState();
					if (sign.getLine(0).equalsIgnoreCase("[IDT]")) {foundSign = true;} else {foundSign = false;}
				}DoorSign = DoorHold.getRelative(BlockFace.WEST);
				if (!foundSign & (DoorSign.getTypeId()==63|DoorSign.getTypeId()==68|DoorSign.getTypeId()==323)) {
					sign = (Sign) DoorSign.getState();
					if (sign.getLine(0).equalsIgnoreCase("[IDT]")) {foundSign = true;} else {foundSign = false;}
				}
				if (!foundSign) {
					warn(p, "No Sign Found");
					sign = null;
				}
				
				if (foundSign) {if (sign.getLine(1).length() > 0) {useDoor = usePerm + "." + sign.getLine(1);} else {useDoor = usePerm;}} else {useDoor = usePerm;}

				debug(p, useDoor); if (p.hasPermission(useDoor)) {debug(p, "true");} else {debug(p, "false");}
				
				if (sign!=null|p.hasPermission(usePerm)) {
					if (p.hasPermission(useDoor)|p.hasPermission(usePerm)) {
						
						Block TeleportBlock1 = DoorHold.getRelative(BlockFace.NORTH);
						if (TeleportBlock1.getTypeId() != TeleportBlock) {TeleportBlock1 = TeleportBlock1.getRelative(BlockFace.NORTH);
					
							if (TeleportBlock1.getTypeId() != TeleportBlock) {TeleportBlock1 = DoorHold.getRelative(BlockFace.EAST);
						
								if (TeleportBlock1.getTypeId() != TeleportBlock) {TeleportBlock1 = TeleportBlock1.getRelative(BlockFace.EAST);
							
									if (TeleportBlock1.getTypeId() != TeleportBlock) {warn(p, "No teleport location found!");}
								}
							}
						}
						
						Block TeleportBlock2 = DoorHold.getRelative(BlockFace.SOUTH);
						if (TeleportBlock2.getTypeId() != TeleportBlock) {TeleportBlock2 = TeleportBlock2.getRelative(BlockFace.SOUTH); 
					
							if (TeleportBlock2.getTypeId() != TeleportBlock) {TeleportBlock2 = DoorHold.getRelative(BlockFace.WEST);
						
								if (TeleportBlock2.getTypeId() != TeleportBlock) {TeleportBlock2 = TeleportBlock2.getRelative(BlockFace.WEST);
							
									if (TeleportBlock2.getTypeId() != TeleportBlock) {warn(p, "No teleport location found!");}
								}
							}
						}
				
					Location TeleportBlock1Loc = TeleportBlock1.getLocation();
					Location TeleportBlock2Loc = TeleportBlock2.getLocation();
				
					double TeleportBlock1_Distance = Math.sqrt((pLoc.getBlockX()-TeleportBlock1Loc.getBlockX())*(pLoc.getBlockX()-TeleportBlock1Loc.getBlockX()) + (pLoc.getBlockZ()-TeleportBlock1Loc.getBlockZ())*(pLoc.getBlockZ()-TeleportBlock1Loc.getBlockZ()));
					double TeleportBlock2_Distance = Math.sqrt((pLoc.getBlockX()-TeleportBlock2Loc.getBlockX())*(pLoc.getBlockX()-TeleportBlock2Loc.getBlockX()) + (pLoc.getBlockZ()-TeleportBlock2Loc.getBlockZ())*(pLoc.getBlockZ()-TeleportBlock2Loc.getBlockZ()));
				
					Location newLoc = pLoc; 
				
					if (TeleportBlock1_Distance > TeleportBlock2_Distance) {newLoc = TeleportBlock1Loc;} else 
						if (TeleportBlock1_Distance < TeleportBlock2_Distance){newLoc = TeleportBlock2Loc;}
				
					newLoc.setY(newLoc.getBlockY()+1);
					newLoc.setX(newLoc.getX()+0.5);
					newLoc.setZ(newLoc.getZ()+0.5);
				
					p.getWorld().playEffect(pLoc, Effect.MOBSPAWNER_FLAMES, 1);//flames at the before spot
					p.teleport(newLoc);
					p.getWorld().playEffect(newLoc, Effect.MOBSPAWNER_FLAMES, 1);//flames at the after spot
					}
				}
			}
		}
	}
    
	public static void warn(Player p, String message){if (p.hasPermission(warnPerm)|p.isOp()) {p.sendMessage(message);}}
	public static void debug(Player p, String message){if (p.hasPermission(debugPerm)|p.isOp()) {p.sendMessage(message);}}
}
