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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IfElseNode that = (IfElseNode) o;

        if (bool != null ? !bool.equals(that.bool) : that.bool != null) return false;
        if (stmtTrue != null ? !stmtTrue.equals(that.stmtTrue) : that.stmtTrue != null) return false;
        return stmtFalse != null ? stmtFalse.equals(that.stmtFalse) : that.stmtFalse == null;
    }

    @Override
    public int hashCode() {
        int result = bool != null ? bool.hashCode() : 0;
        result = 31 * result + (stmtTrue != null ? stmtTrue.hashCode() : 0);
        result = 31 * result + (stmtFalse != null ? stmtFalse.hashCode() : 0);
        return result;
    }
}
