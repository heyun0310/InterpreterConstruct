package com.cmm.parser;

import com.cmm.lexer.Token;
import com.sun.corba.se.impl.oa.toa.TOA;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.ListIterator;

public class Parser {

    private static LinkedList<TreeNode> treeNodeLinkedList;
    private static Token currentToken = null;
    private static ListIterator<Token> iterator = null;
    private static int spaceNum;    //绘制语法树时用于缩进

    public static LinkedList<TreeNode> syntacticAnalyse(LinkedList<Token> tokenLinkedList) throws Exception
    {
        treeNodeLinkedList = new LinkedList<TreeNode>();
        iterator = tokenLinkedList.listIterator();

        System.out.println("Programme:");
        while (iterator.hasNext())
        {
            spaceNum = 1;
            System.out.print("     ");
            treeNodeLinkedList.add(parseStatement());
        }
        return treeNodeLinkedList;
    }

    private static TreeNode parseStatement() throws Exception
    {
        switch (getNextTokenType())
        {
            case Token.INT:
            case Token.REAL:
                return parseDeclareStatement();
            case Token.LBRACE:
                return parseBlockStatement();
            case Token.ID:
                return parseAssignStatement();
            case Token.READ:
                return parseReadStatement();
            case Token.WRITE:
                return parseWriteStatement();
            case Token.WHILE:
                return parseWhileStatement();
            case Token.BREAK:
                return parseBreakStatement();
            case Token.IF:
                return parseIfStmt();
            default:
                throw new Exception("Line" + getNextTokenLineNo() + " expects token");
        }
    }

