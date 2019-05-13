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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlockNode blockNode = (BlockNode) o;

        return nodeList != null ? nodeList.equals(blockNode.nodeList) : blockNode.nodeList == null;
    }

    @Override
    public int hashCode() {
        return nodeList != null ? nodeList.hashCode() : 0;
    }
}
