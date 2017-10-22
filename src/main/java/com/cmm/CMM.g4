grammar CMM;

prog
    : structures EOF
    ;

structures
    : structure+
;

structure
    : sequenceStructure
    | ifElseStructure
    | whileStructure
    ;

sequenceStructure
    : expressionStatement
    | variableDeclaration
    | blockStatement
    | readStatement
    | writeStatement
    ;

expressionStatement
    : expression SEMICOLON
    ;

variableDeclaration
    : dataType ID ( LBRACKET Integer RBRACKET ) * initialize ?
        ( COMMA ID ( LBRACKET Integer RBRACKET ) * initialize ?) * SEMICOLON
    ;

dataType
    : INT | REAL
    ;

initialize
    : ASSIGNSYM ( expression | arrayLiteral )
    ;

arrayLiteral
    :   LBRACE
            ( expression | arrayLiteral ) ( COMMA ( expression | arrayLiteral ) ) *
        RBRACE
    ;

blockStatement
    : LBRACE structures RBRACE
    ;

assignStatement
    : ID ASSIGNSYM expression
    ;

readStatement
    : READ variableAccess SEMCOLON
    ;

variableAccess
    : ID ( LBRACKET INT RBRACKET ) *
    ;

writeStatement
    : WRITE expression SEMICOLON
    ;

ifElseStructure
    : IF LPARENT expression RPARENT structure
    | ( ELSEIF LPARENT expression RPARENT structure ) *
    | ( ELSE structure ) ?
    ;

whileStructure
    : WHILE LPARENT expression RPARENT structure
    ;

expression
    : assignExpression
    | logicalOrExpression
    ;

assignExpression
    : variableAccess ASSIGNSYM expression
    ;

logicalOrExpression
    : logicalAndExpression ( OROR logicalAndExpression ) *
    ;

logicalAndExpression
    : relationalExpression ( ANDAND relationalExpression ) *
    ;

relationalExpression
    : addExpression ( relationalOperator addExpression ) *
    | EXCLAMATION relationalExpression
    ;

addExpression
    :multiplyExpression ( addOperator multiplyExpression ) *
    ;

multiplyExpression
    : primaryExpression ( multiplyOperator primaryExpression ) *
    ;

primaryExpression
    : variableAccess
    | Integer
    | RealNumber
    | LPARENT expression RPARENT
    | SUB primaryExpression
    ;

relationalOperator
    : LESSTHAN
    | GREATERTHAN
    | IDENTICALEQUAL
    | LESSOREQUAL
    | GREATEROREQUAL
    | NOTEQUAL
    ;

addOperator
    : ADD
    | SUB
    ;

multiplyOperator
    : MUL
    | DIV
    ;



LPARENT
    : '('
    ;

RPARENT
    : ')'
    ;

LBRACKET
    : '['
    ;

RBRACKET
    : ']'
    ;

LBRACE
    : '{'
    ;

RBRACE
    : '}'
    ;

COMMA
    : ','
    ;

SEMICOLON
    : ':'
    ;

ADD
    : '+'
    ;

SUB
    : '-'
    ;

MUL
    : '*'
    ;

DIV
    : '/'
    ;

IDENTICALEQUAL
    : '=='
    ;

NOTEQUAL
    :'!='
    ;

LESSTHAN
    :'<'
    ;

LESSOREQUAL
    :'<='
    ;

GREATERTHAN
    :'>'
    ;

GREATEROREQUAL
    :'>='
    ;

EXCLAMATION
    :'!'
    ;

ANDAND
    :'&&'
    ;

OROR
    :'||'
    ;

ASSIGNSYM
    :'='
    ;

IF
    :'if'
    ;

IFELSE
    :'if else'
    ;

WHILE
    :'while'
    ;

READ
    :'read'
    ;

WRITE
    :'write'
    ;

INT
    :'int'
    ;

REAL
    :'real'
    ;

ID
    : LetterOrUnderscore ( LetterOrUnderscore | Digit ) *
    ;

Integer
    : Digit+
    ;

RealNumber
    : Digit+ '.' Digit+
    ;

fragment
Digit
    : '0'..'9'
    ;

fragment
LetterOrUnderscore
    : Letter
    | '_'
    ;

fragment
Letter
    : ('a'..'z' | 'A'..'Z' )
    ;

WS
    : ( ' ' | '\t' | '\r' | '\n' ) + { $channel = HIDDEN; }
    ;

Comment
    : '/*' . * '*/' -> skip
    ;

LineCommment
    : '//' ~('\n'|'\r')*'\r'?'\n' -> skip











