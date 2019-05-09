// Generated from C:/Users/Maria-Theresa/IdeaProjects/HelixBackend\CFG.g4 by ANTLR 4.7.2
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
		RULE_stmt = 5, RULE_bExp = 6, RULE_nAexp = 7, RULE_aExp = 8, RULE_multExp = 9, 
		RULE_atom = 10, RULE_k = 11, RULE_p = 12, RULE_c = 13, RULE_inst = 14, 
		RULE_startPause = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "db", "dv", "di", "sp", "stmt", "bExp", "nAexp", "aExp", "multExp", 
			"atom", "k", "p", "c", "inst", "startPause"
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
			setState(32);
			db();
			setState(33);
			dv();
			setState(34);
			sp();
			setState(35);
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
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BPM:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(BPM);
				setState(38);
				match(LPAR);
				setState(39);
				match(NUMBER);
				setState(40);
				match(RPAR);
				setState(41);
				match(SEMI);
				setState(42);
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
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				match(NUM);
				setState(47);
				match(VARNAME);
				setState(48);
				match(ASSIGN);
				setState(49);
				aExp();
				setState(50);
				match(SEMI);
				setState(51);
				dv();
				}
				break;
			case NOTES:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				match(NOTES);
				setState(54);
				match(VARNAME);
				setState(55);
				match(ASSIGN);
				setState(56);
				k(0);
				setState(57);
				match(SEMI);
				setState(58);
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
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
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
			setState(71);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PIANO:
			case DRUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				inst();
				setState(64);
				p();
				setState(65);
				match(BEGIN);
				setState(66);
				stmt(0);
				setState(67);
				match(END);
				setState(68);
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
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case START:
			case PAUSE:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				startPause();
				setState(74);
				p();
				setState(75);
				match(SEMI);
				setState(76);
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
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode IF() { return getToken(CFGParser.IF, 0); }
		public BExpContext bExp() {
			return getRuleContext(BExpContext.class,0);
		}
		public List<TerminalNode> BEGIN() { return getTokens(CFGParser.BEGIN); }
		public TerminalNode BEGIN(int i) {
			return getToken(CFGParser.BEGIN, i);
		}
		public List<TerminalNode> END() { return getTokens(CFGParser.END); }
		public TerminalNode END(int i) {
			return getToken(CFGParser.END, i);
		}
		public TerminalNode ELSE() { return getToken(CFGParser.ELSE, 0); }
		public TerminalNode SEMI() { return getToken(CFGParser.SEMI, 0); }
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
		return stmt(0);
	}

	private StmtContext stmt(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StmtContext _localctx = new StmtContext(_ctx, _parentState);
		StmtContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_stmt, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(82);
				startPause();
				setState(83);
				p();
				}
				break;
			case 2:
				{
				setState(85);
				match(MEL);
				setState(86);
				match(LPAR);
				setState(87);
				match(VARNAME);
				setState(88);
				match(RPAR);
				}
				break;
			case 3:
				{
				setState(89);
				match(VARNAME);
				setState(90);
				match(ASSIGN);
				setState(91);
				aExp();
				}
				break;
			case 4:
				{
				setState(92);
				match(ADSR);
				setState(93);
				match(LPAR);
				{
				setState(94);
				aExp();
				setState(95);
				match(COMMA);
				setState(96);
				aExp();
				setState(97);
				match(COMMA);
				setState(98);
				aExp();
				setState(99);
				match(COMMA);
				setState(100);
				aExp();
				}
				setState(102);
				match(RPAR);
				}
				break;
			case 5:
				{
				setState(104);
				match(TIME);
				setState(105);
				match(LPAR);
				setState(106);
				match(NUMBER);
				setState(107);
				match(COMMA);
				setState(108);
				match(NUMBER);
				setState(109);
				match(RPAR);
				}
				break;
			case 6:
				{
				setState(110);
				match(SEND);
				setState(111);
				match(LPAR);
				setState(112);
				c();
				setState(113);
				match(COMMA);
				setState(114);
				aExp();
				setState(115);
				match(RPAR);
				}
				break;
			case 7:
				{
				setState(117);
				match(RECEIVE);
				setState(118);
				match(LPAR);
				setState(119);
				c();
				setState(120);
				match(COMMA);
				setState(121);
				match(VARNAME);
				setState(122);
				match(RPAR);
				setState(123);
				match(T__0);
				setState(124);
				stmt(3);
				}
				break;
			case 8:
				{
				setState(126);
				match(IF);
				setState(127);
				match(LPAR);
				setState(128);
				bExp();
				setState(129);
				match(RPAR);
				setState(130);
				match(BEGIN);
				setState(131);
				stmt(0);
				setState(132);
				match(END);
				setState(138);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(133);
					match(ELSE);
					setState(134);
					match(BEGIN);
					setState(135);
					stmt(0);
					setState(136);
					match(END);
					}
					break;
				}
				}
				break;
			case 9:
				{
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StmtContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stmt);
					setState(143);
					if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
					setState(144);
					match(SEMI);
					setState(145);
					stmt(7);
					}
					} 
				}
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
		enterRule(_localctx, 12, RULE_bExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			nAexp();
			setState(152);
			match(EQUAL);
			setState(153);
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
		enterRule(_localctx, 14, RULE_nAexp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(155);
				match(NOT);
				}
			}

			setState(158);
			aExp();
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
		public AExpContext aExp() {
			return getRuleContext(AExpContext.class,0);
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
		AExpContext _localctx = new AExpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_aExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			multExp();
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(161);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(162);
				aExp();
				}
				break;
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

	public static class MultExpContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode MULT() { return getToken(CFGParser.MULT, 0); }
		public MultExpContext multExp() {
			return getRuleContext(MultExpContext.class,0);
		}
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
		MultExpContext _localctx = new MultExpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_multExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			atom();
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(166);
				match(MULT);
				setState(167);
				multExp();
				}
				break;
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
		enterRule(_localctx, 20, RULE_atom);
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(NUMBER);
				}
				break;
			case VARNAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				match(VARNAME);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				match(LPAR);
				setState(173);
				aExp();
				setState(174);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_k, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(179);
				match(KEY);
				}
				break;
			case 2:
				{
				setState(180);
				match(LPAR);
				setState(181);
				k(0);
				setState(182);
				match(RPAR);
				}
				break;
			case 3:
				{
				setState(184);
				match(NUMBER);
				}
				break;
			case 4:
				{
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(193);
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
					setState(188);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(189);
					match(COMMA);
					setState(190);
					k(6);
					}
					} 
				}
				setState(195);
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
		enterRule(_localctx, 24, RULE_p);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
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
		enterRule(_localctx, 26, RULE_c);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
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
		enterRule(_localctx, 28, RULE_inst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
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
		enterRule(_localctx, 30, RULE_startPause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
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
		case 5:
			return stmt_sempred((StmtContext)_localctx, predIndex);
		case 11:
			return k_sempred((KContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean stmt_sempred(StmtContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean k_sempred(KContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00cf\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3/\n\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4@\n\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\5\5J\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6R\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\5\7\u008d\n\7\3\7\5\7\u0090\n\7\3\7\3\7\3\7\7\7\u0095\n\7\f\7\16\7\u0098"+
		"\13\7\3\b\3\b\3\b\3\b\3\t\5\t\u009f\n\t\3\t\3\t\3\n\3\n\3\n\5\n\u00a6"+
		"\n\n\3\13\3\13\3\13\5\13\u00ab\n\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b3"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00bd\n\r\3\r\3\r\3\r\7\r\u00c2"+
		"\n\r\f\r\16\r\u00c5\13\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21"+
		"\2\4\f\30\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\5\3\2\31\32\3\2"+
		"\20\21\3\2\n\13\2\u00d6\2\"\3\2\2\2\4.\3\2\2\2\6?\3\2\2\2\bI\3\2\2\2\n"+
		"Q\3\2\2\2\f\u008f\3\2\2\2\16\u0099\3\2\2\2\20\u009e\3\2\2\2\22\u00a2\3"+
		"\2\2\2\24\u00a7\3\2\2\2\26\u00b2\3\2\2\2\30\u00bc\3\2\2\2\32\u00c6\3\2"+
		"\2\2\34\u00c8\3\2\2\2\36\u00ca\3\2\2\2 \u00cc\3\2\2\2\"#\5\4\3\2#$\5\6"+
		"\4\2$%\5\n\6\2%&\5\b\5\2&\3\3\2\2\2\'(\7\4\2\2()\7\22\2\2)*\7\36\2\2*"+
		"+\7\23\2\2+,\7\27\2\2,/\5\4\3\2-/\3\2\2\2.\'\3\2\2\2.-\3\2\2\2/\5\3\2"+
		"\2\2\60\61\7\5\2\2\61\62\7\37\2\2\62\63\7\26\2\2\63\64\5\22\n\2\64\65"+
		"\7\27\2\2\65\66\5\6\4\2\66@\3\2\2\2\678\7\6\2\289\7\37\2\29:\7\26\2\2"+
		":;\5\30\r\2;<\7\27\2\2<=\5\6\4\2=@\3\2\2\2>@\3\2\2\2?\60\3\2\2\2?\67\3"+
		"\2\2\2?>\3\2\2\2@\7\3\2\2\2AB\5\36\20\2BC\5\32\16\2CD\7\24\2\2DE\5\f\7"+
		"\2EF\7\25\2\2FG\5\b\5\2GJ\3\2\2\2HJ\3\2\2\2IA\3\2\2\2IH\3\2\2\2J\t\3\2"+
		"\2\2KL\5 \21\2LM\5\32\16\2MN\7\27\2\2NO\5\n\6\2OR\3\2\2\2PR\3\2\2\2QK"+
		"\3\2\2\2QP\3\2\2\2R\13\3\2\2\2ST\b\7\1\2TU\5 \21\2UV\5\32\16\2V\u0090"+
		"\3\2\2\2WX\7\7\2\2XY\7\22\2\2YZ\7\37\2\2Z\u0090\7\23\2\2[\\\7\37\2\2\\"+
		"]\7\26\2\2]\u0090\5\22\n\2^_\7\b\2\2_`\7\22\2\2`a\5\22\n\2ab\7\30\2\2"+
		"bc\5\22\n\2cd\7\30\2\2de\5\22\n\2ef\7\30\2\2fg\5\22\n\2gh\3\2\2\2hi\7"+
		"\23\2\2i\u0090\3\2\2\2jk\7\t\2\2kl\7\22\2\2lm\7\36\2\2mn\7\30\2\2no\7"+
		"\36\2\2o\u0090\7\23\2\2pq\7\f\2\2qr\7\22\2\2rs\5\34\17\2st\7\30\2\2tu"+
		"\5\22\n\2uv\7\23\2\2v\u0090\3\2\2\2wx\7\r\2\2xy\7\22\2\2yz\5\34\17\2z"+
		"{\7\30\2\2{|\7\37\2\2|}\7\23\2\2}~\7\3\2\2~\177\5\f\7\5\177\u0090\3\2"+
		"\2\2\u0080\u0081\7\16\2\2\u0081\u0082\7\22\2\2\u0082\u0083\5\16\b\2\u0083"+
		"\u0084\7\23\2\2\u0084\u0085\7\24\2\2\u0085\u0086\5\f\7\2\u0086\u008c\7"+
		"\25\2\2\u0087\u0088\7\17\2\2\u0088\u0089\7\24\2\2\u0089\u008a\5\f\7\2"+
		"\u008a\u008b\7\25\2\2\u008b\u008d\3\2\2\2\u008c\u0087\3\2\2\2\u008c\u008d"+
		"\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u0090\3\2\2\2\u008fS\3\2\2\2\u008f"+
		"W\3\2\2\2\u008f[\3\2\2\2\u008f^\3\2\2\2\u008fj\3\2\2\2\u008fp\3\2\2\2"+
		"\u008fw\3\2\2\2\u008f\u0080\3\2\2\2\u008f\u008e\3\2\2\2\u0090\u0096\3"+
		"\2\2\2\u0091\u0092\f\b\2\2\u0092\u0093\7\27\2\2\u0093\u0095\5\f\7\t\u0094"+
		"\u0091\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2"+
		"\2\2\u0097\r\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a\5\20\t\2\u009a\u009b"+
		"\7\35\2\2\u009b\u009c\5\20\t\2\u009c\17\3\2\2\2\u009d\u009f\7\34\2\2\u009e"+
		"\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\5\22"+
		"\n\2\u00a1\21\3\2\2\2\u00a2\u00a5\5\24\13\2\u00a3\u00a4\t\2\2\2\u00a4"+
		"\u00a6\5\22\n\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\23\3\2\2"+
		"\2\u00a7\u00aa\5\26\f\2\u00a8\u00a9\7\33\2\2\u00a9\u00ab\5\24\13\2\u00aa"+
		"\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\25\3\2\2\2\u00ac\u00b3\7\36\2"+
		"\2\u00ad\u00b3\7\37\2\2\u00ae\u00af\7\22\2\2\u00af\u00b0\5\22\n\2\u00b0"+
		"\u00b1\7\23\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00ac\3\2\2\2\u00b2\u00ad\3"+
		"\2\2\2\u00b2\u00ae\3\2\2\2\u00b3\27\3\2\2\2\u00b4\u00b5\b\r\1\2\u00b5"+
		"\u00bd\7 \2\2\u00b6\u00b7\7\22\2\2\u00b7\u00b8\5\30\r\2\u00b8\u00b9\7"+
		"\23\2\2\u00b9\u00bd\3\2\2\2\u00ba\u00bd\7\36\2\2\u00bb\u00bd\3\2\2\2\u00bc"+
		"\u00b4\3\2\2\2\u00bc\u00b6\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2"+
		"\2\2\u00bd\u00c3\3\2\2\2\u00be\u00bf\f\7\2\2\u00bf\u00c0\7\30\2\2\u00c0"+
		"\u00c2\5\30\r\b\u00c1\u00be\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3"+
		"\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\31\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6"+
		"\u00c7\7\37\2\2\u00c7\33\3\2\2\2\u00c8\u00c9\7\37\2\2\u00c9\35\3\2\2\2"+
		"\u00ca\u00cb\t\3\2\2\u00cb\37\3\2\2\2\u00cc\u00cd\t\4\2\2\u00cd!\3\2\2"+
		"\2\17.?IQ\u008c\u008f\u0096\u009e\u00a5\u00aa\u00b2\u00bc\u00c3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}