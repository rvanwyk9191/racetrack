package com.racetrackbet.factory;

import com.racetrackbet.model.BettingHorseModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BettingHorseFactoryTest {

    private BettingHorseFactory bettingHorseFactory;
    private BettingHorseModel bettingHorseModel;
    private int horseBetOn;
    private int wager;
    private int winningHorse;
    private int winningHorseOdds;

    @Before
    public void setup(){
        horseBetOn = 1;
        wager = 5;
        winningHorse = 1;
        winningHorseOdds = 10;
    }

    @Test
    public void testWinningHorseConstructor(){
        bettingHorseModel = new BettingHorseModel();
        bettingHorseModel.setHorseBetOn(horseBetOn);
        bettingHorseModel.setWager(wager);
        bettingHorseModel.setWinningHorse(winningHorse);
        bettingHorseModel.setWinningHorseOdds(winningHorseOdds);
        bettingHorseFactory = new BettingHorseFactory(bettingHorseModel);
        int winnings = bettingHorseFactory.calculateWinnings();
        Assert.assertEquals(50, winnings);
    }

}
