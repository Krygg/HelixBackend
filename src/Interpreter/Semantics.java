package Interpreter;

import Interpreter.AST.Node;
import Interpreter.AST.Nodes.declarationNodes.BPMDeclaration;
import Interpreter.AST.Nodes.declarationNodes.InstDecl;
import Interpreter.AST.Nodes.declarationNodes.NotesDecl;
import Interpreter.AST.Nodes.declarationNodes.NumDecl;
import Interpreter.AST.Nodes.expressionNodes.*;
import Interpreter.AST.Nodes.statementNodes.*;
import Interpreter.AST.Nodes.terminalNodes.AtomNode;
import Interpreter.AST.Nodes.terminalNodes.NotesNode;
import com.company.MidiLookUp;
import terminals.ADSR;
import terminals.GlobalStream;
import terminals.LocalStream;
import terminals.TimeSignature;

import java.util.*;

public class Semantics {

    private static final int ONE_NOTE = 3;
    private HashMap<String, Object> state = new HashMap<>();
    private HashMap<String, Integer> channel = new HashMap<>();
    private List<MultConfig> multConfigs = new ArrayList<>();
    private GlobalStream globalStream = new GlobalStream();
    private HashMap<String, InstrumentInfo> envI = new HashMap<>();
    private List<String> startProcess = new ArrayList<>();

    /**
     * BPM declaration semantics
     */
    public void bpmDeclSemantics(Node node, HashMap<String, Object> state) {

        BPMDeclaration bpm = (BPMDeclaration) node;

        state.put("bpm", bpm.getValue());

        this.state = state;
    }

    /**
     * Variable declaration semantics
     */
    public void varDeclSemantics(Node node, HashMap<String, Object> state) {

        // Num declaration
        if (node instanceof NumDecl) {

            NumDecl numDecl = (NumDecl) node;
            Node nodeValue = numDecl.getValue();

            int value = aExpSemantics(nodeValue);

            state.put(numDecl.getVarName(), value);

            this.state = state;
        }

        // Notes declaration
        else if (node instanceof NotesDecl) {

            NotesDecl notesDecl = (NotesDecl) node;
            Node nodeValue = notesDecl.getValue();

            List<LocalStream> value = keySemantics(nodeValue);

            state.put(notesDecl.getVarName(), value);

            this.state = state;
        }

    }

    /**
     * Instrument declaration
     */
    public void instDeclSemantics(Node node, HashMap<String, InstrumentInfo> envI) {

        InstDecl instDecl = (InstDecl) node;

        envI.put(instDecl.getVarName(), new InstrumentInfo(instDecl.getType(), instDecl.getValue()));

        this.envI = envI;

    }

    /**
     * Chord/notes semantics
     */
    public List<LocalStream> keySemantics(Node node) {

        NotesNode notes = (NotesNode) node;
        String noteValues = notes.getValue();

        // Midi-lookup information
        MidiLookUp midiLookUp = MidiLookUp.getInstance();
        noteValues = noteValues.replaceAll("\\s+", "");

        // Split the string with note-information after parenthesises
        String[] splitNotes = noteValues.split("((?<=[()]|(?=[()])))");

        // The correctly split list of note information
        List<String> notesList = new ArrayList<>();

        for(int i = 0; i < splitNotes.length; i++){

            // If you see a start parenthesis, then it's the start of a chord
            if(splitNotes[i].equals("(")){

                while(!splitNotes[i].equals(")")){

                    i++;

                    // If you see an end parenthesis then it's the end of the chord
                    if(!splitNotes[i].equals(")")){
                        notesList.add(splitNotes[i]);
                    }
                }
            }

            // A single note if it has no relation to a parenthesis
            if(!splitNotes[i].equals("(") && !splitNotes[i].equals(")")){

                String[] strings = splitNotes[i].split(",");

                Collections.addAll(notesList, strings);
            }
        }

        // List of streams with all the individual key-streams
        List<LocalStream> localStreams = new ArrayList<>();

        for (String note : notesList) {

            LocalStream<Object> keyStream = new LocalStream<>();

            // If the note is a chord (contains a comma)
            if(note.contains(",")){

                String[] strings = note.split(",");

                for (String string : strings) {

                    keyStream.addNote(midiLookUp.getMidiNumber(string));
                }

                localStreams.add(keyStream);

            }

            // If the note is a single note
            else {

                keyStream.addNote(midiLookUp.getMidiNumber(note));
                localStreams.add(keyStream);
            }
        }

        return localStreams;
    }

