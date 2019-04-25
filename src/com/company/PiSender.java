package com.company;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.transport.udp.OSCPortOut;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class PiSender  {
    InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
    OSCPortOut portOut = new OSCPortOut(inetAddress,4559);

    public PiSender() throws IOException {
    }


    /**
     *
     * @param sender Et sender object som skal sendes
     * @param address Addressen som den skal sendes til
     */
    public void send(Sender sender, String address) {

        List<Object> arguments = createArgs(sender);

        OSCMessage msg = new OSCMessage(address, arguments);
        try {
            System.out.println(msg.getAddress());
            portOut.send(msg);
        } catch (Exception ex) {
            System.err.println("Couldn't send");
        }

    }

    public void playInstrument(Instrument instrument, ArrayList<String> address) {

    }

    /**
     *
     * @param sender Takes
     * @return Returnere en list, som skal sendes over OCS
     */

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


}
