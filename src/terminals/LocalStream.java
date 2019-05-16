package terminals;

import java.util.ArrayList;
import java.util.List;

public class LocalStream <T> {

    private String soundProfile;
    private List<T> notes;
    private ADSR adsr;
    private TimeSignature time;

    public LocalStream() {

        notes = new ArrayList<>();
    }

    public LocalStream(String soundProfile, List<T> notes, ADSR adsr, TimeSignature time) {
        this.soundProfile = soundProfile;
        this.notes = notes;
        this.adsr = adsr;
        this.time = time;
    }

    public void addNote(T note){
        notes.add(note);
    }

    public String getSoundProfile() {
        return soundProfile;
    }

    public void setSoundProfile(String soundProfile) {
        this.soundProfile = soundProfile;
    }

    public List<T> getNotes() {
        return notes;
    }

    public void setNotes(List<T> notes) {
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
        return "{soundProfile='" + soundProfile + '\n' +
                "notes=" + notes + '\n' +
                "adsr=" + adsr + '\n' +
                "time=" + time +
                '}';
    }
}
