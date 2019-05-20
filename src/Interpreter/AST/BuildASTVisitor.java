package Interpreter.AST;

import Interpreter.AST.Nodes.declarationNodes.*;
import Interpreter.AST.Nodes.expressionNodes.*;
import Interpreter.AST.Nodes.statementNodes.*;
import Interpreter.AST.Nodes.terminalNodes.AtomNode;
import Interpreter.AST.Nodes.terminalNodes.NotesNode;
import antlr.CFGBaseVisitor;
import antlr.CFGParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuildASTVisitor extends CFGBaseVisitor<Node> {

    private HashMap<String, String> symbolTable = new HashMap<>();
    private List<Node> nodeList = new ArrayList<>();
    private List<String> startProcess = new ArrayList<>();
    private HashMap<String, String> receiveMap = new HashMap<>();
    private HashMap<String, String> sendMap = new HashMap<>();

    @Override
    public Node visitProgram(CFGParser.ProgramContext ctx) {

        return super.visitProgram(ctx);
    }

    /**
     * BPM declaration (OK)
     */
    @Override
    public Node visitDb(CFGParser.DbContext ctx) {

        if (ctx.BPM() != null) {

            BPMDeclaration bpmDeclaration = new BPMDeclaration();

            bpmDeclaration.setValue((Integer.parseInt(ctx.NUMBER().getText())));

            nodeList.add(bpmDeclaration);

            return bpmDeclaration;
        }

        return null;
    }

    /**
     * Variable declaration (OK)
     */
    @Override
    public Node visitDv(CFGParser.DvContext ctx) {

        // Expression assigned
        if (ctx.NUM() != null) {

            // Check if variable name has been used before
            checkVarNames(ctx.VARNAME().getText(), ctx.NUM().getText());

            NumDecl numDecl = new NumDecl();
            numDecl.setVarName(ctx.VARNAME().getText());

            numDecl.setValue(visitAExp(ctx.aExp()));

            if (startProcess.contains(numDecl.getVarName())) {

                throw new TypeCheckingError("You can't start anything but an instrument!");
            }

            if (numDecl.getValue().getType().equals("num")) {

                nodeList.add(numDecl);

                visitDv(ctx.dv());

                return numDecl;
            }
        }

        // Notes assigned
        else if (ctx.k() != null) {

            // Check if variable name has been used before
            checkVarNames(ctx.VARNAME().getText(), ctx.NOTES().getText());

            NotesDecl notesDecl = new NotesDecl();
            notesDecl.setVarName(ctx.VARNAME().getText());
            notesDecl.setValue(visitK(ctx.k()));

            if (startProcess.contains(notesDecl.getVarName())) {

                throw new TypeCheckingError("You can't start anything but an instrument!");
            }

            if (notesDecl.getValue().getType().equals("notes")) {

                nodeList.add(notesDecl);

                visitDv(ctx.dv());

                return notesDecl;
            }

            throw new TypeCheckingError("Wrong types!");
        }

        return null;

    }


    /**
     * Declaration of an instrument (OK)
     */
    @Override
    public Node visitDi(CFGParser.DiContext ctx) {

        if (ctx.inst() != null) {

            // Check if variable name has been used before
            checkVarNames(ctx.p().getText(), "inst");

            InstDecl instDecl = new InstDecl();
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

    /**
     * Start a process (don't know if error handling should be done here)
     */
    @Override
    public Node visitSp(CFGParser.SpContext ctx) {

        if (ctx.startPause() != null) {
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
        if (ctx.SEMI() != null) {

            blockNode.addNode(visitStmt(ctx.stmt()));

            if (!ctx.stmts().getText().equals("")) {
                visitStmts(ctx.stmts(), blockNode);
            }

        } else if (ctx.stmt() != null) {

            blockNode.addNode(visitStmt(ctx.stmt()));

        }
    }

    /**
     * Statements (Should be checked once more, to be sure it's correct)
     */
    @Override
    public Node visitStmt(CFGParser.StmtContext ctx) {

        // Assignment
        if (ctx.ASSIGN() != null) {

            String type = symbolTable.get(ctx.VARNAME().getText());

            if (type != null) {

                if (type.equals("num")) {

                    AssignNode assignNode = new AssignNode();

                    assignNode.setVarName(ctx.VARNAME().getText());
                    assignNode.setValue(visitAExp(ctx.aExp(0)));

                    if (assignNode.getValue().getType().equals("num")) {

                        return assignNode;
                    }
                }

                throw new TypeCheckingError("You can't assign anything but a num-value!");

            } else {

                throw new VarException("You can't assign a value to a non-declared variable!");
            }
        }

        // Start statement
        else if (ctx.startPause() != null) {

            StartNode start = new StartNode();
            start.setVarName(ctx.p().getText());

            // If the instrument hasn't been declared yet
            if (symbolTable.get(start.getVarName()) == null) {

                startProcess.add(start.getVarName());

                return start;

            }

            // If the instrument has been declared
            else if (symbolTable.get(start.getVarName()).equals("inst")) {

                return start;
            }

            throw new TypeCheckingError("You can't start anything but an instrument!");

        }

        // Melody statement
        else if (ctx.MEL() != null) {

            String variableType = symbolTable.get(ctx.VARNAME().getText());

            if (variableType != null) {

                if (variableType.equals("notes")) {

                    MelNode mel = new MelNode();
                    mel.setVarName(ctx.VARNAME().getText());

                    return mel;
                }

                throw new TypeCheckingError("This variable has the wrong type!");
            }

            throw new VarException("This variable hasn't been declared!");

        }

        // ADSR command
        else if (ctx.ADSR() != null) {

            ADSRNode adsrNode = new ADSRNode();

            adsrNode.setExp1(visitAExp(ctx.aExp(0)));
            adsrNode.setExp2(visitAExp(ctx.aExp(1)));
            adsrNode.setExp3(visitAExp(ctx.aExp(2)));
            adsrNode.setExp4(visitAExp(ctx.aExp(3)));

            String exp1 = adsrNode.getExp1().getType();
            String exp2 = adsrNode.getExp2().getType();
            String exp3 = adsrNode.getExp3().getType();
            String exp4 = adsrNode.getExp4().getType();

            if (exp1.equals("num") && exp2.equals("num") && exp3.equals("num") && exp4.equals("num")) {

                return adsrNode;
            }

            throw new TypeCheckingError("One of the expression isn't of type \"num\"!");
        }

        // Time statement
        else if (ctx.TIME() != null) {

            TimeNode time = new TimeNode();

            time.setTop(Integer.parseInt(ctx.NUMBER(0).getText()));
            time.setBot(Integer.parseInt(ctx.NUMBER(1).getText()));

            return time;

        }

        // Send statement
        else if (ctx.SEND() != null) {

            SendNode send = new SendNode();

            send.setChannel(ctx.c().getText());
            send.setChannelType("num");
            send.setValue(visitAExp(ctx.aExp(0)));

            if (receiveMap.containsKey(send.getChannel())) {

                symbolTable.put(receiveMap.get(send.getChannel()), "num");

            }

            return send;
        }

        // Receive statement
        else if (ctx.RECEIVE() != null) {

            ReceiveNode receive = new ReceiveNode();

            receive.setChannel(ctx.c().getText());
            receive.setChannelType("num");
            receive.setVarName(ctx.VARNAME().getText());


            // Check if variable name has been used before
            checkVarNames(ctx.VARNAME().getText(), "num");


            if (receive.getChannelType().equals("num")) {
                receive.setStatement(visitStmt(ctx.stmt()));

                return receive;
            } else if (!receive.getChannelType().equals("num")) {
                receiveMap.put(receive.getChannel(), receive.getVarName());
            } else {
                throw new TypeCheckingError("The value receive on channel isn't of type \"num\"!");
            }


        }

        // If-else statement
        else if (ctx.IF() != null) {

            IfElseNode ifElseNode = new IfElseNode();
            BlockNode block1 = new BlockNode();
            BlockNode block2 = new BlockNode();

            // Boolean
            ifElseNode.setBool(visitNBExp(ctx.nBExp()));

            // True block
            visitStmts(ctx.stmts(0), block1);
            ifElseNode.setStmtTrue(block1);

            // False Block
            if (ctx.ELSE() != null) {

                visitStmts(ctx.stmts(1), block2);
                ifElseNode.setStmtFalse(block2);
            }

            return ifElseNode;
        }

        return super.visitStmt(ctx);
    }

    @Override
    public Node visitNBExp(CFGParser.NBExpContext ctx) {

        if (ctx.NOT() != null) {

            NotNode not = new NotNode();

            not.setExpressionNode(visitBExp(ctx.bExp()));

            if (not.getExpressionNode().getType().equals("bool")) {

                not.setType("bool");

                return not;
            }

            throw new TypeCheckingError("You can't negate a value that isn't of type bool!");
        }

        return visitBExp(ctx.bExp());

    }

    /**
     * Equals expression (may need to change precedence)
     */
    @Override
    public Node visitBExp(CFGParser.BExpContext ctx) {

        if (ctx.bExp(0) != null) {

            EqualNode equal = new EqualNode();

            equal.setLeft(visitBExp(ctx.bExp(0)));
            equal.setRight(visitBExp(ctx.bExp(1)));

            String leftType = equal.getLeft().getType();
            String rightType = equal.getLeft().getType();

            if (leftType.equals("bool") && rightType.equals("bool")) {

                equal.setType("bool");

                return equal;
            }

            throw new TypeCheckingError("The expressions are not the same!");
        } else if (ctx.aExp(0) != null) {

            EqualNode equal = new EqualNode();

            equal.setLeft(visitAExp(ctx.aExp(0)));
            equal.setRight(visitAExp(ctx.aExp(1)));

            String leftType = equal.getLeft().getType();
            String rightType = equal.getLeft().getType();

            if (leftType.equals("num") && rightType.equals("num")) {

                equal.setType("bool");

                return equal;
            }

            return equal;
        }

        throw new IllegalArgumentException();
    }

    /**
     * Arithmetic expression (OK)
     */
    @Override
    public Node visitAExp(CFGParser.AExpContext ctx) {

        // Addition
        if (ctx.PLUS() != null) {

            PlusNode plus = new PlusNode();

            plus.setLeft(visitAExp(ctx.aExp(0)));
            plus.setRight(visitAExp(ctx.aExp(1)));

            // Type check if this is valid
            typeCheckingBinary(plus);

            return plus;
        }

        // Subtraction
        else if (ctx.MINUS() != null) {

            MinusNode minus = new MinusNode();

            minus.setLeft(visitAExp(ctx.aExp(0)));
            minus.setRight(visitAExp(ctx.aExp(1)));

            // Type check if this is valid
            typeCheckingBinary(minus);

            return minus;

        }

        return visitMultExp(ctx.multExp());
    }

    /**
     * Multiplication (OK)
     */
    @Override
    public Node visitMultExp(CFGParser.MultExpContext ctx) {

        if (ctx.MULT() != null) {
            MultNode mult = new MultNode();

            mult.setLeft(visitMultExp(ctx.multExp(0)));
            mult.setRight(visitMultExp(ctx.multExp(1)));

            // Type check if this is valid
            typeCheckingBinary(mult);

            return mult;
        }

        return visitAtom(ctx.atom());
    }


    /**
     * Atom (OK)
     */
    @Override
    public Node visitAtom(CFGParser.AtomContext ctx) {

        // Reached the terminal
        if (ctx.VARNAME() != null) {

            AtomNode atom = new AtomNode();
            String type = symbolTable.get(ctx.VARNAME().getText());

            if (type != null) {

                if (type.equals("num")) {

                    atom.setValue(ctx.VARNAME().getText());
                    atom.setType(symbolTable.get(ctx.VARNAME().getText()));

                    return atom;
                }

                throw new TypeCheckingError("This variable isn't of type num!");

            } else {

                throw new VarException("This variable hasn't been declared!");
            }

        } else if (ctx.NUMBER() != null) {

            AtomNode atom = new AtomNode();

            atom.setValue(ctx.NUMBER().getText());
            atom.setType("num");

            return atom;
        }


        // Parenthesis rule
        if (ctx.aExp() != null) {
            return visitAExp(ctx.aExp());
        }

        return null;
    }

    /**
     * Notes (May have to change because of the semantics)
     */
    @Override
    public Node visitK(CFGParser.KContext ctx) {

        if (ctx.k() != null) {
            NotesNode note = new NotesNode();
            note.setValue(ctx.getText());
            note.setType("notes");
            return note;
        }
        return super.visitK(ctx);
    }

    private void checkVarNames(String varName, String type) {

        if (symbolTable.get(varName) == null) {

            symbolTable.put(varName, type);

        } else {
            throw new VarException("This variable name has already been used!");
        }
    }

    public void typeCheckingBinary(BinaryExpression node) {

        if (node.getLeft().getType().equals("num") && node.getRight().getType().equals("num")) {

            node.setType("num");

        } else {

            throw new TypeCheckingError("One of the expressions has the wrong type!");
        }
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public HashMap<String, String> getSymbolTable() {
        return symbolTable;
    }

    public void setSymbolTable(HashMap<String, String> symbolTable) {
        this.symbolTable = symbolTable;
    }
}

