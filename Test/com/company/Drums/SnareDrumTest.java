package com.company.Drums;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SnareDrumTest {
    @Test
    public void testLastIModuloSnareDrum() {
        Drum snareDrum = new SnareDrum();
        int i = 15;
        snareDrum.initSamples();
        snareDrum.setI(i);
        snareDrum.getSubDrum(i);

        ArrayList<String> strings = ((SnareDrum) snareDrum).getSubDrums();
        Assert.assertEquals(snareDrum.getLastI(), i % strings.size());
    }

    @Test
    public void testLastISnareDrum() {
        Drum snareDrum = new SnareDrum();
        int i = 2;
        snareDrum.initSamples();
        snareDrum.setI(i);
        snareDrum.getSubDrum(i);

        ArrayList<String> strings = ((SnareDrum) snareDrum).getSubDrums();
        Assert.assertEquals(snareDrum.getLastI(), i % strings.size());
    }

    @Test
    public void testIndexOut() {
        Drum snareDrum = new SnareDrum();
        snareDrum.initSamples();
        ArrayList<String> strings = ((SnareDrum) snareDrum).getSubDrums();
        snareDrum.setI(strings.size());
        snareDrum.getSubDrum(snareDrum.getLastI());
        Assert.assertEquals(snareDrum.getLastI(),0);
    }


    @Test
    public void testNameSnareDrum() {
        Drum bassDrum =  new SnareDrum();
        Assert.assertEquals(bassDrum.getName().toLowerCase(),"snaredrum");

    }

}