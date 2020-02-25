package com.racetrackbet.model;

public class BettingHorseModel {

    private int winningHorse;
    private int horseBetOn;
    private int wager;
    private int winningHorseOdds;

    public int getWinningHorse() {
        return winningHorse;
    }

    public void setWinningHorse(int winningHorse) {
        this.winningHorse = winningHorse;
    }

    public int getHorseBetOn() {
        return horseBetOn;
    }

    public void setHorseBetOn(int horseBetOn) {
        this.horseBetOn = horseBetOn;
    }

    public int getWager() {
        return wager;
    }

    public void setWager(int wager) {
        this.wager = wager;
    }

    public int getWinningHorseOdds() {
        return winningHorseOdds;
    }

    public void setWinningHorseOdds(int winningHorseOdds) {
        this.winningHorseOdds = winningHorseOdds;
    }
}
