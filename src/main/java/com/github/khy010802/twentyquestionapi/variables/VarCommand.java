package com.github.khy010802.twentyquestionapi.variables;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VarCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!sender.isOp()) return true;

        if(args.length == 0){
            help(sender);
        } else if(args.length == 2){ // 2 args
            if(args[0].equalsIgnoreCase("get")){
                get(sender, args);
            }
        } else if(args.length == 3){ // 3 args
            if(args[0].equalsIgnoreCase("set")){
                set(sender, args);
            }
        } else {
            help(sender);
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if(args.length == 0){
            return Arrays.asList("get", "set");
        } else if(args.length == 1){
            return Arrays.stream(Variables.values()).map(Variables::name).collect(Collectors.toList());
        }

        return null;
    }

    private void get(CommandSender sender, String[] args){
        String varName = args[1];
        try {
            Variables varType = Variables.valueOf(varName);
            sender.sendMessage("value of " + varType + " : " + varType.getValue());
        } catch(Exception io){
            sender.sendMessage("§cUnknown var name : " + varName);
        }
    }

    private void set(CommandSender sender, String[] args){
        String varName = args[1];
        try {
            int newValue = Integer.parseInt(args[2]);
            Variables varType = Variables.valueOf(varName);
            varType.getScore().setScore(newValue);
            sender.sendMessage("set value of " + varType + " to : " + varType.getValue());
        } catch(NumberFormatException io){
            sender.sendMessage("§cUnknown value : " + args[2]);
        } catch(Exception io){
            sender.sendMessage("§cUnknown var name : " + varName);
        }
    }

    private void help(CommandSender sender){
        sender.sendMessage("§f/tqvar get [name]");
        sender.sendMessage("§f/tqvar set [name] [value]");
    }
}
