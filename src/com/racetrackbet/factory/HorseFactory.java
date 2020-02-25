package com.racetrackbet.factory;

import com.racetrackbet.constants.RaceTrackBetConstants;
import com.racetrackbet.model.HorseModel;
import com.racetrackbet.util.HorseFileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HorseFactory extends HorseFileReader {

    private final HashMap<String, Integer> horseIndex = new HashMap<>();
    private final List<HorseModel> horseModelList = new ArrayList<>();
    private int winningHorse = 1;

    public HorseFactory(){
        horseModelList.addAll(load());
        horseModelList.forEach((horse) -> horseIndex.put(horse.getHorseName(), horse.getSequence()));
    }

    public void printHorseList(){
        System.out.println("Horses:");
        for(HorseModel horseModel: horseModelList){
            StringBuilder stringBuilder = new StringBuilder();
            String winOrLose = horseModel.getSequence() == winningHorse? "won":"lost";
            stringBuilder.append(horseModel.getSequence()).append(",").append(horseModel.getHorseName()).append(",").append(horseModel.getOdds()).
                    append(",").append(winOrLose);
            System.out.println(stringBuilder.toString());
        }
    }

    public String getWinningHorseName(){
        String horseName = new String();
        for(HorseModel horseModel: horseModelList){
            if(horseModel.getSequence() == winningHorse){
                horseName = horseModel.getHorseName();
            }
        }
        return horseName;
    }

    public int getWinningHorseOdds(){
        int odds = 0;
        for(HorseModel horseModel: horseModelList){
            if(horseModel.getSequence() == winningHorse){
                odds = horseModel.getOdds();
            }
        }
        return odds;
    }

    public String getHorseNameById(Integer id){
        String horseNameForReturn = "";
        for(String horseName: horseIndex.keySet()){
            if(horseIndex.get(horseName).equals(id)){
                horseNameForReturn = horseName;
                break;
            }
        }
        return horseNameForReturn;
    }

    private int getOdds(String horseName){
        return horseModelList.get(horseIndex.get(horseName)-1).getOdds();
    }

    private int getPosition(String horseName){
        return horseModelList.get(horseIndex.get(horseName)-1).getSequence();
    }

    public int getThatDarnGrayCatOdds() {
        return getOdds(RaceTrackBetConstants.THAT_DARN_GRAY_CAT);
    }

    public int getFortUtopiaOdds() {
        return getOdds(RaceTrackBetConstants.FORT_UTOPIA);
    }

    public int getCountSheepOdds() {
        return getOdds(RaceTrackBetConstants.COUNT_SHEEP);
    }

    public int getMsTraitourOdds() {
        return getOdds(RaceTrackBetConstants.MS_TRAITOUR);
    }

    public int getRealPrincessOdds() {
        return getOdds(RaceTrackBetConstants.REAL_PRINCESS);
    }

    public int getPaKettleOdds() {
        return getOdds(RaceTrackBetConstants.PA_KETTLE);
    }


    public int getGinStingerOdds() {
        return getOdds(RaceTrackBetConstants.GIN_STINGER);
    }

    public int getThatDarnGrayCatPosition() {
        return getPosition(RaceTrackBetConstants.THAT_DARN_GRAY_CAT);
    }

    public int getFortUtopiaPosition() {
        return getPosition(RaceTrackBetConstants.FORT_UTOPIA);
    }

    public int getCountSheepPosition() {
        return getPosition(RaceTrackBetConstants.COUNT_SHEEP);
    }

    public int getMsTraitourPosition() {
        return getPosition(RaceTrackBetConstants.MS_TRAITOUR);
    }

    public int getRealPrincessPosition() {
        return getPosition(RaceTrackBetConstants.REAL_PRINCESS);
    }

    public int getPaKettlePosition() {
        return getPosition(RaceTrackBetConstants.PA_KETTLE);
    }

    public int getGinStingerPosition() {
        return getPosition(RaceTrackBetConstants.GIN_STINGER);
    }

    public Boolean setWinningHorse(int winningHorse) {
        if(horseIndex.values().contains(winningHorse)){
            this.winningHorse = winningHorse;
            return true;
        }else{
            System.out.println("Invalid Horse Number: " + winningHorse);
            return false;
        }

    }

    public int getWinningHorse() {
        return this.winningHorse;
    }

    public Boolean horseIsNotValid(int horseSequence){
        return !horseIndex.values().contains(horseSequence);
    }
}
