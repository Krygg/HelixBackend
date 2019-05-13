// Generated from /Users/Maria/Documents/GitHub/HelixBackend/CFG.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CFGParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, BPM=2, NUM=3, NOTES=4, MEL=5, ADSR=6, TIME=7, START=8, PAUSE=9, 
		SEND=10, RECEIVE=11, IF=12, ELSE=13, PIANO=14, DRUM=15, LPAR=16, RPAR=17, 
		BEGIN=18, END=19, ASSIGN=20, SEMI=21, COMMA=22, PLUS=23, MINUS=24, MULT=25, 
		NOT=26, EQUAL=27, NUMBER=28, VARNAME=29, KEY=30, WS=31;
	public static final int
		RULE_program = 0, RULE_db = 1, RULE_dv = 2, RULE_di = 3, RULE_sp = 4, 
		RULE_stmts = 5, RULE_stmt = 6, RULE_bExp = 7, RULE_nAexp = 8, RULE_aExp = 9, 
		RULE_multExp = 10, RULE_atom = 11, RULE_k = 12, RULE_p = 13, RULE_c = 14, 
		RULE_inst = 15, RULE_startPause = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "db", "dv", "di", "sp", "stmts", "stmt", "bExp", "nAexp", 
			"aExp", "multExp", "atom", "k", "p", "c", "inst", "startPause"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'bpm'", "'num'", "'notes'", "'mel'", "'adsr'", "'time'", 
			"'start'", "'pause'", "'send'", "'receive'", "'if'", "'else'", "'Piano'", 
			"'Drum'", "'('", "')'", "'{'", "'}'", "'='", "';'", "','", "'+'", "'-'", 
			"'*'", "'!'", "'=='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "BPM", "NUM", "NOTES", "MEL", "ADSR", "TIME", "START", "PAUSE", 
			"SEND", "RECEIVE", "IF", "ELSE", "PIANO", "DRUM", "LPAR", "RPAR", "BEGIN", 
			"END", "ASSIGN", "SEMI", "COMMA", "PLUS", "MINUS", "MULT", "NOT", "EQUAL", 
			"NUMBER", "VARNAME", "KEY", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CFG.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CFGParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public DbContext db() {
			return getRuleContext(DbContext.class,0);
		}
		public DvContext dv() {
			return getRuleContext(DvContext.class,0);
		}
		public SpContext sp() {
			return getRuleContext(SpContext.class,0);
		}
		public DiContext di() {
			return getRuleContext(DiContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			db();
			setState(35);
			dv();
			setState(36);
			sp();
			setState(37);
			di();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DbContext extends ParserRuleContext {
		public TerminalNode BPM() { return getToken(CFGParser.BPM, 0); }
		public TerminalNode LPAR() { return getToken(CFGParser.LPAR, 0); }
		public TerminalNode NUMBER() { return getToken(CFGParser.NUMBER, 0); }
		public TerminalNode RPAR() { return getToken(CFGParser.RPAR, 0); }
		public TerminalNode SEMI() { return getToken(CFGParser.SEMI, 0); }
		public DbContext db() {
			return getRuleContext(DbContext.class,0);
		}
		public DbContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_db; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterDb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitDb(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitDb(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DbContext db() throws RecognitionException {
		DbContext _localctx = new DbContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_db);
		try {
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BPM:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(BPM);
				setState(40);
				match(LPAR);
				setState(41);
				match(NUMBER);
				setState(42);
				match(RPAR);
				setState(43);
				match(SEMI);
				setState(44);
				db();
				}
				break;
			case EOF:
			case NUM:
			case NOTES:
			case START:
			case PAUSE:
			case PIANO:
			case DRUM:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DvContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(CFGParser.NUM, 0); }
		public TerminalNode VARNAME() { return getToken(CFGParser.VARNAME, 0); }
		public TerminalNode ASSIGN() { return getToken(CFGParser.ASSIGN, 0); }
		public AExpContext aExp() {
			return getRuleContext(AExpContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(CFGParser.SEMI, 0); }
		public DvContext dv() {
			return getRuleContext(DvContext.class,0);
		}
		public TerminalNode NOTES() { return getToken(CFGParser.NOTES, 0); }
		public KContext k() {
			return getRuleContext(KContext.class,0);
		}
		public DvContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterDv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitDv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitDv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DvContext dv() throws RecognitionException {
		DvContext _localctx = new DvContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dv);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				match(NUM);
				setState(49);
				match(VARNAME);
				setState(50);
				match(ASSIGN);
				setState(51);
				aExp(0);
				setState(52);
				match(SEMI);
				setState(53);
				dv();
				}
				break;
			case NOTES:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(NOTES);
				setState(56);
				match(VARNAME);
				setState(57);
				match(ASSIGN);
				setState(58);
				k(0);
				setState(59);
				match(SEMI);
				setState(60);
				dv();
				}
				break;
			case EOF:
			case START:
			case PAUSE:
			case PIANO:
			case DRUM:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DiContext extends ParserRuleContext {
		public InstContext inst() {
			return getRuleContext(InstContext.class,0);
		}
		public PContext p() {
			return getRuleContext(PContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(CFGParser.BEGIN, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public TerminalNode END() { return getToken(CFGParser.END, 0); }
		public DiContext di() {
			return getRuleContext(DiContext.class,0);
		}
		public DiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_di; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterDi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitDi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitDi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DiContext di() throws RecognitionException {
		DiContext _localctx = new DiContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_di);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PIANO:
			case DRUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				inst();
				setState(66);
				p();
				setState(67);
				match(BEGIN);
				setState(68);
				stmts();
				setState(69);
				match(END);
				setState(70);
				di();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SpContext extends ParserRuleContext {
		public StartPauseContext startPause() {
			return getRuleContext(StartPauseContext.class,0);
		}
		public PContext p() {
			return getRuleContext(PContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(CFGParser.SEMI, 0); }
		public SpContext sp() {
			return getRuleContext(SpContext.class,0);
		}
		public SpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterSp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitSp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitSp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpContext sp() throws RecognitionException {
		SpContext _localctx = new SpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sp);
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case START:
			case PAUSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				startPause();
				setState(76);
				p();
				setState(77);
				match(SEMI);
				setState(78);
				sp();
				}
				break;
			case EOF:
			case PIANO:
			case DRUM:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtsContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(CFGParser.SEMI, 0); }
		public StmtsContext stmts() {
			return getRuleContext(StmtsContext.class,0);
		}
		public StmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterStmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitStmts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitStmts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtsContext stmts() throws RecognitionException {
		StmtsContext _localctx = new StmtsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_stmts);
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				stmt();
				setState(84);
				match(SEMI);
				setState(85);
				stmts();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				stmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public StartPauseContext startPause() {
			return getRuleContext(StartPauseContext.class,0);
		}
		public PContext p() {
			return getRuleContext(PContext.class,0);
		}
		public TerminalNode MEL() { return getToken(CFGParser.MEL, 0); }
		public TerminalNode LPAR() { return getToken(CFGParser.LPAR, 0); }
		public TerminalNode VARNAME() { return getToken(CFGParser.VARNAME, 0); }
		public TerminalNode RPAR() { return getToken(CFGParser.RPAR, 0); }
		public TerminalNode ASSIGN() { return getToken(CFGParser.ASSIGN, 0); }
		public List<AExpContext> aExp() {
			return getRuleContexts(AExpContext.class);
		}
		public AExpContext aExp(int i) {
			return getRuleContext(AExpContext.class,i);
		}
		public TerminalNode ADSR() { return getToken(CFGParser.ADSR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CFGParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CFGParser.COMMA, i);
		}
		public TerminalNode TIME() { return getToken(CFGParser.TIME, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(CFGParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(CFGParser.NUMBER, i);
		}
		public TerminalNode SEND() { return getToken(CFGParser.SEND, 0); }
		public CContext c() {
			return getRuleContext(CContext.class,0);
		}
		public TerminalNode RECEIVE() { return getToken(CFGParser.RECEIVE, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode IF() { return getToken(CFGParser.IF, 0); }
		public BExpContext bExp() {
			return getRuleContext(BExpContext.class,0);
		}
		public List<TerminalNode> BEGIN() { return getTokens(CFGParser.BEGIN); }
		public TerminalNode BEGIN(int i) {
			return getToken(CFGParser.BEGIN, i);
		}
		public List<StmtsContext> stmts() {
			return getRuleContexts(StmtsContext.class);
		}
		public StmtsContext stmts(int i) {
			return getRuleContext(StmtsContext.class,i);
		}
		public List<TerminalNode> END() { return getTokens(CFGParser.END); }
		public TerminalNode END(int i) {
			return getToken(CFGParser.END, i);
		}
		public TerminalNode ELSE() { return getToken(CFGParser.ELSE, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stmt);
		int _la;
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case START:
			case PAUSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				startPause();
				setState(91);
				p();
				}
				break;
			case MEL:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(MEL);
				setState(94);
				match(LPAR);
				setState(95);
				match(VARNAME);
				setState(96);
				match(RPAR);
				}
				break;
			case VARNAME:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
				match(VARNAME);
				setState(98);
				match(ASSIGN);
				setState(99);
				aExp(0);
				}
				break;
			case ADSR:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				match(ADSR);
				setState(101);
				match(LPAR);
				setState(102);
				aExp(0);
				setState(103);
				match(COMMA);
				setState(104);
				aExp(0);
				setState(105);
				match(COMMA);
				setState(106);
				aExp(0);
				setState(107);
				match(COMMA);
				setState(108);
				aExp(0);
				setState(109);
				match(RPAR);
				}
				break;
			case TIME:
				enterOuterAlt(_localctx, 5);
				{
				setState(111);
				match(TIME);
				setState(112);
				match(LPAR);
				setState(113);
				match(NUMBER);
				setState(114);
				match(COMMA);
				setState(115);
				match(NUMBER);
				setState(116);
				match(RPAR);
				}
				break;
			case SEND:
				enterOuterAlt(_localctx, 6);
				{
				setState(117);
				match(SEND);
				setState(118);
				match(LPAR);
				setState(119);
				c();
				setState(120);
				match(COMMA);
				setState(121);
				aExp(0);
				setState(122);
				match(RPAR);
				}
				break;
			case RECEIVE:
				enterOuterAlt(_localctx, 7);
				{
				setState(124);
				match(RECEIVE);
				setState(125);
				match(LPAR);
				setState(126);
				c();
				setState(127);
				match(COMMA);
				setState(128);
				match(VARNAME);
				setState(129);
				match(RPAR);
				setState(130);
				match(T__0);
				setState(131);
				stmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 8);
				{
				setState(133);
				match(IF);
				setState(134);
				match(LPAR);
				setState(135);
				bExp();
				setState(136);
				match(RPAR);
				setState(137);
				match(BEGIN);
				setState(138);
				stmts();
				setState(139);
				match(END);
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(140);
					match(ELSE);
					setState(141);
					match(BEGIN);
					setState(142);
					stmts();
					setState(143);
					match(END);
					}
				}

				}
				break;
			case END:
			case SEMI:
				enterOuterAlt(_localctx, 9);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BExpContext extends ParserRuleContext {
		public List<NAexpContext> nAexp() {
			return getRuleContexts(NAexpContext.class);
		}
		public NAexpContext nAexp(int i) {
			return getRuleContext(NAexpContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(CFGParser.EQUAL, 0); }
		public BExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterBExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitBExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitBExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BExpContext bExp() throws RecognitionException {
		BExpContext _localctx = new BExpContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			nAexp();
			setState(151);
			match(EQUAL);
			setState(152);
			nAexp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NAexpContext extends ParserRuleContext {
		public AExpContext aExp() {
			return getRuleContext(AExpContext.class,0);
		}
		public TerminalNode NOT() { return getToken(CFGParser.NOT, 0); }
		public NAexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nAexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterNAexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitNAexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitNAexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NAexpContext nAexp() throws RecognitionException {
		NAexpContext _localctx = new NAexpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_nAexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(154);
				match(NOT);
				}
			}

			setState(157);
			aExp(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AExpContext extends ParserRuleContext {
		public MultExpContext multExp() {
			return getRuleContext(MultExpContext.class,0);
		}
		public List<AExpContext> aExp() {
			return getRuleContexts(AExpContext.class);
		}
		public AExpContext aExp(int i) {
			return getRuleContext(AExpContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(CFGParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(CFGParser.PLUS, 0); }
		public AExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterAExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitAExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitAExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AExpContext aExp() throws RecognitionException {
		return aExp(0);
	}

	private AExpContext aExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AExpContext _localctx = new AExpContext(_ctx, _parentState);
		AExpContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_aExp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(160);
			multExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(167);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_aExp);
					setState(162);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(163);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(164);
					aExp(2);
					}
					} 
				}
				setState(169);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultExpContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<MultExpContext> multExp() {
			return getRuleContexts(MultExpContext.class);
		}
		public MultExpContext multExp(int i) {
			return getRuleContext(MultExpContext.class,i);
		}
		public TerminalNode MULT() { return getToken(CFGParser.MULT, 0); }
		public MultExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterMultExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitMultExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitMultExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultExpContext multExp() throws RecognitionException {
		return multExp(0);
	}

	private MultExpContext multExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultExpContext _localctx = new MultExpContext(_ctx, _parentState);
		MultExpContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_multExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(171);
			atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multExp);
					setState(173);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(174);
					match(MULT);
					setState(175);
					multExp(2);
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(CFGParser.NUMBER, 0); }
		public TerminalNode VARNAME() { return getToken(CFGParser.VARNAME, 0); }
		public TerminalNode LPAR() { return getToken(CFGParser.LPAR, 0); }
		public AExpContext aExp() {
			return getRuleContext(AExpContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(CFGParser.RPAR, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_atom);
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(NUMBER);
				}
				break;
			case VARNAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				match(VARNAME);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				match(LPAR);
				setState(184);
				aExp(0);
				setState(185);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KContext extends ParserRuleContext {
		public TerminalNode KEY() { return getToken(CFGParser.KEY, 0); }
		public TerminalNode LPAR() { return getToken(CFGParser.LPAR, 0); }
		public List<KContext> k() {
			return getRuleContexts(KContext.class);
		}
		public KContext k(int i) {
			return getRuleContext(KContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(CFGParser.RPAR, 0); }
		public TerminalNode NUMBER() { return getToken(CFGParser.NUMBER, 0); }
		public TerminalNode COMMA() { return getToken(CFGParser.COMMA, 0); }
		public KContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_k; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterK(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitK(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitK(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KContext k() throws RecognitionException {
		return k(0);
	}

	private KContext k(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		KContext _localctx = new KContext(_ctx, _parentState);
		KContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_k, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(190);
				match(KEY);
				}
				break;
			case 2:
				{
				setState(191);
				match(LPAR);
				setState(192);
				k(0);
				setState(193);
				match(RPAR);
				}
				break;
			case 3:
				{
				setState(195);
				match(NUMBER);
				}
				break;
			case 4:
				{
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new KContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_k);
					setState(199);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(200);
					match(COMMA);
					setState(201);
					k(6);
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PContext extends ParserRuleContext {
		public TerminalNode VARNAME() { return getToken(CFGParser.VARNAME, 0); }
		public PContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PContext p() throws RecognitionException {
		PContext _localctx = new PContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_p);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(VARNAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CContext extends ParserRuleContext {
		public TerminalNode VARNAME() { return getToken(CFGParser.VARNAME, 0); }
		public CContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_c; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitC(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitC(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CContext c() throws RecognitionException {
		CContext _localctx = new CContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_c);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(VARNAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstContext extends ParserRuleContext {
		public TerminalNode PIANO() { return getToken(CFGParser.PIANO, 0); }
		public TerminalNode DRUM() { return getToken(CFGParser.DRUM, 0); }
		public InstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterInst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitInst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitInst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstContext inst() throws RecognitionException {
		InstContext _localctx = new InstContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_inst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_la = _input.LA(1);
			if ( !(_la==PIANO || _la==DRUM) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StartPauseContext extends ParserRuleContext {
		public TerminalNode START() { return getToken(CFGParser.START, 0); }
		public TerminalNode PAUSE() { return getToken(CFGParser.PAUSE, 0); }
		public StartPauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startPause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).enterStartPause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CFGListener ) ((CFGListener)listener).exitStartPause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CFGVisitor ) return ((CFGVisitor<? extends T>)visitor).visitStartPause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartPauseContext startPause() throws RecognitionException {
		StartPauseContext _localctx = new StartPauseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_startPause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_la = _input.LA(1);
			if ( !(_la==START || _la==PAUSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return aExp_sempred((AExpContext)_localctx, predIndex);
		case 10:
			return multExp_sempred((MultExpContext)_localctx, predIndex);
		case 12:
			return k_sempred((KContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean aExp_sempred(AExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multExp_sempred(MultExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean k_sempred(KContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00da\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\61\n\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4B\n\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5L\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6T\n\6\3\7\3"+
		"\7\3\7\3\7\3\7\5\7[\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0094\n\b\3\b\5\b\u0097\n\b\3\t"+
		"\3\t\3\t\3\t\3\n\5\n\u009e\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\7"+
		"\13\u00a8\n\13\f\13\16\13\u00ab\13\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00b3"+
		"\n\f\f\f\16\f\u00b6\13\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00be\n\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00c8\n\16\3\16\3\16\3\16\7\16"+
		"\u00cd\n\16\f\16\16\16\u00d0\13\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\22\2\5\24\26\32\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2"+
		"\5\3\2\31\32\3\2\20\21\3\2\n\13\2\u00e0\2$\3\2\2\2\4\60\3\2\2\2\6A\3\2"+
		"\2\2\bK\3\2\2\2\nS\3\2\2\2\fZ\3\2\2\2\16\u0096\3\2\2\2\20\u0098\3\2\2"+
		"\2\22\u009d\3\2\2\2\24\u00a1\3\2\2\2\26\u00ac\3\2\2\2\30\u00bd\3\2\2\2"+
		"\32\u00c7\3\2\2\2\34\u00d1\3\2\2\2\36\u00d3\3\2\2\2 \u00d5\3\2\2\2\"\u00d7"+
		"\3\2\2\2$%\5\4\3\2%&\5\6\4\2&\'\5\n\6\2\'(\5\b\5\2(\3\3\2\2\2)*\7\4\2"+
		"\2*+\7\22\2\2+,\7\36\2\2,-\7\23\2\2-.\7\27\2\2.\61\5\4\3\2/\61\3\2\2\2"+
		"\60)\3\2\2\2\60/\3\2\2\2\61\5\3\2\2\2\62\63\7\5\2\2\63\64\7\37\2\2\64"+
		"\65\7\26\2\2\65\66\5\24\13\2\66\67\7\27\2\2\678\5\6\4\28B\3\2\2\29:\7"+
		"\6\2\2:;\7\37\2\2;<\7\26\2\2<=\5\32\16\2=>\7\27\2\2>?\5\6\4\2?B\3\2\2"+
		"\2@B\3\2\2\2A\62\3\2\2\2A9\3\2\2\2A@\3\2\2\2B\7\3\2\2\2CD\5 \21\2DE\5"+
		"\34\17\2EF\7\24\2\2FG\5\f\7\2GH\7\25\2\2HI\5\b\5\2IL\3\2\2\2JL\3\2\2\2"+
		"KC\3\2\2\2KJ\3\2\2\2L\t\3\2\2\2MN\5\"\22\2NO\5\34\17\2OP\7\27\2\2PQ\5"+
		"\n\6\2QT\3\2\2\2RT\3\2\2\2SM\3\2\2\2SR\3\2\2\2T\13\3\2\2\2UV\5\16\b\2"+
		"VW\7\27\2\2WX\5\f\7\2X[\3\2\2\2Y[\5\16\b\2ZU\3\2\2\2ZY\3\2\2\2[\r\3\2"+
		"\2\2\\]\5\"\22\2]^\5\34\17\2^\u0097\3\2\2\2_`\7\7\2\2`a\7\22\2\2ab\7\37"+
		"\2\2b\u0097\7\23\2\2cd\7\37\2\2de\7\26\2\2e\u0097\5\24\13\2fg\7\b\2\2"+
		"gh\7\22\2\2hi\5\24\13\2ij\7\30\2\2jk\5\24\13\2kl\7\30\2\2lm\5\24\13\2"+
		"mn\7\30\2\2no\5\24\13\2op\7\23\2\2p\u0097\3\2\2\2qr\7\t\2\2rs\7\22\2\2"+
		"st\7\36\2\2tu\7\30\2\2uv\7\36\2\2v\u0097\7\23\2\2wx\7\f\2\2xy\7\22\2\2"+
		"yz\5\36\20\2z{\7\30\2\2{|\5\24\13\2|}\7\23\2\2}\u0097\3\2\2\2~\177\7\r"+
		"\2\2\177\u0080\7\22\2\2\u0080\u0081\5\36\20\2\u0081\u0082\7\30\2\2\u0082"+
		"\u0083\7\37\2\2\u0083\u0084\7\23\2\2\u0084\u0085\7\3\2\2\u0085\u0086\5"+
		"\16\b\2\u0086\u0097\3\2\2\2\u0087\u0088\7\16\2\2\u0088\u0089\7\22\2\2"+
		"\u0089\u008a\5\20\t\2\u008a\u008b\7\23\2\2\u008b\u008c\7\24\2\2\u008c"+
		"\u008d\5\f\7\2\u008d\u0093\7\25\2\2\u008e\u008f\7\17\2\2\u008f\u0090\7"+
		"\24\2\2\u0090\u0091\5\f\7\2\u0091\u0092\7\25\2\2\u0092\u0094\3\2\2\2\u0093"+
		"\u008e\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0097\3\2"+
		"\2\2\u0096\\\3\2\2\2\u0096_\3\2\2\2\u0096c\3\2\2\2\u0096f\3\2\2\2\u0096"+
		"q\3\2\2\2\u0096w\3\2\2\2\u0096~\3\2\2\2\u0096\u0087\3\2\2\2\u0096\u0095"+
		"\3\2\2\2\u0097\17\3\2\2\2\u0098\u0099\5\22\n\2\u0099\u009a\7\35\2\2\u009a"+
		"\u009b\5\22\n\2\u009b\21\3\2\2\2\u009c\u009e\7\34\2\2\u009d\u009c\3\2"+
		"\2\2\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\5\24\13\2\u00a0"+
		"\23\3\2\2\2\u00a1\u00a2\b\13\1\2\u00a2\u00a3\5\26\f\2\u00a3\u00a9\3\2"+
		"\2\2\u00a4\u00a5\f\3\2\2\u00a5\u00a6\t\2\2\2\u00a6\u00a8\5\24\13\4\u00a7"+
		"\u00a4\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2"+
		"\2\2\u00aa\25\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ad\b\f\1\2\u00ad\u00ae"+
		"\5\30\r\2\u00ae\u00b4\3\2\2\2\u00af\u00b0\f\3\2\2\u00b0\u00b1\7\33\2\2"+
		"\u00b1\u00b3\5\26\f\4\u00b2\u00af\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\27\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00be\7\36\2\2\u00b8\u00be\7\37\2\2\u00b9\u00ba\7\22\2\2\u00ba\u00bb"+
		"\5\24\13\2\u00bb\u00bc\7\23\2\2\u00bc\u00be\3\2\2\2\u00bd\u00b7\3\2\2"+
		"\2\u00bd\u00b8\3\2\2\2\u00bd\u00b9\3\2\2\2\u00be\31\3\2\2\2\u00bf\u00c0"+
		"\b\16\1\2\u00c0\u00c8\7 \2\2\u00c1\u00c2\7\22\2\2\u00c2\u00c3\5\32\16"+
		"\2\u00c3\u00c4\7\23\2\2\u00c4\u00c8\3\2\2\2\u00c5\u00c8\7\36\2\2\u00c6"+
		"\u00c8\3\2\2\2\u00c7\u00bf\3\2\2\2\u00c7\u00c1\3\2\2\2\u00c7\u00c5\3\2"+
		"\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00ce\3\2\2\2\u00c9\u00ca\f\7\2\2\u00ca"+
		"\u00cb\7\30\2\2\u00cb\u00cd\5\32\16\b\u00cc\u00c9\3\2\2\2\u00cd\u00d0"+
		"\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\33\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d1\u00d2\7\37\2\2\u00d2\35\3\2\2\2\u00d3\u00d4\7\37"+
		"\2\2\u00d4\37\3\2\2\2\u00d5\u00d6\t\3\2\2\u00d6!\3\2\2\2\u00d7\u00d8\t"+
		"\4\2\2\u00d8#\3\2\2\2\17\60AKSZ\u0093\u0096\u009d\u00a9\u00b4\u00bd\u00c7"+
		"\u00ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}