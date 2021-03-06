package Interpreter.AST.Nodes.statementNodes;

import Interpreter.AST.Node;
import Interpreter.AST.Nodes.statementNodes.StatementNode;

public class SendNode extends StatementNode {

    private String channel;
    private String channelType;
    private Node value;


    public String getChannelType() { return channelType; }

    public void setChannelType(String channelType) { this.channelType = channelType; }

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
        return "SendNode{" + channel +
                "," + value +
                '}';
    }
}
