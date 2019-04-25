package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class InstrumentSplitter {
    private ArrayList<Instrument> instrumentArrayList = new ArrayList<>();
    private ArrayList<String> availableAddress = new ArrayList<>();


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

    public void playInstruments() throws IOException {
        int addressCounter = 0;
        PiSender piSender = new PiSender();
        ArrayList<Sender> senders;
        for (Instrument anInstrumentArrayList : instrumentArrayList) {
            senders = anInstrumentArrayList.getSenderArrayList();
            for (Sender sender : senders) {
                piSender.send(sender, availableAddress.get(addressCounter));
                addressCounter++;
            }
        }
    }

}