    private static TreeNode parseDeclareStatement() throws Exception
    {
        spaceNum++;
        int curSpaceNum = spaceNum;
        System.out.println("|———Declare Statement:");
        TreeNode treeNode = new TreeNode(TreeNode.DECLARE_STATEMENT);
        TreeNode variableNode = new TreeNode(TreeNode.VARIABLE);
        LinkedList<TreeNode> variableNodes = new LinkedList<TreeNode>();

        //声明语句中的关键字
        if (checkNextTokenType(Token.INT, Token.REAL))
        {
            currentToken = iterator.next();
            int tokenType = currentToken.getType();
            if (tokenType == Token.INT)
            {
                for (int i = 0;i < spaceNum; i++)
                    System.out.print("     ");
                System.out.println("|———INT");
                variableNode.setTokenType(Token.INT);
            }
            else
            {
                for (int i = 0;i < spaceNum; i++)
                    System.out.print("     ");
                System.out.println("|———REAL");
                variableNode.setTokenType(Token.REAL);
            }
        }else
        {
            throw new Exception("Line" + getNextTokenLineNo() + " expects token INT/NEXT.");
        }

        //声明语句中的自定义标识符
        if (checkNextTokenType(Token.ID))
        {
            currentToken = iterator.next();
            variableNode.setValue(currentToken.getValue());
            for (int i = 0;i < spaceNum; i++)
                System.out.print("     ");
            System.out.println("|———ID:" + currentToken.getValue());
        }else
        {
            throw new Exception("Line" + getNextTokenLineNo() + " expects token ID.");
        }

        //声明语句同时初始化变量中的“=”
        if (checkNextTokenType(Token.EQ))
        {
            for (int i = 0;i < spaceNum; i++)
                System.out.print("     ");
            System.out.println("|——— =");
            skipNextToken(Token.EQ);
            for (int i = 0;i < spaceNum; i++)
                System.out.print("     ");
            treeNode.setMiddleNode(parseExpression());
        }else if (getNextTokenType() == Token.LBRACK)
        {
            //curPos用于找回]所在的缩进位置
            int curPos = spaceNum;
            for (int i = 0;i < spaceNum; i++)
                System.out.print("     ");
            System.out.println("|——— [");
            skipNextToken(Token.LBRACK);
            for (int i = 0;i < spaceNum; i++)
                System.out.print("     ");
            variableNode.setLeftNode(parseExpression());
            spaceNum = curPos;
            for (int i = 0;i < spaceNum; i++)
                System.out.print("     ");
            System.out.println("|——— ]");
            skipNextToken(Token.RBRACK);
            if (checkNextTokenType(Token.LBRACK))
            {
                int curPos_ = spaceNum;
                for (int i = 0;i < spaceNum; i++)
                    System.out.print("     ");
                System.out.println("|——— [");
                skipNextToken(Token.LBRACK);
                for (int i = 0;i < spaceNum; i++)
                    System.out.print("     ");
                variableNode.setMiddleNode(parseExpression());
                spaceNum = curPos_;
                for (int i = 0;i < spaceNum; i++)
                    System.out.print("     ");
                System.out.println("|——— ]");
                skipNextToken(Token.RBRACK);
            }

            //当声明数组的同时初始化数组
            if (checkNextTokenType(Token.EQ))
            {
                for (int i = 0;i < spaceNum; i++)
                    System.out.print("     ");
                System.out.println("|——— =");
                skipNextToken(Token.EQ);
                if (checkNextTokenType(Token.LBRACE))
                {
                    TreeNode twoDimArray = new TreeNode(TreeNode.ARRAY_INITIALIZER);
                    treeNode.setRightNode(twoDimArray);
                    for (int i = 0;i < spaceNum; i++)
                        System.out.print("     ");
                    System.out.println("|———Array:");
                    spaceNum++;
                    int curSpace = spaceNum;
                    for (int i = 0;i < spaceNum; i++)
                        System.out.print("     ");
                    System.out.println("|——— {");
                    skipNextToken(Token.LBRACE);
                    //int arrayLineNo = 0;
                    while (checkNextTokenType(Token.LBRACE))
                    {
                        spaceNum = curSpace;
                        TreeNode oneDimArray = new TreeNode(TreeNode.ARRAY_INITIALIZER);
                        for (int i = 0;i < spaceNum; i++)
                            System.out.print("     ");
                        System.out.println("|———Array:");
                        spaceNum++;
                        for (int i = 0;i < spaceNum; i++)
                            System.out.print("     ");
                        System.out.println("|——— {");
                        skipNextToken(Token.LBRACE);
                        for (int i = 0;i < spaceNum; i++)
                            System.out.print("     ");
                        int curSpace_ = spaceNum;
                        twoDimArray.setChildArray(oneDimArray);
                        oneDimArray.setArrayElement(parseExpression());
                        //variableNode.setArrayElement(arrayLineNo, parseExpression());
                        while (checkNextTokenType(Token.COMMA))
                        {
                            spaceNum = curSpace_;
                            for (int i = 0;i < spaceNum; i++)
                                System.out.print("     ");
                            System.out.println("|——— ,");
                            skipNextToken(Token.COMMA);
                            for (int i = 0;i < spaceNum; i++)
                                System.out.print("     ");
                            oneDimArray.setArrayElement(parseExpression());
                        }
                        for (int i = 0;i < spaceNum; i++)
                            System.out.print("     ");
                        System.out.println("|——— }");
                        skipNextToken(Token.RBRACE);
                        for (int i = 0;i < spaceNum; i++)
                            System.out.print("     ");
                        System.out.println("|——— ,");
                        skipNextToken(Token.COMMA);
                        //arrayLineNo++;
                    }
                }else
                    throw new Exception("Line" + getNextTokenLineNo() + " expects token {.");
            }
        }

        //若同时声明多个变量，则前一variableNode结点的leftChild指向当前variaNode，middleChild指向当前parseExpression()
        //若声明的为多个数组，则rightNode指向[]中的表达式,next指向第二个[]中的表达式（二维数组）
        while (checkNextTokenType(Token.COMMA))
        {
            //variableNode_是所声明的第二个、第三个…变量的结点
            spaceNum = curSpaceNum;
            TreeNode variableNode_ = new TreeNode(TreeNode.VARIABLE);
            variableNode_.setTokenType(variableNode.getTokenType());
            variableNodes.add(variableNode_);
            currentToken = iterator.next();
            if (checkNextTokenType(Token.ID))
            {
                currentToken = iterator.next();
                variableNode_.setValue(currentToken.getValue());
                for (int i = 0;i < spaceNum; i++)
                    System.out.print("     ");
                System.out.println("|———ID:" + currentToken.getValue());
            }else
            {
                throw new Exception("Line" + getNextTokenLineNo() + " expects token ID.");
            }
            //当声明变量的时候同时初始化变量
            if (checkNextTokenType(Token.EQ))
            {
                skipNextToken(Token.EQ);
                if (variableNodes.isEmpty())
                {
                    variableNode.setLeftNode(variableNode_);
                    for (int i = 0;i < spaceNum; i++)
                        System.out.print("     ");
                    System.out.println("|——— =");
                    for (int i = 0;i < spaceNum; i++)
                        System.out.print("     ");
                    variableNode.setMiddleNode(parseExpression());
                }else
                {
                    variableNodes.get(variableNodes.size()-2).setLeftNode(variableNode_);
                    variableNodes.get(variableNodes.size()-2).setMiddleNode(parseExpression());
                }
            }
            //当声明数组时
            else if (getNextTokenType() == Token.LBRACK)
            {
                for (int i = 0;i < spaceNum; i++)
                    System.out.print("     ");
                System.out.println("|——— [");
                skipNextToken(Token.LBRACK);
                for (int i = 0;i < spaceNum; i++)
                    System.out.print("     ");
                variableNode_.setRightNode(parseExpression());
                for (int i = 0;i < spaceNum; i++)
                    System.out.print("     ");
                System.out.println("|——— ]");
                skipNextToken(Token.RBRACK);
                //当声明为二维数组时
                if (checkNextTokenType(Token.LBRACK))
                {
                    for (int i = 0;i < spaceNum; i++)
                        System.out.print("     ");
                    System.out.println("|——— [");
                    skipNextToken(Token.LBRACK);
                    for (int i = 0;i < spaceNum; i++)
                        System.out.print("     ");
                    variableNode.setNext(parseExpression());
                    for (int i = 0;i < spaceNum; i++)
                        System.out.print("     ");
                    System.out.println("|——— ]");
                    skipNextToken(Token.RBRACK);
                }
            }
            //当声明数组的同时初始化数组
            if (checkNextTokenType(Token.EQ))
            {
                for (int i = 0;i < spaceNum; i++)
                    System.out.print("     ");
                System.out.println("|——— =");
                skipNextToken(Token.EQ);
                if (checkNextTokenType(Token.LBRACE))
                {
                    TreeNode twoDimArray = new TreeNode(TreeNode.ARRAY_INITIALIZER);
                    treeNode.setRightNode(twoDimArray);
                    for (int i = 0;i < spaceNum; i++)
                        System.out.print("     ");
                    System.out.println("|——— [");
                    skipNextToken(Token.LBRACE);
                    int arrayLineNo = 0;
                    while (checkNextTokenType(Token.LBRACE))
                    {
                        for (int i = 0;i < spaceNum; i++)
                            System.out.print("     ");
                        System.out.println("|——— [");
                        skipNextToken(Token.LBRACE);
                        TreeNode oneDimArray = new TreeNode(TreeNode.ARRAY_INITIALIZER);
                        twoDimArray.setChildArray(oneDimArray);
                        oneDimArray.setArrayElement(parseExpression());
                        while (checkNextTokenType(Token.COMMA))
                        {
                            for (int i = 0;i < spaceNum; i++)
                                System.out.print("     ");
                            System.out.println("|——— ,");
                            skipNextToken(Token.COMMA);
                            for (int i = 0;i < spaceNum; i++)
                                System.out.print("     ");
                            oneDimArray.setArrayElement(parseExpression());
                        }
                        for (int i = 0;i < spaceNum; i++)
                            System.out.print("     ");
                        System.out.println("|——— ]");
                        skipNextToken(Token.RBRACE);
                        for (int i = 0;i < spaceNum; i++)
                            System.out.print("     ");
                        System.out.println("|——— ,");
                        skipNextToken(Token.COMMA);
                        arrayLineNo++;
                    }
                }else
                    throw new Exception("Line" + getNextTokenLineNo() + " expects token {.");
            }
        }
        if (!variableNodes.isEmpty())
            variableNode.setNext(variableNodes.get(0));
        spaceNum = curSpaceNum;
        for (int i = 0;i < spaceNum; i++)
            System.out.print("     ");
        System.out.println("|——— ;");
        skipNextToken(Token.SEMICOLON);
        treeNode.setLeftNode(variableNode);
        return treeNode;
    } 

