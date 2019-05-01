package com.company;


import com.company.Drums.BassDrum;
import com.company.Drums.Drum;

import java.io.IOException;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException {
        Synth synth3 = new Synth.Builder().Node("c4,e4").build();
        Synth synth4 = new Synth.Builder().Node("e2").build();

        ArrayList<Synth> senders1 = new ArrayList<>();
        senders1.add(synth3);
        senders1.add(synth4);

        Instrument instrument1 = new Instrument(senders1);

        InstrumentSplitter instrumentSplitter = new InstrumentSplitter();
        instrumentSplitter.addInstrument(instrument1);
        instrumentSplitter.prepForPlay();
        instrumentSplitter.play();


        Drum drum = new BassDrum();
        PiSender piSender = new PiSender();
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(drum.getSubDrum(3));
        piSender.send(arrayList,"/trigger/prophet22");
    }


}
