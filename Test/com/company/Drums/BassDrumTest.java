package com.company.Drums;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BassDrumTest {
    @Test
    public void testLastIModuloBassDrum() {
        Drum bassDrum = new BassDrum();
        int i = 7;
        bassDrum.initSubDrums();
        bassDrum.setI(i);
        bassDrum.getSubDrum(i);

        ArrayList<String> strings = ((BassDrum) bassDrum).getSubDrums();
        Assert.assertEquals(bassDrum.getLastI(), i % strings.size());
    }

    @Test
    public void testLastIBassDrum() {
        Drum bassDrum = new BassDrum();
        int i = 3;
        bassDrum.initSubDrums();
        bassDrum.setI(i);
        bassDrum.getSubDrum(i);

        ArrayList<String> strings = ((BassDrum) bassDrum).getSubDrums();
        Assert.assertEquals(bassDrum.getLastI(), i % strings.size());
    }


    @Test
    public void testNameBassDrum() {
        Drum bassDrum =  new BassDrum();
        Assert.assertEquals(bassDrum.getDrumName().toLowerCase(),"bassdrum");

    }


}