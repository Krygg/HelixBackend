package Interpreter.AST;

import Interpreter.AST.Nodes.expressionNodes.EqualNode;
import Interpreter.AST.Nodes.terminalNodes.AtomNode;
import Interpreter.Semantics;
import antlr.CFGLexer;
import antlr.CFGParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class TestClass {

    public static void main(String[] args) throws IOException {


        CharStream charStream = CharStreams.fromFileName("TestProgram");

        CFGLexer lexer = new CFGLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFGParser parser = new CFGParser(tokenStream);

        ParseTree tree = parser.program();

        BuildASTVisitor buildASTVisitor = new BuildASTVisitor();
        buildASTVisitor.visit(tree);

        System.out.println(buildASTVisitor.getNodeList());


        // Declaration of a number
        Semantics semantics = new Semantics();

        semantics.updateState(buildASTVisitor.getNodeList().get(1));
        semantics.updateState(buildASTVisitor.getNodeList().get(2));

        System.out.println(semantics.getState());


        // Equals
        /*AtomNode atomNode1 = new AtomNode();
        atomNode1.setValue("3");

        AtomNode atomNode2 = new AtomNode();
        atomNode2.setValue("2");

        EqualNode node = new EqualNode();
        node.setLeft(atomNode1);
        node.setRight(atomNode2);

        System.out.println(semantics.BexpSemantics(node));*/

    }

}
