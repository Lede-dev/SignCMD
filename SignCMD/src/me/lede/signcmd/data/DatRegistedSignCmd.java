package me.lede.signcmd.data;

import java.util.HashMap;

public class DatRegistedSignCmd {
	
	private static HashMap<String, String> signCmds = new HashMap<>();
	
	public static void setSignCmds(HashMap<String, String> map) {
		signCmds = map;
	}
	
	public static void setSignCmds(String key, String value) {
		signCmds.put(key, value);
	}

	public static HashMap<String, String> GetSignCmds() {
		return signCmds;
	}
	
	public static String getSignCmds(String key) {
		return signCmds.get(key);
	}
	
	public static void delSignCmds(String key) {
		signCmds.remove(key);
	}
}
