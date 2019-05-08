package com.company;


import com.company.Drums.BassDrum;
import com.company.Drums.Drum;
import com.company.Drums.Guitar;
import com.company.Drums.SnareDrum;
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
        Drum drum = new BassDrum();
        Drum drum1 = new SnareDrum();

        drum.setI(3);
        drum.setVolume(0.9);
        drum1.setI(5);
        drum1.setVolume(0.1);
        Drum drum2 = new Guitar();
        drum2.setI(3);
        drum2.setVolume(0.99);

        Instrument instrument1 = new Instrument(senders1);

        InstrumentSplitter instrumentSplitter = new InstrumentSplitter();

        while(true) {
            instrumentSplitter.addMusicElement(instrument1);
            instrumentSplitter.addMusicElement(drum);
            instrumentSplitter.addMusicElement(drum1);
            instrumentSplitter.addMusicElement(drum2);
            instrumentSplitter.prepForPlay();
            instrumentSplitter.play();
            Thread.sleep(5000);
        }

    }

}
