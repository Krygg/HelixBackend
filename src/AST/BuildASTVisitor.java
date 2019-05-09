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

    /** Statements (Should be checked once more, to be sure it's correct)*/
    @Override
    public Node visitStmt(CFGParser.StmtContext ctx) {

        // Block of statements
        if(ctx.SEMI() != null){
            BlockNode block = new BlockNode();
            block.addNode(visitStmt(ctx.stmt(0)));

            if(ctx.stmt(1) != null){
                block.addNode(visitStmt(ctx.stmt(1)));
            }

            return block;
        }

        // Assignment
        if(ctx.ASSIGN() != null){

            if(varNames.contains(ctx.VARNAME().getText())){
                AssignNode assignNode = new AssignNode();

                assignNode.setVarName(ctx.VARNAME().getText());
                assignNode.setValue(visitAExp(ctx.aExp(0)));

                return assignNode;

            } else {
                throw new VarException("You can't assign a value to a non-declared variable!");
            }
        }

        // Start statement
        else if(ctx.startPause() != null){

            StartNode start = new StartNode();
            start.setVarName(ctx.p().getText());

            return start;

        }

        // Melody statement
        else if(ctx.MEL() != null){

            MelNode mel = new MelNode();
            mel.setVarName(ctx.VARNAME().getText());

            return mel;

        }

        // ADSR command
        else if(ctx.ADSR() != null){

            ADSRNode adsrNode = new ADSRNode();

            adsrNode.setExp1(visitAExp(ctx.aExp(0)));
            adsrNode.setExp2(visitAExp(ctx.aExp(1)));
            adsrNode.setExp3(visitAExp(ctx.aExp(2)));
            adsrNode.setExp4(visitAExp(ctx.aExp(3)));

            return adsrNode;
        }

        // Time statement
        else if(ctx.TIME() != null){

            TimeNode time = new TimeNode();

            time.setTop(Integer.parseInt(ctx.NUMBER(0).getText()));
            time.setBot(Integer.parseInt(ctx.NUMBER(1).getText()));

            return time;

        }

        // Send statement
        else if(ctx.SEND() != null){

            SendNode send = new SendNode();

            send.setChannel(ctx.c().getText());
            send.setValue(visitAExp(ctx.aExp(0)));

            return send;
        }

        // Receive statement
        else if(ctx.RECEIVE() != null){

            ReceiveNode receive = new ReceiveNode();

            receive.setChannel(ctx.c().getText());
            receive.setVarName(ctx.VARNAME().getText());
            receive.setStatement(visitStmt(ctx.stmt(0)));

            return receive;

        }

        // If-else statement
        else if(ctx.IF() != null){

            IfElseNode ifElseNode = new IfElseNode();

            ifElseNode.setBool(visitBExp(ctx.bExp()));
            ifElseNode.setStmtTrue(visitStmt(ctx.stmt(0)));

            if(ctx.ELSE() != null){

                ifElseNode.setStmtFalse(visitStmt(ctx.stmt(1)));
            }

            return ifElseNode;
        }

        return super.visitStmt(ctx);
    }


    /**Equals expression (may need to change precedence)*/
    @Override
    public Node visitBExp(CFGParser.BExpContext ctx) {

        EqualNode equal = new EqualNode();

        equal.setLeft(visitNAexp(ctx.nAexp(0)));
        equal.setRight(visitNAexp(ctx.nAexp(1)));

        return equal;
    }

    /**Not expression (may need to change precedence)*/
    @Override
    public Node visitNAexp(CFGParser.NAexpContext ctx) {

        if(ctx.NOT() != null){

            NotNode not = new NotNode();

            not.setExpressionNode(visitAExp(ctx.aExp()));

            return not;
        }

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

    /**Multiplication (OK)*/
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


    /** Atom (OK) */
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

    private void checkVarNames(String varName){
        if(!varNames.contains(varName)){
            varNames.add(varName);
        } else {
            throw new VarException("This variable name has already been used!");
        }
    }
}

