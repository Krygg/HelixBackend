package Interpreter.AST.Nodes.expressionNodes;

import Interpreter.AST.Node;
import Interpreter.AST.Nodes.expressionNodes.ExpressionNode;

public class UnaryExpression extends ExpressionNode {
    private Node expressionNode;

    public Node getExpressionNode() {
        return expressionNode;
    }

    public void setExpressionNode(Node expressionNode) {
        this.expressionNode = expressionNode;
    }

    @Override
    public String toString() {
        return "UnaryExpression{" + expressionNode + '}';
    }
}
