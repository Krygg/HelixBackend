package Interpreter.AST.Nodes.statementNodes;

import Interpreter.AST.Node;
import Interpreter.AST.Nodes.statementNodes.StatementNode;

public class AssignNode extends StatementNode {

    private String varName;
    private Node value;

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public Node getValue() {
        return value;
    }

    public void setValue(Node value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AssignNode{" + varName + "," + value + '}';
    }
}
