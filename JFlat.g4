grammar JFlat;

@header {
    import wci.intermediate.TypeSpec;
}

// Reserved words
IF        : 'if' ;
ELSE      : 'else' ;
WHILE	  : 'while' ;
FUNCT     : 'function' ;
VAR       : 'var' ;
PRINT     : 'print' ;
RETURN    : 'return';

// Primatives
PBOOL 	  : 'boolean';
PINT	  : 'int';
PREAL	  : 'real';
PVOID	  : 'void';

// Literals
BOOL      : 'true' | 'false' ;
INT       : [0-9]+ ;
REAL	  : [0-9]+ '.' [0-9]+ ;


// Symbols
MUL       : '*' ;
DIV       : '/' ;
ADD       : '+' ;
SUB       : '-' ;
MOD       : '%' ;

GT        : '>' ;
LT        : '<' ;
GTE       : '>=' ;
LTE       : '<=' ;
EQ        : '==' ;
SEPARATOR : ';' ;

// Identifiers
IDENTIFIER       : [A-Za-z_][A-Za-z0-9_]* ;


// Whitespace and comments
NEWLINE   	  : '\r' ? '\n' -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;
LINE_COMMENT  : '//' ~[\n\r]* -> skip ;
WS            : [ \t]+ -> skip ; // ignore whitespace


// ***Paring rules ***

/** The start rule */
prog: stat+ ;

stat: expr SEPARATOR                                    # bareExpr
    | IF '(' expr ')' block ELSE block                  # ifThenElse
    | IF '(' expr ')' block                             # ifThen
	| WHILE '(' expr ')' block							# while
	| PRINT '(' expr ')' ';'							# print
	| FUNCT primType IDENTIFIER params '{' stat* '}'	# functDeclare
	| VAR varList ';'									# varListDeclare
	| SEPARATOR											# emptyStat
	| RETURN expr ';'									# exprReturn
	| RETURN ';'										# emptyReturn
    ;
    
varList: varDec (',' varDec)* ;

varDec:	IDENTIFIER										# varDeclare
	  | IDENTIFIER '=' expr								# varDeclareAssign
	  ;

expr locals [ TypeSpec type = null ]
	: IDENTIFIER args									# functApply
	| expr op=( '*' | '/' | '%' ) expr                  # mulDivMod
	| expr op=( '+' | '-' ) expr						# addSub
	| expr op=( '<' | '<=' | '>' | '>=' | '==' ) expr	# comparison
	| IDENTIFIER										# varRef	
    | number                                            # unsignNumber
    | signedNumber										# signedNum		
	| BOOL												# boolean
    | '(' expr ')'                                      # parens
    | IDENTIFIER '=' expr								# varAssign
    ;
    
signedNumber locals [ TypeSpec type = null ]
	: sign number
	;
	
sign: ADD | SUB;
	
number locals [ TypeSpec type = null ]
	: INT												# intConst
	| REAL												# realConst
	;
	
params: '(' primType IDENTIFIER ( ',' primType IDENTIFIER )*')'			
	|  '(' ')'											
	;
	
args: '(' expr (',' expr )* ')'							
	| '(' ')'											
	;

block: '{' stat* '}'                                    # fullBlock
    | stat                                             	# simpBlock
    ;
    
primType locals [ TypeSpec type = null ]
	: PBOOL												# typeBool
	| PINT												# typeInt
	| PREAL												# typeReal
	| PVOID												# typeVoid
	;

