# **스무고개 API 플러그인**

## 빌드
[![](https://jitpack.io/v/khy010802/TwentyQuestionAPI.svg)](https://jitpack.io/#khy010802/TwentyQuestionAPI)

## PlaceHolderAPI 지원
```
String money = "%tqvar_money%원";
String point = "%tqvar_point%포인트";
Bukkit.broadcastMessage(PlaceholderAPI.setPlaceholders(null, money));
Bukkit.broadcastMessage(PlaceholderAPI.setPlaceholders(null, point));
```

## 용법

### 팀API : 미니게임 참가자 구하기
```
TeamAPI.getPlayers(Teams.PARTICIPANTS);
```

### 팀API : 미니게임 참가자에 플레이어 추가
```
TeamAPI.addPlayer(player, Teams.PARTICIPANTS);
```



### 변수 API : 현재 남은 행동 포인트 구하기
```
int value = Variables.POINT.getValue();
```

### 변수 API : 돈 100원 추가
```
VarAPI.addValue(Variables.MONEY, 100);
```