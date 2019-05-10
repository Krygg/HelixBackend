package com.company.Samples;

import java.util.ArrayList;

public class Guitar implements Sample {
    private String name = "Guitar";
    private int flag = 0;
    private int lastI = 0;
    private double volume = 1;
    private ArrayList<String> samples = new ArrayList<>();


    @Override
    public String getSubDrum(int i) {
        if (flag == 0) initSamples();
        if (i > samples.size()) {
            lastI = i % samples.size();
            return samples.get(lastI);
        }
        lastI = i;
        return samples.get(i);
    }

    @Override
    public void initSamples() {
        samples.add("guit_harmonics");
        samples.add("guit_e_fifths");
        samples.add("guit_e_slide");
        samples.add("guit_em9");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLastI() {
        return this.lastI;
    }

    @Override
    public void setI(int i) {
        this.lastI = i;
    }

    @Override
    public void setVolume(double volume) {
        if (volume > 0 && volume < 1) {
            this.volume = volume;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double getVolume() {
        return this.volume;
    }
}
