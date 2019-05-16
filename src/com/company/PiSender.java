package com.company;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.transport.udp.OSCPortOut;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class PiSender extends Thread{
    private InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
    private final OSCPortOut portOut = new OSCPortOut(inetAddress, 4559);
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

    public void send(String address, List<Object> arguments, String note) {
        arguments.add(note);
        OSCMessage msg = new OSCMessage(address, arguments);
        try {
            portOut.send(msg);
            arguments.remove(arguments.size()-1);

        } catch (Exception ex) {
            System.err.println("Couldn't send");
        }

    }



}