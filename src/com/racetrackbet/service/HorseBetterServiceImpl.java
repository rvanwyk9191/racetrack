package com.racetrackbet.service;

import com.racetrackbet.factory.BettingHorseFactory;
import com.racetrackbet.factory.DenominationFactory;
import com.racetrackbet.factory.HorseFactory;
import com.racetrackbet.model.BettingHorseModel;

public class HorseBetterServiceImpl{

    private String[] text;
    private BettingHorseModel bettingHorseModel;
    private int bettingHorse;
    private int winningHorse;
    private HorseFactory horseFactory;
    private DenominationFactory denominationFactory;

    public void execute() {
        try {
            if(text[1].contains(".")) throw new NumberFormatException();
            int bettingAmount = Integer.parseInt(text[1]);
            bettingHorseModel.setWager(bettingAmount);
            bettingHorseModel.setHorseBetOn(bettingHorse);
            bettingHorseModel.setWinningHorse(winningHorse);
            bettingHorseModel.setWinningHorseOdds(horseFactory.getWinningHorseOdds());
            BettingHorseFactory bettingHorseFactory = new BettingHorseFactory(bettingHorseModel);
            if(bettingHorse == horseFactory.getWinningHorse()){
                int winnings = bettingHorseFactory.calculateWinnings();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Payout: ").append(horseFactory.getWinningHorseName()).append(",").append(winnings);
                System.out.println(stringBuilder.toString());
                denominationFactory.withdrawMoney(winnings);
            }else{
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No Payout: ").append(horseFactory.getHorseNameById(bettingHorse));
                System.out.println(stringBuilder.toString());
            }
            denominationFactory.printInventory();
            horseFactory.printHorseList();

        } catch (NumberFormatException e) {
            if(text[1].contains(".")){
                System.out.println("Invalid Bet: " + text[1]);
            }else{
                System.out.println("Invalid Command: " + text[1]);
            }
        }
    }

    public void setText(String[] text) {
        this.text = text;
    }

    public void setBettingHorseModel(BettingHorseModel bettingHorseModel) {
        this.bettingHorseModel = bettingHorseModel;
    }

    public void setBettingHorse(int bettingHorse) {
        this.bettingHorse = bettingHorse;
    }

    public void setWinningHorse(int winningHorse) {
        this.winningHorse = winningHorse;
    }

    public void setHorseFactory(HorseFactory horseFactory) {
        this.horseFactory = horseFactory;
    }

    public void setDenominationFactory(DenominationFactory denominationFactory) {
        this.denominationFactory = denominationFactory;
    }
}