    private static TreeNode parseBlockStatement() throws Exception
    {
        System.out.println("|———Block Statement:");
        TreeNode treeNode = new TreeNode(TreeNode.BLOCK_STATEMENT);
        TreeNode rootNode = treeNode;
        TreeNode tempNode = null;
        skipNextToken(Token.LBRACE);
        while (getNextTokenType()!= Token.RBRACE)
        {
            tempNode = parseStatement();
            treeNode.setNext(tempNode);
            treeNode = tempNode;
        }
        skipNextToken(Token.RBRACE);
        return rootNode;
    }

    private static TreeNode parseAssignStatement() throws Exception
    {
        spaceNum++;
        int curSpaceNum = spaceNum;
        System.out.println("|———Assign Statement:");
        TreeNode treeNode = new TreeNode(TreeNode.ASSIGN_STATEMENT);
        for (int i = 0; i < spaceNum;i++)
            System.out.print("     ");
        treeNode.setLeftNode(variableName());
        skipNextToken(Token.EQ);
        for (int i = 0; i < spaceNum;i++)
            System.out.print("     ");
        treeNode.setMiddleNode(parseExpression());
        spaceNum = curSpaceNum;
        for (int i = 0; i < spaceNum;i++)
            System.out.print("     ");
        System.out.println("|——— ;");
        skipNextToken(Token.SEMICOLON);
        return treeNode;
    }

