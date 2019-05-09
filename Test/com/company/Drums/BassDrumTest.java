package com.company.Drums;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BassDrumTest {
    @Test
    public void testLastIModuloBassDrum() {
        Drum bassDrum = new BassDrum();
        int i = 7;
        bassDrum.initSamples();
        bassDrum.setI(i);
        bassDrum.getSubDrum(i);

        ArrayList<String> strings = ((BassDrum) bassDrum).getSubDrums();
        Assert.assertEquals(bassDrum.getLastI(), i % strings.size());
    }

    @Test
    public void testIndexOut() {
        Drum bassDrum = new BassDrum();
        bassDrum.initSamples();
        ArrayList<String> strings = ((BassDrum) bassDrum).getSubDrums();
        bassDrum.setI(strings.size());
        bassDrum.getSubDrum(bassDrum.getLastI());
        Assert.assertEquals(bassDrum.getLastI(),0);
    }

    @Test
    public void testLastIBassDrum() {
        Drum bassDrum = new BassDrum();
        int i = 3;
        bassDrum.initSamples();
        bassDrum.setI(i);
        bassDrum.getSubDrum(i);

        ArrayList<String> strings = ((BassDrum) bassDrum).getSubDrums();
        Assert.assertEquals(bassDrum.getLastI(), i % strings.size());
    }


    @Test
    public void testNameBassDrum() {
        Drum bassDrum =  new BassDrum();
        Assert.assertEquals(bassDrum.getName().toLowerCase(),"bassdrum");

    }


}