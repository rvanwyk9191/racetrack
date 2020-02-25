package com.racetrackbet.service;

import com.racetrackbet.constants.RaceTrackBetConstants;
import com.racetrackbet.factory.DenominationFactory;
import com.racetrackbet.factory.HorseFactory;
import com.racetrackbet.model.BettingHorseModel;

import java.util.Scanner;

public class RaceTrackServiceImpl {

    private HorseBetterServiceImpl horseBettingService;
    private DenominationFactory denominationFactory;
    private HorseFactory horseFactory;
    private BettingHorseModel bettingHorseModel;
    private int bettingHorse;
    private int winningHorse;

    public void execute(){
        initialize();
        Scanner scanner = new Scanner(System.in);
        printInitial();
        while(scanner.hasNext()){
            String[] text = scanner.nextLine().split(" ");
            processSwitch(text);
        }
    }

    private void processSwitch(String[] text){
        try{
            bettingHorse = Integer.parseInt(text[0]);
            text[0] = RaceTrackBetConstants.LOWER_B;

        } catch (NumberFormatException e) {
            text[0] = text[0].toLowerCase();
        }
        switch (text[0]){
            case RaceTrackBetConstants.LOWER_Q:
                System.exit(0);
                break;
            case RaceTrackBetConstants.LOWER_R:
                denominationFactory.resetInventory();
                denominationFactory.printInventory();
                break;
            case RaceTrackBetConstants.LOWER_W:
                try{
                    winningHorse = Integer.parseInt(text[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Command: " + text[1]);
                }
                horseFactory.setWinningHorse(winningHorse);
                break;
            case RaceTrackBetConstants.LOWER_B:
                processHorseBettingService(text);
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid Command: ");
                for(String s: text){
                    stringBuilder.append(s).append(" ");
                }
                System.out.println(stringBuilder.toString());
                break;
        }
    }

    private void processHorseBettingService(String[] text){
        if(horseBettingService == null) horseBettingService = new HorseBetterServiceImpl();
        if(horseFactory.horseIsNotValid(bettingHorse)){
            System.out.println("Invalid Horse Number: " + bettingHorse);
        }else{
            horseBettingService.setBettingHorse(bettingHorse);
            horseBettingService.setBettingHorseModel(bettingHorseModel);
            horseBettingService.setDenominationFactory(denominationFactory);
            horseBettingService.setHorseFactory(horseFactory);
            horseBettingService.setText(text);
            horseBettingService.setWinningHorse(winningHorse);
            horseBettingService.execute();
        }
    }

    private void printInitial(){
        denominationFactory.printInventory();
        horseFactory.printHorseList();
    }

    private void initialize(){
        denominationFactory = new DenominationFactory();
        bettingHorseModel = new BettingHorseModel();
        horseFactory = new HorseFactory();
        bettingHorse = 1;
        winningHorse = 1;
        bettingHorseModel.setWinningHorse(horseFactory.getWinningHorse());
    }

}