    private static TreeNode parseReadStatement() throws Exception
    {
        System.out.println("     |———Read Statement:");
        System.out.print("  ");
        TreeNode treeNode = new TreeNode(TreeNode.READ_STATEMENT);
        skipNextToken(Token.READ);
        treeNode.setLeftNode(variableName());
        skipNextToken(Token.SEMICOLON);
        return treeNode;
    }

    private static TreeNode parseWriteStatement() throws Exception
    {
        System.out.println("     |———Write Statement:");
        System.out.print("  ");
        TreeNode treeNode = new TreeNode(TreeNode.WRITE_STATEMENT);
        skipNextToken(Token.WRITE);
        treeNode.setLeftNode(parseExpression());
        skipNextToken(Token.SEMICOLON);
        return treeNode;
    }

    private static TreeNode parseWhileStatement() throws Exception
    {
        System.out.println("|———While Statement:");
        TreeNode treeNode = new TreeNode(TreeNode.WHILE_STATEMENT);
        skipNextToken(Token.WHILE);
        skipNextToken(Token.LPAREN);
        treeNode.setLeftNode(parseExpression());
        skipNextToken(Token.RPAREN);
        treeNode.setMiddleNode(parseStatement());
        return treeNode;
    }

    private static TreeNode parseBreakStatement() throws Exception
    {
        System.out.println("|———Break Statement:");
        TreeNode treeNode = new TreeNode(TreeNode.BREAK_STATEMENT);
        skipNextToken(Token.BREAK);
        skipNextToken(Token.SEMICOLON);
        return treeNode;
    }

