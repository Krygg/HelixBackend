package com.company.TimedJobs;

public class TestJobs implements Runnable {

    Runnable job;

    public TestJobs(){
        this.job = this::run;
    }

    @Override
    public void run() {
        try {
            System.out.println("Starting: ");
            //TODO Replace this with actual jobs
            Thread.sleep(150);
            System.out.println("Completed: ");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Ripped: ");
        }
    }

    public Runnable getJob() {
        return job;
    }
}
