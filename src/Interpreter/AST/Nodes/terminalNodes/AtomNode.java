package Interpreter.AST.Nodes.terminalNodes;

import Interpreter.AST.Node;

import java.util.Objects;

public class AtomNode implements Node {

    private String value;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AtomNode atomNode = (AtomNode) o;
        return Objects.equals(value, atomNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }
}
