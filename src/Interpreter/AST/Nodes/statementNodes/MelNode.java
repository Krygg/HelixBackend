package Interpreter.AST.Nodes.statementNodes;

import Interpreter.AST.Nodes.statementNodes.StatementNode;

public class MelNode extends StatementNode {

    private String varName;

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    @Override
    public String toString() {
        return "MelNode{" + varName + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MelNode melNode = (MelNode) o;

        return varName != null ? varName.equals(melNode.varName) : melNode.varName == null;
    }

    @Override
    public int hashCode() {
        return varName != null ? varName.hashCode() : 0;
    }
}
