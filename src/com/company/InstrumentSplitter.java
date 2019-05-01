package com.company;


import com.company.Drums.Drum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InstrumentSplitter {
    private ArrayList<Instrument> instrumentArrayList = new ArrayList<>();
    private ArrayList<String> availableAddressInstrument = new ArrayList<>();
    private ArrayList<Drum> drumArrayList = new ArrayList<>();
    private ArrayList<List> streamToPlay = new ArrayList<>();
    private ArrayList<String> availableAddressDrum  = new ArrayList<>();
    private int flag = 0;


    public InstrumentSplitter() {
    }

    public ArrayList<List> getStream() {
        return this.streamToPlay;
    }

    public void addMusicElement(Object object) {
        if (object instanceof Drum) {
            drumArrayList.add((Drum) object);
        }
        else if (object instanceof Instrument) {
            instrumentArrayList.add((Instrument) object);
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    //Loading all addresses intro an array, for use to send to sonic 3.1415926
    private void loadAddress() {
        flag = 1;
        for (int i = 1; i < 7; i++) {
            availableAddressInstrument.add("/trigger/prophet" + i);
            System.out.println("INSTRUMENT /trigger/prophet" + i);
        }

        for (int i = 7; i < 11; i++) {
            availableAddressDrum.add("/trigger/prophet" + i);
            System.out.println(" DRUM /trigger/prophet" + i);
        }
    }

    //Goes though every instrument, to convert them intro stream format.
    private void getStreamToPlay() {
        ArrayList<Synth> synths;
        for (Instrument anInstrumentArrayList : instrumentArrayList) {
            synths = anInstrumentArrayList.getSynthArrayList();
            for (Synth synth : synths) {
                streamToPlay.add(createArgs(synth));
            }
        }
    }



    //public method for starting the process for getting the stream ready.
     public void prepForPlay() {
        if (flag == 0) loadAddress();
        getStreamToPlay();
    }

    //Takes the sender opject and returns it at a list of object
    private List<Object> createArgs(Synth synth) {
        List<Object> arguments = new ArrayList<>();
        arguments.add(synth.getSynth());
        arguments.add(synth.getNode());
        arguments.add(synth.getRelease());
        arguments.add(synth.getSustain());
        arguments.add(synth.getAttack());
        arguments.add(synth.getDecay());

        return arguments;
    }



    //Sends the stream to Sonic pi, after clears the arrays.
    public void play() throws IOException {
        final int maxAddress = 6;
        PiSender piSender = new PiSender();
        int addressCounter = 0;
        for (List stream : streamToPlay) {
            piSender.send(stream, availableAddressInstrument.get(addressCounter));
            addressCounter++;
            if (addressCounter == maxAddress) break;
        }
        streamToPlay.clear();
        instrumentArrayList.clear();
    }


}
