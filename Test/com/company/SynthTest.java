package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class SynthTest {

    @Test
    public void getNode() {
        Synth synth = new Synth.Builder().Node("c4").build();
        assertEquals(synth.getNode(),"60");
    }

    @Test
    public void getAttack() {
        int attack = 1;
        Synth synth = new Synth.Builder().Attack(attack).build();
        assertEquals(synth.getAttack(),attack);
    }

    @Test
    public void getDecay() {
        int decay = 1;
        Synth synth = new Synth.Builder().Decay(decay).build();
        assertEquals(synth.getDecay(),decay);
    }

    @Test
    public void getSustain() {
        int sustain = 1;
        Synth synth = new Synth.Builder().Sustain(sustain).build();
        assertEquals(synth.getSustain(),sustain);
    }

    @Test
    public void getRelease() {
        int release = 1;
        Synth synth = new Synth.Builder().Release(release).build();
        assertEquals(synth.getRelease(),release);
    }

    @Test
    public void getSynth() {
        String synth = "pianoTest";
        Synth synth1 = new Synth.Builder().Synth(synth).build();
        assertEquals(synth1.getSynth(),synth);
    }

    @Test
    public void getVolume() {
        double volume = 0.5;
        Synth synth = new Synth.Builder().Volume(volume).build();
        assertEquals(synth.getVolume(),volume,0.01);

    }
}