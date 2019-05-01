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


    public static void main(String[] args) throws IOException, InterruptedException {
        Sender sender3 = new Sender.Builder().Node("c2,        c4,b3").build();
        Sender sender4 = new Sender.Builder().Node("e2").build();

        ArrayList<Sender> senders1 = new ArrayList<>();
        senders1.add(sender3);
        senders1.add(sender4);

        Instrument instrument1 = new Instrument(senders1);

        InstrumentSplitter instrumentSplitter = new InstrumentSplitter();
        instrumentSplitter.addInstrument(instrument1);
        instrumentSplitter.prepForPlay();
        instrumentSplitter.play();

    }


}
