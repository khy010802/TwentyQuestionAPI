package com.github.khy010802.twentyquestionapi;

import com.github.khy010802.twentyquestionapi.teams.TeamCommand;
import com.github.khy010802.twentyquestionapi.teams.Teams;
import com.github.khy010802.twentyquestionapi.variables.VarCommand;
import com.github.khy010802.twentyquestionapi.variables.Variables;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public TeamCommand cmdTeam;
    public VarCommand cmdVar;

    @Override
    public void onEnable() {
        Teams.register();
        Variables.register();

        cmdTeam = new TeamCommand();
        cmdVar = new VarCommand();

        getCommand("tqteam").setExecutor(cmdTeam);
        getCommand("tqteam").setTabCompleter(cmdTeam);

        getCommand("tqvar").setExecutor(cmdVar);
        getCommand("tqvar").setTabCompleter(cmdVar);
    }

    @Override
    public void onDisable() {

    }
}
