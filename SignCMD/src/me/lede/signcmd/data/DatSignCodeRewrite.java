package me.lede.signcmd.data;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class DatSignCodeRewrite {

	private static HashMap <Player, String> rewriteCode = new HashMap<>();
	
	public static void setRewriteCode(HashMap<Player, String> map) {
		rewriteCode = map;
	}
	
	public static void setRewriteCode(Player key, String value) {
		rewriteCode.put(key, value);
	}
	
	public static HashMap<Player, String> getRewriteCode() {
		return rewriteCode;
	}
	
	public static String getRewriteCode(Player key) {
		return rewriteCode.get(key);
	}
	
	public static void delRewriteCode(Player key) {
		rewriteCode.remove(key);
	}
	
}
