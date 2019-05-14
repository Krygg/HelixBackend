package Interpreter;

import Interpreter.AST.Node;

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
}
