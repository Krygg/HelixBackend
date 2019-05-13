package terminals;


import java.util.List;

public class GlobalStream {

    private List<LocalStream> localStreams;

    public GlobalStream(List<LocalStream> localStreams) {
        this.localStreams = localStreams;
    }

    public List<LocalStream> getLocalStreams() {
        return localStreams;
    }

    public void setLocalStreams(List<LocalStream> localStreams) {
        this.localStreams = localStreams;
    }
}
