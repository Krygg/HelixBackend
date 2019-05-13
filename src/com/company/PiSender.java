package com.company;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.transport.udp.OSCPortOut;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

public class PiSender  {
    //TODO: here is one sout.

    private InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
    private OSCPortOut portOut = new OSCPortOut(inetAddress,4559);

    public PiSender() throws IOException {
    }

    public void send(List<Object> arguments, String address) {

        OSCMessage msg = new OSCMessage(address, arguments);
        System.out.println(msg.toString());
        try {
            System.out.println(msg.getAddress());
            portOut.send(msg);
        } catch (Exception ex) {
            System.err.println("Couldn't send");
        }

    }

}
