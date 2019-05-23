// Generated from C:/Users/Krog/IdeaProjects/OSCtest\CFG.g4 by ANTLR 4.7.2
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
		SEND=10, RECEIVE=11, IF=12, ELSE=13, PIANO=14, DRUM=15, BEEP=16, BLADE=17, 
		BNOICE=18, CHIPBASE=19, CHIPLEAD=20, CHIPNOISE=21, CNOISE=22, DPULSE=23, 
		DSAW=24, DTRI=25, FM=26, GNOISE=27, GROWL=28, HOLLOW=29, HOOVER=30, NOISE=31, 
		PLUCK=32, PNOISE=33, PROPHET=34, PULSE=35, SAW=36, SINE=37, SQUARE=38, 
		SUBPULSE=39, SUPERSAW=40, TB303=41, TRI=42, ZAWA=43, LPAR=44, RPAR=45, 
		BEGIN=46, END=47, ASSIGN=48, SEMI=49, COMMA=50, PLUS=51, MINUS=52, MULT=53, 
		NOT=54, EQUAL=55, NUMBER=56, VARNAME=57, KEY=58, WS=59;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "BPM", "NUM", "NOTES", "MEL", "ADSR", "TIME", "START", "PAUSE", 
			"SEND", "RECEIVE", "IF", "ELSE", "PIANO", "DRUM", "BEEP", "BLADE", "BNOICE", 
			"CHIPBASE", "CHIPLEAD", "CHIPNOISE", "CNOISE", "DPULSE", "DSAW", "DTRI", 
			"FM", "GNOISE", "GROWL", "HOLLOW", "HOOVER", "NOISE", "PLUCK", "PNOISE", 
			"PROPHET", "PULSE", "SAW", "SINE", "SQUARE", "SUBPULSE", "SUPERSAW", 
			"TB303", "TRI", "ZAWA", "LPAR", "RPAR", "BEGIN", "END", "ASSIGN", "SEMI", 
			"COMMA", "PLUS", "MINUS", "MULT", "NOT", "EQUAL", "NUMBER", "VARNAME", 
			"KEY", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'bpm'", "'num'", "'notes'", "'mel'", "'adsr'", "'time'", 
			"'start'", "'pause'", "'send'", "'receive'", "'if'", "'else'", "'Piano'", 
			"'Drum'", "'beep'", "'blade'", "'bnoise'", "'chipbass'", "'chiplead'", 
			"'chipnoise'", "'cnoice'", "'dpulse'", "'dsaw'", "'dtri'", "'fm'", "'gnoise'", 
			"'growl'", "'hollow'", "'hoover'", "'noise'", "'pluck'", "'pnoise'", 
			"'prophet'", "'pulse'", "'saw'", "'sine'", "'square'", "'subpulse'", 
			"'supersaw'", "'tb303'", "'tri'", "'zawa'", "'('", "')'", "'{'", "'}'", 
			"'='", "';'", "','", "'+'", "'-'", "'*'", "'!'", "'=='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "BPM", "NUM", "NOTES", "MEL", "ADSR", "TIME", "START", "PAUSE", 
			"SEND", "RECEIVE", "IF", "ELSE", "PIANO", "DRUM", "BEEP", "BLADE", "BNOICE", 
			"CHIPBASE", "CHIPLEAD", "CHIPNOISE", "CNOISE", "DPULSE", "DSAW", "DTRI", 
			"FM", "GNOISE", "GROWL", "HOLLOW", "HOOVER", "NOISE", "PLUCK", "PNOISE", 
			"PROPHET", "PULSE", "SAW", "SINE", "SQUARE", "SUBPULSE", "SUPERSAW", 
			"TB303", "TRI", "ZAWA", "LPAR", "RPAR", "BEGIN", "END", "ASSIGN", "SEMI", 
			"COMMA", "PLUS", "MINUS", "MULT", "NOT", "EQUAL", "NUMBER", "VARNAME", 
			"KEY", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u01b1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3"+
		"!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3$\3$\3"+
		"$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3"+
		"+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3"+
		"\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\38\39\69\u0194"+
		"\n9\r9\169\u0195\3:\6:\u0199\n:\r:\16:\u019a\3:\3:\6:\u019f\n:\r:\16:"+
		"\u01a0\5:\u01a3\n:\3;\3;\5;\u01a7\n;\3;\3;\3;\5;\u01ac\n;\3<\3<\3<\3<"+
		"\2\2=\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<w=\3\2\6\3\2\62;\4\2C\\c|\4\2CIci\5\2\13\f\17\17\"\"\2\u01b6"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\3y\3\2\2\2\5"+
		"{\3\2\2\2\7\177\3\2\2\2\t\u0083\3\2\2\2\13\u0089\3\2\2\2\r\u008d\3\2\2"+
		"\2\17\u0092\3\2\2\2\21\u0097\3\2\2\2\23\u009d\3\2\2\2\25\u00a3\3\2\2\2"+
		"\27\u00a8\3\2\2\2\31\u00b0\3\2\2\2\33\u00b3\3\2\2\2\35\u00b8\3\2\2\2\37"+
		"\u00be\3\2\2\2!\u00c3\3\2\2\2#\u00c8\3\2\2\2%\u00ce\3\2\2\2\'\u00d5\3"+
		"\2\2\2)\u00de\3\2\2\2+\u00e7\3\2\2\2-\u00f1\3\2\2\2/\u00f8\3\2\2\2\61"+
		"\u00ff\3\2\2\2\63\u0104\3\2\2\2\65\u0109\3\2\2\2\67\u010c\3\2\2\29\u0113"+
		"\3\2\2\2;\u0119\3\2\2\2=\u0120\3\2\2\2?\u0127\3\2\2\2A\u012d\3\2\2\2C"+
		"\u0133\3\2\2\2E\u013a\3\2\2\2G\u0142\3\2\2\2I\u0148\3\2\2\2K\u014c\3\2"+
		"\2\2M\u0151\3\2\2\2O\u0158\3\2\2\2Q\u0161\3\2\2\2S\u016a\3\2\2\2U\u0170"+
		"\3\2\2\2W\u0174\3\2\2\2Y\u0179\3\2\2\2[\u017b\3\2\2\2]\u017d\3\2\2\2_"+
		"\u017f\3\2\2\2a\u0181\3\2\2\2c\u0183\3\2\2\2e\u0185\3\2\2\2g\u0187\3\2"+
		"\2\2i\u0189\3\2\2\2k\u018b\3\2\2\2m\u018d\3\2\2\2o\u018f\3\2\2\2q\u0193"+
		"\3\2\2\2s\u0198\3\2\2\2u\u01a4\3\2\2\2w\u01ad\3\2\2\2yz\7\60\2\2z\4\3"+
		"\2\2\2{|\7d\2\2|}\7r\2\2}~\7o\2\2~\6\3\2\2\2\177\u0080\7p\2\2\u0080\u0081"+
		"\7w\2\2\u0081\u0082\7o\2\2\u0082\b\3\2\2\2\u0083\u0084\7p\2\2\u0084\u0085"+
		"\7q\2\2\u0085\u0086\7v\2\2\u0086\u0087\7g\2\2\u0087\u0088\7u\2\2\u0088"+
		"\n\3\2\2\2\u0089\u008a\7o\2\2\u008a\u008b\7g\2\2\u008b\u008c\7n\2\2\u008c"+
		"\f\3\2\2\2\u008d\u008e\7c\2\2\u008e\u008f\7f\2\2\u008f\u0090\7u\2\2\u0090"+
		"\u0091\7t\2\2\u0091\16\3\2\2\2\u0092\u0093\7v\2\2\u0093\u0094\7k\2\2\u0094"+
		"\u0095\7o\2\2\u0095\u0096\7g\2\2\u0096\20\3\2\2\2\u0097\u0098\7u\2\2\u0098"+
		"\u0099\7v\2\2\u0099\u009a\7c\2\2\u009a\u009b\7t\2\2\u009b\u009c\7v\2\2"+
		"\u009c\22\3\2\2\2\u009d\u009e\7r\2\2\u009e\u009f\7c\2\2\u009f\u00a0\7"+
		"w\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a2\7g\2\2\u00a2\24\3\2\2\2\u00a3\u00a4"+
		"\7u\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7p\2\2\u00a6\u00a7\7f\2\2\u00a7"+
		"\26\3\2\2\2\u00a8\u00a9\7t\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7e\2\2\u00ab"+
		"\u00ac\7g\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7x\2\2\u00ae\u00af\7g\2\2"+
		"\u00af\30\3\2\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7h\2\2\u00b2\32\3\2\2"+
		"\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7n\2\2\u00b5\u00b6\7u\2\2\u00b6\u00b7"+
		"\7g\2\2\u00b7\34\3\2\2\2\u00b8\u00b9\7R\2\2\u00b9\u00ba\7k\2\2\u00ba\u00bb"+
		"\7c\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7q\2\2\u00bd\36\3\2\2\2\u00be\u00bf"+
		"\7F\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1\7w\2\2\u00c1\u00c2\7o\2\2\u00c2"+
		" \3\2\2\2\u00c3\u00c4\7d\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7g\2\2\u00c6"+
		"\u00c7\7r\2\2\u00c7\"\3\2\2\2\u00c8\u00c9\7d\2\2\u00c9\u00ca\7n\2\2\u00ca"+
		"\u00cb\7c\2\2\u00cb\u00cc\7f\2\2\u00cc\u00cd\7g\2\2\u00cd$\3\2\2\2\u00ce"+
		"\u00cf\7d\2\2\u00cf\u00d0\7p\2\2\u00d0\u00d1\7q\2\2\u00d1\u00d2\7k\2\2"+
		"\u00d2\u00d3\7u\2\2\u00d3\u00d4\7g\2\2\u00d4&\3\2\2\2\u00d5\u00d6\7e\2"+
		"\2\u00d6\u00d7\7j\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9\7r\2\2\u00d9\u00da"+
		"\7d\2\2\u00da\u00db\7c\2\2\u00db\u00dc\7u\2\2\u00dc\u00dd\7u\2\2\u00dd"+
		"(\3\2\2\2\u00de\u00df\7e\2\2\u00df\u00e0\7j\2\2\u00e0\u00e1\7k\2\2\u00e1"+
		"\u00e2\7r\2\2\u00e2\u00e3\7n\2\2\u00e3\u00e4\7g\2\2\u00e4\u00e5\7c\2\2"+
		"\u00e5\u00e6\7f\2\2\u00e6*\3\2\2\2\u00e7\u00e8\7e\2\2\u00e8\u00e9\7j\2"+
		"\2\u00e9\u00ea\7k\2\2\u00ea\u00eb\7r\2\2\u00eb\u00ec\7p\2\2\u00ec\u00ed"+
		"\7q\2\2\u00ed\u00ee\7k\2\2\u00ee\u00ef\7u\2\2\u00ef\u00f0\7g\2\2\u00f0"+
		",\3\2\2\2\u00f1\u00f2\7e\2\2\u00f2\u00f3\7p\2\2\u00f3\u00f4\7q\2\2\u00f4"+
		"\u00f5\7k\2\2\u00f5\u00f6\7e\2\2\u00f6\u00f7\7g\2\2\u00f7.\3\2\2\2\u00f8"+
		"\u00f9\7f\2\2\u00f9\u00fa\7r\2\2\u00fa\u00fb\7w\2\2\u00fb\u00fc\7n\2\2"+
		"\u00fc\u00fd\7u\2\2\u00fd\u00fe\7g\2\2\u00fe\60\3\2\2\2\u00ff\u0100\7"+
		"f\2\2\u0100\u0101\7u\2\2\u0101\u0102\7c\2\2\u0102\u0103\7y\2\2\u0103\62"+
		"\3\2\2\2\u0104\u0105\7f\2\2\u0105\u0106\7v\2\2\u0106\u0107\7t\2\2\u0107"+
		"\u0108\7k\2\2\u0108\64\3\2\2\2\u0109\u010a\7h\2\2\u010a\u010b\7o\2\2\u010b"+
		"\66\3\2\2\2\u010c\u010d\7i\2\2\u010d\u010e\7p\2\2\u010e\u010f\7q\2\2\u010f"+
		"\u0110\7k\2\2\u0110\u0111\7u\2\2\u0111\u0112\7g\2\2\u01128\3\2\2\2\u0113"+
		"\u0114\7i\2\2\u0114\u0115\7t\2\2\u0115\u0116\7q\2\2\u0116\u0117\7y\2\2"+
		"\u0117\u0118\7n\2\2\u0118:\3\2\2\2\u0119\u011a\7j\2\2\u011a\u011b\7q\2"+
		"\2\u011b\u011c\7n\2\2\u011c\u011d\7n\2\2\u011d\u011e\7q\2\2\u011e\u011f"+
		"\7y\2\2\u011f<\3\2\2\2\u0120\u0121\7j\2\2\u0121\u0122\7q\2\2\u0122\u0123"+
		"\7q\2\2\u0123\u0124\7x\2\2\u0124\u0125\7g\2\2\u0125\u0126\7t\2\2\u0126"+
		">\3\2\2\2\u0127\u0128\7p\2\2\u0128\u0129\7q\2\2\u0129\u012a\7k\2\2\u012a"+
		"\u012b\7u\2\2\u012b\u012c\7g\2\2\u012c@\3\2\2\2\u012d\u012e\7r\2\2\u012e"+
		"\u012f\7n\2\2\u012f\u0130\7w\2\2\u0130\u0131\7e\2\2\u0131\u0132\7m\2\2"+
		"\u0132B\3\2\2\2\u0133\u0134\7r\2\2\u0134\u0135\7p\2\2\u0135\u0136\7q\2"+
		"\2\u0136\u0137\7k\2\2\u0137\u0138\7u\2\2\u0138\u0139\7g\2\2\u0139D\3\2"+
		"\2\2\u013a\u013b\7r\2\2\u013b\u013c\7t\2\2\u013c\u013d\7q\2\2\u013d\u013e"+
		"\7r\2\2\u013e\u013f\7j\2\2\u013f\u0140\7g\2\2\u0140\u0141\7v\2\2\u0141"+
		"F\3\2\2\2\u0142\u0143\7r\2\2\u0143\u0144\7w\2\2\u0144\u0145\7n\2\2\u0145"+
		"\u0146\7u\2\2\u0146\u0147\7g\2\2\u0147H\3\2\2\2\u0148\u0149\7u\2\2\u0149"+
		"\u014a\7c\2\2\u014a\u014b\7y\2\2\u014bJ\3\2\2\2\u014c\u014d\7u\2\2\u014d"+
		"\u014e\7k\2\2\u014e\u014f\7p\2\2\u014f\u0150\7g\2\2\u0150L\3\2\2\2\u0151"+
		"\u0152\7u\2\2\u0152\u0153\7s\2\2\u0153\u0154\7w\2\2\u0154\u0155\7c\2\2"+
		"\u0155\u0156\7t\2\2\u0156\u0157\7g\2\2\u0157N\3\2\2\2\u0158\u0159\7u\2"+
		"\2\u0159\u015a\7w\2\2\u015a\u015b\7d\2\2\u015b\u015c\7r\2\2\u015c\u015d"+
		"\7w\2\2\u015d\u015e\7n\2\2\u015e\u015f\7u\2\2\u015f\u0160\7g\2\2\u0160"+
		"P\3\2\2\2\u0161\u0162\7u\2\2\u0162\u0163\7w\2\2\u0163\u0164\7r\2\2\u0164"+
		"\u0165\7g\2\2\u0165\u0166\7t\2\2\u0166\u0167\7u\2\2\u0167\u0168\7c\2\2"+
		"\u0168\u0169\7y\2\2\u0169R\3\2\2\2\u016a\u016b\7v\2\2\u016b\u016c\7d\2"+
		"\2\u016c\u016d\7\65\2\2\u016d\u016e\7\62\2\2\u016e\u016f\7\65\2\2\u016f"+
		"T\3\2\2\2\u0170\u0171\7v\2\2\u0171\u0172\7t\2\2\u0172\u0173\7k\2\2\u0173"+
		"V\3\2\2\2\u0174\u0175\7|\2\2\u0175\u0176\7c\2\2\u0176\u0177\7y\2\2\u0177"+
		"\u0178\7c\2\2\u0178X\3\2\2\2\u0179\u017a\7*\2\2\u017aZ\3\2\2\2\u017b\u017c"+
		"\7+\2\2\u017c\\\3\2\2\2\u017d\u017e\7}\2\2\u017e^\3\2\2\2\u017f\u0180"+
		"\7\177\2\2\u0180`\3\2\2\2\u0181\u0182\7?\2\2\u0182b\3\2\2\2\u0183\u0184"+
		"\7=\2\2\u0184d\3\2\2\2\u0185\u0186\7.\2\2\u0186f\3\2\2\2\u0187\u0188\7"+
		"-\2\2\u0188h\3\2\2\2\u0189\u018a\7/\2\2\u018aj\3\2\2\2\u018b\u018c\7,"+
		"\2\2\u018cl\3\2\2\2\u018d\u018e\7#\2\2\u018en\3\2\2\2\u018f\u0190\7?\2"+
		"\2\u0190\u0191\7?\2\2\u0191p\3\2\2\2\u0192\u0194\t\2\2\2\u0193\u0192\3"+
		"\2\2\2\u0194\u0195\3\2\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196"+
		"r\3\2\2\2\u0197\u0199\t\3\2\2\u0198\u0197\3\2\2\2\u0199\u019a\3\2\2\2"+
		"\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u01a2\3\2\2\2\u019c\u019e"+
		"\7a\2\2\u019d\u019f\t\2\2\2\u019e\u019d\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0"+
		"\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1\u01a3\3\2\2\2\u01a2\u019c\3\2"+
		"\2\2\u01a2\u01a3\3\2\2\2\u01a3t\3\2\2\2\u01a4\u01a6\t\4\2\2\u01a5\u01a7"+
		"\7%\2\2\u01a6\u01a5\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7\u01ab\3\2\2\2\u01a8"+
		"\u01ac\t\2\2\2\u01a9\u01aa\7/\2\2\u01aa\u01ac\7\63\2\2\u01ab\u01a8\3\2"+
		"\2\2\u01ab\u01a9\3\2\2\2\u01acv\3\2\2\2\u01ad\u01ae\t\5\2\2\u01ae\u01af"+
		"\3\2\2\2\u01af\u01b0\b<\2\2\u01b0x\3\2\2\2\t\2\u0195\u019a\u01a0\u01a2"+
		"\u01a6\u01ab\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}