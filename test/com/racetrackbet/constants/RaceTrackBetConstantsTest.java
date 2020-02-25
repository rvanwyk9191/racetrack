package com.racetrackbet.constants;

import com.racetrackbet.constants.RaceTrackBetConstants;
import org.junit.Assert;
import org.junit.Test;

public class RaceTrackBetConstantsTest {

    private final int INITIAL_DENOM_COUNT = 10;
    private final int ONE_DOLLAR = 1;
    private final int FIVE_DOLLARS = 5;
    private final int TEN_DOLLARS = 10;
    private final int TWENTY_DOLLARS = 20;
    private final int HUNDRED_DOLLARS = 100;

    @Test
    public void test(){
        Assert.assertEquals(INITIAL_DENOM_COUNT, RaceTrackBetConstants.INITAL_DENOM_COUNT);
        Assert.assertEquals(ONE_DOLLAR, RaceTrackBetConstants.ONE_DOLLAR);
        Assert.assertEquals(FIVE_DOLLARS, RaceTrackBetConstants.FIVE_DOLLARS);
        Assert.assertEquals(TEN_DOLLARS, RaceTrackBetConstants.TEN_DOLLARS);
        Assert.assertEquals(TWENTY_DOLLARS, RaceTrackBetConstants.TWENTY_DOLLARS);
        Assert.assertEquals(HUNDRED_DOLLARS, RaceTrackBetConstants.HUNDRED_DOLLARS);
    }

}
