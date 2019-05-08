package com.company.Drums;

import java.util.ArrayList;

public class SnareDrum implements Drum {
    private int flag = 0;
    private int lastI = 0;
    private double volume = 1;
    private String drumName = "SnareDrum";
    private ArrayList<String> subDrums = new ArrayList<>();


    public ArrayList<String> getSubDrums() {
        return subDrums;
    }


    @Override
    public void setI(int i) {
        lastI = i;
    }

    @Override
    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }

    @Override
    public String getSubDrum(int i) {
        if (flag == 0) initSamples();
        if (i > subDrums.size()-1) {
            lastI = i % subDrums.size();
            return subDrums.get(lastI);
        }
        lastI = i;
        return subDrums.get(i);
    }

    @Override
    public void initSamples() {
        flag = 1;
        subDrums.add("sn_dub");
        subDrums.add("sn_dolf");
        subDrums.add("sn_zome");
        subDrums.add("sn_generic");
    }

    @Override
    public int getLastI() {
        return this.lastI;
    }

    @Override
    public String getName() {
        return this.drumName;
    }
}
