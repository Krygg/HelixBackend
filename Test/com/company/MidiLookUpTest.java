package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class MidiLookUpTest {

    @Test(expected = NullPointerException.class)
    public void getMidiNumberException() {
        MidiLookUp midiLookUp = MidiLookUp.getInstance();
        int midiNote = midiLookUp.getMidiNumber("c45");


    }

    @Test
    public void testMidiLookUp() {
        MidiLookUp midiLookUp = new MidiLookUp();
        String note  = "c4";
        int midi = midiLookUp.getMidiNumber(note);
        Assert.assertEquals(midi,60);
    }

    @Test
    public void multipleMidiNumber() {
        MidiLookUp midiLookUp = MidiLookUp.getInstance();
        String note = "c4,      c6,   e8";

    }

    @Test
    public void getHashMap() {
        HashMap<String, Integer> hashMap = MidiLookUp.getInstance().getHashMap();
        int hashMapInt = hashMap.get("c4");
        assertEquals(hashMapInt,60);
        HashMap<String, Integer> hashMap1 = MidiLookUp.getInstance().getHashMap();
    }



}