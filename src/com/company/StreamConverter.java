package com.company;

import com.company.ThreadManager.ThreadSync;
import terminals.GlobalStream;
import terminals.LocalStream;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StreamConverter {
    ArrayList<Synth> streamToPlay = new ArrayList<>();
    ArrayList<List> OSCList = new ArrayList<>();



    public void ConvertGlobalStreamToOSC(GlobalStream globalStream) throws IOException {
        List<LocalStream> localStreams = globalStream.getLocalStreams();
        AddressHolder addressHolder = AddressHolder.getInstance();

        for (LocalStream localStream : localStreams) {
            streamToPlay.add(convertToSynth(localStream));
            convertToOSCFormat();
        }

        ThreadSync threadSync = new ThreadSync(OSCList,addressHolder.getAddresses());
        threadSync.start();


    }

    private Synth convertToSynth(LocalStream localStream) {
        int bpm = 128;
        //TODO oversæt notes til en string;
        String soundProfile = "";
        if (localStream.getSoundProfile().isEmpty()) {
            soundProfile = "piano";
        }
        soundProfile = localStream.getSoundProfile();


        Synth synth = new Synth("60",soundProfile,
                localStream.getAdsr().getAttack(),localStream.getAdsr().getDecay(),localStream.getAdsr().getSustain(),
                localStream.getAdsr().getRelease(),1,localStream.getTime());


        return synth;
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
