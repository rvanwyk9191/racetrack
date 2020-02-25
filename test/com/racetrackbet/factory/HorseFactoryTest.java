package com.racetrackbet.factory;

import org.junit.Assert;
import org.junit.Test;

public class HorseFactoryTest {

    private HorseFactory horseFactory;
    private final int ONE = 1;
    private final int TWO = 2;
    private final int THREE = 3;
    private final int FOUR = 4;
    private final int FIVE = 5;
    private final int SIX = 6;
    private final int SEVEN = 7;
    private final int NINE = 9;
    private final int TEN = 10;

    @Test
    public void testConstructor(){
        horseFactory = new HorseFactory();
        Assert.assertEquals(FIVE, horseFactory.getThatDarnGrayCatOdds());
        Assert.assertEquals(TEN, horseFactory.getFortUtopiaOdds());
        Assert.assertEquals(NINE, horseFactory.getCountSheepOdds());
        Assert.assertEquals(FOUR, horseFactory.getMsTraitourOdds());
        Assert.assertEquals(THREE, horseFactory.getRealPrincessOdds());
        Assert.assertEquals(FIVE, horseFactory.getPaKettleOdds());
        Assert.assertEquals(SIX, horseFactory.getGinStingerOdds());

        Assert.assertEquals(ONE, horseFactory.getThatDarnGrayCatPosition());
        Assert.assertEquals(TWO, horseFactory.getFortUtopiaPosition());
        Assert.assertEquals(THREE, horseFactory.getCountSheepPosition());
        Assert.assertEquals(FOUR, horseFactory.getMsTraitourPosition());
        Assert.assertEquals(FIVE, horseFactory.getRealPrincessPosition());
        Assert.assertEquals(SIX, horseFactory.getPaKettlePosition());
        Assert.assertEquals(SEVEN, horseFactory.getGinStingerPosition());
    }

    @Test
    public void testWinningHorse(){
        horseFactory = new HorseFactory();
        horseFactory.setWinningHorse(ONE);
        Assert.assertEquals(ONE, horseFactory.getWinningHorse());
    }

}
