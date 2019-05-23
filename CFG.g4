grammar CFG;

program: db dv sp di;

db: BPM LPAR NUMBER RPAR SEMI db | ;

dv: NUM VARNAME ASSIGN aExp SEMI dv
    | NOTES VARNAME ASSIGN k SEMI dv | ;

di: inst p BEGIN stmts END di | ;

sp: startPause p SEMI sp | ;

stmts: stmt SEMI stmts
    | stmt;

stmt:  startPause p | MEL LPAR VARNAME RPAR
    | VARNAME ASSIGN aExp
    | ADSR LPAR aExp COMMA aExp COMMA aExp COMMA aExp RPAR
    | TIME LPAR NUMBER COMMA NUMBER RPAR
    | SEND LPAR c COMMA aExp RPAR
    | RECEIVE LPAR c COMMA VARNAME RPAR '.' stmt
    | IF LPAR nBExp RPAR BEGIN stmts END (ELSE BEGIN stmts END)? | ;

nBExp: NOT LPAR bExp RPAR | bExp ;
bExp: LPAR bExp RPAR EQUAL LPAR bExp RPAR | aExp EQUAL aExp ;

aExp: multExp | aExp (MINUS|PLUS) aExp;
multExp: atom | multExp MULT multExp;
atom: NUMBER | VARNAME | LPAR aExp RPAR;

k: k COMMA k | KEY | LPAR k RPAR | NUMBER | ;

p: VARNAME;

c: VARNAME;

inst: PIANO | DRUM | BEEP |BLADE  |BNOICE  |CHIPBASE  |CHIPLEAD  |CHIPNOISE  |CNOISE
  |DPULSE  |DSAW  |DTRI  |FM  |GNOISE  |GROWL  |HOLLOW  |HOOVER  |NOISE  |PLUCK  |PNOISE
   |PROPHET  |PULSE  |SAW  | SINE  |SQUARE  |SUBPULSE  |SUPERSAW  |TB303  |TRI  |ZAWA;

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

//Synth
BEEP: 'beep';
BLADE: 'blade';
BNOICE: 'bnoise';
CHIPBASE: 'chipbass';
CHIPLEAD: 'chiplead';
CHIPNOISE: 'chipnoise';
CNOISE: 'cnoice';
DPULSE: 'dpulse';
DSAW: 'dsaw';
DTRI: 'dtri';
FM: 'fm';
GNOISE: 'gnoise';
GROWL: 'growl';
HOLLOW: 'hollow';
HOOVER: 'hoover';
NOISE: 'noise';
PLUCK: 'pluck';
PNOISE: 'pnoise';
PROPHET: 'prophet';
PULSE: 'pulse';
SAW: 'saw';
SINE: 'sine';
SQUARE: 'square';
SUBPULSE: 'subpulse';
SUPERSAW: 'supersaw';
TB303: 'tb303';
TRI: 'tri';
ZAWA: 'zawa';

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
KEY: [A-Ga-g]('#')?([0-9]|'-1');

/* WHITE SPACE */
WS  :   (' '|'\r'|'\n'|'\t') -> channel(HIDDEN);
