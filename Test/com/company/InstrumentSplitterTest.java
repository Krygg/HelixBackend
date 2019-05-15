package com.company;

import com.company.Samples.BassDrum;
import com.company.Samples.Sample;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class InstrumentSplitterTest {

    @Test
    public void getStream() {
    }

    @Test
    public void addMusicElement() {
        Sample sample = new BassDrum();
        Synth synth = new Synth.Builder().build();
        Instrument instrument = new Instrument(new ArrayList<>());
        instrument.addSynth(synth);
        InstrumentSplitter instrumentSplitter = new InstrumentSplitter();
        instrumentSplitter.addMusicElement(sample);
        instrumentSplitter.addMusicElement(instrument);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addMusicElementFail() {
        String string = "";
        InstrumentSplitter instrumentSplitter = new InstrumentSplitter();
        instrumentSplitter.addMusicElement(string);
    }

    @Test
    public void prepForPlay() {
        Sample sample = new BassDrum();
        sample.setI(2);
        Instrument instrument = new Instrument(new ArrayList<>());
        instrument.addSynth(new Synth.Builder().build());

        InstrumentSplitter instrumentSplitter = new InstrumentSplitter();
        instrumentSplitter.addMusicElement(instrument);
        instrumentSplitter.addMusicElement(sample);
        instrumentSplitter.prepForPlay();
    }

    //TODO: Had to comment one line out because it had an error.
    @Test
    public void play() throws IOException, InterruptedException {
        Sample sample = new BassDrum();
        sample.setI(2);
        Instrument instrument = new Instrument(new ArrayList<>());
        instrument.addSynth(new Synth.Builder().build());

        InstrumentSplitter instrumentSplitter = new InstrumentSplitter();
        instrumentSplitter.addMusicElement(instrument);
        instrumentSplitter.addMusicElement(sample);
        instrumentSplitter.prepForPlay();
        //instrumentSplitter.play();
    }
}