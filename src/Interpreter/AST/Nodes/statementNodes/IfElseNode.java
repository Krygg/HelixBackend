package Interpreter.AST.Nodes.statementNodes;

import Interpreter.AST.Node;
import Interpreter.AST.Nodes.statementNodes.StatementNode;

public class IfElseNode extends StatementNode {

    private Node bool;
    private Node stmtTrue;
    private Node stmtFalse;

    public Node getBool() {
        return bool;
    }

    public void setBool(Node bool) {
        this.bool = bool;
    }

    public Node getStmtTrue() {
        return stmtTrue;
    }

    public void setStmtTrue(Node stmtTrue) {
        this.stmtTrue = stmtTrue;
    }

    public Node getStmtFalse() {
        return stmtFalse;
    }

    public void setStmtFalse(Node stmtFalse) {
        this.stmtFalse = stmtFalse;
    }

    @Override
    public String toString() {
        return "IfElseNode{" + bool +
                "," + stmtTrue +
                "," + stmtFalse +
                '}';
    }
}
