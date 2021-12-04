package com.github.khy010802.twentyquestionapi.events;

import org.bukkit.event.HandlerList;

public class MinigameEndEvent extends MinigameEvent {

    private boolean win;
    private int option;

    public MinigameEndEvent(Games game, boolean win, int option){
        super(game);
        this.win = win;
        this.option = option;
    }

    public boolean isWin(){ return this.win; }
    public int getOption() { return this.option; }


    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
