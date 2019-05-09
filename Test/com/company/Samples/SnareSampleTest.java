package com.company.Samples;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SnareSampleTest {
    @Test
    public void testLastIModuloSnareDrum() {
        Sample snareSample = new SnareDrum();
        int i = 15;
        snareSample.initSamples();
        snareSample.setI(i);
        snareSample.getSubDrum(i);

        ArrayList<String> strings = ((SnareDrum) snareSample).getSubDrums();
        Assert.assertEquals(snareSample.getLastI(), i % strings.size());
    }

    @Test
    public void testLastISnareDrum() {
        Sample snareSample = new SnareDrum();
        int i = 2;
        snareSample.initSamples();
        snareSample.setI(i);
        snareSample.getSubDrum(i);

        ArrayList<String> strings = ((SnareDrum) snareSample).getSubDrums();
        Assert.assertEquals(snareSample.getLastI(), i % strings.size());
    }

    @Test
    public void testIndexOut() {
        Sample snareSample = new SnareDrum();
        snareSample.initSamples();
        ArrayList<String> strings = ((SnareDrum) snareSample).getSubDrums();
        snareSample.setI(strings.size());
        snareSample.getSubDrum(snareSample.getLastI());
        Assert.assertEquals(snareSample.getLastI(),0);
    }


    @Test
    public void testNameSnareDrum() {
        Sample bassSample =  new SnareDrum();
        Assert.assertEquals(bassSample.getName().toLowerCase(),"snaredrum");

    }

}