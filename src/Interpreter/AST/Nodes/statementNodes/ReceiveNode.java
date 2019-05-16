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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiveNode that = (ReceiveNode) o;

        if (channel != null ? !channel.equals(that.channel) : that.channel != null) return false;
        if (varName != null ? !varName.equals(that.varName) : that.varName != null) return false;
        return statement != null ? statement.equals(that.statement) : that.statement == null;
    }

    @Override
    public int hashCode() {
        int result = channel != null ? channel.hashCode() : 0;
        result = 31 * result + (varName != null ? varName.hashCode() : 0);
        result = 31 * result + (statement != null ? statement.hashCode() : 0);
        return result;
    }
}
