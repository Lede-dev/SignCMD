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
import me.lede.signcmd.data.DatSignCodeRewrite;
import me.lede.signcmd.utils.Language;
import me.lede.signcmd.utils.Utils;

public class LstnSignCodeRewrite implements Listener{
	
	@SuppressWarnings("unused")
	private Main plugin;
	
	public LstnSignCodeRewrite(Main plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	private void onSignClicked(PlayerInteractEvent event) {
		
		Player p = event.getPlayer();
		
		if (!p.hasPermission(Utils.PERM_REWRITE_CODE)) return;

		if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

		if (DatSignCodeRewrite.getRewriteCode(p) == null) return;

		BlockState state = event.getClickedBlock().getState();
		
		if (!(state instanceof Sign)) return;
		
		Sign sign = (Sign) state;
		
		if (!sign.getLine(0).equalsIgnoreCase(Utils.chat(Utils.CREATE))) {		
			p.sendMessage(Utils.chat(Utils.PREFIX + Language.SIGN_EMPTY_ERROR));
			return;
		}
		
		event.setCancelled(true);
		
		String value = DatSignCodeRewrite.getRewriteCode(p);
		
		sign.setLine(1, Utils.chat("&a" + value));
		
		sign.update(true);
		
		DatSignCodeRewrite.delRewriteCode(p);
		
		p.sendMessage(Utils.chat(Utils.PREFIX + Language.COMPLETE_REWRITE_CODE));
		
	}

}
