package Interpreter.AST.Nodes.statementNodes;

import Interpreter.AST.Nodes.statementNodes.StatementNode;

public class TimeNode extends StatementNode {

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
        return "TimeNode{" + top +
                "," + bot +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeNode timeNode = (TimeNode) o;

        if (top != timeNode.top) return false;
        return bot == timeNode.bot;
    }

    @Override
    public int hashCode() {
        int result = top;
        result = 31 * result + bot;
        return result;
    }
}
