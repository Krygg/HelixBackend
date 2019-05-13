package terminals;


import java.util.ArrayList;
import java.util.List;

public class GlobalStream {

    private List<LocalStream> localStreams;

    public GlobalStream() {

        localStreams  = new ArrayList<>();
    }

    public GlobalStream(List<LocalStream> localStreams) {
        this.localStreams = localStreams;
    }

    public void addStream(LocalStream stream){

        localStreams.add(stream);
    }

    public List<LocalStream> getLocalStreams() {
        return localStreams;
    }

    public void setLocalStreams(List<LocalStream> localStreams) {
        this.localStreams = localStreams;
    }

    @Override
    public String toString() {
        return "GlobalStream{" +
                "localStreams=" + localStreams +
                '}';
    }
}
