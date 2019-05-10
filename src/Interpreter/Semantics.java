package Interpreter;

import Interpreter.AST.Node;
import Interpreter.AST.Nodes.declarationNodes.Declaration;
import Interpreter.AST.Nodes.expressionNodes.*;
import Interpreter.AST.Nodes.statementNodes.AssignNode;
import Interpreter.AST.Nodes.terminalNodes.AtomNode;
import Interpreter.AST.Nodes.terminalNodes.NotesNode;

import java.util.HashMap;

public class Semantics {

    private HashMap<String, Object> state = new HashMap<>();

    /**
     * Update the state
     */
    public void updateState(Node node) {


        if (node instanceof Declaration) {

            Declaration declNode = (Declaration) node;

            Node nodeValue = declNode.getValue();

            // A num variable has been declared
            if (nodeValue instanceof ExpressionNode || nodeValue instanceof AtomNode) {

                int value = AexpSemantics(nodeValue);

                state.put(declNode.getVarName(), value);
            }

            //TODO: doesn't work yet
            else if (nodeValue instanceof NotesNode) {

                String value = "KEY";

                state.put(declNode.getVarName(), value);
            }

        } else if (node instanceof AssignNode) {

            AssignNode assignNode = (AssignNode) node;

            Node nodeValue = assignNode.getValue();


            if (nodeValue instanceof ExpressionNode || nodeValue instanceof AtomNode) {
                int value = AexpSemantics(nodeValue);

                state.replace(assignNode.getVarName(), value);
            }
        }


    }

    /**
     * Semantics for arithmetic expressions
     */
    public int AexpSemantics(Node node) {


        // Plus expression
        if (node instanceof PlusNode) {

            PlusNode plusNode = (PlusNode) node;

            return AexpSemantics(plusNode.getLeft()) + AexpSemantics(plusNode.getRight());

        }

        // Minus expression
        else if (node instanceof MinusNode) {

            MinusNode minusNode = (MinusNode) node;

            return AexpSemantics(minusNode.getLeft()) - AexpSemantics(minusNode.getRight());

        }

        // Multiplication expression
        else if (node instanceof MultNode) {

            MultNode multNode = (MultNode) node;

            return AexpSemantics(multNode.getLeft()) * AexpSemantics(multNode.getRight());

        }

        // Terminal
        else if (node instanceof AtomNode) {

            AtomNode atomNode = (AtomNode) node;

            // If it's a variable name
            if (state.containsKey(atomNode.getValue())) {

                return Integer.parseInt(state.get(atomNode.getValue()).toString());
            }

            return Integer.parseInt(atomNode.getValue());
        }

        throw new IllegalArgumentException();

    }

    /**
     * Semantics for boolean expressions
     */
    //TODO: Missing NOT since the precedence doesn't make sense
    public Boolean BexpSemantics(Node node) {

        if (node instanceof EqualNode) {

            return AexpSemantics(((EqualNode) node).getLeft()) == AexpSemantics(((EqualNode) node).getRight());
        }

        return true;
    }

    public HashMap<String, Object> getState() {
        return state;
    }

    public void setState(HashMap<String, Object> state) {
        this.state = state;
    }
}
