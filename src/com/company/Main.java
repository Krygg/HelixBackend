package com.company;


import com.company.Samples.BassDrum;
import com.company.Samples.Sample;
import com.company.Samples.Guitar;
import com.company.Samples.SnareDrum;
import com.company.ThreadManager.ThreadSync;
import com.company.TimedJobs.Metronome;
import terminals.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    int id = 0;


    public static void main(String[] args) throws IOException, InterruptedException {
        //ThreadSync mainLead = new ThreadSync(new GlobalStream(new ArrayList<>()));
       // mainLead.start();
    //Main.testBackEnd();
       testStreamConverter();



    }

    private void testBPM() {
        Metronome metronome = new Metronome(128);
        TimeSignature timeSignature = new TimeSignature(4, 4);
        metronome.startComputingOnBeat(timeSignature);

    }


    private static void testStreamConverter() throws IOException, InterruptedException {

        Note note = new Note();
        ArrayList<Note> list = new ArrayList<Note>();
        list.add(note);


        ADSR adsr = new ADSR(1, 1, 1, 1);

        TimeSignature timeSignature = new TimeSignature(4, 4);

        LocalStream localStream = new LocalStream("piano",list, adsr, timeSignature);


        ArrayList<LocalStream> localStreams = new ArrayList<LocalStream>();
        localStreams.add(localStream);
        localStreams.add(localStream);
        localStreams.add(localStream);
        localStreams.add(localStream);

        GlobalStream globalStream = new GlobalStream(localStreams);

        StreamConverter streamConverter = new StreamConverter();

        streamConverter.ConvertGlobalStreamToOSC(globalStream,128);

    }


}
