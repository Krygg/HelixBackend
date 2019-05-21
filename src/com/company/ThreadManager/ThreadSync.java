package com.company.ThreadManager;

import terminals.TimeSignature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThreadSync extends Thread {

    private List<List> streamToPlay;
    private List<String> addresses;
    private List<TimeSignature> timeSignatures;
    private List<List> notes;
    private List<Long> normalDelayList = new ArrayList<>();
    private List<ThreadWorker> activeWorkers = new ArrayList<>();
    private List<Long> baseDelayList = new ArrayList<>();
    private List<Integer> noteSelector = new ArrayList<>();
    private int flag = 0;
    private int bpm;

    public ThreadSync(List<List> streamToPlay, List<String> addresses, List<TimeSignature> timeSignatures, int bpm, List<List> notes) {
        this.notes = notes;
        this.bpm = bpm;
        this.timeSignatures = timeSignatures;
        this.streamToPlay = streamToPlay;
        this.addresses = addresses;
    }

    public void run() {
        //Starting the process
        try {
            startWorkers();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void startWorkers() throws InterruptedException {
        final long updateRate = 10000;
        normalDelayList.clear();


        //Creates workers and sets information, that it needs to play
        for (int i = 0; i < streamToPlay.size(); i++) {
            ThreadWorker threadWorker = new ThreadWorker();
            threadWorker.setNoteDelay(calculateDelay(this.bpm, timeSignatures.get(i)));
            threadWorker.setArguments(streamToPlay.get(i));
            threadWorker.setAddress(addresses.get(i));
            threadWorker.setNotes(notes.get(i));
            //only needs to be set after first run
            if (flag == 1) {
                //Sets the delay and the note, it needs to start on
                threadWorker.setBaseDelay(baseDelayList.get(i));
                threadWorker.setI(noteSelector.get(i));

            }
            activeWorkers.add(threadWorker);
            threadWorker.start();
        }

        //Begging the Thread for calculating the time each thread has to wait before playing again

        ThreadCalculator threadCalculator = new ThreadCalculator();
        threadCalculator.setNormalDelayList(this.normalDelayList);
        threadCalculator.setBaseDelayList(baseDelayList);
        threadCalculator.setThreadSync(this);
        threadCalculator.start();


        //Sleep until the program need to sync all the threads.
        Thread.sleep(updateRate);


        //Killing old worker, and adding the last note played so the new workers plays the same
        for (ThreadWorker worker : activeWorkers) {
            noteSelector.add(worker.getI());
            worker.interrupt();
            worker.setFlag(1);
        }
        activeWorkers.clear();
        threadCalculator.interrupt();


        //setting a flag, after first time run. And calling the method again.
        flag = 1;
        startWorkers();

    }


    //Calculate the delay, between each note, so 4/4 would be 480ms delay in 128bpm
    private long calculateDelay(int bpm, TimeSignature timeSignature) {
        final double moveComma = 1000;
        final double secondPrMin = 60;
        double baseDelay = (moveComma) * (secondPrMin / (double) bpm);
        double timeSignDelay = (double) timeSignature.getN1() / (double) timeSignature.getN2();
        double delay = baseDelay * timeSignDelay;
        normalDelayList.add((long) delay);
        return (long) delay;
    }

    private String getAddress() {
        if (!addresses.isEmpty()) {
            String str = addresses.get(0);
            addresses.remove(0);
            return str;
        }
        return "";

    }

    public void returnAddress(String address) {
    }

    public void setBaseDelayList(List<Long> baseDelayList) {
        this.baseDelayList = baseDelayList;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
