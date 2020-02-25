package com.racetrackbet.factory;

import com.racetrackbet.constants.RaceTrackBetConstants;

import java.util.*;

public class DenominationFactory extends  HashMap<Integer, Integer>{

    private int total = 0;

    public DenominationFactory(){
        setInitialInventory();
    }

    public void printInventory(){
        System.out.println("Inventory: ");
        List<Integer> keyList = new ArrayList<>(keySet());
        Collections.sort(keyList);
        for(Integer key: keyList){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("$").append(key).append(",").append(get(key));
            System.out.println(stringBuilder.toString());
        }
    }

    public void withdrawMoney(int amount){
        int initialAmount = amount;
        List<Integer> moneyList = new ArrayList<>(keySet());
        Collections.sort(moneyList, Collections.reverseOrder());
        HashMap<Integer, Integer> totalDenominations = new HashMap<>();
        totalDenominations.put(RaceTrackBetConstants.ONE_DOLLAR, RaceTrackBetConstants.ZERO);
        totalDenominations.put(RaceTrackBetConstants.FIVE_DOLLARS,RaceTrackBetConstants.ZERO);
        totalDenominations.put(RaceTrackBetConstants.TEN_DOLLARS,RaceTrackBetConstants.ZERO);
        totalDenominations.put(RaceTrackBetConstants.TWENTY_DOLLARS,RaceTrackBetConstants.ZERO);
        totalDenominations.put(RaceTrackBetConstants.HUNDRED_DOLLARS, RaceTrackBetConstants.ZERO);
        if(amount < this.total) {
            for (Integer dollarAmount : moneyList) {
                while (get(dollarAmount) > RaceTrackBetConstants.ZERO) {
                    if (amount - dollarAmount < RaceTrackBetConstants.ZERO) {
                        break;
                    } else {
                        subtract(dollarAmount, RaceTrackBetConstants.ONE);
                        amount = amount - dollarAmount;
                        totalDenominations.put(dollarAmount, totalDenominations.get(dollarAmount) + 1);
                    }
                }
            }
        }
        if(amount > 0) {
            System.out.println("Insufficient Funds: " + initialAmount);
        }else{
            this.total -= initialAmount;
            System.out.println("Dispensing:");
            System.out.println("$1," + totalDenominations.get(RaceTrackBetConstants.ONE_DOLLAR));
            System.out.println("$5," + totalDenominations.get(RaceTrackBetConstants.FIVE_DOLLARS));
            System.out.println("$10," + totalDenominations.get(RaceTrackBetConstants.TEN_DOLLARS));
            System.out.println("$20," + totalDenominations.get(RaceTrackBetConstants.TWENTY_DOLLARS));
            System.out.println("$100," + totalDenominations.get(RaceTrackBetConstants.HUNDRED_DOLLARS));
        }
    }

    public void resetInventory() {
        setInitialInventory();
    }

    private void setInitialInventory(){
        put(RaceTrackBetConstants.ONE_DOLLAR, RaceTrackBetConstants.INITAL_DENOM_COUNT);
        put(RaceTrackBetConstants.FIVE_DOLLARS, RaceTrackBetConstants.INITAL_DENOM_COUNT);
        put(RaceTrackBetConstants.TEN_DOLLARS, RaceTrackBetConstants.INITAL_DENOM_COUNT);
        put(RaceTrackBetConstants.TWENTY_DOLLARS, RaceTrackBetConstants.INITAL_DENOM_COUNT);
        put(RaceTrackBetConstants.HUNDRED_DOLLARS, RaceTrackBetConstants.INITAL_DENOM_COUNT);
        for(Integer amount: keySet()){
            this.total += (amount * RaceTrackBetConstants.INITAL_DENOM_COUNT);
        }
    }

    public int getOneDollarDenominations() {
        return get(RaceTrackBetConstants.ONE_DOLLAR);
    }

    public int getFiveDollarsDenominations() {
        return get(RaceTrackBetConstants.FIVE_DOLLARS);
    }

    public int getTenDollarsDenominations() {
        return get(RaceTrackBetConstants.TEN_DOLLARS);
    }

    public int getTwentyDollarsDenominations() {
        return get(RaceTrackBetConstants.TWENTY_DOLLARS);
    }

    public int getHundredDollarsDenominations() {
        return get(RaceTrackBetConstants.HUNDRED_DOLLARS);
    }

    public void subtractFromOneDollar(int count) {
        subtract(RaceTrackBetConstants.ONE_DOLLAR, count);
    }

    private void subtract(Integer denomination, Integer count){
        put(denomination, get(denomination) - count);
    }

    public void subtractFromFiveDollars(int count) {
        subtract(RaceTrackBetConstants.FIVE_DOLLARS, count);
    }

    public void subtractFromTenDollars(int count) {
        subtract(RaceTrackBetConstants.TEN_DOLLARS, count);
    }

    public void subtractFromTwentyDollars(int count) {
        subtract(RaceTrackBetConstants.TWENTY_DOLLARS, count);
    }

    public void subtractFromHundredDollars(int count) {
        subtract(RaceTrackBetConstants.HUNDRED_DOLLARS, count);
    }
}
