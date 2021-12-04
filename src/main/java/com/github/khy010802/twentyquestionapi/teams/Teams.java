package com.github.khy010802.twentyquestionapi.teams;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;

public enum Teams {

    OPERATOR(ChatColor.RED,"관리자", "op"),
    PLAYERS(ChatColor.YELLOW, "플레이어", "players"),
    PARTICIPANTS(ChatColor.AQUA, "참가자", "participants");

    public final static HashMap<Team, Teams> TEAM_TO_TEAMS_HASH = new HashMap<>();
    public final static HashMap<String, Teams> TEAMNAME_TO_TEAMS_HASH = new HashMap<>();

    private Team team;
    private ChatColor teamColor;
    private String name;
    private String teamName;

    Teams(ChatColor teamColor, String name, String teamName){
        this.teamColor = teamColor;
        this.name = name;
        this.teamName = teamName;
    }

    public ChatColor getTeamColor() {
        return teamColor;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getName() {
        return name;
    }

    public Team getTeam(){
        return this.team;
    }

    private void setTeam(Team t){
        team = t;
    }


    /*
    API 플러그인 실행 시, 최초로 실행됩니다.
    팀을 register하고 각 enum에 Team을 집어넣습니다.
    이 Team은 getTeam()으로 얻을 수 있습니다.
     */
    public static void register(){
        Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
        for(Teams t : Teams.values()){
            Team team = (sb.getTeam(t.getTeamName()) != null) ? sb.getTeam(t.getTeamName()) : sb.registerNewTeam(t.getTeamName());
            team.setColor(t.getTeamColor());
            team.setPrefix("[" + t.getName() + "]");
            team.setAllowFriendlyFire(true);
            team.setCanSeeFriendlyInvisibles(true);
            team.setOption(Team.Option.COLLISION_RULE, Team.OptionStatus.FOR_OWN_TEAM);
            t.setTeam(team);
            TEAM_TO_TEAMS_HASH.put(team, t);
            TEAMNAME_TO_TEAMS_HASH.put(t.getTeamName(), t);
        }
    }


}
