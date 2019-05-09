package Interpreter.AST.Nodes.terminalNodes;

import Interpreter.AST.Node;

public class AtomNode implements Node {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AtomNode{" + value + '}';
    }
}
