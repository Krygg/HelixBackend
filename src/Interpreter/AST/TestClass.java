package Interpreter.AST;

import Interpreter.AST.Nodes.declarationNodes.Declaration;
import Interpreter.AST.Nodes.expressionNodes.EqualNode;
import Interpreter.AST.Nodes.expressionNodes.NotNode;
import Interpreter.AST.Nodes.statementNodes.AssignNode;
import Interpreter.AST.Nodes.statementNodes.BlockNode;
import Interpreter.AST.Nodes.terminalNodes.AtomNode;
import Interpreter.AST.Nodes.terminalNodes.NotesNode;
import Interpreter.Semantics;
import antlr.CFGLexer;
import antlr.CFGParser;
import com.company.MidiLookUp;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import terminals.LocalStream;

import java.io.IOException;
import java.util.HashMap;

public class TestClass {

    public static void main(String[] args) throws IOException {

        CharStream charStream = CharStreams.fromFileName("TestProgram");

        CFGLexer lexer = new CFGLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFGParser parser = new CFGParser(tokenStream);

        ParseTree tree = parser.program();

        BuildASTVisitor buildASTVisitor = new BuildASTVisitor();
        buildASTVisitor.visit(tree);

        //System.out.println(buildASTVisitor.getNodeList());




        // Assignment
        /* Semantics semantics = new Semantics();

        HashMap<String, Object> state = new HashMap<>();
        state.put("x", "5");

        LocalStream localStream = new LocalStream();

        AtomNode atomNode1 = new AtomNode();
        atomNode1.setValue("3");

        AssignNode assignNode = new AssignNode();
        assignNode.setVarName("x");
        assignNode.setValue(atomNode1);

        System.out.println(semantics.statementsSemantics(assignNode,state,localStream));*/




        // Notes declaration
        /* Semantics semantics = new Semantics();

        Declaration notesDecl = new Declaration();
        NotesNode notes = new NotesNode();
        notes.setValue("c4,(c4,c5),c4");

        notesDecl.setVarName("chordC4");
        notesDecl.setValue(notes);

        semantics.varDeclSemantics(notesDecl);

        System.out.println(semantics.getState());*/





        // Declaration of a number
        /*Semantics semantics = new Semantics();

        semantics.updateState(buildASTVisitor.getNodeList().get(1));
        semantics.updateState(buildASTVisitor.getNodeList().get(2));

        System.out.println(semantics.getState());


        Declaration test = (Declaration) buildASTVisitor.getNodeList().get(3);

        BlockNode node = (BlockNode) test.getValue();

        semantics.updateState(node.getNodeList().get(0));

        System.out.println(semantics.getState());*/




        // Equals
        /*Semantics semantics = new Semantics();

        AtomNode atomNode1 = new AtomNode();
        atomNode1.setValue("3");

        AtomNode atomNode2 = new AtomNode();
        atomNode2.setValue("4");

        EqualNode node2 = new EqualNode();
        node2.setLeft(atomNode1);
        node2.setRight(atomNode1);

        EqualNode node3 = new EqualNode();
        node3.setLeft(atomNode1);
        node3.setRight(atomNode2);

        EqualNode node = new EqualNode();
        node.setLeft(node2);
        node.setRight(node3);

        NotNode notNode = new NotNode();
        notNode.setExpressionNode(node);

        System.out.println(semantics.bexpSemantics(node));*/

    }

}
