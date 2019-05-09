package Interpreter.AST.Nodes.terminalNodes;

import Interpreter.AST.Node;

/**Terminals*/
public class NotesNode implements Node {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NotesNode{" + value + '}';
    }
}
