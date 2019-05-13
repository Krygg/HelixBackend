package Interpreter.AST;

import Interpreter.AST.Nodes.declarationNodes.BPMDeclaration;
import Interpreter.AST.Nodes.declarationNodes.Declaration;
import Interpreter.AST.Nodes.statementNodes.AssignNode;
import Interpreter.AST.Nodes.statementNodes.BlockNode;
import Interpreter.AST.Nodes.statementNodes.MelNode;
import Interpreter.AST.Nodes.statementNodes.StartNode;
import Interpreter.AST.Nodes.terminalNodes.AtomNode;
import Interpreter.AST.Nodes.terminalNodes.NotesNode;
import Interpreter.Semantics;
import antlr.CFGLexer;
import antlr.CFGParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildASTVisitorTest {

    @Test
    public void visitDb(){
        CharStream charStream = CharStreams.fromString("bpm(128);");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        BPMDeclaration bpm = new BPMDeclaration();
        bpm.setValue(128);

        assertEquals(bpm,visitor.getNodeList().get(0));
    }

    @Test
    public void visitDv1(){
        CharStream charStream = CharStreams.fromString("num x = 1;");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        Declaration test = new Declaration();
        AtomNode node = new AtomNode();
        node.setValue("1");

        test.setType("num");
        test.setVarName("x");
        test.setValue(node);

        assertEquals(test,visitor.getNodeList().get(0));
    }

    @Test
    public void visitDv2(){
        CharStream charStream = CharStreams.fromString("notes x = c4;");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        Declaration test = new Declaration();
        NotesNode node = new NotesNode();
        node.setValue("c4");

        test.setType("notes");
        test.setVarName("x");
        test.setValue(node);

        assertEquals(test,visitor.getNodeList().get(0));
    }

    @Test
    public void visitDi(){

        CharStream charStream = CharStreams.fromString("Piano p {}");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        Declaration test = new Declaration();
        BlockNode node = new BlockNode();
        node.addNode(null);

        test.setType("Piano");
        test.setVarName("p");
        test.setValue(node);

        assertEquals(test,visitor.getNodeList().get(0));

    }

    @Test
    public void visitSp(){
        CharStream charStream = CharStreams.fromString("start p;");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        StartNode start = new StartNode();
        start.setVarName("p");

        assertEquals(start, visitor.getNodeList().get(0));
    }

    @Test
    public void visitStmts(){
        CharStream charStream = CharStreams.fromString("num x = 3; Piano p { x = 1; x = 6;}");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        Declaration testInstrument = (Declaration) visitor.getNodeList().get(1);

        AtomNode atomNode1 = new AtomNode();
        atomNode1.setValue("1");

        AssignNode assignNode1 = new AssignNode();
        assignNode1.setVarName("x");
        assignNode1.setValue(atomNode1);

        AtomNode atomNode2 = new AtomNode();
        atomNode2.setValue("6");

        AssignNode assignNode2 = new AssignNode();
        assignNode2.setVarName("x");
        assignNode2.setValue(atomNode2);

        BlockNode node = new BlockNode();
        node.addNode(assignNode1);
        node.addNode(assignNode2);

        Declaration instrument = new Declaration();
        instrument.setType("Piano");
        instrument.setVarName("p");
        instrument.setValue(node);


        assertEquals(instrument, testInstrument);
    }

    @Test
    public void visitAssignStmt(){

        CharStream charStream = CharStreams.fromString("num x = 3; Piano p { x = 1;}");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        Declaration testInstrument = (Declaration) visitor.getNodeList().get(1);
        BlockNode node = (BlockNode) testInstrument.getValue();

        AtomNode atomNode1 = new AtomNode();
        atomNode1.setValue("1");

        AssignNode assignNode = new AssignNode();
        assignNode.setVarName("x");
        assignNode.setValue(atomNode1);

        assertEquals(assignNode, node.getNodeList().get(0));
    }

    @Test
    public void visitStart(){
        CharStream charStream = CharStreams.fromString("num x = 3; Piano p { start p;}");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        Declaration testInstrument = (Declaration) visitor.getNodeList().get(1);
        BlockNode node = (BlockNode) testInstrument.getValue();

        StartNode start = new StartNode();
        start.setVarName("p");

        assertEquals(start, node.getNodeList().get(0));
    }

    @Test
    public void visitMel(){
        CharStream charStream = CharStreams.fromString("num x = 3; Piano p { mel(x);}");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        Declaration testInstrument = (Declaration) visitor.getNodeList().get(1);
        BlockNode node = (BlockNode) testInstrument.getValue();

        MelNode melNode = new MelNode();
        melNode.setVarName("x");

        assertEquals(melNode, node.getNodeList().get(0));
    }

    @Test
    public void visitADSR(){
        CharStream charStream = CharStreams.fromString("num x = 3; Piano p { adsr(2,3,4,1);}");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

    }

    private void AST(CharStream charStream, BuildASTVisitor visitor){

        CFGLexer lexer = new CFGLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFGParser parser = new CFGParser(tokenStream);

        ParseTree tree = parser.program();

        visitor.visit(tree);
    }
}