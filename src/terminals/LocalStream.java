package terminals;

import com.company.Instrument;

import java.util.List;

public class LocalStream {

    private String soundProfile;
    private List<Note> notes;
    private ADSR adsr;
    private TimeSignature time;

    public LocalStream() {
    }

    public LocalStream(String soundProfile, List<Note> notes, ADSR adsr, TimeSignature time) {
        this.soundProfile = soundProfile;
        this.notes = notes;
        this.adsr = adsr;
        this.time = time;
    }

    public String getSoundProfile() {
        return soundProfile;
    }

    public void setSoundProfile(String soundProfile) {
        this.soundProfile = soundProfile;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
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
}
