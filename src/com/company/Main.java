package com.company;


import com.company.Drums.BassDrum;
import com.company.Drums.Drum;
import com.company.Drums.SnareDrum;

import java.io.IOException;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {
        Synth synth3 = new Synth.Builder().Node("c4,e4").build();
        Synth synth4 = new Synth.Builder().Node("e2").build();

        ArrayList<Synth> senders1 = new ArrayList<>();
        senders1.add(synth3);
        senders1.add(synth4);
        Drum drum = new BassDrum();
        Drum drum1 = new SnareDrum();

        drum.setI(4);
        drum1.setI(2);


        Instrument instrument1 = new Instrument(senders1);

        InstrumentSplitter instrumentSplitter = new InstrumentSplitter();
        instrumentSplitter.addMusicElement(instrument1);
        instrumentSplitter.addMusicElement(drum);
        instrumentSplitter.addMusicElement(drum1);
        instrumentSplitter.prepForPlay();
        instrumentSplitter.play();


    }


}
