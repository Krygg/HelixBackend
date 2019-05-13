package com.company;

import terminals.GlobalStream;
import terminals.LocalStream;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StreamConverter {
    ArrayList<Synth> streamToPlay = new ArrayList<>();


    public void ConvertGlobalStreamToOSC(GlobalStream globalStream) {
        List<LocalStream> localStreams = globalStream.getLocalStreams();
        for (LocalStream localStream : localStreams) {
            streamToPlay.add(convertToSynth(localStream));
        }
    }

    private Synth convertToSynth(LocalStream localStream) {
        int bpm = 128;
        //TODO oversæt notes til en string;
        //TODO SoundProfile can be null, fix please
        Synth synth = new Synth("hello",localStream.getSoundProfile(),
                localStream.getAdsr().getAttack(),localStream.getAdsr().getDecay(),localStream.getAdsr().getSustain(),
                localStream.getAdsr().getRelease(),1,localStream.getTime());




        return synth;
    }







}
