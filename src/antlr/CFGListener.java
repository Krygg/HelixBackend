// Generated from C:/Users/Maria-Theresa/IdeaProjects/HelixBackend\CFG.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CFGParser}.
 */
public interface CFGListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CFGParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CFGParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CFGParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#db}.
	 * @param ctx the parse tree
	 */
	void enterDb(CFGParser.DbContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#db}.
	 * @param ctx the parse tree
	 */
	void exitDb(CFGParser.DbContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#dv}.
	 * @param ctx the parse tree
	 */
	void enterDv(CFGParser.DvContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#dv}.
	 * @param ctx the parse tree
	 */
	void exitDv(CFGParser.DvContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#di}.
	 * @param ctx the parse tree
	 */
	void enterDi(CFGParser.DiContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#di}.
	 * @param ctx the parse tree
	 */
	void exitDi(CFGParser.DiContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#sp}.
	 * @param ctx the parse tree
	 */
	void enterSp(CFGParser.SpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#sp}.
	 * @param ctx the parse tree
	 */
	void exitSp(CFGParser.SpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(CFGParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(CFGParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#bExp}.
	 * @param ctx the parse tree
	 */
	void enterBExp(CFGParser.BExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#bExp}.
	 * @param ctx the parse tree
	 */
	void exitBExp(CFGParser.BExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#nAexp}.
	 * @param ctx the parse tree
	 */
	void enterNAexp(CFGParser.NAexpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#nAexp}.
	 * @param ctx the parse tree
	 */
	void exitNAexp(CFGParser.NAexpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#aExp}.
	 * @param ctx the parse tree
	 */
	void enterAExp(CFGParser.AExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#aExp}.
	 * @param ctx the parse tree
	 */
	void exitAExp(CFGParser.AExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#multExp}.
	 * @param ctx the parse tree
	 */
	void enterMultExp(CFGParser.MultExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#multExp}.
	 * @param ctx the parse tree
	 */
	void exitMultExp(CFGParser.MultExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(CFGParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(CFGParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#k}.
	 * @param ctx the parse tree
	 */
	void enterK(CFGParser.KContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#k}.
	 * @param ctx the parse tree
	 */
	void exitK(CFGParser.KContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#p}.
	 * @param ctx the parse tree
	 */
	void enterP(CFGParser.PContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#p}.
	 * @param ctx the parse tree
	 */
	void exitP(CFGParser.PContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#c}.
	 * @param ctx the parse tree
	 */
	void enterC(CFGParser.CContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#c}.
	 * @param ctx the parse tree
	 */
	void exitC(CFGParser.CContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#inst}.
	 * @param ctx the parse tree
	 */
	void enterInst(CFGParser.InstContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#inst}.
	 * @param ctx the parse tree
	 */
	void exitInst(CFGParser.InstContext ctx);
	/**
	 * Enter a parse tree produced by {@link CFGParser#startPause}.
	 * @param ctx the parse tree
	 */
	void enterStartPause(CFGParser.StartPauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CFGParser#startPause}.
	 * @param ctx the parse tree
	 */
	void exitStartPause(CFGParser.StartPauseContext ctx);
}