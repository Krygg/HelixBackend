package com.company;

import com.company.Drums.BassDrum;
import com.company.Drums.Drum;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InstrumentSplitterTest {

    @Test
    public void getStream() {
    }

    @Test
    public void addMusicElement() {
        Drum drum = new BassDrum();
        Synth synth = new Synth.Builder().build();
        Instrument instrument = new Instrument(new ArrayList<>());
        instrument.addSynth(synth);
        InstrumentSplitter instrumentSplitter = new InstrumentSplitter();
        instrumentSplitter.addMusicElement(drum);
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
    }

    @Test
    public void play() {
    }
}