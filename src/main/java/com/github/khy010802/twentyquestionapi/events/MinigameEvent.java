package com.github.khy010802.twentyquestionapi.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

public abstract class MinigameEvent extends Event implements Cancellable {

    private Games gameType;
    private boolean isCancelled;

    public MinigameEvent(Games game){
        this.isCancelled = false;
        this.gameType = game;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    public Games getGameType() { return this.gameType; }

    public enum Games {

        RGJUMP("무궁화 꽃이 뛰었습니다"),
        FMONEY("날아라 돈다발");

        private final String name;
        Games(String name){
            this.name = name;

        }

        public String getName() { return this.name; }

    }

}
