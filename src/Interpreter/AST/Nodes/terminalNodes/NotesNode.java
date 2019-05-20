package Interpreter.AST.Nodes.terminalNodes;

import Interpreter.AST.Node;

import java.util.Objects;

/**Terminals*/
public class NotesNode implements Node {

    private String value;
    private String type;

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
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotesNode notesNode = (NotesNode) o;
        return Objects.equals(value, notesNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }
}
