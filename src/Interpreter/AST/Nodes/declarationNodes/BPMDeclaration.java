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
}
