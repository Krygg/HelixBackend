package Interpreter.AST.Nodes.expressionNodes;

import Interpreter.AST.Node;
import Interpreter.AST.Nodes.expressionNodes.ExpressionNode;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnaryExpression that = (UnaryExpression) o;
        return Objects.equals(expressionNode, that.expressionNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expressionNode);
    }
}
