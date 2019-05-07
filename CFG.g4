grammar CFG;

program: db dv sp di;

db: BPM LPAR NUMBER RPAR SEMI db | ;

dv: NUM VARNAME ASSIGN aExp SEMI dv
    | NOTES VARNAME ASSIGN k SEMI dv | ;

di: inst p BEGIN stmt END di | ;

sp: startPause p SEMI sp | ;

stmt:  startPause p | MEL LPAR (VARNAME|k) RPAR
    | VARNAME ASSIGN aExp
    | ADSR LPAR (aExp COMMA aExp COMMA aExp COMMA aExp) RPAR
    | stmt SEMI stmt
    | TIME LPAR MEASURE RPAR
    | SEND LPAR c COMMA aExp RPAR
    | RECEIVE LPAR c COMMA VARNAME RPAR '.' stmt
    | IF LPAR bExp RPAR BEGIN stmt END (ELSE BEGIN stmt END)? | ;

bExp: nAexp EQUAL nAexp;
nAexp: (NOT)? aExp;

aExp: multExp ((MINUS|PLUS) aExp)?;
multExp: atom (MULT multExp)?;
atom: NUMBER | VARNAME | LPAR aExp RPAR;

k: k COMMA k | KEY | LPAR k RPAR | NUMBER | ;

p: VARNAME;

c: VARNAME;

inst: PIANO | DRUM ;

startPause: START | PAUSE ;





// KEYWORDS
BPM: 'bpm';
NUM: 'num';
NOTES: 'notes';
MEL: 'mel';
ADSR: 'adsr';
TIME: 'time';
START: 'start';
PAUSE: 'pause';
SEND: 'send';
RECEIVE: 'receive';
IF: 'if';
ELSE: 'else';
PIANO: 'Piano';
DRUM: 'Drum';

// SIGNS
LPAR: '(';
RPAR: ')';
BEGIN: '{';
END: '}';
ASSIGN: '=';
SEMI: ';';
COMMA: ',';

// OPERATORS
PLUS: '+';
MINUS: '-';
MULT: '*';
NOT: '!';
EQUAL: '==';


// TERMINALS
NUMBER: [0-9]+;
VARNAME: [a-zA-Z]+('_'[0-9]+)?;
MEASURE: [0-9]+'/'[0-9]+;
KEY: [A-Ga-g]('#')?([0-9]|'-1');

/* WHITE SPACE */
WS  :   (' '|'\r'|'\n'|'\t') -> channel(HIDDEN);