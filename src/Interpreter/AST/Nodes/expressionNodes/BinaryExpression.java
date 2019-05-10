package Interpreter.AST.Nodes.expressionNodes;

import Interpreter.AST.Node;

public class BinaryExpression extends ExpressionNode {
    private Node left;
    private Node right;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Binary {" +
                "left: " + left +
                ", right: " + right +
                '}';
    }
}
