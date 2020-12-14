package me.lede.signcmd.commands;

import java.util.HashMap;
import java.util.Objects;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.lede.signcmd.Main;
import me.lede.signcmd.data.DatRegistedSignCmd;
import me.lede.signcmd.data.DatSignCodeRewrite;
import me.lede.signcmd.data.DatSignTextRewrite;
import me.lede.signcmd.utils.Language;
import me.lede.signcmd.utils.SignConfigUtils;
import me.lede.signcmd.utils.Utils;

public class CmdMain implements CommandExecutor{

	@SuppressWarnings("unused")
	private Main plugin;
	
	public CmdMain(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("signcmd").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!label.equalsIgnoreCase("signcmd")) return true;
		
		if (!(sender instanceof Player)) return true;
		
		Player p = (Player) sender;
		
		if (!p.hasPermission(Utils.PERM_CREATE)) {		
			p.sendMessage(Utils.chat(Utils.PREFIX + Language.PERMISSION_MSG));
			return true;
		}
		
		if (args.length == 0) {
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd add <code> <command>"));
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd remove <code>"));
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd list <page>"));
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd save"));
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd edit <code>"));
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd change <line> <text>"));
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd cancel <edit/change>"));
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd lan <kr/en>"));
			return true;
		}
		
		if (args[0].equalsIgnoreCase("save")) {
			SignConfigUtils.save(plugin);
			p.sendMessage(Utils.chat(Utils.PREFIX + Language.COMPLETE_SAVE));
			return true;
		}
		
		else if (args[0].equalsIgnoreCase("lan")) {
			
			if (args.length == 1 || args.length > 2) {
				p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd lan <kr/en>"));
				return true;
			}
			
			Language.changeLan(args[1]);
			p.sendMessage(Utils.chat(Utils.PREFIX + Language.CHANGE_LANGUAGE));
			return true;
		}
		
		else if (args[0].equalsIgnoreCase("cancel")) {
			
			if (args.length == 1 || args.length > 2) {
				p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd cancel <edit/change>"));
				return true;
			}
			
			if (args[1].equalsIgnoreCase("edit")) {
				
				if (DatSignCodeRewrite.getRewriteCode(p) == null) {
					p.sendMessage(Utils.chat(Utils.PREFIX + Language.ALREADY_DISABLE_CHANGE));
					return true;
				}
				DatSignCodeRewrite.delRewriteCode(p);
				p.sendMessage(Utils.chat(Utils.PREFIX + Language.COMPLETE_DISABLE_CHANGE));
				return true;
			}
			
			else if (args[1].equalsIgnoreCase("change")) {
				
				if (DatSignTextRewrite.getRewriteTextLine(p) == null) {
					p.sendMessage(Utils.chat(Utils.PREFIX + Language.ALREADY_DISABLE_CHANGE));
					return true;
				}
				
				DatSignTextRewrite.delRewriteText(p);
				DatSignTextRewrite.delRewriteTextLine(p);
				p.sendMessage(Utils.chat(Utils.PREFIX + Language.COMPLETE_DISABLE_CHANGE));
				return true;
			}
			
			return true;
		}
		
		else if (args[0].equalsIgnoreCase("edit")) {
			
			if (args.length == 1 || args.length > 2) {
				p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd edit <code>"));
				return true;
			}
			
			String arg1 = args[1].replace("^", " ");
			
			if (DatRegistedSignCmd.getSignCmds(arg1) == null) {
				p.sendMessage(Utils.chat(Utils.PREFIX + Language.SIGN_CHANGE_ERROR));
				return true;
			}
			
			DatSignCodeRewrite.setRewriteCode(p, arg1);
			p.sendMessage(Utils.chat(Utils.PREFIX + "&6Code&f: " + arg1));
			p.sendMessage(Utils.chat(Utils.PREFIX + Language.SIGN_CHANGE_ACCEPT));
			return true;
			
		}
		