    /**
     * Semantics for arithmetic expressions
     */
    public int aExpSemantics(Node node) {


        // Plus expression
        if (node instanceof PlusNode) {

            PlusNode plusNode = (PlusNode) node;

            return aExpSemantics(plusNode.getLeft()) + aExpSemantics(plusNode.getRight());

        }

        // Minus expression
        else if (node instanceof MinusNode) {

            MinusNode minusNode = (MinusNode) node;

            return aExpSemantics(minusNode.getLeft()) - aExpSemantics(minusNode.getRight());

        }

        // Multiplication expression
        else if (node instanceof MultNode) {

            MultNode multNode = (MultNode) node;

            return aExpSemantics(multNode.getLeft()) * aExpSemantics(multNode.getRight());

        }

        // Terminal
        else if (node instanceof AtomNode) {

            AtomNode atomNode = (AtomNode) node;

            // If it's a variable name
            if (state.containsKey(atomNode.getValue())) {

                return Integer.parseInt(state.get(atomNode.getValue()).toString());
            }

            // If it's only a number
            return Integer.parseInt(atomNode.getValue());
        }

        throw new IllegalArgumentException();

    }

    /**
     * Semantics for boolean expressions
     */
    public Boolean bexpSemantics(Node node) {

        // Not expression
        if (node instanceof NotNode) {

            NotNode notNode = (NotNode) node;

            return !bexpSemantics(notNode.getExpressionNode());
        }

        // Equal expression
        else if (node instanceof EqualNode) {

            EqualNode equalNode = (EqualNode) node;


            // If it's another boolean expression
            if (equalNode.getLeft() instanceof EqualNode) {

                return bexpSemantics(equalNode.getLeft()) == bexpSemantics(equalNode.getRight());
            }

            // If it's an arithmetic expression
            return aExpSemantics(equalNode.getLeft()) == aExpSemantics(equalNode.getRight());

        }

        throw new IllegalArgumentException();
    }

    /**
     * Statement semantics
     */
    public void statementsSemantics(Node node, HashMap<String, Object> state, LocalStream<LocalStream> localStream) {

        // Assign Statement
        if (node instanceof AssignNode) {
            AssignNode assignNode = (AssignNode) node;

            Node nodeValue = assignNode.getValue();

            if (nodeValue instanceof ExpressionNode || nodeValue instanceof AtomNode) {
                int value = aExpSemantics(nodeValue);
                state.replace(assignNode.getVarName(), value);
                this.state = state;
            }
        }

        // Melody statement
        else if (node instanceof MelNode) {

            MelNode melNode = (MelNode) node;

            String soundProfile = localStream.getSoundProfile();

            List<LocalStream> noteStream = (List) state.get(melNode.getVarName());

            for (LocalStream stream : noteStream) {

                stream.setSoundProfile(soundProfile);

                if (localStream.getAdsr() != null) {

                    stream.setAdsr(localStream.getAdsr());
                }

                if (localStream.getTime() != null) {

                    stream.setTime(localStream.getTime());
                }

            }

            localStream.setNotes(noteStream);
        }

        // ADSR statement
        else if (node instanceof ADSRNode) {

            ADSRNode adsrNode = (ADSRNode) node;

            int attack = aExpSemantics(adsrNode.getExp1());
            int decay = aExpSemantics(adsrNode.getExp2());
            int sustain = aExpSemantics(adsrNode.getExp3());
            int release = aExpSemantics(adsrNode.getExp4());

            ADSR adsrValue = new ADSR(attack, decay, sustain, release);

            localStream.setAdsr(adsrValue);

        }

        // Time statement
        else if (node instanceof TimeNode) {

            TimeNode timeNode = (TimeNode) node;

            TimeSignature timeSignature = new TimeSignature(timeNode.getTop(), timeNode.getBot());

            localStream.setTime(timeSignature);
        }

        //Composition statement
        else if (node instanceof BlockNode) {

            BlockNode blockNode = (BlockNode) node;

            for (Node bodyNode : blockNode.getNodeList()) {

                statementsSemantics(bodyNode, state, localStream);
            }
        }

        // If-else statement
        else if (node instanceof IfElseNode) {

            IfElseNode ifElse = (IfElseNode) node;

            if (bexpSemantics(ifElse.getBool())) {

                statementsSemantics(ifElse.getStmtTrue(), state, localStream);

            } else {

                statementsSemantics(ifElse.getStmtFalse(), state, localStream);
            }
        }
    }


