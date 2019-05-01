package com.company.TimedJobs;


public class Metronome{
    private double bpm;
    private int measure, counter;
    public Metronome(double bpm, int measure){
        this.bpm = bpm;
        this.measure = measure;
    }
    public void startComputingOnBeat() {
        while(true) {
            try {
                //TODO check that this ensures a steady bpm
                Thread thread = new Thread(new TestProcess(16, 50, 20, (long) bpm));
                thread.start();
                Thread.sleep((long)bpmMilliDouble(bpm));
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
}

