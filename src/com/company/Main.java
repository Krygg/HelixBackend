package com.company;


import com.company.Samples.BassDrum;
import com.company.Samples.Sample;
import com.company.Samples.Guitar;
import com.company.Samples.SnareDrum;
import com.company.TimedJobs.Metronome;
import com.company.TimedJobs.JobHandler;
import com.company.TimedJobs.TestJobs;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    int id = 0;


    public static void main(String[] args) throws IOException, InterruptedException {

        Main.testBackEnd();



    }

    private void testBPM() {
        TestJobs testJob = new TestJobs();
        JobHandler jobHandler = new JobHandler(testJob.getJob());
        Metronome metronome = new Metronome(128, 4);
        metronome.startComputingOnBeat(jobHandler, metronome.getBpm());

    }

    private static void testBackEnd() throws IOException, InterruptedException {
        Synth synth3 = new Synth.Builder().Node("c4,e4").Volume(0.4).build();
        Synth synth4 = new Synth.Builder().Node("e2").Volume(0.1).build();

        ArrayList<Synth> senders1 = new ArrayList<>();
        senders1.add(synth3);
        senders1.add(synth4);
        Sample sample = new BassDrum();
        Sample sample1 = new SnareDrum();

        sample.setI(3);
        sample.setVolume(0.9);
        sample1.setI(5);
        sample1.setVolume(0.1);
        Sample sample2 = new Guitar();
        sample2.setI(3);
        sample2.setVolume(0.99);

        Instrument instrument1 = new Instrument(senders1);

        InstrumentSplitter instrumentSplitter = new InstrumentSplitter();

        while(true) {
            instrumentSplitter.addMusicElement(instrument1);
            instrumentSplitter.addMusicElement(sample);
            instrumentSplitter.addMusicElement(sample1);
            instrumentSplitter.addMusicElement(sample2);
            instrumentSplitter.prepForPlay();
            instrumentSplitter.play();
            Thread.sleep(4000);
        }

    }

}
