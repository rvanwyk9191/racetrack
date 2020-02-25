package com.racetrackbet.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DenominationFactoryTest {

    private DenominationFactory denominationFactory;
    private final int ONE_DOLLAR_TOTAL_BEGIN = 10;
    private final int FIVE_DOLLAR_TOTAL_BEGIN = 10;
    private final int TEN_DOLLAR_TOTAL_BEGIN = 10;
    private final int TWENTY_DOLLAR_TOTAL_BEGIN = 10;
    private final int HUNDRED_DOLLAR_TOTAL_BEGIN = 10;

    @Before
    public void setup(){
        denominationFactory = new DenominationFactory();
    }

    @Test
    public void testConstructor(){
        Assert.assertEquals("One dollar count is incorrect!", ONE_DOLLAR_TOTAL_BEGIN, denominationFactory.getOneDollarDenominations());
        Assert.assertEquals("Five dollar count is incorrect!", FIVE_DOLLAR_TOTAL_BEGIN, denominationFactory.getFiveDollarsDenominations());
        Assert.assertEquals("Ten dollar count is incorrect!", TEN_DOLLAR_TOTAL_BEGIN, denominationFactory.getTenDollarsDenominations());
        Assert.assertEquals("Twenty dollar count is incorrect!", TWENTY_DOLLAR_TOTAL_BEGIN, denominationFactory.getTwentyDollarsDenominations());
        Assert.assertEquals("Hundred dollar count is incorrect!", HUNDRED_DOLLAR_TOTAL_BEGIN, denominationFactory.getHundredDollarsDenominations());
    }

    @Test
    public void testSubtractInventory(){
        denominationFactory.subtractFromOneDollar(1);
        Assert.assertEquals(9, denominationFactory.getOneDollarDenominations());
        denominationFactory.subtractFromOneDollar(2);
        Assert.assertEquals(7, denominationFactory.getOneDollarDenominations());
    }

    @Test
    public void testSubtractFiveDollarInventory(){
        denominationFactory.subtractFromFiveDollars(2);
        Assert.assertEquals(8, denominationFactory.getFiveDollarsDenominations());
        denominationFactory.subtractFromFiveDollars(2);
        Assert.assertEquals(6, denominationFactory.getFiveDollarsDenominations());
    }

    @Test
    public void testSubtractTenDollarInventory(){
        denominationFactory.subtractFromTenDollars(3);
        Assert.assertEquals(7, denominationFactory.getTenDollarsDenominations());
        denominationFactory.subtractFromTenDollars(2);
        Assert.assertEquals(5, denominationFactory.getTenDollarsDenominations());
    }

    @Test
    public void testSubtractTwentyDollarInventory(){
        denominationFactory.subtractFromTwentyDollars(4);
        Assert.assertEquals(6, denominationFactory.getTwentyDollarsDenominations());
        denominationFactory.subtractFromTwentyDollars(3);
        Assert.assertEquals(3, denominationFactory.getTwentyDollarsDenominations());
    }

    @Test
    public void testSubtractHundredDollarInventory(){
        denominationFactory.subtractFromHundredDollars(5);
        Assert.assertEquals(5, denominationFactory.getHundredDollarsDenominations());
        denominationFactory.subtractFromHundredDollars(3);
        Assert.assertEquals(2, denominationFactory.getHundredDollarsDenominations());
    }

    @Test
    public void testResetInventory(){
        denominationFactory.subtractFromOneDollar(1);
        denominationFactory.subtractFromFiveDollars(2);
        denominationFactory.subtractFromTenDollars(3);
        denominationFactory.subtractFromTwentyDollars(4);
        denominationFactory.subtractFromHundredDollars(5);
        denominationFactory.resetInventory();
        Assert.assertEquals("One dollar count is incorrect!", ONE_DOLLAR_TOTAL_BEGIN, denominationFactory.getOneDollarDenominations());
        Assert.assertEquals("Five dollar count is incorrect!", FIVE_DOLLAR_TOTAL_BEGIN, denominationFactory.getFiveDollarsDenominations());
        Assert.assertEquals("Ten dollar count is incorrect!", TEN_DOLLAR_TOTAL_BEGIN, denominationFactory.getTenDollarsDenominations());
        Assert.assertEquals("Twenty dollar count is incorrect!", TWENTY_DOLLAR_TOTAL_BEGIN, denominationFactory.getTwentyDollarsDenominations());
        Assert.assertEquals("Hundred dollar count is incorrect!", HUNDRED_DOLLAR_TOTAL_BEGIN, denominationFactory.getHundredDollarsDenominations());
    }

    @Test
    public void testSubtract100(){
        denominationFactory.withdrawMoney(100);
        Assert.assertEquals(9, denominationFactory.getHundredDollarsDenominations());
        Assert.assertEquals(10, denominationFactory.getOneDollarDenominations());
        Assert.assertEquals(10, denominationFactory.getFiveDollarsDenominations());
        Assert.assertEquals(10, denominationFactory.getTenDollarsDenominations());
        Assert.assertEquals(10, denominationFactory.getTwentyDollarsDenominations());
    }

    @Test
    public void testSubtract150(){
        denominationFactory.withdrawMoney(150);
        Assert.assertEquals(9, denominationFactory.getHundredDollarsDenominations());
        Assert.assertEquals(10, denominationFactory.getOneDollarDenominations());
        Assert.assertEquals(10, denominationFactory.getFiveDollarsDenominations());
        Assert.assertEquals(9, denominationFactory.getTenDollarsDenominations());
        Assert.assertEquals(8, denominationFactory.getTwentyDollarsDenominations());
    }

    @Test
    public void testSubtract175(){
        denominationFactory.withdrawMoney(175);
        Assert.assertEquals(9, denominationFactory.getHundredDollarsDenominations());
        Assert.assertEquals(10, denominationFactory.getOneDollarDenominations());
        Assert.assertEquals(9, denominationFactory.getFiveDollarsDenominations());
        Assert.assertEquals(9, denominationFactory.getTenDollarsDenominations());
        Assert.assertEquals(7, denominationFactory.getTwentyDollarsDenominations());
    }

}
