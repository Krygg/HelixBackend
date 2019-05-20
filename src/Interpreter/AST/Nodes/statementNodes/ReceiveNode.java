package Interpreter.AST.Nodes.statementNodes;

import Interpreter.AST.Node;
import Interpreter.AST.Nodes.statementNodes.StatementNode;

public class ReceiveNode extends StatementNode {

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

    @Override
    public String toString() {
        return "ReceiveNode{" + channel +
                ",'" + varName +
                "," + statement +
                '}';
    }
}