    public void communicationSemantics(Node node, HashMap<String, Object> state, LocalStream<LocalStream> localStream) {

        // Send statement
        if (node instanceof SendNode) {

            SendNode sendNode = (SendNode) node;

            int value = aExpSemantics(sendNode.getValue());

            channel.putIfAbsent(sendNode.getChannel(), value);

        }

        // Receive statement
        else if (node instanceof ReceiveNode) {

            ReceiveNode receiveNode = (ReceiveNode) node;

            state.put(receiveNode.getVarName(), channel.get(receiveNode.getChannel()));

            this.state = state;

            statementsSemantics(receiveNode.getStatement(), state, localStream);
        }

        // Start statement
        else if (node instanceof StartNode) {

            StartNode startNode = (StartNode) node;

            if(!startProcess.contains(startNode.getVarName())){

                localStream = new LocalStream<>();

                startProcess.add(startNode.getVarName());

                InstrumentInfo info = envI.get(startNode.getVarName());

                localStream.setSoundProfile(info.getSoundProfile());

                MultConfig multConfig = new MultConfig(info.getNode(), localStream);

                multConfigs.add(multConfig);
            }
        }
    }

    /** Global communication semantics */
    public void globalCommuSemantics(List<MultConfig> multConfigs, GlobalStream globalStream, HashMap<String, Object> state) {

        // Look after all start
        for (int i = 0; i < startProcess.size(); i++) {

            BlockNode body = (BlockNode) multConfigs.get(i).getBody();

            LocalStream localStream = multConfigs.get(i).getStream();

            for (Node node : body.getNodeList()) {

                if (node instanceof StartNode) {

                    communicationSemantics(node, state, localStream);
                }
            }
        }

        // Send
        for (MultConfig multConfig : multConfigs) {

            BlockNode body = (BlockNode) multConfig.getBody();

            LocalStream localStream = multConfig.getStream();

            for (Node node : body.getNodeList()) {

                if (node instanceof SendNode) {

                    communicationSemantics(node, state, localStream);
                }
            }

        }

        // Receive
        for (MultConfig multConfig : multConfigs) {

            BlockNode body = (BlockNode) multConfig.getBody();

            LocalStream localStream = multConfig.getStream();

            for (Node node : body.getNodeList()) {

                if (node instanceof ReceiveNode) {

                    communicationSemantics(node, state, localStream);
                }
            }
        }

        // The rest of the statements are processed
        for (MultConfig multConfig : multConfigs) {

            BlockNode body = (BlockNode) multConfig.getBody();

            LocalStream localStream = multConfig.getStream();

            for (Node node : body.getNodeList()) {

                statementsSemantics(node, state, localStream);
            }

            globalStream.addStream(localStream);
        }
    }

    /**
     * Getters and Setters
     */
    public HashMap<String, Object> getState() {
        return state;
    }

    public void setState(HashMap<String, Object> state) {
        this.state = state;
    }

    public HashMap<String, InstrumentInfo> getEnvI() {
        return envI;
    }

    public void setEnvI(HashMap<String, InstrumentInfo> envI) {
        this.envI = envI;
    }

    public List<MultConfig> getMultConfigs() {
        return multConfigs;
    }

    public void setMultConfigs(List<MultConfig> multConfigs) {
        this.multConfigs = multConfigs;
    }
}
