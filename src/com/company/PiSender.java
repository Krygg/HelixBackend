package com.company;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.transport.udp.OSCPortOut;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class PiSender extends Thread{
    //TODO: here is one sout.
    private int flag = 0;
    private ArrayList<String> availableAddressInstrument = new ArrayList<>();
    private InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
    private OSCPortOut portOut = new OSCPortOut(inetAddress, 4559);
    private List<Object> objects = new ArrayList<>();
    private String address = "";

    public PiSender() throws IOException {
    }

    public void addObjectList(List<Object> objects) {
        this.objects = objects;
    }
    public void setAddress(String str) {
        this.address = str;
    }


    public void run() {
        this.send();

    }

    public void send() {
        System.out.println(this.address);
        AddressHolder addressHolder = AddressHolder.getInstance();
        OSCMessage msg = new OSCMessage(this.address, this.objects);
        addressHolder.returnAddress(this.address);
        System.out.println(msg.toString());
        try {
            portOut.send(msg);

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
