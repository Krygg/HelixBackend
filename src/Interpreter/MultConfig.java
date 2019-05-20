package Interpreter;

import Interpreter.AST.Node;
import Interpreter.AST.Nodes.statementNodes.BlockNode;
import terminals.LocalStream;

import java.util.Objects;

public class MultConfig {

    private Node body;
    private LocalStream stream ;

    public MultConfig(Node body, LocalStream stream) {
        this.body = body;
        this.stream = stream;
    }

    public Node getBody() {
        return body;
    }

    public void setBody(BlockNode body) {
        this.body = body;
    }

    public LocalStream getStream() {
        return stream;
    }

    public void setStream(LocalStream stream) {
        this.stream = stream;
    }

    @Override
    public String toString() {
        return "MultConfig{" +
                "\n" + body +
                "\n stream: " + stream +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultConfig that = (MultConfig) o;
        return Objects.equals(body, that.body) &&
                Objects.equals(stream, that.stream);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, stream);
    }
}
