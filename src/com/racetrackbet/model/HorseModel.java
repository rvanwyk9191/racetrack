package com.racetrackbet.model;

public class HorseModel {

    private int sequence;
    private String horseName;
    private int odds;

    public HorseModel(int sequence, String horseName, int odds) {
        this.sequence = sequence;
        this.horseName = horseName;
        this.odds = odds;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public int getOdds() {
        return odds;
    }

    public void setOdds(int odds) {
        this.odds = odds;
    }
}
