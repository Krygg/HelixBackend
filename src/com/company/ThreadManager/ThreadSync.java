package com.company.ThreadManager;

import terminals.GlobalStream;
import terminals.TimeSignature;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadSync extends Thread {

    private List<List> streamToPlay;
    private List<String> addresses;
    private List<TimeSignature> timeSignatures;
    private int bpm ;

    public ThreadSync(List<List> streamToPlay, List<String> addresses, List<TimeSignature> timeSignatures, int bpm) {
        this.bpm = bpm;
        this.timeSignatures = timeSignatures;
        this.streamToPlay = streamToPlay;
        this.addresses = addresses;
    }

    public void run() {
        startWorkers();
    }



    private void startWorkers() {
        for (int i = 0; i < streamToPlay.size(); i++) {
            ThreadWorker threadWorker = new ThreadWorker();
            threadWorker.setTimeSplit(calculateDelay(timeSignatures.get(i)));
            threadWorker.setArguments(streamToPlay.get(i));
            threadWorker.setAddress(getAddress());
            threadWorker.start();
        }
    }


    private long calculateDelay(TimeSignature timeSignature) {
        return 1000;
    }


    private void startWorkersDemo() {

        //TODO make this do all thing streamConverter do!
        Random randomNumber = new Random();





        for (int i = 0; i < 2; i++) {
            ThreadWorker threadWorker = new ThreadWorker();
            threadWorker.setTimeSplit((3000*(i+1)));
            threadWorker.setAddress(getAddress());

            //TODO make so no null pointer exception
            threadWorker.setArguments(streamToPlay.get(0));
            streamToPlay.remove(0);
            threadWorker.start();
        }
    }

    private String getAddress() {
        if (!addresses.isEmpty()) {
            String str = addresses.get(0);
            addresses.remove(0);
            return str;
        }
        return "";

    }
    
    
    
    
    
    
    
    
}
