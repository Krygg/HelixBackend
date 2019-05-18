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

}
