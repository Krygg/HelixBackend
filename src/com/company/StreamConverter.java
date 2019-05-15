package com.company;

import com.company.ThreadManager.ThreadSync;
import terminals.GlobalStream;
import terminals.LocalStream;
import terminals.TimeSignature;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StreamConverter {
    private ArrayList<Synth> streamToPlay = new ArrayList<>();
    private ArrayList<List> OSCList = new ArrayList<>();
    private ArrayList<TimeSignature> timeSignaturList = new ArrayList<>();
    int flag = 0;




    public void ConvertGlobalStreamToOSC(GlobalStream globalStream) throws IOException {
        List<LocalStream> localStreams = globalStream.getLocalStreams();
        AddressHolder addressHolder = AddressHolder.getInstance();

        for (LocalStream localStream : localStreams) {
            streamToPlay.add(convertToSynth(localStream));
            timeSignaturList.add(localStream.getTime());
        }
        convertToOSCFormat();

        ThreadSync threadSync = new ThreadSync(OSCList,addressHolder.getAddresses(),timeSignaturList);
        threadSync.start();


    }

    private Synth convertToSynth(LocalStream localStream) {
        int bpm = 128;
        //TODO oversæt notes til en string;
        String soundProfile;
        if (localStream.getSoundProfile().isEmpty()) {
            soundProfile = "piano";
        }
        soundProfile = localStream.getSoundProfile();

        if (flag == 0) {
            flag = 1;
            return new Synth("60",soundProfile,
                    localStream.getAdsr().getAttack(),localStream.getAdsr().getDecay(),localStream.getAdsr().getSustain(),
                    localStream.getAdsr().getRelease(),1,localStream.getTime());

        } else {
            return new Synth("42",soundProfile,
                    localStream.getAdsr().getAttack(),localStream.getAdsr().getDecay(),localStream.getAdsr().getSustain(),
                    localStream.getAdsr().getRelease(),1,localStream.getTime());
        }
    }


    private void convertToOSCFormat() throws IOException {
        for (Synth aStreamToPlay : streamToPlay) {
            OSCList.add(OSCFormatHelper(aStreamToPlay));
        }
    }

    private List<Object> OSCFormatHelper(Synth synth) {

        List<Object> arguments = new ArrayList<>();
        arguments.add(synth.getSynth());
        arguments.add(synth.getNote());
        arguments.add(synth.getRelease());
        arguments.add(synth.getSustain());
        arguments.add(synth.getAttack());
        arguments.add(synth.getVolume());

        return arguments;
    }
}
