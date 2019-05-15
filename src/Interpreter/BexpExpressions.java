package Interpreter;

import Interpreter.AST.EndConfiguration;
import Interpreter.AST.Node;
import Interpreter.AST.Nodes.expressionNodes.*;
import Interpreter.AST.Nodes.statementNodes.AssignNode;
import Interpreter.AST.Nodes.terminalNodes.AtomNode;
import terminals.LocalStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BexpExpressions {

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

            return Integer.parseInt(atomNode.getValue());
        }

        throw new IllegalArgumentException();

    }


    /**
     * Semantics for boolean expressions
     */
    //TODO: Missing NOT since the precedence doesn't make sense - Det giver stadig ikke mening, den returnere kun false
    public Boolean BexpSemantics(Node node) {

        // Equals Expression
        if (node instanceof EqualNode) {

            EqualNode equalNode = (EqualNode) node;

            return BexpSemantics(equalNode.getLeft()) == BexpSemantics(equalNode.getRight());
        }

        // NOT Expression
        if (node instanceof NotNode) {

            NotNode notNode = (NotNode) node;

            return !(BexpSemantics(notNode.getExpressionNode()));
        }

        // Arithmetic Expression - Sikring mod Rekursive kald af BexpSemantics
        if (node instanceof BinaryExpression) {

            BinaryExpression binaryExpression = (BinaryExpression) node;

            AexpSemantics(binaryExpression);

            return true;
        } else if (node instanceof AtomNode) {

            AtomNode atomNode = (AtomNode) node;

            AexpSemantics(atomNode);

            return false;

        }

        throw new IllegalArgumentException();
    }

    // TODO: lige begyndt med det her, if statement kan ikke laves da BexpSemantics ikke er helt færdig
    public EndConfiguration statementsSemantics(Node node, HashMap<String, Object> state, LocalStream localStream) {

        // Assign Statement
        if (node instanceof AssignNode) {
            AssignNode assignNode = (AssignNode) node;

            Node nodeValue = assignNode.getValue();

            if (nodeValue instanceof ExpressionNode || nodeValue instanceof AtomNode) {
                int value = AexpSemantics(nodeValue);
                state.replace(assignNode.getVarName(), value);
            }

            return new EndConfiguration(localStream, state);
        }

        throw new IllegalArgumentException();

    }


}
