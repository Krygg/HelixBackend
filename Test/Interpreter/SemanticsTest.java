package Interpreter;

import Interpreter.AST.BuildASTVisitor;
import Interpreter.AST.Nodes.declarationNodes.BPMDeclaration;
import Interpreter.AST.Nodes.declarationNodes.InstDecl;
import Interpreter.AST.Nodes.declarationNodes.NotesDecl;
import Interpreter.AST.Nodes.declarationNodes.NumDecl;
import Interpreter.AST.Nodes.expressionNodes.EqualNode;
import Interpreter.AST.Nodes.expressionNodes.NotNode;
import Interpreter.AST.Nodes.statementNodes.*;
import Interpreter.AST.Nodes.terminalNodes.AtomNode;
import Interpreter.AST.Nodes.terminalNodes.NotesNode;
import antlr.CFGLexer;
import antlr.CFGParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;
import terminals.ADSR;
import terminals.GlobalStream;
import terminals.LocalStream;
import terminals.TimeSignature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class SemanticsTest {

    private Semantics semantics;
    private HashMap<String, Object> state;
    private HashMap<String, InstrumentInfo> envI;
    private HashMap<BlockNode, Object> multMap;
    private LocalStream<LocalStream> localStream;
    private GlobalStream globalStream;

    @Before
    public void setUp() throws Exception {

        semantics = new Semantics();

        // Maps
        state = new HashMap<>();
        envI = new HashMap<>();
        multMap = new HashMap<>();

        // Streams
        localStream = new LocalStream<>();
        globalStream = new GlobalStream();

    }

    @Test
    public void bpm(){

        BPMDeclaration bpm = new BPMDeclaration();
        bpm.setValue(128);

        semantics.bpmDeclSemantics(bpm,state);

        HashMap<String, Object> testState = new HashMap<>();
        testState.put("bpm", 128);

        assertEquals(testState, semantics.getState());
    }

    @Test
    public void numDeclSem(){

        AtomNode atomNode = new AtomNode();
        atomNode.setValue("3");

        NumDecl numDecl = new NumDecl();
        numDecl.setVarName("x");
        numDecl.setValue(atomNode);

        semantics.varDeclSemantics(numDecl, state);

        HashMap<String, Object> testState = new HashMap<>();
        testState.put("x", 3);

        assertEquals(testState, semantics.getState());

    }

    @Test
    public void notesDeclSem(){

        NotesNode note = new NotesNode();
        note.setValue("c4,(c5,c4)");

        NotesDecl notesDecl = new NotesDecl();
        notesDecl.setVarName("x");
        notesDecl.setValue(note);

        semantics.varDeclSemantics(notesDecl, state);

        LocalStream<Object> key1 = new LocalStream<>();
        key1.addNote(60);

        LocalStream<Object> key2 = new LocalStream<>();
        key2.addNote(72);
        key2.addNote(60);

        List<LocalStream> keyStream = new ArrayList<>();
        keyStream.add(key1);
        keyStream.add(key2);

        HashMap<String, Object> testState = new HashMap<>();
        testState.put("x", keyStream);

        assertEquals(testState, semantics.getState());

    }

    @Test
    public void instDecl(){

        CharStream charStream = CharStreams.fromString("num x = 3; Piano p{x=10}");
        BuildASTVisitor visitor = new BuildASTVisitor();

        CFGLexer lexer = new CFGLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFGParser parser = new CFGParser(tokenStream);

        ParseTree tree = parser.program();

        visitor.visit(tree);

        NumDecl numDecl = (NumDecl) visitor.getNodeList().get(0);
        InstDecl instDecl = (InstDecl) visitor.getNodeList().get(1);

        semantics.varDeclSemantics(numDecl, state);
        semantics.instDeclSemantics(instDecl, envI);

        InstrumentInfo info = new InstrumentInfo(instDecl.getType(), instDecl.getValue());

        HashMap<String, InstrumentInfo> testEnvI = new HashMap<>();
        testEnvI.put("p", info);

        assertEquals(testEnvI, envI);

    }

    @Test
    public void aExpSem(){

        CharStream charStream = CharStreams.fromString("num x = 3; num y = x+(5-2)*4-5;");
        BuildASTVisitor visitor = new BuildASTVisitor();

        CFGLexer lexer = new CFGLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFGParser parser = new CFGParser(tokenStream);

        ParseTree tree = parser.program();

        visitor.visit(tree);

        NumDecl xNum = (NumDecl) visitor.getNodeList().get(0);
        NumDecl yNum = (NumDecl) visitor.getNodeList().get(1);

        semantics.varDeclSemantics(xNum, state);
        semantics.varDeclSemantics(yNum, state);

        HashMap<String, Object> testState = new HashMap<>();
        testState.put("x", 3);
        testState.put("y", 10);

        assertEquals(testState, semantics.getState());
    }

    @Test
    public void bExpSem(){

        AtomNode atomNode = new AtomNode();
        atomNode.setValue("2");

        EqualNode rightEqual = new EqualNode();
        rightEqual.setLeft(atomNode);
        rightEqual.setRight(atomNode);

        EqualNode leftEqual = new EqualNode();
        leftEqual.setLeft(atomNode);
        leftEqual.setRight(atomNode);

        EqualNode testEqual = new EqualNode();
        testEqual.setLeft(leftEqual);
        testEqual.setRight(rightEqual);

        NotNode notNode = new NotNode();
        notNode.setExpressionNode(testEqual);

        assertFalse(semantics.bexpSemantics(notNode));
    }

    @Test
    public void assignSem(){

        state.put("x", 3);

        AtomNode atomNode = new AtomNode();
        atomNode.setValue("10");

        AssignNode assignNode = new AssignNode();
        assignNode.setVarName("x");
        assignNode.setValue(atomNode);

        semantics.statementsSemantics(assignNode, state, localStream);

        HashMap<String, Object> testState = new HashMap<>();
        testState.put("x", 10);

        assertEquals(testState, semantics.getState());
    }

    @Test
    public void melSem(){

        LocalStream<Object> key1 = new LocalStream<>();
        key1.addNote(60);

        LocalStream<Object> key2 = new LocalStream<>();
        key2.addNote(72);
        key2.addNote(60);

        List<LocalStream> keyStream = new ArrayList<>();
        keyStream.add(key1);
        keyStream.add(key2);

        state.put("x", keyStream);

        MelNode melNode = new MelNode();
        melNode.setVarName("x");

        semantics.statementsSemantics(melNode, state, localStream);

        LocalStream<LocalStream> testStream = new LocalStream<>();
        testStream.setNotes(keyStream);

        assertEquals(testStream, localStream);
    }

    @Test
    public void ADSRSem(){

        AtomNode atomNode = new AtomNode();
        atomNode.setValue("1");

        ADSRNode adsrNode = new ADSRNode();
        adsrNode.setExp1(atomNode);
        adsrNode.setExp2(atomNode);
        adsrNode.setExp3(atomNode);
        adsrNode.setExp4(atomNode);

        semantics.statementsSemantics(adsrNode, state, localStream);

        ADSR testAdsr = new ADSR(1,1,1,1);

        LocalStream<LocalStream> testStream = new LocalStream<>();
        testStream.setAdsr(testAdsr);

        assertEquals(testStream, localStream);
    }

    @Test
    public void timeSem(){

        TimeNode timeNode = new TimeNode();
        timeNode.setTop(4);
        timeNode.setBot(4);

        semantics.statementsSemantics(timeNode, state, localStream);

        TimeSignature timeSignature = new TimeSignature(4,4);

        LocalStream<LocalStream> testStream = new LocalStream<>();
        testStream.setTime(timeSignature);

        assertEquals(testStream, localStream);
    }

    @Test
    public void blockSem(){

        CharStream charStream = CharStreams.fromString("num x = 3; Piano p{x=10}");
        BuildASTVisitor visitor = new BuildASTVisitor();

        CFGLexer lexer = new CFGLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFGParser parser = new CFGParser(tokenStream);

        ParseTree tree = parser.program();

        visitor.visit(tree);

        NumDecl numDecl = (NumDecl) visitor.getNodeList().get(0);
        InstDecl instDecl = (InstDecl) visitor.getNodeList().get(1);

        semantics.varDeclSemantics(numDecl,state);
        semantics.statementsSemantics(instDecl.getValue(),state,localStream);

        HashMap<String, Object> testState = new HashMap<>();
        testState.put("x", 10);

        assertEquals(testState, semantics.getState());

    }

    @Test
    public void ifElseTrueSem(){

        CharStream charStream = CharStreams.fromString("num x = 3; Piano p{if(2==2){x=1}else{x=0}}");
        BuildASTVisitor visitor = new BuildASTVisitor();

        CFGLexer lexer = new CFGLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFGParser parser = new CFGParser(tokenStream);

        ParseTree tree = parser.program();

        visitor.visit(tree);

        NumDecl numDecl = (NumDecl) visitor.getNodeList().get(0);
        InstDecl instDecl = (InstDecl) visitor.getNodeList().get(1);
        BlockNode blockNode = (BlockNode) instDecl.getValue();

        semantics.varDeclSemantics(numDecl,state);
        semantics.statementsSemantics(blockNode.getNodeList().get(0), state, localStream);

        HashMap<String, Object> testState = new HashMap<>();
        testState.put("x", 1);

        assertEquals(testState, semantics.getState());

    }

    @Test
    public void ifElseFalseSem(){

        CharStream charStream = CharStreams.fromString("num x = 3; Piano p{if(2==3){x=1}else{x=0}}");
        BuildASTVisitor visitor = new BuildASTVisitor();

        CFGLexer lexer = new CFGLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CFGParser parser = new CFGParser(tokenStream);

        ParseTree tree = parser.program();

        visitor.visit(tree);

        NumDecl numDecl = (NumDecl) visitor.getNodeList().get(0);
        InstDecl instDecl = (InstDecl) visitor.getNodeList().get(1);
        BlockNode blockNode = (BlockNode) instDecl.getValue();

        semantics.varDeclSemantics(numDecl,state);
        semantics.statementsSemantics(blockNode.getNodeList().get(0), state, localStream);

        HashMap<String, Object> testState = new HashMap<>();
        testState.put("x", 0);

        assertEquals(testState, semantics.getState());

    }
}