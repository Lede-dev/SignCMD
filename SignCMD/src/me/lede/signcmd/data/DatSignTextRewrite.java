package me.lede.signcmd.data;

import java.util.HashMap;

import org.bukkit.entity.Player;

public class DatSignTextRewrite {
	
	private static HashMap <Player, String> rewriteText = new HashMap<>();

	public static void setRewriteText(HashMap<Player, String> map) {
		rewriteText = map;
	}
	
	public static void setRewriteText(Player key, String value) {
		rewriteText.put(key, value);
	}
	
	public static HashMap<Player, String> getRewriteText() {
		return rewriteText;
	}
	
	public static String getRewriteText(Player key) {
		return rewriteText.get(key);
	}
	
	public static void delRewriteText(Player key) {
		rewriteText.remove(key);
	}
	
	//=======================================================================
	private static HashMap <Player, String> rewriteTextLine = new HashMap<>();
	
	public static void setRewriteTextLine(HashMap<Player, String> map) {
		rewriteTextLine = map;
	}
	
	public static void setRewriteTextLine(Player key, String value) {
		rewriteTextLine.put(key, value);
	}
	
	public static HashMap<Player, String> getRewriteTextLine() {
		return rewriteTextLine;
	}
	
	public static String getRewriteTextLine(Player key) {
		return rewriteTextLine.get(key);
	}
	
	public static void delRewriteTextLine(Player key) {
		rewriteTextLine.remove(key);
	}
	
}
