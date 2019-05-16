package terminals;

import java.util.Objects;

public class ADSR {

    private int attack;
    private int decay;
    private int sustain;
    private int release;

    public ADSR(int attack, int decay, int sustain, int release) {
        this.attack = attack;
        this.decay = decay;
        this.sustain = sustain;
        this.release = release;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDecay() {
        return decay;
    }

    public void setDecay(int decay) {
        this.decay = decay;
    }

    public int getSustain() {
        return sustain;
    }

    public void setSustain(int sustain) {
        this.sustain = sustain;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ADSR adsr = (ADSR) o;
        return attack == adsr.attack &&
                decay == adsr.decay &&
                sustain == adsr.sustain &&
                release == adsr.release;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attack, decay, sustain, release);
    }
}
