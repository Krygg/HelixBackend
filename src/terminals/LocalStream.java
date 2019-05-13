package terminals;

import Interpreter.AST.Node;
import Interpreter.AST.Nodes.terminalNodes.NotesNode;
import com.company.Instrument;

import java.util.ArrayList;
import java.util.List;

public class LocalStream {

    private String soundProfile;
    private List<Object> notes;
    private ADSR adsr;
    private TimeSignature time;

    public LocalStream() {

        notes = new ArrayList<>();
    }

    public LocalStream(String soundProfile, List<Object> notes, ADSR adsr, TimeSignature time) {
        this.soundProfile = soundProfile;
        this.notes = notes;
        this.adsr = adsr;
        this.time = time;
    }

    public void addNote(Object note){
        notes.add(note);
    }

    public String getSoundProfile() {
        return soundProfile;
    }

    public void setSoundProfile(String soundProfile) {
        this.soundProfile = soundProfile;
    }

    public List<Object> getNotes() {
        return notes;
    }

    public void setNotes(List<Object> notes) {
        this.notes = notes;
    }

    public ADSR getAdsr() {
        return adsr;
    }

    public void setAdsr(ADSR adsr) {
        this.adsr = adsr;
    }

    public TimeSignature getTime() {
        return time;
    }

    public void setTime(TimeSignature time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "LocalStream{" +
                "soundProfile='" + soundProfile + '\'' +
                ", notes=" + notes +
                ", adsr=" + adsr +
                ", time=" + time +
                '}';
    }
}
