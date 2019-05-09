package Interpreter.AST.Nodes.declarationNodes;

import Interpreter.AST.Node;

/**Declaration node*/
public class Declaration implements Node {
    private String type;
    private String varName;
    private Node value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName = varName;
    }

    public Node getValue() {
        return value;
    }

    public void setValue(Node value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Declaration{" + type + "," + varName + "," + value + '}';
    }
}
