package com.github.khy010802.twentyquestionapi;

import com.github.khy010802.twentyquestionapi.teams.TeamCommand;
import com.github.khy010802.twentyquestionapi.teams.Teams;
import com.github.khy010802.twentyquestionapi.variables.VarCommand;
import com.github.khy010802.twentyquestionapi.variables.Variables;
import com.github.khy010802.twentyquestionapi.variables.hook.PlaceHolderAPIHook;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public TeamCommand cmdTeam;
    public VarCommand cmdVar;

    public PlaceHolderAPIHook papi_hook;

    @Override
    public void onEnable() {
        Teams.register();
        Variables.register();

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            papi_hook = new PlaceHolderAPIHook();
            papi_hook.register();
        }

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
