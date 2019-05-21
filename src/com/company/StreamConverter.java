package com.company;

import com.company.ThreadManager.ThreadSync;
import terminals.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StreamConverter {
    private ArrayList<Synth> streamToPlay = new ArrayList<>();
    private ArrayList<List> OSCList = new ArrayList<>();
    private ArrayList<TimeSignature> timeSignaturList = new ArrayList<>();
    private List<List> notes = new ArrayList<>();
    private int bpm = 0;
    int flag = 0;




    public void ConvertGlobalStreamToOSC(GlobalStream globalStream, int bpm) throws IOException {
        List<LocalStream> localStreams = globalStream.getLocalStreams();
        AddressHolder addressHolder = AddressHolder.getInstance();

        for (LocalStream localStream : localStreams) {
            streamToPlay.add(convertToSynth(localStream));
            timeSignaturList.add(localStream.getTime());
        }


        convertToOSCFormat();

        ThreadSync threadSync = new ThreadSync(OSCList,addressHolder.getAddresses(),timeSignaturList,bpm,notes);
        threadSync.start();


    }

    private Synth convertToSynth(LocalStream<LocalStream> localStream) {
        String soundProfile;
        List<LocalStream> localStreams = localStream.getNotes();
        List<String> localNotes = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder("");
        int size = 0;


        for (int i = 0; i < localStream.getNotes().size(); i++) {
            for (int j = 0; j < localStream.getNotes().get(i).getNotes().size(); j++) {
                if (localStream.getNotes().get(i).getNotes().size() > 1) {
                    stringBuilder.append(localStream.getNotes().get(i).getNotes().get(j));
                    if (j < (localStream.getNotes().get(i).getNotes().size()-1)) {
                        stringBuilder.append(", ");
                    }
                } else {
                    stringBuilder.append(localStream.getNotes().get(i).getNotes().get(j));
                }
            }
            localNotes.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        System.out.println(localNotes);

        notes.add(localNotes);

        localStream.setSoundProfile(localStream.getSoundProfile().toLowerCase());
        if (localStream.getSoundProfile().isEmpty()) {
            soundProfile = "piano";
        }

        soundProfile = localStream.getSoundProfile();

        //Checker om adsr er tom
        if (localStream.getAdsr() == null) {
            ADSR adsr  = new ADSR(0,0,0,0);
            localStream.setAdsr(adsr);
        }

        if (localStream.getTime() == null) {
            TimeSignature timeSignature = new TimeSignature(4,4);
            localStream.setTime(timeSignature);
        }

        return new Synth("60",soundProfile,
                localStream.getAdsr().getAttack(),localStream.getAdsr().getDecay(),localStream.getAdsr().getSustain(),
                localStream.getAdsr().getRelease(),1,localStream.getTime());

    }


    private void convertToOSCFormat() throws IOException {
        for (Synth aStreamToPlay : streamToPlay) {
            OSCList.add(OSCFormatHelper(aStreamToPlay));
        }
    }

    private List<Object> OSCFormatHelper(Synth synth) {

        List<Object> arguments = new ArrayList<>();
        arguments.add(synth.getSynth());
        arguments.add(1);
        arguments.add(synth.getRelease());
        arguments.add(synth.getSustain());
        arguments.add(synth.getAttack());
        //TODO add the real values for ADSR, so alll of this works


        return arguments;
    }
}
