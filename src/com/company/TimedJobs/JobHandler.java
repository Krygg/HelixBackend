package com.company.TimedJobs;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JobHandler
        implements Runnable
        {

    int id = 0;
    Runnable job;

    public JobHandler(Runnable job) {
        this.id = 0;
        this.job = job;
    }

    public void executorMethod(Runnable job, double bpm) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(16);
        int i = 0;
        for (i=0; i<= 25; i++) {
            this.setId(i);
            executor.submit(job);
        }
        executor.shutdown();

        System.out.println("Tasks submitted...");
        if (!executor.awaitTermination((long) Metronome.bpmMilliDouble(bpm), TimeUnit.MILLISECONDS)) {
            executor.shutdownNow();
            System.out.println("TIMELIMIT ECEEDED. Threads terminated.");
        }
        System.out.println("Tasks completed.");
    }

    public void setId(int id) {
        this.id = id;
    }

            public int getId() {
                return id;
            }

            public Runnable getJob() {
                return job;
            }

            @Override
            public void run() {

            }
    /*
    @Override
    public void run() {
        System.out.println("Starting: " + id);
        try {
            //TODO Replace this with actual jobs
            Thread.sleep(150);
            System.out.println("Completed: " + id);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Ripped: " + id);
        }

    }
*/
}


