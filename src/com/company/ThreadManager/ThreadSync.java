package com.company.ThreadManager;

import terminals.GlobalStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadSync extends Thread {

    private List<List> streamToPlay;
    private List<String> addresses;

    public ThreadSync(List<List> streamToPlay, List<String> addresses) {
        this.streamToPlay = streamToPlay;
        this.addresses = addresses;
    }

    public void run() {
        startWorkers();
    }
    
    private void startWorkers() {

        //TODO make this do all thing streamConverter do!
        Random randomNumber = new Random();
        for (int i = 0; i < 2; i++) {
            ThreadWorker threadWorker = new ThreadWorker();
            threadWorker.setTimeSplit(randomNumber.nextInt(1000)+1000);
            threadWorker.setAddress(getAddress());
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
