package me.lede.signcmd.utils;

public class Language {
	
	public static String PERMISSION_MSG;
	
	public static String SIGN_CREATE_ERRER;
	
	public static String SIGN_CHANGE_ACCEPT;
	
	public static String SIGN_CHANGE_ERROR;
	
	public static String SIGN_EMPTY_ERROR;
	
	public static String COMPLETE_REWRITE_CODE;
	
	public static String COMPLETE_REWRITE_TEXT;
	
	public static String ALREADY_DISABLE_CHANGE;
	
	public static String COMPLETE_DISABLE_CHANGE;
	
	public static String CHANGE_TEXT_LINE_ERROR;
	
	public static String NON_EXISTENT_CODE;
	
	public static String REGISTER_COMMAND_ERROR;
	
	public static String COMPLETE_SAVE;
	
	public static String COMPLETE_ADD;
	
	public static String COMPLETE_REMOVE;
	
	public static String CHANGE_LANGUAGE;
	
	public static void loadLan() {
		loadLanEn();
	}
	
	public static void changeLan(String lan) {
		
		if (lan.equals("kr")) {
			loadLanKr();
		}
		
		else if (lan.equals("en")) {
			loadLanEn();
		}
		
		else loadLanEn();
	}
	
	public static void loadLanKr() {
		
		PERMISSION_MSG = "&c당신은 SignCMD를 사용할 수 없습니다.";
		
		SIGN_CREATE_ERRER = "&c등록되지 않은 코드입니다.";
		
		SIGN_CHANGE_ACCEPT = "&a변경할 표지판을 우클릭하세요.";
		
		SIGN_CHANGE_ERROR = "&c등록되지 않은 코드입니다.";
		
		SIGN_EMPTY_ERROR = "&c이 표지판은 변경할 수 없습니다.";
		
		COMPLETE_REWRITE_CODE = "&a코드 재설정 완료.";
		
		COMPLETE_REWRITE_TEXT = "&a텍스트 재설정 완료.";
		
		ALREADY_DISABLE_CHANGE = "&c이미 비활성화 상태입니다.";
		
		COMPLETE_DISABLE_CHANGE = "&aSignCMD 재설정이 비활성화 되었습니다.";
		
		CHANGE_TEXT_LINE_ERROR = "&c3번, 4번 라인만 수정 가능합니다.";
		
		NON_EXISTENT_CODE = "&c존재하지 않는 코드입니다.";
		
		REGISTER_COMMAND_ERROR = "&c등록된 명령어가 없습니다.";
		
		COMPLETE_SAVE = "&a저장 완료!";
		
		COMPLETE_ADD = "&aSignCMD 추가 완료!";
		
		COMPLETE_REMOVE = "&aSignCMD 제거 완료!";
		
		CHANGE_LANGUAGE = "&a언어 변경 완료!";
		
	}
	
	public static void loadLanEn() {
		
		PERMISSION_MSG = "&cYou cannot use SignCMD.";
		
		SIGN_CREATE_ERRER = "&cThis code is not registered.";
		
		SIGN_CHANGE_ACCEPT = "&aRight-click on the sign you want to change.";
		
		SIGN_CHANGE_ERROR = "&cThis code is not registered.";
		
		SIGN_EMPTY_ERROR = "&cThis sign cannot be changed.";
		
		COMPLETE_REWRITE_CODE = "&aCode setup complete.";
		
		COMPLETE_REWRITE_TEXT = "&aText setup complete.";
		
		ALREADY_DISABLE_CHANGE = "&cIt is already disabled.";
		
		COMPLETE_DISABLE_CHANGE = "&aSignCMD reset has been disabled.";
		
		CHANGE_TEXT_LINE_ERROR = "&cOnly lines 3 and 4 can be modified.";
		
		NON_EXISTENT_CODE = "&cThis code does not exist.";
		
		REGISTER_COMMAND_ERROR = "&cThere are no registered commands.";
		
		COMPLETE_SAVE = "&aSaved!";
		
		COMPLETE_ADD = "&aSignCMD added!";
		
		COMPLETE_REMOVE = "&aSignCMD remove complete!";
		
		CHANGE_LANGUAGE = "&aLanguage change complete!";
		
	}

}
