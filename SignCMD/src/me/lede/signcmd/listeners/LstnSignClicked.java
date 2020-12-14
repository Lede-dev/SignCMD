package me.lede.signcmd.listeners;

import org.bukkit.Bukkit;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.lede.signcmd.Main;
import me.lede.signcmd.data.DatRegistedSignCmd;
import me.lede.signcmd.data.DatSignCodeRewrite;
import me.lede.signcmd.data.DatSignTextRewrite;
import me.lede.signcmd.utils.Language;
import me.lede.signcmd.utils.Utils;
import net.md_5.bungee.api.ChatColor;

public class LstnSignClicked implements Listener{

	@SuppressWarnings("unused")
	private Main plugin;
	
	
	public LstnSignClicked(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	private void onSignClick(PlayerInteractEvent event) {
		
		Player p = event.getPlayer();
		
		if (!p.hasPermission("signcmd.user.use") || !p.isOp()) {
			p.sendMessage(Utils.chat(Utils.PREFIX + Language.PERMISSION_MSG));
			return;	
		}

		if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
		
		if (DatSignCodeRewrite.getRewriteCode(p) != null) return;
		
		if (DatSignTextRewrite.getRewriteTextLine(p) != null) return;
		
		BlockState state = event.getClickedBlock().getState();

		if (!(state instanceof Sign)) return;
		
		Sign sign = (Sign) state;
		
		String[] lines = sign.getLines();
		
		if (DatRegistedSignCmd.getSignCmds(ChatColor.stripColor(lines[1])) == null) return;
		
		String cmd = DatRegistedSignCmd.getSignCmds(ChatColor.stripColor(lines[1])).replace("%player%", p.getName()).replace("%world%", p.getWorld().getName());
		
		if (p.isOp()) {
			Bukkit.dispatchCommand(p, cmd);
			return;
		}
		
		p.setOp(true);
		Bukkit.dispatchCommand(p, cmd);
		p.setOp(false);
	}
	
}
