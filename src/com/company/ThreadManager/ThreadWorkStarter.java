package com.company.ThreadManager;

import java.util.List;

public class ThreadWorkStarter extends Thread {
    private List<ThreadWorker> threadWorkers;
    private List<Integer> lasti;


    public void run() {
        startingWorkers();
    }

    private void startingWorkers() {
        for (int i = 0; i < threadWorkers.size(); i++) {
            threadWorkers.get(i).setI(lasti.get(i));
            threadWorkers.get(i).start();
        }
    }

    public void setThreadWorkers(List<ThreadWorker> threadWorkers) {
        this.threadWorkers = threadWorkers;
    }

    public void setLasti(List<Integer> lasti) {
        this.lasti = lasti;
    }
}
