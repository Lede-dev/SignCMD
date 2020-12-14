package me.lede.signcmd.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import me.lede.signcmd.Main;
import me.lede.signcmd.data.DatRegistedSignCmd;
import me.lede.signcmd.utils.Language;
import me.lede.signcmd.utils.Utils;

public class LstnSignChanged implements Listener{

	
	@SuppressWarnings("unused")
	private Main plugin;
	
	
	public LstnSignChanged(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	private void onPlacedSign(SignChangeEvent event) {
		
		Player p = event.getPlayer();
		String[] lines = event.getLines();
		

		if (!lines[0].toLowerCase().equals("signcmd") || lines[0] == null) return;

		if (!p.hasPermission(Utils.PERM_CREATE)) {
			p.sendMessage(Utils.chat(Utils.PREFIX + Language.PERMISSION_MSG));
			return;
		}
		
		if (DatRegistedSignCmd.getSignCmds(lines[1]) != null) {
			event.setLine(0, Utils.chat(Utils.CREATE));
			event.setLine(1, Utils.chat("&a"+lines[1]));
			event.setLine(2, Utils.chat("&a"+lines[2]));
			event.setLine(3, Utils.chat("&a"+lines[3]));
		}
		else {
			p.sendMessage(Utils.chat(Utils.PREFIX + Language.SIGN_CREATE_ERRER));
			event.getBlock().breakNaturally();
		}
		
		
	}
}
