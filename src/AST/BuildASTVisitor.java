package AST;
import antlr.CFGBaseVisitor;
import antlr.CFGParser;

import java.util.ArrayList;
import java.util.List;

public class BuildASTVisitor extends CFGBaseVisitor<Node> {

    private List<String> varNames = new ArrayList<>();

    @Override
    public Node visitProgram(CFGParser.ProgramContext ctx) {
        return super.visitProgram(ctx);
    }

    /**BPM declaration (OK)*/
    @Override
    public Node visitDb(CFGParser.DbContext ctx) {

        BPMDeclaration bpmDeclaration = new BPMDeclaration();

        bpmDeclaration.setValue((Integer.parseInt(ctx.NUMBER().getText())));

        return bpmDeclaration;
    }

    /** Variable declaration (OK)*/
    @Override
    public Node visitDv(CFGParser.DvContext ctx) {

        if(ctx.aExp() != null){

            // Check if variable name has been used before
            checkVarNames(ctx.VARNAME().getText());

            Declaration numDecl = new Declaration();
            numDecl.setType("num");
            numDecl.setVarName(ctx.VARNAME().getText());
            numDecl.setValue(visitAExp(ctx.aExp()));

            visitDv(ctx.dv());

            return numDecl;

        } else if (ctx.k() != null){

            // Check if variable name has been used before
            checkVarNames(ctx.VARNAME().getText());

            Declaration notesDecl = new Declaration();
            notesDecl.setType("notes");
            notesDecl.setVarName(ctx.VARNAME().getText());
            notesDecl.setValue(visitK(ctx.k()));

            visitDv(ctx.dv());

            return notesDecl;
        }

        return null;

    }


    /** Declaration of an instrument (OK)*/
    @Override
    public Node visitDi(CFGParser.DiContext ctx) {

        if(ctx.inst() != null){

            // Check if variable name has been used before
            checkVarNames(ctx.p().getText());

            Declaration instDecl = new Declaration();
            instDecl.setType(ctx.inst().getText());
            instDecl.setVarName(ctx.p().getText());
            instDecl.setValue(visitStmt(ctx.stmt()));

            visitDi(ctx.di());

            return instDecl;
        }

        return null;

    }

    /** Start a process (don't know if error handling should be done here)*/
    @Override
    public Node visitSp(CFGParser.SpContext ctx) {

        if(ctx.startPause() != null){
            StartNode start = new StartNode();
            start.setVarName(ctx.p().getText());

            visitSp(ctx.sp());

            return start;
        }

        return null;
    }

    @Override
    public Node visitStmt(CFGParser.StmtContext ctx) {

        //Check if the statement is an assignment
        if(ctx.ASSIGN() != null){

            if(varNames.contains(ctx.VARNAME().getText())){
                AssignNode assignNode = new AssignNode();

                assignNode.setVarName(ctx.VARNAME().getText());
                assignNode.setValue(visitAExp(ctx.aExp(0)));

                System.out.println("Assign: " + assignNode.getValue());

            } else {
                throw new VarException("You can't assign a value to a non-declared variable!");
            }

        } else if(ctx.startPause() != null){

            StartNode start = new StartNode();
            start.setVarName(ctx.p().getText());

        }

        return super.visitStmt(ctx);
    }

    @Override
    public Node visitBExp(CFGParser.BExpContext ctx) {

        visitNAexp(ctx.nAexp(0));
        visitNAexp(ctx.nAexp(1));
        return null;
    }

    @Override
    public Node visitNAexp(CFGParser.NAexpContext ctx) {

        return visitAExp(ctx.aExp());
    }

    /** Arithmetic expression (OK)*/
    @Override
    public Node visitAExp(CFGParser.AExpContext ctx) {

        // Addition
        if(ctx.PLUS() != null){
            PlusNode plus = new PlusNode();
            plus.setLeft(visitMultExp(ctx.multExp()));
            plus.setRight(visitAExp(ctx.aExp()));

            return plus;
        }
        // Subtraction
        else if(ctx.MINUS() != null){
            MinusNode minus = new MinusNode();
            minus.setLeft(visitMultExp(ctx.multExp()));
            minus.setRight(visitAExp(ctx.aExp()));

            return minus;

        }

        return visitMultExp(ctx.multExp());
    }

    @Override
    public Node visitMultExp(CFGParser.MultExpContext ctx) {

        if(ctx.MULT() != null){
            MultNode mult = new MultNode();

            mult.setLeft(visitAtom(ctx.atom()));
            mult.setRight(visitMultExp(ctx.multExp()));

            return mult;
        }

        return visitAtom(ctx.atom());
    }

    @Override
    public Node visitAtom(CFGParser.AtomContext ctx) {

        AtomNode atom = new AtomNode();

        if(ctx.VARNAME() != null){
            if(varNames.contains(ctx.VARNAME().getText())){
                atom.setValue(ctx.VARNAME().getText());
            } else {
                throw new VarException("This variable hasn't been declared!");
            }
        } else if(ctx.NUMBER() != null){
            atom.setValue(ctx.NUMBER().getText());
        }


        if(ctx.aExp() != null){
            visitAExp(ctx.aExp());
        }

        return atom;
    }

    /** Notes (OK)*/
    @Override
    public Node visitK(CFGParser.KContext ctx) {

        if(ctx.k() != null){
            NotesNode note = new NotesNode();
            note.setValue(ctx.getText());
            return note;
        }
        return super.visitK(ctx);
    }

    @Override
    public Node visitP(CFGParser.PContext ctx) {
        return super.visitP(ctx);
    }

    @Override
    public Node visitC(CFGParser.CContext ctx) {
        return super.visitC(ctx);
    }

    @Override
    public Node visitInst(CFGParser.InstContext ctx) {
        return super.visitInst(ctx);
    }

    @Override
    public Node visitStartPause(CFGParser.StartPauseContext ctx) {
        return super.visitStartPause(ctx);
    }

    private void checkVarNames(String varName){
        if(!varNames.contains(varName)){
            varNames.add(varName);
        } else {
            throw new VarException("This variable name has already been used!");
        }
    }

    private void emptyRight(BinaryExpression binaryNode, CFGParser.AExpContext ctx){

        if(ctx.aExp()!= null){
            binaryNode.setRight(visitAExp(ctx.aExp()));
        }

    }
}

