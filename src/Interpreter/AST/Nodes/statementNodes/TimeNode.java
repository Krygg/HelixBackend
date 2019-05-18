package Interpreter.AST.Nodes.statementNodes;

import Interpreter.AST.Nodes.statementNodes.StatementNode;

public class TimeNode extends StatementNode {

    private int top;
    private int bot;
    private String type;

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
        return "TimeNode{" + top +
                "," + bot +
                '}';
    }

}
