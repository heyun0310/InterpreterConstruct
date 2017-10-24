package com.cmm.lexer;

/**
 * Created by Administrator on 2017/10/2 0002.
 */
public class Token {
    public static final int WS = 1;
    public static final int Comment = 2;
    public static final int LineComment = 3;
    public static final int LPAREN = 4;
    public static final int RPAREN = 5;
    public static final int LBRACK = 6;
    public static final int RBRACK = 7;
    public static final int LBRACE = 8;
    public static final int RBRACE = 9;
    public static final int COMMA = 10;
    public static final int SEMICOLON = 11;
    public static final int ADD = 12;
    public static final int SUB = 13;
    public static final int MUL = 14;
    public static final int DIV = 15;
    public static final int BANG = 16;
    public static final int OROR = 17;
    public static final int ANDAND = 18;
    public static final int EQEQ = 19;
    public static final int NE = 20;
    public static final int LT = 21;
    public static final int GT = 22;
    public static final int EQ = 23;
    public static final int IF = 24;
    public static final int ELSE = 25;
    public static final int WHILE = 26;
    public static final int BREAK = 27;
    public static final int READ = 28;
    public static final int WRITE = 29;
    public static final int INT = 30;
    public static final int REAL = 31;
    public static final int Integer = 32;
    public static final int RealNumber = 33;
    public static final int ID = 34;
    public static final int NULL = 35;
    public static final int LogicOrAndExpression = 36;
    public static final int LogicEqualExpression = 37;
    public static final int LogicNotEqualExpression = 38;
    public static final int AddibleExpression = 39;
    public static final int TermExpression = 40;
    public static final int NotExpression = 41;
    public static final int RETURN = 42;


    private int type;
    private String value;
    private int lineNo;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getLineNo() {
        return lineNo;
    }

    public void setLineNo(int lineNo) {
        this.lineNo = lineNo;
    }

    public Token(int lineNo){
        this(0,null,lineNo);
    }

    public Token(int type, int lineNo){
        this(type, null, lineNo);
    }

    public Token(int type, String value, int lineNo){
        super();
        this.type = type;
        this.value = value;
        this.lineNo = lineNo;
    }

    public String toStringWithLine(){
        switch (type){

            case Comment: return "LINE "+ this.lineNo + ": Comment";
            case LineComment: return "LINE " + this.lineNo + ": LineComment";

            case LPAREN: return "LINE " + this.lineNo + ": (";
            case RPAREN: return "LINE " + this.lineNo + ": )";
            case LBRACK: return "LINE " + this.lineNo + ": [";
            case RBRACK: return "LINE " + this.lineNo + ": ]";
            case LBRACE: return "LINE " + this.lineNo + ": {";
            case RBRACE: return  "LINE " + this.lineNo + ": }";

            case COMMA: return "LINE " + this.lineNo + ": ,";
            case SEMICOLON: return "LINE " + this.lineNo + ": ;";

            case ADD: return "LINE " + this.lineNo + ": +";
            case SUB: return "LINE " + this.lineNo + ": -";
            case MUL: return "LINE " + this.lineNo + ": *";
            case DIV: return "LINE " + this.lineNo + ": /";

            case BANG: return "LINE " + this.lineNo + ": !";
            case OROR: return "LINE " + this.lineNo + ": ||";
            case ANDAND: return "LINE " + this.lineNo + ": &&";

            case EQEQ: return "LINE " + this.lineNo + ": ==";
            case NE: return "LINE " + this.lineNo + ": <>";
            case LT: return "LINE " + this.lineNo + ": <";
            case GT: return "LINE " + this.lineNo + ": >";
            case EQ: return "LINE " + this.lineNo + ": =";

            case IF: return "LINE " + this.lineNo + ": IF";
            case ELSE: return "LINE " + this.lineNo + ": ELSE";
            case WHILE: return "LINE " + this.lineNo + ": WHILE";
            case BREAK: return "LINE " + this.lineNo + ": BREAK";
            case READ: return "LINE " + this.lineNo + ": READ";
            case WRITE: return "LINE " + this.lineNo + ": WRITE";

            case INT: return "LINE " + this.lineNo + ": INT";
            case REAL: return "LINE " + this.lineNo + ": REAL";

            case Integer:
            case RealNumber:
            case ID: return "LINE " + this.lineNo + ": " + this.value;

            case RETURN: return "LINE " + this.lineNo + ": " + this.value;

            default: return "LINE " + this.lineNo + ": UNKNOWN";
        }
    }

    public String toString(){
        switch (type){

            case LPAREN: return "(";
            case RPAREN: return ")";
            case LBRACK: return "[";
            case RBRACK: return "]";
            case LBRACE: return "{";
            case RBRACE: return  "}";

            case COMMA: return ",";
            case SEMICOLON: return ";";

            case ADD: return "+";
            case SUB: return "-";
            case MUL: return "*";
            case DIV: return "/";

            case BANG: return "!";
            case OROR: return "||";
            case ANDAND: return "&&";

            case EQEQ: return "==";
            case NE: return "<>";
            case LT: return "<";
            case GT: return ">";
            case EQ: return "=";

            case IF: return "IF";
            case ELSE: return "ESLE";
            case WHILE: return "WHILE";
            case BREAK: return "BREAK";
            case READ: return "READ";
            case WRITE: return "WRITE";

            case INT: return "INT";
            case REAL: return "REAL";

            case Integer:
            case RealNumber:
            case ID: return "" + this.value;

            case RETURN: return "RETURN";


            default: return "ERROR";

        }
    }
}
