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
    private int i = 0;
    private int nodeSelector = 0;
    private long baseDelay = 0;
    private int flag = 0;


    public void run() {
        //baseDelay that it needs to sleep before a Thread starts.
        System.out.println(baseDelay);
        try {
            Thread.sleep(baseDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // runs this, then it dies
        while (flag != 1) {
            try {
                //sending the information to sonicPI over OSC

                //TODO fix the divide by 0 error
                PiSender piSender = new PiSender();
                nodeSelector = i % notes.size();
                piSender.send(address, arguments, notes.get(nodeSelector));
                i++;
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Sleep the noteDelay.
            try {
                Thread.sleep(noteDelay);
            } catch (InterruptedException e) {
                break;
            }

        }
    }

    public void setBaseDelay(long baseDelay) {
        this.baseDelay = baseDelay;
    }

    public void setNoteDelay(long noteDelay) {
        this.noteDelay = noteDelay;
    }

    public int getI() {
        return i;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setArguments(List<Object> arguments) {
        this.arguments = arguments;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

