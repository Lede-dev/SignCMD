package me.lede.signcmd.utils;

import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;

import me.lede.signcmd.Main;
import me.lede.signcmd.data.DatRegistedSignCmd;

public class SignConfigUtils {
	
	
	public static void save(Main plugin) {
		
		HashMap<String, String> data = DatRegistedSignCmd.GetSignCmds();
		FileConfiguration config = plugin.getConfig();
		
		for (String configKey : config.getKeys(false)) {
			config.set(configKey, null);
		}
		
		for(String key : data.keySet()){
			config.addDefault(key, data.get(key));
		}
		
		config.options().copyDefaults(true);
		plugin.saveConfig();
	}	
	
	public static void load(Main plugin) {
		
		HashMap<String, String> data = new HashMap<>();
		FileConfiguration config = plugin.getConfig();
		
		for (String key : config.getKeys(false)) {
			data.put(key, config.getString(key));
		}
		
		DatRegistedSignCmd.setSignCmds(data);
		
	}

}
