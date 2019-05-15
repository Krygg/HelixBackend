package Interpreter.AST.Nodes.statementNodes;

import Interpreter.AST.Node;
import Interpreter.AST.Nodes.statementNodes.StatementNode;

public class ADSRNode extends StatementNode {

    private Node exp1;
    private Node exp2;
    private Node exp3;
    private Node exp4;

    public Node getExp1() {
        return exp1;
    }

    public void setExp1(Node exp1) {
        this.exp1 = exp1;
    }

    public Node getExp2() {
        return exp2;
    }

    public void setExp2(Node exp2) {
        this.exp2 = exp2;
    }

    public Node getExp3() {
        return exp3;
    }

    public void setExp3(Node exp3) {
        this.exp3 = exp3;
    }

    public Node getExp4() {
        return exp4;
    }

    public void setExp4(Node exp4) {
        this.exp4 = exp4;
    }

    @Override
    public String toString() {
        return "ADSRNode{" + exp1 +
                "," + exp2 +
                "," + exp3 +
                "," + exp4 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ADSRNode adsrNode = (ADSRNode) o;

        if (exp1 != null ? !exp1.equals(adsrNode.exp1) : adsrNode.exp1 != null) return false;
        if (exp2 != null ? !exp2.equals(adsrNode.exp2) : adsrNode.exp2 != null) return false;
        if (exp3 != null ? !exp3.equals(adsrNode.exp3) : adsrNode.exp3 != null) return false;
        return exp4 != null ? exp4.equals(adsrNode.exp4) : adsrNode.exp4 == null;
    }

    @Override
    public int hashCode() {
        int result = exp1 != null ? exp1.hashCode() : 0;
        result = 31 * result + (exp2 != null ? exp2.hashCode() : 0);
        result = 31 * result + (exp3 != null ? exp3.hashCode() : 0);
        result = 31 * result + (exp4 != null ? exp4.hashCode() : 0);
        return result;
    }
}
