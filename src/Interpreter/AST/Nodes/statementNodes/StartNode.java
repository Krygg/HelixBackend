package Interpreter.AST.Nodes.statementNodes;

public class StartNode extends StatementNode {

    private String varName;

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    @Override
    public String toString() {
        return "StartNode{" + varName + '}';
    }

}
