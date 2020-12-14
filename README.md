# SignCMD

It is a Minecraft plugin that allows you to register and use commands on signs.

Auther: Lede

Discord: https://discord.gg/ZZc7fBK

## How to use

#### Eng
```
1. Register a command by using the "/signcmd add <code> <command>" command.
2. Type "signcmd" on the first line of the sign.
3. Enter the registered code on the second line of the sign.
4. In the 3rd and 4th lines, you can freely enter a description.
```

#### Kor
```
1. "/signcmd add <code> <command>" 명령어를 이용하여 명령어를 등록한다.
2. 표지판의 첫번째 줄에 "signcmd" 를 입력한다.
3. 표지판의 두번째 줄에 생성한 코드를 입력한다.
4. 표지판의 3번째와 4번째줄은 자유롭게 설명을 입력한다.
```

## Commands

#### Add command code
```
/signcmd add <code> <command>

 - <code>: Enter custom code that does not overlap.
 - <command>: Command input, command executed with op.
```

#### Remove command code
```
/signcmd remove <code>

 - <code>: Enter the registered code.
```

#### Check the code list
```
/signcmd list <page>

 - <page>: Enter an integer.
```

#### Save the generated code
```
/signcmd save
```

#### Change the code of the sign
```
/signcmd edit <code>

 - <code>: Enter the generated code.
```

#### Change the description of the sign
```
/signcmd change <line> <text>

 - <line>: Enter line 3 or 4.
 - <text>: You can enter a string including a color code.
```

#### Cancels the edit/change command.
```
/signcmd cancel <edit/change>
```

#### Change the language setting. Default is English.
```
signcmd lan <kr/en>
```



