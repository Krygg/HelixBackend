import com.company.Instrument;
import com.company.InstrumentSplitter;
import com.company.MidiLookUp;
import com.company.Sender;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BackEndTest {
    @Test
    public void getStreamToPlayTest() {
        Sender sender = new Sender.Builder().Node("c4,e4").build();
        ArrayList<Sender> arrayList = new ArrayList();
        arrayList.add(sender);
        Instrument instrument =  new Instrument(arrayList);

        InstrumentSplitter instrumentSplitter = new InstrumentSplitter();
        instrumentSplitter.addInstrument(instrument);
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
        Sender sender = new Sender.Builder().Node("c4, c5, c6, c7,                c8").build();
        sender.getNode();
        Assert.assertEquals(sender.getNode(),"60, 72, 84, 96, 108");
    }

    @Test
    public void testBuilderOneNote() {
        Sender sender = new Sender.Builder().Node("c4").build();
        Assert.assertEquals(sender.getNode(),"60" +
                "");
    }

    @Test
    public void testBuilderBuilding() {
        Sender sender = new Sender.Builder().
                Node("c4").Attack(1).Decay(1).Release(1).Sustain(1).Synth("piano").build();

        ArrayList<Object> expectedList = new ArrayList();
        expectedList.add("60");
        expectedList.add(1);
        expectedList.add(1);
        expectedList.add(1);
        expectedList.add(1);
        expectedList.add("piano");


        ArrayList<Object>  senderList = new ArrayList<>();
        senderList.add(sender.getNode());
        senderList.add(sender.getDecay());
        senderList.add(sender.getAttack());
        senderList.add(sender.getSustain());
        senderList.add(sender.getRelease());
        senderList.add(sender.getSynth());

        Assert.assertEquals(senderList,expectedList);
    }


}
