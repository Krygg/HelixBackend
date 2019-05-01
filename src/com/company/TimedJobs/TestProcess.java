package com.company.TimedJobs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestProcess implements Runnable {

    int time = 2000, id;

    public TestProcess(int id, int waitTime) {
        this.id = id;
        this.time = waitTime;
    }

    @Override
    public void run() {
        System.out.println("Starting: " + id);
        try {
            //TODO Replace this with actual jobs
            Thread.sleep(time);
            System.out.println("Completed: " + id);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Ripped: " + id);
        }
    }

    public TestProcess(int workers, int jobLoad, int amountOfJobs, long bpm) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(workers);

        for (int i = 0; i <= amountOfJobs; i++) {
            executor.submit(new TestProcess(i, jobLoad));
        }

        executor.shutdown();

        System.out.println("Tasks submitted...");
        if (!executor.awaitTermination((long) Metronome.bpmMilliDouble(bpm), TimeUnit.MILLISECONDS)) {
            executor.shutdownNow();
            System.out.println("TIMELIMIT ECEEDED. Threads terminated.");
        }
        System.out.println("Tasks completed.");
    }
}


