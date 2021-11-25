package com.github.khy010802.twentyquestionapi.teams;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TeamCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!sender.isOp()) return true;

        if(args.length == 0){
            help(sender);
        } else if(args.length == 2){ // 2 args
            if(args[0].equalsIgnoreCase("remove")){
                remove(sender, args);
            }
        } else if(args.length == 3){ // 3 args
            if(args[0].equalsIgnoreCase("add")){
                add(sender, args);
            }
        } else {
            help(sender);
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if(args.length == 0){
            return Arrays.asList("add", "remove");
        } else if(args[0].equalsIgnoreCase("add")){
            if(args.length == 1){
                return Bukkit.getOnlinePlayers().stream().map(Player::getName).collect(Collectors.toList());
            } else if(args.length == 2){
                return Teams.TEAM_TO_TEAMS_HASH.values().stream().map(Teams::getTeamName).collect(Collectors.toList());
            }
        } else if(args[0].equalsIgnoreCase("remove")){
            if(args.length == 1){
                return Bukkit.getOnlinePlayers().stream().map(Player::getName).collect(Collectors.toList());
            }
        }

        return null;
    }

    private void remove(CommandSender sender, String[] args){
        String name = args[1];

        Player p = Bukkit.getPlayer(name);
        if(p != null){
            TeamAPI.removePlayer(p);
            sender.sendMessage("removed");
        } else {
            sender.sendMessage("§cNo player named " + name);
        }
    }

    private void add(CommandSender sender, String[] args){
        String name = args[1];
        String team = args[2];

        Player p = Bukkit.getPlayer(name);
        Teams t = TeamAPI.getTeamByTeamName(team);

        if(t == null){
            sender.sendMessage("§cNo team named  " + team);
        } else if(p == null){
            sender.sendMessage("§cNo player named " + name);
        } else {
            TeamAPI.addPlayer(p, t);
            sender.sendMessage(name + " joins " + team);
        }

    }

    private void help(CommandSender sender){
        sender.sendMessage("§f/tqteam add [name] [team]");
        sender.sendMessage("§f/tqteam remove [name]");
    }


}
