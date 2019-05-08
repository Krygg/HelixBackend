// Generated from C:/Users/Maria-Theresa/IdeaProjects/HelixBackend\CFG.g4 by ANTLR 4.7.2
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CFGLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, BPM=2, NUM=3, NOTES=4, MEL=5, ADSR=6, TIME=7, START=8, PAUSE=9, 
		SEND=10, RECEIVE=11, IF=12, ELSE=13, PIANO=14, DRUM=15, LPAR=16, RPAR=17, 
		BEGIN=18, END=19, ASSIGN=20, SEMI=21, COMMA=22, PLUS=23, MINUS=24, MULT=25, 
		NOT=26, EQUAL=27, NUMBER=28, VARNAME=29, KEY=30, WS=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "BPM", "NUM", "NOTES", "MEL", "ADSR", "TIME", "START", "PAUSE", 
			"SEND", "RECEIVE", "IF", "ELSE", "PIANO", "DRUM", "LPAR", "RPAR", "BEGIN", 
			"END", "ASSIGN", "SEMI", "COMMA", "PLUS", "MINUS", "MULT", "NOT", "EQUAL", 
			"NUMBER", "VARNAME", "KEY", "WS"
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


	public CFGLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CFG.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00c3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\34\3\35\6\35\u00a6\n\35\r\35\16\35\u00a7\3\36\6\36\u00ab"+
		"\n\36\r\36\16\36\u00ac\3\36\3\36\6\36\u00b1\n\36\r\36\16\36\u00b2\5\36"+
		"\u00b5\n\36\3\37\3\37\5\37\u00b9\n\37\3\37\3\37\3\37\5\37\u00be\n\37\3"+
		" \3 \3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!\3\2\6\3\2\62;\4\2C\\c|\4\2CIci\5\2\13\f\17\17\""+
		"\"\2\u00c8\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5C\3\2\2\2\7G\3\2\2\2"+
		"\tK\3\2\2\2\13Q\3\2\2\2\rU\3\2\2\2\17Z\3\2\2\2\21_\3\2\2\2\23e\3\2\2\2"+
		"\25k\3\2\2\2\27p\3\2\2\2\31x\3\2\2\2\33{\3\2\2\2\35\u0080\3\2\2\2\37\u0086"+
		"\3\2\2\2!\u008b\3\2\2\2#\u008d\3\2\2\2%\u008f\3\2\2\2\'\u0091\3\2\2\2"+
		")\u0093\3\2\2\2+\u0095\3\2\2\2-\u0097\3\2\2\2/\u0099\3\2\2\2\61\u009b"+
		"\3\2\2\2\63\u009d\3\2\2\2\65\u009f\3\2\2\2\67\u00a1\3\2\2\29\u00a5\3\2"+
		"\2\2;\u00aa\3\2\2\2=\u00b6\3\2\2\2?\u00bf\3\2\2\2AB\7\60\2\2B\4\3\2\2"+
		"\2CD\7d\2\2DE\7r\2\2EF\7o\2\2F\6\3\2\2\2GH\7p\2\2HI\7w\2\2IJ\7o\2\2J\b"+
		"\3\2\2\2KL\7p\2\2LM\7q\2\2MN\7v\2\2NO\7g\2\2OP\7u\2\2P\n\3\2\2\2QR\7o"+
		"\2\2RS\7g\2\2ST\7n\2\2T\f\3\2\2\2UV\7c\2\2VW\7f\2\2WX\7u\2\2XY\7t\2\2"+
		"Y\16\3\2\2\2Z[\7v\2\2[\\\7k\2\2\\]\7o\2\2]^\7g\2\2^\20\3\2\2\2_`\7u\2"+
		"\2`a\7v\2\2ab\7c\2\2bc\7t\2\2cd\7v\2\2d\22\3\2\2\2ef\7r\2\2fg\7c\2\2g"+
		"h\7w\2\2hi\7u\2\2ij\7g\2\2j\24\3\2\2\2kl\7u\2\2lm\7g\2\2mn\7p\2\2no\7"+
		"f\2\2o\26\3\2\2\2pq\7t\2\2qr\7g\2\2rs\7e\2\2st\7g\2\2tu\7k\2\2uv\7x\2"+
		"\2vw\7g\2\2w\30\3\2\2\2xy\7k\2\2yz\7h\2\2z\32\3\2\2\2{|\7g\2\2|}\7n\2"+
		"\2}~\7u\2\2~\177\7g\2\2\177\34\3\2\2\2\u0080\u0081\7R\2\2\u0081\u0082"+
		"\7k\2\2\u0082\u0083\7c\2\2\u0083\u0084\7p\2\2\u0084\u0085\7q\2\2\u0085"+
		"\36\3\2\2\2\u0086\u0087\7F\2\2\u0087\u0088\7t\2\2\u0088\u0089\7w\2\2\u0089"+
		"\u008a\7o\2\2\u008a \3\2\2\2\u008b\u008c\7*\2\2\u008c\"\3\2\2\2\u008d"+
		"\u008e\7+\2\2\u008e$\3\2\2\2\u008f\u0090\7}\2\2\u0090&\3\2\2\2\u0091\u0092"+
		"\7\177\2\2\u0092(\3\2\2\2\u0093\u0094\7?\2\2\u0094*\3\2\2\2\u0095\u0096"+
		"\7=\2\2\u0096,\3\2\2\2\u0097\u0098\7.\2\2\u0098.\3\2\2\2\u0099\u009a\7"+
		"-\2\2\u009a\60\3\2\2\2\u009b\u009c\7/\2\2\u009c\62\3\2\2\2\u009d\u009e"+
		"\7,\2\2\u009e\64\3\2\2\2\u009f\u00a0\7#\2\2\u00a0\66\3\2\2\2\u00a1\u00a2"+
		"\7?\2\2\u00a2\u00a3\7?\2\2\u00a38\3\2\2\2\u00a4\u00a6\t\2\2\2\u00a5\u00a4"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		":\3\2\2\2\u00a9\u00ab\t\3\2\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2"+
		"\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00b4\3\2\2\2\u00ae\u00b0"+
		"\7a\2\2\u00af\u00b1\t\2\2\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00ae\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5<\3\2\2\2\u00b6\u00b8\t\4\2\2\u00b7\u00b9"+
		"\7%\2\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bd\3\2\2\2\u00ba"+
		"\u00be\t\2\2\2\u00bb\u00bc\7/\2\2\u00bc\u00be\7\63\2\2\u00bd\u00ba\3\2"+
		"\2\2\u00bd\u00bb\3\2\2\2\u00be>\3\2\2\2\u00bf\u00c0\t\5\2\2\u00c0\u00c1"+
		"\3\2\2\2\u00c1\u00c2\b \2\2\u00c2@\3\2\2\2\t\2\u00a7\u00ac\u00b2\u00b4"+
		"\u00b8\u00bd\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}