		else if (args[0].equalsIgnoreCase("change")) {
			
			if (args.length == 1 || args.length == 2 || args.length > 3) {
				p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd change <line> <text>"));
				return true;
			}
			
			if (!(args[1].equalsIgnoreCase("3") || args[1].equalsIgnoreCase("4"))) {
				p.sendMessage(Utils.chat(Utils.PREFIX + Language.CHANGE_TEXT_LINE_ERROR));
				return true;
			}
			
			String text = args[2].replace("^", " ");
			
			DatSignTextRewrite.setRewriteTextLine(p, args[1]);
			DatSignTextRewrite.setRewriteText(p, text);
			p.sendMessage(Utils.chat(Utils.PREFIX + "&6Line&f: " + args[1]));
			p.sendMessage(Utils.chat(Utils.PREFIX + "&6Text&f: " + Utils.chat(text)));
			p.sendMessage(Utils.chat(Utils.PREFIX + Language.SIGN_CHANGE_ACCEPT));
			return true;
			
		}
		
		else if (args[0].equalsIgnoreCase("add")) {
			
			if (args.length == 1 || args.length == 2 || args.length > 3) {
				p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd add <code> <command>"));
				return true;
			}
			
			else {
				String arg1 = args[1].replace("^", " ");
				String arg2 = args[2].replace("^", " ");
				DatRegistedSignCmd.setSignCmds(arg1, arg2);
				p.sendMessage(Utils.chat(Utils.PREFIX + Language.COMPLETE_ADD));
				p.sendMessage(Utils.chat(Utils.PREFIX + "&6" + arg1 + "&f: " + arg2));
				return true;
			}
			
		} 
		
		else if (args[0].equalsIgnoreCase("remove")) {
			
			if (args.length == 1 || args.length > 2) {
				p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd remove <code>"));
				return true;
			}
			
			else {
				
				String arg1 = args[1].replace("^", " ");
				
				if (DatRegistedSignCmd.getSignCmds(arg1) == null) {
					p.sendMessage(Utils.chat(Utils.PREFIX + Language.NON_EXISTENT_CODE));
					return true;
				}
				
				
				p.sendMessage(Utils.chat(Utils.PREFIX + Language.COMPLETE_REMOVE));
				p.sendMessage(Utils.chat(Utils.PREFIX + "&6" + arg1 + "&f: " + DatRegistedSignCmd.getSignCmds(arg1)));
				DatRegistedSignCmd.delSignCmds(arg1);
				return true;
			}
			
		}
		
		else if (args[0].equalsIgnoreCase("list")) {
			
			if (args.length == 1 || args.length > 2) {
				p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd list <page>"));
				return true;
			}
			
			else if (Objects.isNull(Integer.parseInt(args[1])) || Integer.parseInt(args[1]) <= 0) {
				p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd list <page>"));
				return true;
			}
			
			else {
				
				HashMap<String, String> list = DatRegistedSignCmd.GetSignCmds();
				String[] value = new String[100];
				int size = 0;
				
				for (String l : list.keySet()) {
					value[size++] = Utils.chat(l + ": " + list.get(l));
				}
				
				if (size == 0) {
					p.sendMessage(Utils.chat(Utils.PREFIX + Language.REGISTER_COMMAND_ERROR));
					return true;
				}
				
				if (Integer.parseInt(args[1]) > (size/10 + 1)) {
					p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd list 1 ~ " + (size/10 + 1)));
					return true;
				}
				
				int end = Integer.parseInt(args[1])*10;
				int start = end-10;
				
				p.sendMessage(Utils.chat("&6================== <Page "+ args[1] + "/" + (size/10 + 1) +"> =================="));
				for (int i = start; i < end; i++) {
					if (value[i] == null) break;
					p.sendMessage(Utils.chat(" - " + value[i]));	
				}
				p.sendMessage(Utils.chat("&6================================================"));
				
				return true;
			}
		
		}
		
		else {
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd add <code> <command>"));
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd remove <code>"));
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd list <page>"));
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd save"));
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd edit <code>"));
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd change <line> <text>"));
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd cancel <edit/change>"));
			p.sendMessage(Utils.chat(Utils.PREFIX + "/signcmd lan <kr/en>"));
			return true;
		}
	}
}
