package com.company.Drums;

import java.util.ArrayList;

public interface Drum {
    String getSubDrum(int i);

    void initSubDrums();
    String getDrumName();
    int getLastI();
    void setI(int i);
    void setVolume(double volume);
    double getVolume();




}
