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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotesNode notesNode = (NotesNode) o;

        return value != null ? value.equals(notesNode.value) : notesNode.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
