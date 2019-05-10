package Interpreter.AST;
import Interpreter.AST.Nodes.declarationNodes.BPMDeclaration;
import Interpreter.AST.Nodes.declarationNodes.Declaration;
import Interpreter.AST.Nodes.expressionNodes.*;
import Interpreter.AST.Nodes.statementNodes.*;
import Interpreter.AST.Nodes.terminalNodes.AtomNode;
import Interpreter.AST.Nodes.terminalNodes.NotesNode;
import antlr.CFGBaseVisitor;
import antlr.CFGParser;

import java.util.ArrayList;
import java.util.List;

public class BuildASTVisitor extends CFGBaseVisitor<Node> {

    private List<String> varNames = new ArrayList<>();
    private List<Node> nodeList = new ArrayList<>();

    @Override
    public Node visitProgram(CFGParser.ProgramContext ctx) {

        return super.visitProgram(ctx);
    }

    /**BPM declaration (OK)*/
    @Override
    public Node visitDb(CFGParser.DbContext ctx) {

        if(ctx.BPM() != null){

            BPMDeclaration bpmDeclaration = new BPMDeclaration();

            bpmDeclaration.setValue((Integer.parseInt(ctx.NUMBER().getText())));

            nodeList.add(bpmDeclaration);

            return bpmDeclaration;
        }

        return null;
    }

    /** Variable declaration (OK)*/
    @Override
    public Node visitDv(CFGParser.DvContext ctx) {

        // Expression assigned
        if(ctx.NUM() != null){

            // Check if variable name has been used before
            checkVarNames(ctx.VARNAME(0).getText());

            Declaration numDecl = new Declaration();
            numDecl.setType("num");
            numDecl.setVarName(ctx.VARNAME(0).getText());

            if(ctx.aExp() != null){

                numDecl.setValue(visitAExp(ctx.aExp()));

            } else if(ctx.VARNAME(1) != null){}


            nodeList.add(numDecl);

            visitDv(ctx.dv());

            return numDecl;

        }
        // Notes assigned
        else if (ctx.k() != null){

            // Check if variable name has been used before
            checkVarNames(ctx.VARNAME(0).getText());

            Declaration notesDecl = new Declaration();
            notesDecl.setType("notes");
            notesDecl.setVarName(ctx.VARNAME(0).getText());
            notesDecl.setValue(visitK(ctx.k()));

            nodeList.add(notesDecl);

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
            BlockNode blockNode = new BlockNode();

            instDecl.setType(ctx.inst().getText());
            instDecl.setVarName(ctx.p().getText());

            visitStmts(ctx.stmts(), blockNode);

            instDecl.setValue(blockNode);

            nodeList.add(instDecl);

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

            nodeList.add(start);

            return start;
        }

        return null;
    }

    public void visitStmts(CFGParser.StmtsContext ctx, BlockNode blockNode) {

        // Block of statements
        if(ctx.SEMI() != null){

            blockNode.addNode(visitStmt(ctx.stmt()));

            visitStmts(ctx.stmts(), blockNode);

        } else if (ctx.stmt() != null) {

            blockNode.addNode(visitStmt(ctx.stmt()));

        }
    }

    /** Statements (Should be checked once more, to be sure it's correct)*/
    @Override
    public Node visitStmt(CFGParser.StmtContext ctx) {

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
            receive.setStatement(visitStmt(ctx.stmt()));

            return receive;

        }

        // If-else statement
        else if(ctx.IF() != null){

            IfElseNode ifElseNode = new IfElseNode();
            BlockNode block1 = new BlockNode();
            BlockNode block2 = new BlockNode();

            // Boolean
            ifElseNode.setBool(visitBExp(ctx.bExp()));

            // True block
            visitStmts(ctx.stmts(0), block1);
            ifElseNode.setStmtTrue(block1);

            // False Block
            if(ctx.ELSE() != null){

                visitStmts(ctx.stmts(1), block2);
                ifElseNode.setStmtFalse(block2);
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

            plus.setLeft(visitAExp(ctx.aExp(0)));
            plus.setRight(visitAExp(ctx.aExp(1)));

            return plus;
        }

        // Subtraction
        else if(ctx.MINUS() != null){

            MinusNode minus = new MinusNode();

            minus.setLeft(visitAExp(ctx.aExp(0)));
            minus.setRight(visitAExp(ctx.aExp(1)));

            return minus;

        }

        return visitMultExp(ctx.multExp());
    }

    /**Multiplication (OK)*/
    @Override
    public Node visitMultExp(CFGParser.MultExpContext ctx) {

        if(ctx.MULT() != null){
            MultNode mult = new MultNode();

            mult.setLeft(visitMultExp(ctx.multExp(0)));
            mult.setRight(visitMultExp(ctx.multExp(1)));

            return mult;
        }

        return visitAtom(ctx.atom());
    }


    /** Atom (OK) */
    @Override
    public Node visitAtom(CFGParser.AtomContext ctx) {

        // Reached the terminal
        if(ctx.VARNAME() != null){

            AtomNode atom = new AtomNode();

            if(varNames.contains(ctx.VARNAME().getText())){
                atom.setValue(ctx.VARNAME().getText());

                return atom;

            } else {
                throw new VarException("This variable hasn't been declared!");
            }
        } else if(ctx.NUMBER() != null){

            AtomNode atom = new AtomNode();

            atom.setValue(ctx.NUMBER().getText());

            return atom;
        }


        // Parenthesis rule
        if(ctx.aExp() != null){
            return visitAExp(ctx.aExp());
        }

        return null;
    }

    /** Notes (May have to change because of the semantics)*/
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

    public List<Node> getNodeList() {
        return nodeList;
    }
}

