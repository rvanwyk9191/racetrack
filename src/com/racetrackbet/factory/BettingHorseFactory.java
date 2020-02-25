package com.racetrackbet.factory;

import com.racetrackbet.model.BettingHorseModel;

public class BettingHorseFactory {

    private int horseBetOn;
    private int wager;
    private int winningHorse;
    private int odds;

    public BettingHorseFactory(BettingHorseModel bettingHorseModel) {
        horseBetOn = bettingHorseModel.getHorseBetOn();
        wager = bettingHorseModel.getWager();
        winningHorse = bettingHorseModel.getWinningHorse();
        odds = bettingHorseModel.getWinningHorseOdds();
    }


    public int calculateWinnings() {
        if(horseBetOn == winningHorse){
            return wager * odds;
        }else{
            return 0;
        }
    }
}
