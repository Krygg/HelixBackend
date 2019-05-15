package Interpreter;

import Interpreter.AST.Node;

import java.util.Objects;

public class InstrumentInfo {

    private String soundProfile;
    private Node node;

    public InstrumentInfo(String soundProfile, Node node) {
        this.soundProfile = soundProfile;
        this.node = node;
    }

    public String getSoundProfile() {
        return soundProfile;
    }

    public void setSoundProfile(String soundProfile) {
        this.soundProfile = soundProfile;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstrumentInfo info = (InstrumentInfo) o;
        return Objects.equals(soundProfile, info.soundProfile) &&
                Objects.equals(node, info.node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soundProfile, node);
    }
}
