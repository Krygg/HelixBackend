package Interpreter.AST.Nodes.statementNodes;

import Interpreter.AST.Node;
import Interpreter.AST.Nodes.statementNodes.StatementNode;

import java.util.ArrayList;
import java.util.List;

public class BlockNode extends StatementNode {
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
