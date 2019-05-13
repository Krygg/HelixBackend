package Interpreter;

import Interpreter.AST.Node;
import Interpreter.AST.Nodes.declarationNodes.BPMDeclaration;
import Interpreter.AST.Nodes.declarationNodes.Declaration;
import Interpreter.AST.Nodes.expressionNodes.*;
import Interpreter.AST.Nodes.statementNodes.AssignNode;
import Interpreter.AST.Nodes.terminalNodes.AtomNode;
import Interpreter.AST.Nodes.terminalNodes.NotesNode;
import com.company.MidiLookUp;
import terminals.GlobalStream;
import terminals.LocalStream;

import java.util.HashMap;

public class Semantics {

    private static final int ONE_NOTE = 3;
    private HashMap<String, Object> state = new HashMap<>();

    /** BPM declaration semantics */
    public void bpmDeclSemantics(Node node){

        BPMDeclaration bpm = (BPMDeclaration) node;

        state.put("bpm", bpm.getValue());
    }

    /** Variable declaration semantics */
    public void varDeclSemantics(Node node){

        Declaration declNode = (Declaration) node;

        Node nodeValue = declNode.getValue();

        // Num declaration
        if (nodeValue instanceof ExpressionNode || nodeValue instanceof AtomNode) {

            int value = aExpSemantics(nodeValue);

            state.put(declNode.getVarName(), value);
        }

        // Notes declaration
        else if (nodeValue instanceof NotesNode) {

            GlobalStream value = keySemantics(nodeValue);

            state.put(declNode.getVarName(), value);
        }

    }

    /** Chord/notes semantics */
    public GlobalStream keySemantics(Node node){

        NotesNode notes = (NotesNode) node;

        String noteValues = notes.getValue();

        GlobalStream globalStream = new GlobalStream();

        // Midi-lookup information
        MidiLookUp midiLookUp = MidiLookUp.getInstance();
        noteValues = noteValues.replaceAll("\\s+", "");
        String[] noteStrings = noteValues.split("[()]");

        int i;

        for (i = 0; i < noteStrings.length; i++){

            LocalStream stream = new LocalStream();

            // A chord
            if(noteStrings[i].length() > ONE_NOTE){

                String[] chord = noteStrings[i].split(",");

                int j;

                for(j = 0; j < chord.length; j++){

                    stream.addNote(midiLookUp.getMidiNumber(chord[j]));

                }

                globalStream.addStream(stream);

            }

            // A single note
            else {

                String note = noteStrings[i].replace(",", "");

                stream.addNote(midiLookUp.getMidiNumber(note));

                globalStream.addStream(stream);
            }
        }

        return globalStream;
    }

    /** Semantics for arithmetic expressions */
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

    /** Semantics for boolean expressions */
    public Boolean bexpSemantics(Node node) {

        // Not expression
        if(node instanceof NotNode){

            NotNode notNode = (NotNode) node;

            return !bexpSemantics(notNode.getExpressionNode());
        }

        // Equal expression
        else if (node instanceof EqualNode) {

            EqualNode equalNode = (EqualNode) node;


            // If it's another boolean expression
            if(equalNode.getLeft() instanceof EqualNode){

                return bexpSemantics(equalNode.getLeft()) == bexpSemantics(equalNode.getRight());
            }

            // If it's an arithmetic expression
            return aExpSemantics(equalNode.getLeft()) == aExpSemantics(equalNode.getRight());

        }

        throw new IllegalArgumentException();
    }

    /** Statement semantics */
    public EndConfiguration statementsSemantics(Node node, HashMap<String, Object> state, LocalStream localStream) {

        // Assign Statement
        if (node instanceof AssignNode) {
            AssignNode assignNode = (AssignNode) node;

            Node nodeValue = assignNode.getValue();

            if (nodeValue instanceof ExpressionNode || nodeValue instanceof AtomNode) {
                int value = aExpSemantics(nodeValue);
                state.replace(assignNode.getVarName(), value);
            }

            return new EndConfiguration(localStream, state);
        }

        throw new IllegalArgumentException();

    }


    /** Getters and Setters */
    public HashMap<String, Object> getState() {
        return state;
    }

    public void setState(HashMap<String, Object> state) {
        this.state = state;
    }
}
