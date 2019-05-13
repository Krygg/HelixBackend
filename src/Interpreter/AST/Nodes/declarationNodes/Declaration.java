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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Declaration that = (Declaration) o;

        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (varName != null ? !varName.equals(that.varName) : that.varName != null) return false;
        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (varName != null ? varName.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
