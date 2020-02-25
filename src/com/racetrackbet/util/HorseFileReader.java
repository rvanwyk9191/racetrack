package com.racetrackbet.util;

import com.racetrackbet.model.HorseModel;

import java.util.ArrayList;
import java.util.List;

public class HorseFileReader {

    List<HorseModel> horseModelList = new ArrayList<>();

    protected List<HorseModel> load(){
        for(String line: read()){
            String[] record = line.split(",");
            horseModelList.add(new HorseModel(Integer.parseInt(record[0]), record[1], Integer.parseInt(record[2])));
        }
        return horseModelList;
    }

    private String[] read(){
        String[] file = {"1,That Darn Gray Cat,5",
        "2,Fort Utopia,10",
        "3,Count Sheep,9",
        "4,Ms Traitour,4",
        "5,Real Princess,3",
        "6,Pa Kettle,5",
        "7,Gin Stinger,6"};
        return file;
    }

}
