package terminals;

import java.util.Objects;

public class TimeSignature {

    private int n1;
    private int n2;

    public TimeSignature(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    @Override
    public String toString() {
        return "TimeSignature{" +
                "n1=" + n1 +
                ", n2=" + n2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSignature that = (TimeSignature) o;
        return n1 == that.n1 &&
                n2 == that.n2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n1, n2);
    }
}
