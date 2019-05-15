package com.company.TimedJobs;

import com.company.ThreadManager.ThreadWorker;
import terminals.TimeSignature;

public class Metronome implements Runnable{
    private double bpm;
    private int measure, counter=0;
    public Metronome(double bpm){
        this.bpm = bpm;

    }
    public void startComputingOnBeat(TimeSignature timeSignature) {

        while(true) {
            try {
                //TODO check that this ensures a steady bpm
                Thread.sleep((long) bpmMilliDouble(bpm));
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
            if (counter%measure==0){
                System.out.println("TICK");
            }else{
                System.out.println("TOCK");
            }
        }
    }
    public static double bpmMilliDouble(double bpm){
        double timeBetweenBeats = 1000*(60/bpm);
        return timeBetweenBeats;
    }

    @Override
    public void run() {

    }

    public double getBpm() {
        return bpm;
    }

    public int getMeasure() {
        return measure;
    }
}

