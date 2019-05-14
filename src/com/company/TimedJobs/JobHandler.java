package com.company.TimedJobs;

import java.util.ArrayList;
import java.util.concurrent.*;

public class JobHandler
        implements Runnable
        {

    private int id=0;
    Runnable JHjob;
    ArrayList<Runnable> JHjobs;
    public BlockingQueue<JobHandler> queue = new ArrayBlockingQueue<JobHandler>(100);

    public JobHandler(){}


    public void JobPackager(int id, Runnable job) throws InterruptedException {
        this.id = id;
        this.JHjob = job;
        queue.put(this);
    }

    void executorMethod(double bpm) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(16);
        int i;
        for (i=0; i<= this.queue.size(); i++) {
            executor.submit(this.queue.take());
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


