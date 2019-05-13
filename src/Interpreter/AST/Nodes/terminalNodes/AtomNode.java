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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AtomNode atomNode = (AtomNode) o;

        return value != null ? value.equals(atomNode.value) : atomNode.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
