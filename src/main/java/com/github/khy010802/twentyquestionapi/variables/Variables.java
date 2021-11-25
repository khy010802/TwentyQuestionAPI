package com.github.khy010802.twentyquestionapi.variables;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public enum Variables {

    MONEY("상금", "money"),
    POINT("행동 포인트", "point");

    private final String name;
    private final String objName;
    private Objective obj;

    Variables(String name, String dummyName){
        this.name = name;
        this.objName = dummyName;
    }

    public String getName() { return this.name; }
    public String getDummyName(){ return this.objName; }
    public Objective getObjective() { return this.obj; }
    public Score getScore() { return this.obj.getScore(name); }
    public int getValue() { return getScore().getScore(); }

    private void setObjective(Objective obj){
        this.obj = obj;
    }


    /*
    API 플러그인 실행 시, 최초로 실행됩니다.
    각 Objectives를 register하고 enum 값에 집어넣습니다.
    해당 Objective는 Variables.getObjective()로 구할 수 있습니다.
    해당 Variable에 해당하는 Score는 Variables.getScore()로 구할 수 있습니다.
    단순히 변수의 값만을 원한다면 getValue()를 사용하시면 됩니다.
     */
    public static void register(){
        Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
        for(Variables vars : Variables.values()){
            if(sb.getObjective(vars.getDummyName()) == null){
                Objective obj = sb.registerNewObjective(vars.getDummyName(), "dummy");
                obj.setDisplayName(vars.getName());
                obj.getScore(vars.getName()).setScore(0);
                vars.setObjective(obj);
            }
        }
    }

}
