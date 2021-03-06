package com.company.Samples;

import java.util.ArrayList;

public class BassDrum implements Sample {
    private int flag = 0;
    private int lastI = 0;
    private double volume = 1;
    private String drumName = "BassDrum";
    private ArrayList<String> subDrums = new ArrayList<>();


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

    public ArrayList<String> getSubDrums() {
        return subDrums;
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

    //More can be added for later.
    @Override
    public void initSamples() {
        flag = 1;
        subDrums.add("bd_ada");
        subDrums.add("bd_pure");
        subDrums.add("bd_808");
        subDrums.add("bd_zum");
        subDrums.add("bd_gas");
        subDrums.add("bd_sone");
    }

    public int getLastI() {
        return lastI;
    }

    @Override
    public String getName() {
        return this.drumName;
    }
}