    private static TreeNode parseIfStmt() throws Exception
    {
        System.out.println("|———If Statement:");
        TreeNode treeNode = new TreeNode(TreeNode.IF_STATEMENT);
        skipNextToken(Token.IF);
        skipNextToken(Token.LPAREN);
        treeNode.setLeftNode(parseExpression());
        skipNextToken(Token.RPAREN);
        treeNode.setMiddleNode(parseStatement());
        if (getNextTokenType() == Token.ELSE)
        {
            skipNextToken(Token.ELSE);
            treeNode.setRightNode(parseStatement());
        }
        return treeNode;
    }

    private static TreeNode parseExpression()throws Exception
    {
        spaceNum++;
        System.out.println("|———Expression:");
        TreeNode treeNode = new TreeNode(TreeNode.EXPRESSION);
        treeNode.setTokenType(Token.LogicOrAndExpression);
        for (int i = 0;i < spaceNum; i++)
            System.out.print("     ");
        TreeNode leftChild = logicEqualExpression();
        if (checkNextTokenType(Token.OROR, Token.ANDAND))
        {
            treeNode.setLeftNode(leftChild);
            treeNode.setMiddleNode(logicOperator());
            for (int i = 0;i < spaceNum; i++)
                System.out.print("     ");
            treeNode.setRightNode(logicEqualExpression());
        }else
        {
            return leftChild;
        }
        return treeNode;
    }

    private static TreeNode logicEqualExpression() throws Exception
    {
        spaceNum++;
        System.out.println("|———Logical Expression:");
        TreeNode treeNode = new TreeNode(TreeNode.EXPRESSION);
        treeNode.setTokenType(Token.LogicEqualExpression);
        for (int i = 0;i < spaceNum; i++)
            System.out.print("     ");
        TreeNode leftChild = logicNotEqualExpression();
        if (checkNextTokenType(Token.EQEQ))
        {
            treeNode.setLeftNode(leftChild);
            treeNode.setMiddleNode(logicOperator());
            for (int i = 0;i < spaceNum; i++)
                System.out.print("     ");
            treeNode.setRightNode(logicNotEqualExpression());
        }else
            return leftChild;
        return treeNode;
    }

    private static TreeNode logicNotEqualExpression() throws Exception
    {
        TreeNode treeNode = new TreeNode(TreeNode.EXPRESSION);
        treeNode.setTokenType(Token.LogicNotEqualExpression);
        TreeNode leftChild = addibleExpression();
        if (checkNextTokenType(Token.NE, Token.LT, Token.GT))
        {
            treeNode.setLeftNode(leftChild);
            treeNode.setMiddleNode(logicOperator());
            for (int i = 0;i < spaceNum; i++)
                System.out.print("     ");
            treeNode.setRightNode(addibleExpression());
        }else
            return leftChild;
        return treeNode;
    }

    private static TreeNode addibleExpression() throws Exception
    {
        spaceNum++;
        //这里的curSpaceNum用于使加号与Arithmetic Expression在同一级
        int curSpaceNum = spaceNum - 1;
        System.out.println("|———Arithmetic Expression:");
        TreeNode treeNode = new TreeNode(TreeNode.EXPRESSION);
        treeNode.setTokenType(Token.AddibleExpression);
        for (int i = 0;i < spaceNum; i++)
            System.out.print("     ");
        TreeNode leftChild = term();
        if (checkNextTokenType(Token.ADD))
        {
            spaceNum = curSpaceNum;
            for (int i = 0;i < spaceNum; i++)
                System.out.print("     ");
            System.out.println("|——— +");
            treeNode.setLeftNode(leftChild);
            treeNode.setMiddleNode(addibleOperator());
            for (int i = 0;i < spaceNum; i++)
                System.out.print("     ");
            treeNode.setRightNode(addibleExpression());
        }else if (checkNextTokenType(Token.SUB))    //?????
        {
            spaceNum = curSpaceNum;
            for (int i = 0;i < spaceNum; i++)
                System.out.print("     ");
            System.out.println("|——— -");
            treeNode.setLeftNode(leftChild);
            TreeNode subOperatorNode = new TreeNode(TreeNode.OPERATOR);
            subOperatorNode.setTokenType(Token.ADD);
            treeNode.setMiddleNode(subOperatorNode);
            for (int i = 0;i < spaceNum; i++)
                System.out.print("     ");
            treeNode.setRightNode(addibleExpression());
        }else
            return leftChild;
        return treeNode;
    }

