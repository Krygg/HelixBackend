package com.company;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPacket;
import com.illposed.osc.transport.udp.OSCPort;
import com.illposed.osc.transport.udp.OSCPortOut;


import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        Sender sender = new Sender.Builder().Node("c4").build();
        Sender sender1 = new Sender.Builder().Node("e4").build();
        Sender sender2 = new Sender.Builder().Node("g4").Synth("dull_bell").build();



        ArrayList<Sender> senders = new ArrayList<>();
        senders.add(sender);
        senders.add(sender1);

        Instrument instrument = new Instrument(senders);

        Sender sender3 = new Sender.Builder().Node("c6").build();
        Sender sender4 = new Sender.Builder().Node("e6").build();

        ArrayList<Sender> senders1 = new ArrayList<>();
        senders1.add(sender3);
        senders1.add(sender4);

        Instrument instrument1 = new Instrument(senders1);

        InstrumentSplitter instrumentSplitter = new InstrumentSplitter();
        instrumentSplitter.addInstrument(instrument);
        instrumentSplitter.addInstrument(instrument1);
        instrumentSplitter.loadAddress();
        instrumentSplitter.prepForPlay();
        instrumentSplitter.play();
    }


}
