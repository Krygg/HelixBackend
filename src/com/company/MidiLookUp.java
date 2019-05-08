package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class MidiLookUp {
    private HashMap<String, Integer> midiList = new HashMap<>();
    private int checkFlag = 0;
    private static MidiLookUp ourInstance = new MidiLookUp();

    public static MidiLookUp getInstance() {
        return ourInstance;
    }

    public MidiLookUp() {
    }


    //Kaldes for at hente informationerne fra en csv fil med noder og midinotes
    private void getMidiList() {
        //Path til filen
        Path path = Paths.get("midiNotes");


        //Læser filen til slut
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) {

            String line = br.readLine();

            //Læser strengen ind, og splitter ved , og sætter ind i et hashmap.
            while (line != null) {
                String[] attributes = line.split(",");
                midiList.put(attributes[0],Integer.parseInt(attributes[1]));
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Man kan kalde denne funktion for at få et midi number tilbage fra en node

    public int getMidiNumber(String midiNote)   {
        //Bruger checkflag så vi kun skal indlæse filen engang.
        if (checkFlag == 0) {
            getMidiList();
            checkFlag = 1;
        }
        Integer midiValue = midiList.get(midiNote.toLowerCase());
        if (midiValue == null) {
            throw new NullPointerException();
        }
        return midiValue;
    }

    public HashMap<String, Integer> getHashMap() {
        if (checkFlag == 0) {
            getMidiList();
            checkFlag = 1;
        }
        return midiList;
    }
}
