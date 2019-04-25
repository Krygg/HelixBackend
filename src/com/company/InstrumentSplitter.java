package com.company;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InstrumentSplitter {
    private ArrayList<Instrument> instrumentArrayList = new ArrayList<>();
    private ArrayList<String> availableAddress = new ArrayList<>();
    private ArrayList<List> streamToPlay = new ArrayList<>();


    public InstrumentSplitter() {
    }


    public void addInstrument(Instrument instrument) {
        instrumentArrayList.add(instrument);
    }

    public void loadAddress() {
        availableAddress.add("/trigger/prophet");
        for (int i = 1; i < 16; i++) {
            availableAddress.add("/trigger/prophet" + i);
        }
    }

    public void getStreamToPlay() {
        ArrayList<Sender> senders;
        for (Instrument anInstrumentArrayList : instrumentArrayList) {
            senders = anInstrumentArrayList.getSenderArrayList();
            for (Sender sender : senders) {
                streamToPlay.add(createArgs(sender));
            }
        }
    }
     public void prepForPlay() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        PiSender piSender = new PiSender();
        getStreamToPlay();
        ArrayList<List> stream = new ArrayList<>(streamToPlay);
    }
    private List<Object> createArgs(Sender sender) {
        List<Object> arguments = new ArrayList<>();
        arguments.add(sender.getSynth());
        arguments.add(sender.getNode());
        arguments.add(sender.getRelease());
        arguments.add(sender.getSustain());
        arguments.add(sender.getAttack());
        arguments.add(sender.getDecay());

        return arguments;
    }
    public void play() throws IOException {
        PiSender piSender = new PiSender();
        int addressCounter = 0;
        for (List stream : streamToPlay) {
            for (Object aStream : stream) {
                System.out.println(aStream);
            }
            piSender.send(stream, availableAddress.get(addressCounter));
            addressCounter++;
        }

        //TODO: nuke everything after played
    }


}
