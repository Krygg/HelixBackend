package com.company;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.transport.udp.OSCPortOut;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class PiSender  {
    //TODO: here is one sout.
    private int flag = 0;
    private ArrayList<String> availableAddressInstrument = new ArrayList<>();
    private InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
    private OSCPortOut portOut = new OSCPortOut(inetAddress,4559);

    public PiSender() throws IOException {
    }

    public void send(List<Object> arguments) {
        if (flag == 0)  loadAddress();

        OSCMessage msg = new OSCMessage("null", arguments);
        System.out.println(msg.toString());
        try {
            //synchronized (this){
                System.out.println(msg.getAddress());
                //wait();
                portOut.send(msg);
            //}
        } catch (Exception ex) {
            System.err.println("Couldn't send");
        }

    }

    private void loadAddress() {
        flag = 1;
        for (int i = 1; i < 7; i++) {
            availableAddressInstrument.add("/trigger/prophet" + i);
            System.out.println("INSTRUMENT /trigger/prophet" + i);
        }
    }


}