    private static TreeNode term() throws Exception
    {
        spaceNum++;
        System.out.println("|———Term:");
        TreeNode treeNode = new TreeNode(TreeNode.EXPRESSION);
        treeNode.setTokenType(Token.TermExpression);
        for (int i = 0;i < spaceNum; i++)
            System.out.print("     ");
        TreeNode leftChild = notExpression();
        if (checkNextTokenType(Token.MUL, Token.DIV))
        {
            for (int i = 0;i < spaceNum; i++)
                System.out.print("     ");
            if (checkNextTokenType(Token.MUL))
            {
                System.out.println("|——— *");
                treeNode.setLeftNode(leftChild);
                treeNode.setMiddleNode(multiplyOperator());
            }
            else if (checkNextTokenType(Token.DIV))
            {
                System.out.println("|——— /");
                treeNode.setLeftNode(leftChild);
                treeNode.setMiddleNode(multiplyOperator());
            }
            for (int i = 0;i < spaceNum; i++)
                System.out.print("     ");
            treeNode.setRightNode(term());
        }else
            return leftChild;
        return treeNode;
    }

    private static TreeNode notExpression() throws Exception
    {
        TreeNode treeNode = new TreeNode(TreeNode.EXPRESSION);
        treeNode.setTokenType(Token.NotExpression);
        if (checkNextTokenType(Token.BANG))
        {
            treeNode.setLeftNode(notOperator());
            treeNode.setMiddleNode(factor());
        }else
        {
            return factor();
        }
        return treeNode;
    }

    private static TreeNode factor() throws Exception
    {

        if (iterator.hasNext())
        {
            TreeNode treeNode = new TreeNode(TreeNode.FACTOR);
            switch (getNextTokenType())
            {
                case Token.Integer:
                case Token.RealNumber:
                    treeNode.setLeftNode(literal());
                    break;
                case Token.LPAREN:
                    skipNextToken(Token.LPAREN);
                    treeNode = parseExpression();
                    skipNextToken(Token.RPAREN);
                    break;
                case Token.ADD:
                    currentToken = iterator.next();
                    treeNode.setLeftNode(term());
                    break;
                case Token.SUB:
                    treeNode.setTokenType(Token.SUB);
                    currentToken = iterator.next();
                    treeNode.setLeftNode(term());
                    break;
                default:
                    //System.out.println(""+ currentToken.getValue());
                    return variableName();
            }
            return treeNode;
        }
        throw new Exception("line " + getNextTokenLineNo() + " : next token should be factor.");
    }

    private static TreeNode literal() throws Exception
    {
        if (iterator.hasNext())
        {
            currentToken = iterator.next();
            System.out.println("|———Literal:"+ currentToken.getValue());
            int tokenType = currentToken.getType();
            TreeNode treeNode = new TreeNode(TreeNode.LITERAL);
            treeNode.setTokenType(tokenType);
            treeNode.setValue(currentToken.getValue());
            if (tokenType == Token.Integer || tokenType == Token.RealNumber)
            {
                return treeNode;
            }
        }
        throw new Exception("line " + getNextTokenLineNo() + " : next token should be litreal.");
    }

