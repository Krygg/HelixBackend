package Interpreter.AST.Nodes.statementNodes;

import Interpreter.AST.Nodes.statementNodes.StatementNode;

public class StartNode extends StatementNode {
    private String varName;

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    @Override
    public String toString() {
        return "StartNode{" + varName + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StartNode startNode = (StartNode) o;

        return varName != null ? varName.equals(startNode.varName) : startNode.varName == null;
    }

    @Override
    public int hashCode() {
        return varName != null ? varName.hashCode() : 0;
    }
}
