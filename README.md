# SignCMD

It is a Minecraft plugin that allows you to register and use commands on signs.

Auther: Lede

Discord: https://discord.gg/ZZc7fBK

Youtube: https://www.youtube.com/channel/UCgwJYHQsbW_cPWfOFXo0XXQ

# How to use

## Eng
```
1. Register a command by using the "/signcmd add <code> <command>" command.
2. Type "signcmd" on the first line of the sign.
3. Enter the registered code on the second line of the sign.
4. In the 3rd and 4th lines, you can freely enter a description.

When registering commands, use the ^ character for spaces.
e.g. /signcmd add Go^to^spawn warp^custom^spawn

Players who click on the sign can use %player%
e.g. /signcmd add Heal!!! heal^%player%

```

## Kor
```
1. "/signcmd add <code> <command>" 명령어를 이용하여 명령어를 등록한다.
2. 표지판의 첫번째 줄에 "signcmd" 를 입력한다.
3. 표지판의 두번째 줄에 생성한 코드를 입력한다.
4. 표지판의 3번째와 4번째줄은 자유롭게 설명을 입력한다.

커맨드를 등록할 때, ^ 문자를 이용하여 띄어쓰기를 입력할 수 있다.
예) /signcmd add 스폰으로^이동 warp^custom^spawn

표지판을 클릭한 플레이어는 %player% 를 이용하여 받아올 수 있다.
예) /signcmd add 힐!!! heal^%player%
```

# Commands

## Eng

#### - Add command code
```
/signcmd add <code> <command>

 - <code>: Enter custom code that does not overlap.
 - <command>: Command input, command executed with op.
```

#### - Remove command code
```
/signcmd remove <code>

 - <code>: Enter the registered code.
```

#### - Check the code list
```
/signcmd list <page>

 - <page>: Enter an integer.
```

#### - Save the generated code
```
/signcmd save
```

#### - Change the code of the sign
```
/signcmd edit <code>

 - <code>: Enter the generated code.
```

#### - Change the description of the sign
```
/signcmd change <line> <text>

 - <line>: Enter line 3 or 4.
 - <text>: You can enter a string including a color code.
```

#### - Cancels the edit/change command
```
/signcmd cancel <edit/change>
```

#### - Change the language setting
```
signcmd lan <kr/en>

 - Default is English
```

## Kor

#### - 커맨드 코드를 입력한다
```
/signcmd add <code> <command>

 - <code>: 중복되지 않는 커스텀 코드를 입력한다.
 - <command>: 커맨드를 입력한다, 커맨드는 op 권한으로 실행된다.
```

#### - 커맨드 코드를 제거한다
```
/signcmd remove <code>

 - <code>: 생성된 코드를 입력한다.
```

#### - 코드 목록을 확인한다
```
/signcmd list <page>

 - <page>: 정수를 입력한다.
```

#### - 생성된 코드를 저장한다
```
/signcmd save
```

#### - 표지판의 코드를 변경한다
```
/signcmd edit <code>

 - <code>: 생성된 코드를 입력한다.
```

#### - 표지판의 설명을 변경한다
```
/signcmd change <line> <text>

 - <line>: 3번과 4번라인만 입력 가능하다.
 - <text>: 컬러코드를 포함한 문자열을 자유롭게 입력할 수 있다.
```

#### - edit/change 커맨드를 취소한다
```
/signcmd cancel <edit/change>
```

#### - 언어 설정을 변경한다
```
signcmd lan <kr/en>

 - 기본값은 영어이다.
```