    private static TreeNode logicOperator() throws Exception
    {
        if (iterator.hasNext())
        {
            currentToken = iterator.next();
            int tokeType = currentToken.getType();
            if (tokeType == Token.ANDAND || tokeType == Token.OROR
                    || tokeType == Token.EQEQ || tokeType == Token.LT
                    || tokeType == Token.NE || tokeType == Token.GT)
            {
                TreeNode treeNode = new TreeNode(TreeNode.OPERATOR);
                treeNode.setTokenType(tokeType);
                return treeNode;
            }
        }
        throw new Exception("line " + getNextTokenLineNo() + " : next token should be logical operator.");
    }

    private static TreeNode multiplyOperator() throws Exception
    {
        if (iterator.hasNext())
        {
            currentToken = iterator.next();
            int tokenType = currentToken.getType();
            if (tokenType == Token.MUL || tokenType == Token.DIV)
            {
                TreeNode treeNode = new TreeNode(TreeNode.OPERATOR);
                treeNode.setTokenType(tokenType);
                return treeNode;
            }
        }
        throw new Exception("line " + getNextTokenLineNo() + " : next token should be multiple operator");
    }

    private static TreeNode notOperator() throws Exception
    {
        if (iterator.hasNext())
        {
            currentToken = iterator.next();
            int tokenType = currentToken.getType();
            if (tokenType == Token.BANG)
            {
                TreeNode treeNode = new TreeNode(TreeNode.OPERATOR);
                treeNode.setTokenType(tokenType);
                return treeNode;
            }
        }
        throw new Exception("line " + getNextTokenLineNo() + " : next token should be bang operator");
    }

    private static TreeNode variableName() throws Exception
    {
        spaceNum++;
        TreeNode treeNode = new TreeNode(TreeNode.VARIABLE);
        if (checkNextTokenType(Token.ID))
        {
            currentToken = iterator.next();
            System.out.println("|———Variable:" + currentToken.getValue());
            treeNode.setValue(currentToken.getValue());
        }else
            throw new Exception("line " + getNextTokenLineNo() + " : next token should be ID." );
        if (getNextTokenType() == Token.LBRACK)
        {
            skipNextToken(Token.LBRACK);
            treeNode.setLeftNode(parseExpression());
            skipNextToken(Token.RBRACK);
        }
        return treeNode;
    }


    private static TreeNode addibleOperator() throws Exception
    {
        if (iterator.hasNext())
        {
            currentToken = iterator.next();
            int tokenType = currentToken.getType();
            if (tokenType == Token.ADD || tokenType == Token.SUB)
            {
                TreeNode treeNode = new TreeNode(TreeNode.OPERATOR);
                treeNode.setTokenType(tokenType);
                return treeNode;
            }
        }
        throw new Exception("line " + getNextTokenLineNo() + " : next token should be addible operator.");
    }



    private static int getNextTokenType()
    {
        if (iterator.hasNext()) {
            int tokenType = iterator.next().getType();
            iterator.previous();
            return tokenType;
        }
        return Token.NULL;
    }

    private static int getNextTokenLineNo()
    {
        if (iterator.hasNext())
        {
            int lineNo = iterator.next().getLineNo();
            iterator.previous();
            return lineNo;
        }
        return -1;
    }

    private static boolean checkNextTokenType(int ... tokenType)
    {
        if (iterator.hasNext())
        {
            int nextTokenType = iterator.next().getType();
            iterator.previous();
            for (int token: tokenType)
            {
                if (nextTokenType == token)
                    return true;
            }
        }
        return false;
    }

    private static void skipNextToken(int tokenType) throws Exception
    {
        if (iterator.hasNext()) {
            currentToken = iterator.next();
            if (currentToken.getType() == tokenType)
                return;
        }else
            throw new Exception("line" + getNextTokenLineNo() + " : next token should be " + new Token(tokenType, 0));
    }

}
