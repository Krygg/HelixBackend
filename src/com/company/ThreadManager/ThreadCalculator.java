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
    private int bpm;


    public void run() {
        final long opdateRate = 10000;


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
