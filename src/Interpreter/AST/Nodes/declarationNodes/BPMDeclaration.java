package Interpreter.AST.Nodes.declarationNodes;

import Interpreter.AST.Node;

public class BPMDeclaration implements Node {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BPM{" + value + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BPMDeclaration that = (BPMDeclaration) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String getType() {
        return "num";
    }
}
