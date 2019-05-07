package com.company;

import java.util.ArrayList;

public class Instrument {
    ArrayList<Synth> synthArrayList = new ArrayList<>();
    private String synth = "piano";

    public Instrument(ArrayList<Synth> synthArrayList) {
        this.synthArrayList = synthArrayList;
    }

    public void addSynth(Synth synth) {
        this.synthArrayList.add(synth);
    }

    public ArrayList<Synth> getSynthArrayList() {
        return synthArrayList;
    }
}
