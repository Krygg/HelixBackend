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

class MelNode extends StatementNode{

    private String varName;

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    @Override
    public String toString() {
        return "MelNode{" +
                "varName='" + varName + '\'' +
                '}';
    }
}

class ADSRNode extends StatementNode{

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
        return "ADSRNode{" +
                "exp1=" + exp1 +
                ", exp2=" + exp2 +
                ", exp3=" + exp3 +
                ", exp4=" + exp4 +
                '}';
    }
}

class TimeNode extends StatementNode{

    private int top;
    private int bot;

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getBot() {
        return bot;
    }

    public void setBot(int bot) {
        this.bot = bot;
    }

    @Override
    public String toString() {
        return "TimeNode{" +
                "top=" + top +
                ", bot=" + bot +
                '}';
    }
}

class SendNode extends StatementNode{

    private String channel;
    private Node value;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Node getValue() {
        return value;
    }

    public void setValue(Node value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SendNode{" +
                "channel='" + channel + '\'' +
                ", value=" + value +
                '}';
    }
}

class ReceiveNode extends StatementNode{

    private String channel;
    private String varName;
    private Node statement;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public Node getStatement() {
        return statement;
    }

    public void setStatement(Node statement) {
        this.statement = statement;
    }
}

class IfElseNode extends StatementNode{

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
        return "IfElseNode{" +
                "bool=" + bool +
                ", stmtTrue=" + stmtTrue +
                ", stmtFalse=" + stmtFalse +
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

    @Override
    public String toString() {
        return "BlockNode" + nodeList;
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
class EqualNode extends BinaryExpression{}

class UnaryExpression extends ExpressionNode{
    private Node expressionNode;

    public Node getExpressionNode() {
        return expressionNode;
    }

    public void setExpressionNode(Node expressionNode) {
        this.expressionNode = expressionNode;
    }

    @Override
    public String toString() {
        return "UnaryExpression{" +
                "expressionNode=" + expressionNode +
                '}';
    }
}
class NotNode extends UnaryExpression{}

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