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
}
