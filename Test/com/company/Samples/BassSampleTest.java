package com.company.Samples;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BassSampleTest {
    @Test
    public void testLastIModuloBassDrum() {
        Sample bassSample = new BassDrum();
        int i = 7;
        bassSample.initSamples();
        bassSample.setI(i);
        bassSample.getSubDrum(i);

        ArrayList<String> strings = ((BassDrum) bassSample).getSubDrums();
        Assert.assertEquals(bassSample.getLastI(), i % strings.size());
    }

        @Test
        public void testIndexOut() {
            Sample bassSample = new BassDrum();
            bassSample.initSamples();
            ArrayList<String> strings = ((BassDrum) bassSample).getSubDrums();
            bassSample.setI(strings.size());
            bassSample.getSubDrum(bassSample.getLastI());
            Assert.assertEquals(bassSample.getLastI(),0);
        }

    @Test
    public void testLastIBassDrum() {
        Sample bassSample = new BassDrum();
        int i = 3;
        bassSample.initSamples();
        bassSample.setI(i);
        bassSample.getSubDrum(i);

        ArrayList<String> strings = ((BassDrum) bassSample).getSubDrums();
        Assert.assertEquals(bassSample.getLastI(), i % strings.size());
    }


    @Test
    public void testNameBassDrum() {
        Sample bassSample =  new BassDrum();
        Assert.assertEquals(bassSample.getName().toLowerCase(),"bassdrum");

    }


}