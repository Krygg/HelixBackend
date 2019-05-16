package Interpreter;

import Interpreter.AST.Node;
import Interpreter.AST.Nodes.statementNodes.BlockNode;
import terminals.LocalStream;

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
}
