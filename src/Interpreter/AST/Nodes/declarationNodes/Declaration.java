package Interpreter.AST.Nodes.declarationNodes;

import Interpreter.AST.Node;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Declaration that = (Declaration) o;
        return Objects.equals(type, that.type) &&
                Objects.equals(varName, that.varName) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, varName, value);
    }
}
