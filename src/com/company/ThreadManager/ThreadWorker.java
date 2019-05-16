package com.company.ThreadManager;

import com.company.PiSender;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ThreadWorker extends Thread {

    private String address = "";
    private List<Object> arguments = new ArrayList<>();
    private List<String> notes = new ArrayList<>();
    private long noteDelay = 0;
    private int i=0;
    private int nodeSelector = 0;
    private long baseDelay = 0;



    public void run() {
        try {
            Thread.sleep(baseDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {

            try {
                PiSender piSender = new PiSender();

                nodeSelector = i % notes.size();
                piSender.send(address, arguments, notes.get(nodeSelector));

                i++;
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                Thread.sleep(noteDelay);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void setNoteDelay(long noteDelay) {
        this.noteDelay = noteDelay;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setArguments(List<Object> arguments) {
        this.arguments = arguments;
    }

    public void setNotes(List<String> notes){this.notes = notes;}
}

