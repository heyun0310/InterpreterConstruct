grammar CMinusMinus;

prog: statementList
	;

statementList
	: statement+
	;

statement
	: selectiveStructure
	| cycleStructure
	| sequenceStructure
	;

ifStatement
	: IF LPAREN expression RPAREN statement
	  ( ELSE IF LPAREN expression RPAREN statement )*
	  ( ELSE statement )?
	;

whileStatement
	: WHILE LPAREN expression RPAREN statement
	;

breakStatement
    : BREAK SEMICOLON
    ;

sequenceStructure
	: declareStatement
	| blockStatement
	| assignStatement
	| readStatement
	| writeStatement
	| expression
	;

selectiveStructure
	: ifStatement
	;

cycleStructure
	: whileStatement
	| breakStatement
	;

declareStatement
	: ( INT | REAL ) ID ( LBRACK Integer RBRACK )* initializer?
	  ( COMMA ID ( LBRACK Integer RBRACK )* initializer? )*
	  SEMICOLON
	;

initializer
	: EQ ( expression | arrayLiteral )
	;

arrayLiteral
	: LBRACE ( expression | arrayLiteral )( COMMA ( expression | arrayLiteral ))* RBRACE
	;

blockStatement
	: LBRACE statementList RBRACE
	;

assignStatement
	: ID ( LBRACK Integer RBRACK )? initializer SEMICOLON
	;

readStatement
	: READ ID ( LBRACK Integer RBRACK )? SEMICOLON
	;

writeStatement
	: WRITE expression SEMICOLON
	;

expression
	: arithmeticExpr
	| logicalOrExpr
	;

logicalOrExpr
    : logicalAndExpr ( OROR logicalAndExpr )*
    ;

logicalAndExpr
    : relationExpr ( ANDAND relationExpr )*
    ;

relationExpr
	: variable ( EQEQ | LT | NE | GT ) variable
	| BANG relationExpr
	;

variable
	: ID ( LBRACK Integer RBRACK )?
	| Integer
	| REAL
	| LPAREN arithmeticExpr RPAREN
	;

arithmeticExpr
	: arithmeticExpr ( MUL | DIV ) arithmeticExpr
	| arithmeticExpr ( ADD | SUB ) arithmeticExpr
	| variable
	;

//lexer rules
WS : ( ' ' | '\t' | '\r' | '\n' )+ -> skip;
Comment : '/*' . * '*/' -> skip;
LineComment : '//' ~('\n'|'\r')*'\r'?'\n' ->skip;

LPAREN : '(';
RPAREN : ')';
LBRACK : '[';
RBRACK : ']';
LBRACE : '{';
RBRACE : '}';

COMMA : ',';
SEMICOLON : ';';

ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';

BANG : '!';
OROR : '||';
ANDAND : '&&';

EQEQ : '==';
NE : '<>';
LT : '<';
GT : '>';
EQ : '=';

IF : 'if';
ELSE : 'else';
WHILE : 'while';
BREAK : 'break';
READ : 'read';
WRITE : 'write';

INT : 'int';
REAL : 'real';

Integer : Digit+;
RealNumber : Digit+ '.' Digit+;
ID : ( 'a'..'z' | 'A'..'Z' | '_' )( 'a'..'z' | 'A'..'Z' | '0'..'9' | '_' )*;

fragment
Digit : '0'..'9';
fragment
LetterOrUnderscore : Letter | '_';
fragment
Letter : ( 'a'..'z' | 'A'..'Z' );
