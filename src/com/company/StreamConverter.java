package com.company;

import terminals.GlobalStream;
import terminals.LocalStream;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StreamConverter {
    ArrayList<Synth> streamToPlay = new ArrayList<>();
    ArrayList<List> OSCList = new ArrayList<>();
    PiSender piSender;


    public void ConvertGlobalStreamToOSC(GlobalStream globalStream) throws IOException {
        List<LocalStream> localStreams = globalStream.getLocalStreams();

        int i = 0;
        for (LocalStream localStream : localStreams) {
            streamToPlay.add(convertToSynth(localStream));
            convertToOSCFormat();
            System.out.println("jjj");
        }
        System.out.println(OSCList.isEmpty());


        List<Object> arugements = new ArrayList<>();
        arugements.add("5");
        arugements.add(5);
        piSender.send(arugements);
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


    private void convertToOSCFormat() throws IOException {
        for (Synth aStreamToPlay : streamToPlay) {
            System.out.println("iii");
            OSCList.add(OSCFormatHelper(aStreamToPlay));
        }
    }

    private List<Object> OSCFormatHelper(Synth synth) {

        //TODO add real info here.
        List<Object> arguments = new ArrayList<>();
        arguments.add(synth.getSynth());
        arguments.add(synth.getNote());
        arguments.add(synth.getRelease());
        arguments.add(synth.getSustain());
        arguments.add(synth.getAttack());
        arguments.add(synth.getVolume());
        System.out.println("kkk");

        return arguments;
    }







}
