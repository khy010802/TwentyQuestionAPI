package com.github.khy010802.twentyquestionapi.variables.hook;

import com.github.khy010802.twentyquestionapi.variables.Variables;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;

public class PlaceHolderAPIHook extends PlaceholderExpansion {

    @Override
    public String getIdentifier() {
        return "tqvar";
    }

    @Override
    public  String getAuthor() {
        return "KimBepo";
    }

    @Override
    public String getVersion() {
        return "1.6";
    }

    @Override
    public boolean persist(){
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if(params.equalsIgnoreCase("money")){
            return Integer.toString(Variables.MONEY.getValue());
        }

        if(params.equalsIgnoreCase("point")) {
            return Integer.toString(Variables.POINT.getValue());
        }

        return null;
    }
}
