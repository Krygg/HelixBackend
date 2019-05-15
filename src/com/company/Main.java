package com.company;


import com.company.Samples.BassDrum;
import com.company.Samples.Sample;
import com.company.Samples.Guitar;
import com.company.Samples.SnareDrum;
import com.company.ThreadManager.ThreadSync;
import com.company.TimedJobs.Metronome;
import terminals.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    int id = 0;


    public static void main(String[] args) throws IOException, InterruptedException {
        //ThreadSync mainLead = new ThreadSync(new GlobalStream(new ArrayList<>()));
       // mainLead.start();
    //Main.testBackEnd();
       testStreamConverter();



    }

    private void testBPM() {
        Metronome metronome = new Metronome(128);
        TimeSignature timeSignature = new TimeSignature(4, 4);
        metronome.startComputingOnBeat(timeSignature);

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
        Sample sample2 = new SnareDrum();
        sample2.setI(2);
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
    private static void testStreamConverter() throws IOException {

        Note note = new Note();
        ArrayList<Note> list = new ArrayList<Note>();
        list.add(note);


        ADSR adsr = new ADSR(1, 1, 1, 1);

        TimeSignature timeSignature = new TimeSignature(4, 4);

        LocalStream localStream = new LocalStream("piano",list, adsr, timeSignature);


        ArrayList<LocalStream> localStreams = new ArrayList<LocalStream>();
        localStreams.add(localStream);
        localStreams.add(localStream);
        localStreams.add(localStream);
        localStreams.add(localStream);

        GlobalStream globalStream = new GlobalStream(localStreams);

        StreamConverter streamConverter = new StreamConverter();

        streamConverter.ConvertGlobalStreamToOSC(globalStream);

    }


}
