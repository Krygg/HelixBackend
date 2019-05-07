package AST;

import java.util.ArrayList;
import java.util.List;

class Node {}

/**Declaration node*/
class Declaration extends Node{
    private String type;
    private String varName;
    private Node value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
}

class BPMDeclaration extends Node{
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

/**Statement nodes*/
class StatementNode extends Node{}

class StartNode extends StatementNode{
    private String varName;

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }
}

class AssignNode extends StatementNode{

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
        return "AssignNode{" +
                "varName='" + varName + '\'' +
                ", value=" + value +
                '}';
    }
}

class BlockNode extends StatementNode {
    private List<Node> nodeList = new ArrayList<>();

    public void addNode(Node node){
        nodeList.add(node);
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }
}

class SemiNode extends StatementNode{

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
}

/**Expression nodes*/
class ExpressionNode extends Node{}

class BinaryExpression extends ExpressionNode{
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
        return "Binary { \n" +
                "left=" + left + "\n" +
                "right=" + right + "\n" +
                '}';
    }
}

class PlusNode extends BinaryExpression{}
class MinusNode extends BinaryExpression{}
class MultNode extends BinaryExpression{}

class UnaryExpression extends ExpressionNode{
    private ExpressionNode expressionNode;

    public ExpressionNode getExpressionNode() {
        return expressionNode;
    }

    public void setExpressionNode(ExpressionNode expressionNode) {
        this.expressionNode = expressionNode;
    }
}

/**Terminals*/
class NotesNode extends Node {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "NotesNode{" +
                "value='" + value + '\'' +
                '}';
    }
}
class AtomNode extends Node{
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AtomNode{" +
                "value='" + value + '\'' +
                '}';
    }
}