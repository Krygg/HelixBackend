// Generated from C:/Users/Krog/IdeaProjects/OSCtest\CFG.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CFGParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CFGVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CFGParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CFGParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#db}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDb(CFGParser.DbContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#dv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDv(CFGParser.DvContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#di}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDi(CFGParser.DiContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#sp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSp(CFGParser.SpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmts(CFGParser.StmtsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(CFGParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#nBExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNBExp(CFGParser.NBExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#bExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBExp(CFGParser.BExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#aExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAExp(CFGParser.AExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#multExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExp(CFGParser.MultExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(CFGParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#k}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitK(CFGParser.KContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#p}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitP(CFGParser.PContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#c}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitC(CFGParser.CContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#inst}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInst(CFGParser.InstContext ctx);
	/**
	 * Visit a parse tree produced by {@link CFGParser#startPause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartPause(CFGParser.StartPauseContext ctx);
}