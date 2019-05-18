package Interpreter.AST.Nodes.statementNodes;

import Interpreter.AST.Node;

import java.util.Objects;

/**Statement nodes*/
public class StatementNode implements Node {

    private String type;

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatementNode that = (StatementNode) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
