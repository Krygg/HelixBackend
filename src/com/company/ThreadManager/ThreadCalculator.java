package com.company.ThreadManager;

import terminals.TimeSignature;

import java.util.ArrayList;
import java.util.List;

public class ThreadCalculator extends Thread {

    private List<List> streamToPlay;
    private List<String> addresses;
    private List<TimeSignature> timeSignatures;
    private List<List> notes;
    private List<Long> baseDelayList = new ArrayList<>();
    private List<Long> normalDelayList = new ArrayList<>();
    private List<Long> baseDelayListToSend = new ArrayList<>();
    private ThreadSync threadSync;
    private List<ThreadWorker> threadWorkers = new ArrayList<>();
    private List<Integer> noteSelector = new ArrayList<>();
    private int bpm;


    public void run() {
        calculateBaseDelay();
    }

    private void calculateBaseDelay() {
        //Calculate the delay, that the new Threads new after starting.
        baseDelayListToSend.clear();
        final long opdateRate = 10000;
        long delayTime = 0;
        long difTime = 0;
        int i = 0;
        for (Long aLong : normalDelayList) {
            for (int j = 1; delayTime <= opdateRate; j++) {
                delayTime = (aLong * j) ;
                if (!baseDelayList.isEmpty()) {
                    delayTime += baseDelayList.get(i);
                }

                if (delayTime >= opdateRate) {
                    break;
                }

            }
            difTime = delayTime - opdateRate;
            i++;
            baseDelayListToSend.add(difTime);
            delayTime = 0;
        }

        //Creating workers, so timing works.
        for (int o = 0; o < streamToPlay.size(); o++) {
            ThreadWorker threadWorker = new ThreadWorker();
            threadWorker.setNoteDelay(normalDelayList.get(o));
            threadWorker.setArguments(streamToPlay.get(o));
            threadWorker.setAddress(addresses.get(o));
            threadWorker.setNotes(notes.get(o));
            threadWorker.setBaseDelay(baseDelayListToSend.get(o));
            threadWorkers.add(threadWorker);
        }

        threadSync.setBaseDelayList(baseDelayListToSend);
        threadSync.setFlag(1);

    }


    public List<List> getStreamToPlay() {
        return streamToPlay;
    }

    public void setStreamToPlay(List<List> streamToPlay) {
        this.streamToPlay = streamToPlay;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public List<TimeSignature> getTimeSignatures() {
        return timeSignatures;
    }

    public void setTimeSignatures(List<TimeSignature> timeSignatures) {
        this.timeSignatures = timeSignatures;
    }

    public List<List> getNotes() {
        return notes;
    }

    public void setNotes(List<List> notes) {
        this.notes = notes;
    }

    public List<Long> getBaseDelayList() {
        return baseDelayList;
    }

    public void setNormalDelayList(List<Long> normalDelayList) {
        this.normalDelayList = normalDelayList;
    }

    public List<Long> getNormalDelayList() {
        return normalDelayList;
    }

    public void setThreadSync(ThreadSync threadSync) {
        this.threadSync = threadSync;
    }

    public void setBaseDelayList(List<Long> baseDelayList) {
        this.baseDelayList = baseDelayList;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public void setThreadWorkers(List<ThreadWorker> threadWorkers) {
        this.threadWorkers = threadWorkers;
    }

    public List<Integer> getNodeSelector() {
        return noteSelector;
    }

    public List<ThreadWorker> getThreadWorkers() {
        return threadWorkers;
    }

    public void setNoteSelector(List<Integer> noteSelector) {
        this.noteSelector = noteSelector;
    }
}
