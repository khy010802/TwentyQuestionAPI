package com.github.khy010802.twentyquestionapi.events;

import org.bukkit.event.HandlerList;

public class MinigameStartEvent extends MinigameEvent{

    private static final HandlerList handlers = new HandlerList();

    public MinigameStartEvent(Games game){
        super(game);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
