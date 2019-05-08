package com.company.TimedJobs;

public class Metronome implements Runnable{
    private double bpm;
    private int measure, counter;
    public Metronome(double bpm, int measure){
        this.bpm = bpm;
        this.measure = measure;
    }
    public void startComputingOnBeat(JobHandler jobHandler, Double bpm) {
        while(true) {
            try {
                //TODO check that this ensures a steady bpm
                jobHandler.executorMethod(jobHandler.getJob(), bpm);
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

