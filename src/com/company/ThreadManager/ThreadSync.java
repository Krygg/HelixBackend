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
    private List<List> notes;
    private int bpm;

    public ThreadSync(List<List> streamToPlay, List<String> addresses, List<TimeSignature> timeSignatures, int bpm, List<List> notes) {
        this.notes = notes;
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
            threadWorker.setTimeSplit(calculateDelay(this.bpm, timeSignatures.get(i)));
            threadWorker.setArguments(streamToPlay.get(i));
            threadWorker.setAddress(getAddress());
            threadWorker.setNotes(notes.get(i));
            threadWorker.start();
        }
    }
    private long calculateDelay(int bpm, TimeSignature timeSignature) {
        final double moveComma = 1000;
        final double secondPrMin = 60;
        double baseDelay = (moveComma) * (secondPrMin / (double) bpm);
        double timeSignDelay = (double) timeSignature.getN1() / (double) timeSignature.getN2();
        double delay = baseDelay * timeSignDelay;
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



}
