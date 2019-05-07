import com.company.Drums.BassDrum;
import com.company.Drums.Drum;
import com.company.Drums.SnareDrum;
import com.company.Instrument;
import com.company.InstrumentSplitter;
import com.company.MidiLookUp;
import com.company.Synth;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BackEndTest {
    @Test
    public void getStreamToPlayTest() {
        Synth synth = new Synth.Builder().Node("c4,e4").build();
        ArrayList<Synth> arrayList = new ArrayList();
        arrayList.add(synth);
        Instrument instrument =  new Instrument(arrayList);

        InstrumentSplitter instrumentSplitter = new InstrumentSplitter();
        instrumentSplitter.addMusicElement(instrument);
        instrumentSplitter.prepForPlay();
        ArrayList<List> listOfStream = instrumentSplitter.getStream();

        ArrayList<Object> expectedObject = new ArrayList<>();
        expectedObject.add("piano");
        expectedObject.add("60, 64");
        expectedObject.add(1);
        expectedObject.add(1);
        expectedObject.add(1);
        expectedObject.add(1);
        Assert.assertEquals(listOfStream.get(0),expectedObject);
    }

    @Test
    public void testMidiLookUp() {
        MidiLookUp midiLookUp = new MidiLookUp();
        String note  = "c4";
        int midi = midiLookUp.getMidiNumber(note);
        Assert.assertEquals(midi,60);
    }

    @Test
    public void testBuilderMoreNotes() {
        Synth synth = new Synth.Builder().Node("c4, c5, c6, c7,                c8").build();
        synth.getNode();
        Assert.assertEquals(synth.getNode(),"60, 72, 84, 96, 108");
    }

    @Test
    public void testBuilderOneNote() {
        Synth synth = new Synth.Builder().Node("c4").build();
        Assert.assertEquals(synth.getNode(),"60" +
                "");
    }

    @Test
    public void testBuilderBuilding() {
        Synth synth = new Synth.Builder().
                Node("c4").Attack(1).Decay(1).Release(1).Sustain(1).Synth("piano").build();

        ArrayList<Object> expectedList = new ArrayList();
        expectedList.add("60");
        expectedList.add(1);
        expectedList.add(1);
        expectedList.add(1);
        expectedList.add(1);
        expectedList.add("piano");


        ArrayList<Object>  senderList = new ArrayList<>();
        senderList.add(synth.getNode());
        senderList.add(synth.getDecay());
        senderList.add(synth.getAttack());
        senderList.add(synth.getSustain());
        senderList.add(synth.getRelease());
        senderList.add(synth.getSynth());

        Assert.assertEquals(senderList,expectedList);
    }


    //TODO add test for drums

}
