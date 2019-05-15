package com.company.ThreadManager;

import com.company.PiSender;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThreadWorker extends Thread {

    private String address = "";
    private List<Object> arguments = new ArrayList<>();
    private long timeSplit = 0;

    public void run() {
        while (true) {
            System.out.println("im playing a sound");
            System.out.println(address);
            try {
                PiSender piSender = new PiSender();
                piSender.send(address,arguments);
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                Thread.sleep(timeSplit);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setTimeSplit(long timeSplit) {
        this.timeSplit = timeSplit;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setArguments(List<Object> arguments) {
        this.arguments = arguments;
    }
}
