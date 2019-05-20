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
    private ThreadSync threadSync;
    private int bpm;


    public void run() {
        calculateBaseDelay();
    }

    private void calculateBaseDelay() {
        final long opdateRate = 10000;
        baseDelayList.clear();
        long delayTime = 0;
        long difTime = 0;
        for (Long aLong : normalDelayList) {
            for (int j = 1; delayTime <= opdateRate; j++) {
                delayTime = (aLong * j);
            }
            difTime = delayTime - opdateRate;
            System.out.println("Diff time is " + difTime);
            baseDelayList.add(difTime);
        }

        threadSync.setBaseDelayList(baseDelayList);
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


}
