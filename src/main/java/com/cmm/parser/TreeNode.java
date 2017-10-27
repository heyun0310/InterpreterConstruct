package com.cmm.parser;

import com.cmm.lexer.Token;
import com.sun.org.apache.regexp.internal.RE;
import org.omg.CORBA.PUBLIC_MEMBER;
import sun.awt.geom.AreaOp;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {

    //节点与节点之间通过指针相连，父节点指向孩子节点
    //类型为NULL的节点作为根节点，不存储信息

    public static final int NULL = 0;

    //顺序结构中的语句
    public static final int DECLARE_STATEMENT = 1;
    public static final int BLOCK_STATEMENT = 2;
    public static final int ASSIGN_STATEMENT = 3;
    public static final int READ_STATEMENT = 4;
    public static final int WRITE_STATEMENT = 5;
    public static final int EXPRESSION = 6;

    //循环结构中的语句
    public static final int WHILE_STATEMENT = 7;
    public static final int BREAK_STATEMENT = 8;

    //选择结构中的语句
    public static final int IF_STATEMENT = 9;

    //变量、常量、操作符和因子<id>|<integer>|'('<表达式>')'
    public static final int VARIABLE = 10;
    public static final int LITERAL = 11;
    public static final int OPERATOR = 12;
    public static final int FACTOR = 13;

    public static final int ARRAY_INITIALIZER = 14;

    public static final int RETURN_STATEMENT = 15;

    public static final int INT = 16;
    public static final int REAL = 17;
    public static final int MUL = 18;
    public static final int EQ = 19;
    public static final int GetAddress = 20;
    public static final int LBRACK = 21;
    public static final int RBRACK = 22;
    public static final int LBRACE = 23;
    public static final int RBRACE = 24;
    public static final int ARRAY_LITERAL = 25;
    public static final int COMMA = 26;
    public static final int LPAREN = 27;
    public static final int RPAREN = 28;
    public static final int STATEMENT_LIST = 29;
    public static final int SEMICOLON = 30;
    public static final int READ = 31;
    public static final int WRITE = 32;
    public static final int WHILE = 33;
    public static final int BREAK = 34;
    public static final int IF = 35;
    public static final int ELSE = 36;
    public static final int RETURN = 37;
    public static final int ADD = 38;
    public static final int SUB = 39;
    public static final int DIV = 40;

    private int nodeType;
    private int tokenType;
    private String value;
    //用于储存指向孩子节点的指针的数组
    private LinkedList<TreeNode> childrenList = new LinkedList<TreeNode>();

    //用于二维数组
    //private LinkedList<TreeNode> arrayElementsLine0 = new LinkedList<TreeNode>();
    //private LinkedList<TreeNode> arrayElementsLine1 = new LinkedList<TreeNode>();

    private LinkedList<TreeNode> oneDimArray = new LinkedList<TreeNode>();

    private LinkedList<TreeNode> twoDimArray = new LinkedList<TreeNode>();

    //?????
//    public void setArrayElement(int line, TreeNode arrayElement)
//    {
//        if (0 == line)
//        {
//            arrayElementsLine0.add(arrayElement);
//        }else if (1 == line)
//        {
//            arrayElementsLine1.add(arrayElement);
//        }
//        this.twoDimArray.add(arrayElementsLine0);
//        this.twoDimArray.add(arrayElementsLine1);
//    }

    public void setArrayElement(TreeNode arrayElement)
    {
        this.oneDimArray.add(arrayElement);
    }

    public void setChildArray(TreeNode childArray)
    {
        this.twoDimArray.add(childArray);
    }

    public TreeNode(int _nodeType)
    {
        super();
        this.nodeType = _nodeType;
        switch (this.nodeType)
        {
            case FACTOR:
            case LITERAL:
                this.tokenType = Token.ADD; //?????
                break;
            default:
                break;
        }
    }

    private String printNode(int nodeType)
    {
        switch (nodeType)
        {
            case NULL:
                return "|——— Program:";
            case DECLARE_STATEMENT:
                return "|——— Declare Statement:";
            case BLOCK_STATEMENT:
                return "|——— Block Statement:";
            case ASSIGN_STATEMENT:
                return "|——— Assign Statement:";
            case READ_STATEMENT:
                return "|——— Read Statement:";
            case WRITE_STATEMENT:
                return "|——— Write Statement:";
            case EXPRESSION:
                return "|——— Expression";
            case WHILE_STATEMENT:
                return "|——— While Statement:";
            case BREAK_STATEMENT:
                return "|——— Break Statement:";
            case IF_STATEMENT:
                return "|——— If Statement:";
            case VARIABLE:
                return "|——— Variable:";
            case LITERAL:
                return "|——— Literal:";
            case FACTOR:
                return "|——— Factor:";
            case ARRAY_INITIALIZER:
                return "|——— Array Initializer:";
            case RETURN_STATEMENT:
                return "|——— Return Statement:";
            case INT:
                return "|——— INT";
            case REAL:
                return "|——— REAL";
            case MUL:
                return "|——— *";
            case EQ:
                return "|——— =";
            case GetAddress:
                return "|——— &";
            case LBRACE:
                return "|——— {";
            case RBRACE:
                return "|——— }";
            case LBRACK:
                return "|——— [";
            case RBRACK:
                return "|——— ]";
            case ARRAY_LITERAL:
                return "|——— Array Literal:";
            case COMMA:
                return "|——— ,";
            case LPAREN:
                return "|——— (";
            case RPAREN:
                return "|——— )";
            case STATEMENT_LIST:
                return "Statement List";
            case SEMICOLON:
                return "|——— ;";
            case READ:
                return "|——— READ";
            case WRITE:
                return "|——— WRITE";
            case WHILE:
                return "|——— WHILE";
            case BREAK:
                return "|——— BREAK";
            case IF:
                return "|——— IF";
            case ELSE:
                return "|——— ELSE";
            case RETURN:
                return "|——— RETURN";
            case ADD:
                return "|——— +";
            case SUB:
                return "|——— -";
            case DIV:
                return "|——— /";
            default:
                    return "";
        }
    }

    public int getNodeType() {
        return nodeType;
    }

    public void setNodeType(int nodeType) {
        this.nodeType = nodeType;
    }


    public int getTokenType() {
        return tokenType;
    }

    public void setTokenType(int tokenType) {
        this.tokenType = tokenType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setChildNode(TreeNode childNode)
    {
        this.childrenList.add(childNode);
    }


}
