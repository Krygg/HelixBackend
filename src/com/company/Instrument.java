package com.company;

import java.util.ArrayList;
import java.util.List;

public class Instrument {
    ArrayList<Sender> senderArrayList = new ArrayList<>();
    private String synth = "piano";

    public Instrument(ArrayList<Sender> senderArrayList) {
        this.senderArrayList = senderArrayList;
    }

    public ArrayList<Sender> getSenderArrayList() {
        return senderArrayList;
    }
}
