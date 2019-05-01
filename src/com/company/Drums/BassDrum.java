package com.company.Drums;

import java.util.ArrayList;

public class BassDrum implements Drum {
    private int flag = 0;
    private String drumName = "BassDrum";
    private ArrayList<String> subDrums = new ArrayList<>();


    @Override
    public String getSubDrum(int i) {
        if (flag == 0) initSubDrums();
        if (i > subDrums.size()) return subDrums.get((i % subDrums.size()));
        return subDrums.get(i);
    }

    //More can be added for later.
    @Override
    public void initSubDrums() {
        flag = 1;
        subDrums.add("bd_ada");
        subDrums.add("bd_pure");
        subDrums.add("bd_808");
        subDrums.add("bd_zum");
        subDrums.add("bd_gas");
        subDrums.add("bd_sone");
    }

    @Override
    public String getDrumName() {
        return this.drumName;
    }
}