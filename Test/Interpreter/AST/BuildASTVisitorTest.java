package Interpreter.AST;

import Interpreter.AST.Nodes.declarationNodes.*;
import Interpreter.AST.Nodes.expressionNodes.*;
import Interpreter.AST.Nodes.statementNodes.*;
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

        AtomNode node = new AtomNode();
        node.setValue("1");

        NumDecl test = new NumDecl();
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

        NotesNode node = new NotesNode();
        node.setValue("c4");

        NotesDecl test = new NotesDecl();
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

        BlockNode node = new BlockNode();
        node.addNode(null);

        InstDecl test = new InstDecl();
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

        InstDecl testInstrument = (InstDecl) visitor.getNodeList().get(1);

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

        InstDecl instrument = new InstDecl();
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
        CharStream charStream = CharStreams.fromString("num x = 3; Piano p { adsr(2,2,2,2);}");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        Declaration testInstrument = (Declaration) visitor.getNodeList().get(1);
        BlockNode node = (BlockNode) testInstrument.getValue();

        AtomNode atomNode = new AtomNode();
        atomNode.setValue("2");

        ADSRNode adsrNode = new ADSRNode();

        adsrNode.setExp1(atomNode);
        adsrNode.setExp2(atomNode);
        adsrNode.setExp3(atomNode);
        adsrNode.setExp4(atomNode);

        assertEquals(adsrNode, node.getNodeList().get(0));

    }

    @Test
    public void visitTime(){

        CharStream charStream = CharStreams.fromString("num x = 3; Piano p { time(4,4); }");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        Declaration testInstrument = (Declaration) visitor.getNodeList().get(1);
        BlockNode node = (BlockNode) testInstrument.getValue();

        TimeNode timeNode = new TimeNode();
        timeNode.setTop(4);
        timeNode.setBot(4);

        assertEquals(timeNode, node.getNodeList().get(0));

    }

    @Test
    public void visitSend(){

        CharStream charStream = CharStreams.fromString("num x = 3; Piano p { send(c,2); }");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        Declaration testInstrument = (Declaration) visitor.getNodeList().get(1);
        BlockNode node = (BlockNode) testInstrument.getValue();

        AtomNode atomNode = new AtomNode();
        atomNode.setValue("2");

        SendNode sendNode = new SendNode();
        sendNode.setChannel("c");
        sendNode.setValue(atomNode);

        assertEquals(sendNode, node.getNodeList().get(0));

    }

    @Test
    public void visitReceive(){

        CharStream charStream = CharStreams.fromString("num x = 3; num y = 4; Piano p { receive(c,x).y=8; }");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        Declaration testInstrument = (Declaration) visitor.getNodeList().get(2);
        BlockNode node = (BlockNode) testInstrument.getValue();

        AtomNode atomNode = new AtomNode();
        atomNode.setValue("8");

        AssignNode assignNode = new AssignNode();
        assignNode.setVarName("y");
        assignNode.setValue(atomNode);

        ReceiveNode receiveNode = new ReceiveNode();
        receiveNode.setChannel("c");
        receiveNode.setVarName("x");
        receiveNode.setStatement(assignNode);

        assertEquals(receiveNode, node.getNodeList().get(0));

    }

    @Test
    public void visitIfElse(){
        CharStream charStream = CharStreams.fromString("num x = 3; Piano p { if(2==2){}}");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        Declaration testInstrument = (Declaration) visitor.getNodeList().get(1);
        BlockNode node = (BlockNode) testInstrument.getValue();

        AtomNode atomNode = new AtomNode();
        atomNode.setValue("2");

        AtomNode atomNode1 = new AtomNode();
        atomNode1.setValue("4");

        AtomNode atomNode2 = new AtomNode();
        atomNode2.setValue("5");

        EqualNode equalNode = new EqualNode();
        equalNode.setLeft(atomNode);
        equalNode.setRight(atomNode);

        BlockNode blockNode1 = new BlockNode();
        blockNode1.addNode(null);

        IfElseNode ifElseNode = new IfElseNode();
        ifElseNode.setBool(equalNode);
        ifElseNode.setStmtTrue(blockNode1);

        assertEquals(ifElseNode, node.getNodeList().get(0));

    }

    @Test
    public void visitNBExp(){
        CharStream charStream = CharStreams.fromString("num x = 3; Piano p { if(!(2==2)){x = 4} else{x = 5}}");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        Declaration testInstrument = (Declaration) visitor.getNodeList().get(1);
        BlockNode node = (BlockNode) testInstrument.getValue();
        IfElseNode ifElseNode = (IfElseNode) node.getNodeList().get(0);

        AtomNode atomNode = new AtomNode();
        atomNode.setValue("2");

        EqualNode equalNode = new EqualNode();
        equalNode.setLeft(atomNode);
        equalNode.setRight(atomNode);

        NotNode notNode = new NotNode();
        notNode.setExpressionNode(equalNode);

        assertEquals(notNode, ifElseNode.getBool());
    }

    @Test
    public void visitBExp1(){
        CharStream charStream = CharStreams.fromString("num x = 3; Piano p { if(2==2){x = 4} else{x = 5}}");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        Declaration testInstrument = (Declaration) visitor.getNodeList().get(1);
        BlockNode node = (BlockNode) testInstrument.getValue();
        IfElseNode ifElseNode = (IfElseNode) node.getNodeList().get(0);

        AtomNode atomNode = new AtomNode();
        atomNode.setValue("2");

        EqualNode equalNode = new EqualNode();
        equalNode.setLeft(atomNode);
        equalNode.setRight(atomNode);

        assertEquals(equalNode, ifElseNode.getBool());
    }

    @Test
    public void visitBExp2(){
        CharStream charStream = CharStreams.fromString("num x = 3; Piano p { if((2==2)==(2==2)){x = 4} else{x = 5}}");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        Declaration testInstrument = (Declaration) visitor.getNodeList().get(1);
        BlockNode node = (BlockNode) testInstrument.getValue();
        IfElseNode ifElseNode = (IfElseNode) node.getNodeList().get(0);

        AtomNode atomNode = new AtomNode();
        atomNode.setValue("2");

        EqualNode equalNode1 = new EqualNode();
        equalNode1.setLeft(atomNode);
        equalNode1.setRight(atomNode);

        EqualNode equalNode2 = new EqualNode();
        equalNode2.setLeft(atomNode);
        equalNode2.setRight(atomNode);

        EqualNode equalNode = new EqualNode();
        equalNode.setLeft(equalNode1);
        equalNode.setRight(equalNode2);

        assertEquals(equalNode, ifElseNode.getBool());
    }

    @Test
    public void visitAExp(){

        CharStream charStream = CharStreams.fromString("num x = 3+3-3;");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        NumDecl numDecl = (NumDecl) visitor.getNodeList().get(0);

        AtomNode atomNode = new AtomNode();
        atomNode.setValue("3");

        PlusNode plusNode = new PlusNode();
        plusNode.setLeft(atomNode);
        plusNode.setRight(atomNode);

        MinusNode minusNode = new MinusNode();
        minusNode.setLeft(plusNode);
        minusNode.setRight(atomNode);

        assertEquals(minusNode, numDecl.getValue());

    }

    @Test
    public void visitMultExp(){

        CharStream charStream = CharStreams.fromString("num x = 3+3*3;");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        NumDecl numDecl = (NumDecl) visitor.getNodeList().get(0);

        AtomNode atomNode = new AtomNode();
        atomNode.setValue("3");

        MultNode multNode = new MultNode();
        multNode.setLeft(atomNode);
        multNode.setRight(atomNode);

        PlusNode plusNode = new PlusNode();
        plusNode.setLeft(atomNode);
        plusNode.setRight(multNode);

        assertEquals(plusNode, numDecl.getValue());
    }

    @Test
    public void visitParan(){

        CharStream charStream = CharStreams.fromString("num x = (3+3)*3;");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        NumDecl numDecl = (NumDecl) visitor.getNodeList().get(0);

        AtomNode atomNode = new AtomNode();
        atomNode.setValue("3");

        PlusNode plusNode = new PlusNode();
        plusNode.setLeft(atomNode);
        plusNode.setRight(atomNode);

        MultNode multNode = new MultNode();
        multNode.setLeft(plusNode);
        multNode.setRight(atomNode);

        assertEquals(multNode, numDecl.getValue());
    }

    @Test
    public void visitAtomVar(){

        CharStream charStream = CharStreams.fromString("num x = 3; num y = x;");
        BuildASTVisitor visitor = new BuildASTVisitor();

        AST(charStream, visitor);

        NumDecl numDecl = (NumDecl) visitor.getNodeList().get(1);

        AtomNode atomNode = new AtomNode();
        atomNode.setValue("x");

        assertEquals(atomNode, numDecl.getValue());
    }


    private void AST(CharStream charStream, BuildASTVisitor visitor){

        CFGLexer lexer = new CFGLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFGParser parser = new CFGParser(tokenStream);

        ParseTree tree = parser.program();

        visitor.visit(tree);
    }
}