package com.company;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InstrumentSplitter {
    private ArrayList<Instrument> instrumentArrayList = new ArrayList<>();
    private ArrayList<String> availableAddress = new ArrayList<>();
    private ArrayList<List> streamToPlay = new ArrayList<>();
    private int flag = 0;


    public InstrumentSplitter() {
    }

    public void addInstrument(Instrument instrument) {
        instrumentArrayList.add(instrument);
    }


    //Loading all addresses intro an array, for use to send to sonic 3.1415926
    private void loadAddress() {
        flag = 1;
        availableAddress.add("/trigger/prophet");
        for (int i = 1; i < 16; i++) {
            availableAddress.add("/trigger/prophet" + i);
        }
    }

    //Goes though every instrument, to convert them intro stream format.
    private void getStreamToPlay() {
        ArrayList<Sender> senders;
        for (Instrument anInstrumentArrayList : instrumentArrayList) {
            senders = anInstrumentArrayList.getSenderArrayList();
            for (Sender sender : senders) {
                streamToPlay.add(createArgs(sender));
            }
        }
    }

    //public method for starting the process for getting the stream ready.
     public void prepForPlay() {
        if (flag == 0) loadAddress();
        getStreamToPlay();
    }

    //Takes the sender opject and returns it at a list of object
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



    //Sends the stream to Sonic pi, after clears the arrays.
    public void play() throws IOException {
        PiSender piSender = new PiSender();
        int addressCounter = 0;
        for (List stream : streamToPlay) {
            piSender.send(stream, availableAddress.get(addressCounter));
            addressCounter++;
            if (addressCounter == 16) break;
        }
        streamToPlay.clear();
        instrumentArrayList.clear();
    }


}
