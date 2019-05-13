package Interpreter;

import terminals.LocalStream;

import java.util.HashMap;

public class EndConfiguration {

    private LocalStream localStream;
    private HashMap<String,Object> state;

    public EndConfiguration(LocalStream localStream, HashMap<String, Object> state) {
        this.localStream = localStream;
        this.state = state;
    }

    public LocalStream getLocalStream() {
        return localStream;
    }

    public void setLocalStream(LocalStream localStream) {
        this.localStream = localStream;
    }

    public HashMap<String, Object> getState() {
        return state;
    }

    public void setState(HashMap<String, Object> state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "EndConfiguration{" +
                "localStream=" + localStream +
                ", state=" + state +
                '}';
    }
}
