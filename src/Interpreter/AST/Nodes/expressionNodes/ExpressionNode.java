package Interpreter.AST.Nodes.expressionNodes;

import Interpreter.AST.Node;

/**Expression nodes*/
public class ExpressionNode implements Node {

    private String type;

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
