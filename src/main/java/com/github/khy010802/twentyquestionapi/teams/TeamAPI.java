package com.github.khy010802.twentyquestionapi.teams;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TeamAPI {

    private final static Scoreboard SCOREBOARD = Bukkit.getScoreboardManager().getMainScoreboard();


    /**
     * 팀 이름으로 Team을 얻습니다.
     * 사실 Scoreboard.getTeam이 있어서 의미없는 API긴 합니다
     * @param teamName 팀 이름
     * @return Teams enum
     */
    public static Teams getTeamByTeamName(String teamName) {
        return Teams.TEAMNAME_TO_TEAMS_HASH.get(teamName);
    }

    /**
     * 해당 플레이어를 팀에 추가합니다.
     * 이미 가입된 팀이 있다면 해당 팀에서 탈퇴시킵니다.
     * @param p 대상 플레이어
     * @param t 대상 팀(Teams)
     */
    public static void addPlayer(Player p, Teams t){
        removePlayer(p);
        t.getTeam().addEntry(p.getUniqueId().toString());
    }

    /**
     * 해당 플레이어를 소속된 팀에서 제거합니다.
     * 주의) 컨텐츠 진행 중에는 모든 플레이어가 팀에 소속되어있어야 정상 작동합니다.
     * @param p 대상 플레이어
     * @return 성공 여부(false 리턴 시, 해당 플레이어가 소속된 팀이 없었다는 것)
     */
    public static boolean removePlayer(Player p){
        String uuid = p.getUniqueId().toString();
        Team team = SCOREBOARD.getEntryTeam(uuid);
        if(team != null){
            team.removeEntry(uuid);
        }
        return team != null;
    }

    /**
     * 해당 팀에 소속된 플레이어들을 불러옵니다.
     * @param team Teams enum
     * @return 플레이어들의 리스트
     */
    public static List<Player> getPlayers(Teams team){
        List<Player> players = new ArrayList<>();
        Team t = team.getTeam();
        for(String entry : t.getEntries()){
            if(Bukkit.getPlayer(entry) != null){
                players.add(Bukkit.getPlayer(entry));
            } else {
                Player p = Bukkit.getPlayer(UUID.fromString(entry));
                if(p != null)
                    players.add(p);
            }
        }
        return players;
    }

    /**
     * 해당 플레이어가 소속된 팀을 구합니다.
     * @param p 플레이어
     * @return 해당 플레이어의 팀
     */
    public static Teams getTeam(Player p){
        Scoreboard sb = Bukkit.getScoreboardManager().getMainScoreboard();
        Team t = sb.getEntryTeam(p.getUniqueId().toString());
        if(t == null)
            return null;
        return Teams.TEAM_TO_TEAMS_HASH.get(t);
    }
}
