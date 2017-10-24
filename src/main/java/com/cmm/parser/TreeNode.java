package com.cmm.parser;

import com.cmm.lexer.Token;
import org.omg.CORBA.PUBLIC_MEMBER;
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

    private int nodeType;
    private int tokenType;
    private String value;
    private TreeNode next;
    private TreeNode leftNode;
    private TreeNode middleNode;
    private TreeNode rightNode;

    //用于二维数组
    //private LinkedList<TreeNode> arrayElementsLine0 = new LinkedList<TreeNode>();
    //private LinkedList<TreeNode> arrayElementsLine1 = new LinkedList<TreeNode>();

    private LinkedList<TreeNode> oneDimArray = new LinkedList<TreeNode>();

    private LinkedList<LinkedList> twoDimArray = new LinkedList<LinkedList>();

    private LinkedList<TreeNode> twoDimArray_ = new LinkedList<TreeNode>();

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
        this.twoDimArray_.add(childArray);
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

    public TreeNode getNext() {
        return next;
    }

    public void setNext(TreeNode next) {
        this.next = next;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getMiddleNode() {
        return middleNode;
    }

    public void setMiddleNode(TreeNode middleNode) {
        this.middleNode = middleNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }


}
