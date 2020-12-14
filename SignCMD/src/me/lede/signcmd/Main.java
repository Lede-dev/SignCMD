package me.lede.signcmd;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.lede.signcmd.listeners.LstnSignClicked;
import me.lede.signcmd.listeners.LstnSignCodeRewrite;
import me.lede.signcmd.listeners.LstnSignTextRewrite;
import me.lede.signcmd.utils.Language;
import me.lede.signcmd.utils.SignConfigUtils;
import me.lede.signcmd.utils.Utils;
import me.lede.signcmd.commands.CmdMain;
import me.lede.signcmd.listeners.LstnSignChanged;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		
		SignConfigUtils.load(this);
		Language.loadLan();
		
		registListeners();
		registCommands();
		
		enableMessage();
	}
	
	@Override
	public void onDisable() {
		
		SignConfigUtils.save(this);
		
		disableMessage();
	}
	
	
	
	
	public void registListeners() {
		new LstnSignChanged(this);
		new LstnSignClicked(this);
		new LstnSignCodeRewrite(this);
		new LstnSignTextRewrite(this);
	}
	
	private void registCommands() {
		new CmdMain(this);
	}
	
	public void enableMessage() {
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&e==================================================="));
		Bukkit.getConsoleSender().sendMessage(Utils.chat(""));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&aEnable " + Utils.NAME + " " + Utils.VERSION));
		Bukkit.getConsoleSender().sendMessage(Utils.chat(""));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6Name: &f" + Utils.NAME));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6Version: &f" + Utils.VERSION));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6Author: &f" + Utils.AUTHOR));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6Discord: &f" + Utils.DISCORD));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6Update: &f" + Utils.DISCORD));
		Bukkit.getConsoleSender().sendMessage(Utils.chat(""));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&e==================================================="));
	}
	
	public void disableMessage() {
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&e==================================================="));
		Bukkit.getConsoleSender().sendMessage(Utils.chat(""));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&cDisable " + Utils.NAME + " " + Utils.VERSION));
		Bukkit.getConsoleSender().sendMessage(Utils.chat(""));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6Name: &f" + Utils.NAME));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6Version: &f" + Utils.VERSION));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6Author: &f" + Utils.AUTHOR));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6Discord: &f" + Utils.DISCORD));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&6Update: &f" + Utils.DISCORD));
		Bukkit.getConsoleSender().sendMessage(Utils.chat(""));
		Bukkit.getConsoleSender().sendMessage(Utils.chat("&e==================================================="));
	}
	

}
