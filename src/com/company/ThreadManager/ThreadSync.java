package com.company.ThreadManager;

import terminals.TimeSignature;

import java.util.ArrayList;
import java.util.List;

public class ThreadSync extends Thread {

    private List<List> streamToPlay;
    private List<String> addresses;
    private List<TimeSignature> timeSignatures;
    private List<List> notes;
    private List<Long> normalDelayList = new ArrayList<>();
    private List<ThreadWorker> activeWorkers = new ArrayList<>();
    private List<Long> baseDelayList = new ArrayList<>();
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
        try {
            startWorkers();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void startWorkers() throws InterruptedException {

        for (int i = 0; i < streamToPlay.size(); i++) {
            ThreadWorker threadWorker = new ThreadWorker();
            threadWorker.setNoteDelay(calculateDelay(this.bpm, timeSignatures.get(i)));
            threadWorker.setArguments(streamToPlay.get(i));
            threadWorker.setAddress(getAddress());
            threadWorker.setNotes(notes.get(i));
            if (flag == 1) {
                threadWorker.setNoteDelay(baseDelayList.get(i));
            }
            threadWorker.start();
            activeWorkers.add(threadWorker);
        }

        //TODO begin process of getting new delays for workers

        ThreadCalculator threadCalculator = new ThreadCalculator();
        threadCalculator.setNormalDelayList(this.normalDelayList);
        threadCalculator.setThreadSync(this);
        threadCalculator.start();

        Thread.sleep(10000);

        //TODO Kill old workers

        for (ThreadWorker worker : activeWorkers) {
            worker.interrupt();
        }


        //TODO start the workers again();

        startWorkers();
    }



    private void startCalculator() {

    }




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

    public void setBaseDelayList(List<Long> baseDelayList) {
        this.baseDelayList = baseDelayList;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
