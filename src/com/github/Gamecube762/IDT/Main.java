package com.github.Gamecube762.IDT;

import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
	
    @Override
    public void onEnable(){
        getServer().getPluginManager().registerEvents(new PlayerEventHandler(), this);
    }
    
    @Override
    public void onDisable(){
        
    }
	

}
