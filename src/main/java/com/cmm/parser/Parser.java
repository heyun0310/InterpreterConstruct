package com.cmm.parser;

import com.cmm.lexer.Token;
import com.sun.corba.se.impl.oa.toa.TOA;
import sun.reflect.generics.tree.Tree;

import javax.transaction.TransactionRequiredException;
import java.util.LinkedList;
import java.util.ListIterator;

public class Parser {

    //private static LinkedList<TreeNode> treeNodeLinkedList;
    private static TreeNode rootNode;
    private static Token currentToken = null;
    private static ListIterator<Token> iterator = null;
    private static int spaceNum;    //绘制语法树时用于缩进

    public static TreeNode syntacticAnalyse(LinkedList<Token> tokenLinkedList) throws Exception
    {
        //treeNodeLinkedList = new LinkedList<TreeNode>();
        rootNode = new TreeNode(TreeNode.NULL);
        iterator = tokenLinkedList.listIterator();

        //System.out.println("Programme:");
        while (iterator.hasNext())
        {
            spaceNum = 1;
            //System.out.print("     ");
            //treeNodeLinkedList.add(parseStatement());
            rootNode.setChildNode(parseStatement());
        }
        return rootNode;
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
            case Token.RETURN:
                return parseReturnStatement();
            default:
                throw new Exception("Line" + getNextTokenLineNo() + " expects token");
        }
    }

    private static TreeNode parseDeclareStatement() throws Exception {
        spaceNum++;
        int curSpaceNum = spaceNum;
        //System.out.println("|———Declare Statement:");
        TreeNode treeNode = new TreeNode(TreeNode.DECLARE_STATEMENT);
        TreeNode variableNode = new TreeNode(TreeNode.VARIABLE);
        //LinkedList<TreeNode> variableNodes = new LinkedList<TreeNode>();

        //声明语句中的关键字
        if (checkNextTokenType(Token.INT, Token.REAL)) {
            currentToken = iterator.next();
            int tokenType = currentToken.getType();
            if (tokenType == Token.INT) {
                TreeNode keyNode = new TreeNode(TreeNode.INT);
                treeNode.setChildNode(keyNode);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
//                System.out.println("|———INT");
                variableNode.setTokenType(Token.INT);
            } else {
                TreeNode keyNode = new TreeNode(TreeNode.REAL);
                treeNode.setChildNode(keyNode);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
//                System.out.println("|———REAL");
                variableNode.setTokenType(Token.REAL);
            }
        } else {
            throw new Exception("Line" + getNextTokenLineNo() + " expects token INT/NEXT.");
        }
        //这里MUL*作为指针符号
        if (checkNextTokenType(Token.MUL)) {
            currentToken = iterator.next();
            TreeNode operatorNode = new TreeNode(TreeNode.MUL);
            treeNode.setChildNode(operatorNode);
//            for (int i = 0; i < spaceNum; i++)
//                System.out.print("     ");
//            System.out.println("|——— *");
        }

        //声明语句中的自定义标识符
        if (checkNextTokenType(Token.ID)) {
            treeNode.setChildNode(variableNode);
            currentToken = iterator.next();
            variableNode.setValue(currentToken.getValue());
//            for (int i = 0; i < spaceNum; i++)
//                System.out.print("     ");
//            System.out.println("|———ID:" + currentToken.getValue());
//            treeNode.setChildNode(variableNode);
        } else {
            throw new Exception("Line" + getNextTokenLineNo() + " expects token ID.");
        }


        //声明语句同时初始化变量中的“=”
        if (checkNextTokenType(Token.EQ)) {
            TreeNode keyNode = new TreeNode(TreeNode.EQ);
            treeNode.setChildNode(keyNode);
//            for (int i = 0; i < spaceNum; i++)
//                System.out.print("     ");
//            System.out.println("|——— =");
            skipNextToken(Token.EQ);

            if (checkNextTokenType(Token.GetAddress)) {
                //spaceNum = curSpace;
                TreeNode operatorNode = new TreeNode(TreeNode.GetAddress);
                treeNode.setChildNode(operatorNode);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
//                System.out.println("|——— &");
                skipNextToken(Token.GetAddress);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
                treeNode.setChildNode(variableName());
            } else if (checkNextTokenType(Token.MUL)) {
                TreeNode operatorNode = new TreeNode(TreeNode.MUL);
                treeNode.setChildNode(operatorNode);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
//                System.out.println("|——— *");
                skipNextToken(Token.MUL);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
                treeNode.setChildNode(variableName());
            } else {
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
                treeNode.setChildNode(parseExpression());
            }
        } else if (getNextTokenType() == Token.LBRACK)
        {
            //curPos用于找回]所在的缩进位置
            int curPos = spaceNum;
            TreeNode operatorNode = new TreeNode(TreeNode.LBRACK);
            treeNode.setChildNode(operatorNode);
//            for (int i = 0; i < spaceNum; i++)
//                System.out.print("     ");
//            System.out.println("|——— [");
            skipNextToken(Token.LBRACK);
//            for (int i = 0; i < spaceNum; i++)
//                System.out.print("     ");
            treeNode.setChildNode(parseExpression());
            spaceNum = curPos;
            TreeNode operatorNode2 = new TreeNode(TreeNode.RBRACK);
            treeNode.setChildNode(operatorNode2);
//            for (int i = 0; i < spaceNum; i++)
//                System.out.print("     ");
//            System.out.println("|——— ]");
            skipNextToken(Token.RBRACK);
            if (checkNextTokenType(Token.LBRACK)) {
                int curPos_ = spaceNum;
                TreeNode operatorNode_1 = new TreeNode(TreeNode.LBRACK);
                treeNode.setChildNode(operatorNode_1);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
//                System.out.println("|——— [");
                skipNextToken(Token.LBRACK);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
                treeNode.setChildNode(parseExpression());
                spaceNum = curPos_;
                TreeNode operatorNode_2 = new TreeNode(TreeNode.LBRACK);
                treeNode.setChildNode(operatorNode_2);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
//                System.out.println("|——— ]");
                skipNextToken(Token.RBRACK);
            }

            //当声明数组的同时初始化数组
            if (checkNextTokenType(Token.EQ))
            {
                TreeNode arrayInitializer = new TreeNode(TreeNode.ARRAY_INITIALIZER);
                treeNode.setChildNode(arrayInitializer);
                TreeNode eqNode = new TreeNode(TreeNode.EQ);
                TreeNode arrayLiteral = new TreeNode(TreeNode.ARRAY_LITERAL);
                arrayInitializer.setChildNode(arrayLiteral);
                arrayInitializer.setChildNode(eqNode);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
//                System.out.println("|——— =");
                skipNextToken(Token.EQ);
                if (checkNextTokenType(Token.LBRACE)) {
//                    for (int i = 0; i < spaceNum; i++)
//                        System.out.print("     ");
//                    System.out.println("|———Array:");
                    spaceNum++;
                    int curSpace = spaceNum;
                    TreeNode lbraceNode = new TreeNode(TreeNode.LBRACE);
                    arrayLiteral.setChildNode(lbraceNode);
//                    for (int i = 0; i < spaceNum; i++)
//                        System.out.print("     ");
//                    System.out.println("|——— {");
                    skipNextToken(Token.LBRACE);
                    while (checkNextTokenType(Token.LBRACE)) {
                        TreeNode childArrayLiteral = new TreeNode(TreeNode.ARRAY_LITERAL);
                        arrayLiteral.setChildNode(childArrayLiteral);
                        spaceNum = curSpace;
//                        for (int i = 0; i < spaceNum; i++)
//                            System.out.print("     ");
//                        System.out.println("|———Array:");
                        spaceNum++;
                        TreeNode lbraceNode_ = new TreeNode(TreeNode.LBRACE);
                        childArrayLiteral.setChildNode(lbraceNode_);
//                        for (int i = 0; i < spaceNum; i++)
//                            System.out.print("     ");
//                        System.out.println("|——— {");
                        skipNextToken(Token.LBRACE);
//                        for (int i = 0; i < spaceNum; i++)
//                            System.out.print("     ");
                        int curSpace_ = spaceNum;
                        childArrayLiteral.setChildNode(parseExpression());
                        //variableNode.setArrayElement(arrayLineNo, parseExpression());
                        while (checkNextTokenType(Token.COMMA)) {
                            TreeNode commaNode = new TreeNode(TreeNode.COMMA);
                            childArrayLiteral.setChildNode(commaNode);
                            spaceNum = curSpace_;
//                            for (int i = 0; i < spaceNum; i++)
//                                System.out.print("     ");
//                            System.out.println("|——— ,");
                            skipNextToken(Token.COMMA);
//                            for (int i = 0; i < spaceNum; i++)
//                                System.out.print("     ");
                            childArrayLiteral.setChildNode(parseExpression());
                        }
                        TreeNode rbraceNode = new TreeNode(TreeNode.RBRACE);
                        childArrayLiteral.setChildNode(rbraceNode);
//                        for (int i = 0; i < spaceNum; i++)
//                            System.out.print("     ");
//                        System.out.println("|——— }");
                        skipNextToken(Token.RBRACE);
                        TreeNode commaNode = new TreeNode(TreeNode.COMMA);
                        arrayLiteral.setChildNode(commaNode);
//                        for (int i = 0; i < spaceNum; i++)
//                            System.out.print("     ");
//                        System.out.println("|——— ,");
                        skipNextToken(Token.COMMA);
                        //arrayLineNo++;
                    }
                } else
                    throw new Exception("Line" + getNextTokenLineNo() + " expects token {.");
            }
        }
        //处理函数声明
        else if (getNextTokenType() == Token.LPAREN) {
            TreeNode lparenNode = new TreeNode(TreeNode.LPAREN);
            treeNode.setChildNode(lparenNode);
//            for (int i = 0; i < spaceNum; i++)
//                System.out.print("     ");
//            System.out.println("|——— (");
            skipNextToken(Token.LPAREN);
            if (getNextTokenType() == Token.RPAREN) {
                TreeNode rparenNode = new TreeNode(TreeNode.RPAREN);
                treeNode.setChildNode(rparenNode);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
//                System.out.println("|——— )");
                skipNextToken(Token.RPAREN);
            } else {
                System.out.println("Line" + getNextTokenLineNo() + "function declarement expects token ).");
            }
            //用于处理函数体，即BlockStatement
//            for (int i = 0; i < spaceNum; i++)
//                System.out.print("     ");
//            treeNode.setChildNode(parseStatement());
        }

        while (checkNextTokenType(Token.COMMA)) {
            spaceNum = curSpaceNum;
            TreeNode commaNode = new TreeNode(TreeNode.COMMA);
            treeNode.setChildNode(commaNode);
            TreeNode theOtherVariableNode = new TreeNode(TreeNode.VARIABLE);
            theOtherVariableNode.setTokenType(variableNode.getTokenType());
            currentToken = iterator.next();
            appendToParseDeclareStatement(treeNode, variableNode, theOtherVariableNode, curSpaceNum);
        }
        spaceNum = curSpaceNum;
        //为了处理函数声明，这里添加一个if（函数体结束后后面没有分号）
        if (getNextTokenType() == Token.SEMICOLON) {
            TreeNode semiNode = new TreeNode(TreeNode.SEMICOLON);
            treeNode.setChildNode(semiNode);
//            for (int i = 0; i < spaceNum; i++)
//                System.out.print("     ");
//            System.out.println("|——— ;");
            skipNextToken(Token.SEMICOLON);
        }
        //treeNode.setChildNode(variableNode);
        return treeNode;
    }

    private static void appendToParseDeclareStatement(TreeNode parentNode, TreeNode variableNode, TreeNode theOtherVariableNode, int curSpaceNum) throws Exception
    {
        if (checkNextTokenType(Token.MUL)) {
            currentToken = iterator.next();
            TreeNode operatorNode = new TreeNode(TreeNode.MUL);
            parentNode.setChildNode(operatorNode);
//            for (int i = 0; i < spaceNum; i++)
//                System.out.print("     ");
//            System.out.println("|——— *");
        }

        //声明语句中的自定义标识符
        if (checkNextTokenType(Token.ID)) {
            currentToken = iterator.next();
            theOtherVariableNode.setValue(currentToken.getValue());
//            for (int i = 0; i < spaceNum; i++)
//                System.out.print("     ");
//            System.out.println("|———ID:" + currentToken.getValue());
            parentNode.setChildNode(theOtherVariableNode);
        } else {
            throw new Exception("Line" + getNextTokenLineNo() + " expects token ID.");
        }


        //声明语句同时初始化变量中的“=”
        if (checkNextTokenType(Token.EQ))
        {
            TreeNode keyNode = new TreeNode(TreeNode.EQ);
            parentNode.setChildNode(keyNode);
//            for (int i = 0; i < spaceNum; i++)
//                System.out.print("     ");
//            System.out.println("|——— =");
            skipNextToken(Token.EQ);

            if (checkNextTokenType(Token.GetAddress)) {
                //spaceNum = curSpace;
                TreeNode operatorNode = new TreeNode(TreeNode.GetAddress);
                parentNode.setChildNode(operatorNode);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
//                System.out.println("|——— &");
                skipNextToken(Token.GetAddress);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
                parentNode.setChildNode(variableName());
            } else if (checkNextTokenType(Token.MUL)) {
                TreeNode operatorNode = new TreeNode(TreeNode.MUL);
                parentNode.setChildNode(operatorNode);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
//                System.out.println("|——— *");
                skipNextToken(Token.MUL);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
                parentNode.setChildNode(variableName());
            } else {
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
                parentNode.setChildNode(parseExpression());
            }
        } else if (getNextTokenType() == Token.LBRACK) {
            //curPos用于找回]所在的缩进位置
            int curPos = spaceNum;
            TreeNode operatorNode = new TreeNode(TreeNode.LBRACK);
            parentNode.setChildNode(operatorNode);
//            for (int i = 0; i < spaceNum; i++)
//                System.out.print("     ");
//            System.out.println("|——— [");
            skipNextToken(Token.LBRACK);
//            for (int i = 0; i < spaceNum; i++)
//                System.out.print("     ");
            parentNode.setChildNode(parseExpression());
            spaceNum = curPos;
            TreeNode operatorNode2 = new TreeNode(TreeNode.RBRACK);
            parentNode.setChildNode(operatorNode2);
//            for (int i = 0; i < spaceNum; i++)
//                System.out.print("     ");
//            System.out.println("|——— ]");
            skipNextToken(Token.RBRACK);
            if (checkNextTokenType(Token.LBRACK)) {
                int curPos_ = spaceNum;
                TreeNode operatorNode_1 = new TreeNode(TreeNode.LBRACK);
                parentNode.setChildNode(operatorNode_1);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
//                System.out.println("|——— [");
                skipNextToken(Token.LBRACK);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
                parentNode.setChildNode(parseExpression());
                spaceNum = curPos_;
                TreeNode operatorNode_2 = new TreeNode(TreeNode.LBRACK);
                parentNode.setChildNode(operatorNode_2);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
//                System.out.println("|——— ]");
                skipNextToken(Token.RBRACK);
            }
            if (checkNextTokenType(Token.EQ)) {
                TreeNode arrayInitializer = new TreeNode(TreeNode.ARRAY_INITIALIZER);
                parentNode.setChildNode(arrayInitializer);
                TreeNode eqNode = new TreeNode(TreeNode.EQ);
                TreeNode arrayLiteral = new TreeNode(TreeNode.ARRAY_LITERAL);
                arrayInitializer.setChildNode(arrayLiteral);
                arrayInitializer.setChildNode(eqNode);
//                for (int i = 0; i < spaceNum; i++)
//                    System.out.print("     ");
//                System.out.println("|——— =");
                skipNextToken(Token.EQ);
                if (checkNextTokenType(Token.LBRACE)) {
//                    for (int i = 0; i < spaceNum; i++)
//                        System.out.print("     ");
//                    System.out.println("|———Array:");
                    spaceNum++;
                    int curSpace = spaceNum;
                    TreeNode lbraceNode = new TreeNode(TreeNode.LBRACE);
                    arrayLiteral.setChildNode(lbraceNode);
//                    for (int i = 0; i < spaceNum; i++)
//                        System.out.print("     ");
//                    System.out.println("|——— {");
                    skipNextToken(Token.LBRACE);
                    while (checkNextTokenType(Token.LBRACE)) {
                        TreeNode childArrayLiteral = new TreeNode(TreeNode.ARRAY_LITERAL);
                        arrayLiteral.setChildNode(childArrayLiteral);
                        spaceNum = curSpace;
//                        for (int i = 0; i < spaceNum; i++)
//                            System.out.print("     ");
//                        System.out.println("|———Array:");
                        spaceNum++;
                        TreeNode lbraceNode_ = new TreeNode(TreeNode.LBRACE);
                        childArrayLiteral.setChildNode(lbraceNode_);
//                        for (int i = 0; i < spaceNum; i++)
//                            System.out.print("     ");
//                        System.out.println("|——— {");
                        skipNextToken(Token.LBRACE);
//                        for (int i = 0; i < spaceNum; i++)
//                            System.out.print("     ");
                        int curSpace_ = spaceNum;
                        childArrayLiteral.setChildNode(parseExpression());
                        //variableNode.setArrayElement(arrayLineNo, parseExpression());
                        while (checkNextTokenType(Token.COMMA)) {
                            TreeNode commaNode = new TreeNode(TreeNode.COMMA);
                            childArrayLiteral.setChildNode(commaNode);
                            spaceNum = curSpace_;
//                            for (int i = 0; i < spaceNum; i++)
//                                System.out.print("     ");
//                            System.out.println("|——— ,");
                            skipNextToken(Token.COMMA);
//                            for (int i = 0; i < spaceNum; i++)
//                                System.out.print("     ");
                            childArrayLiteral.setChildNode(parseExpression());
                        }
                        TreeNode rbraceNode = new TreeNode(TreeNode.RBRACE);
                        childArrayLiteral.setChildNode(rbraceNode);
//                        for (int i = 0; i < spaceNum; i++)
//                            System.out.print("     ");
//                        System.out.println("|——— }");
                        skipNextToken(Token.RBRACE);
                        TreeNode commaNode = new TreeNode(TreeNode.COMMA);
                        arrayLiteral.setChildNode(commaNode);
//                        for (int i = 0; i < spaceNum; i++)
//                            System.out.print("     ");
//                        System.out.println("|——— ,");
                        skipNextToken(Token.COMMA);
                        //arrayLineNo++;
                    }
                } else
                    throw new Exception("Line" + getNextTokenLineNo() + " expects token {.");
            }
        }
    }

    private static TreeNode parseBlockStatement() throws Exception
    {
        spaceNum++;
        int curSpace = spaceNum;
        //System.out.println("|———Block Statement:");
        TreeNode treeNode = new TreeNode(TreeNode.BLOCK_STATEMENT);
        TreeNode rootNode = treeNode;
        TreeNode statementNodeInBlock = null;
        skipNextToken(Token.LBRACE);
        TreeNode lbraceNode = new TreeNode(TreeNode.LBRACE);
        treeNode.setChildNode(lbraceNode);
        TreeNode statementListInBlock = new TreeNode(TreeNode.STATEMENT_LIST);
        treeNode.setChildNode(statementListInBlock);
//        for (int i = 0;i<spaceNum;i++)
//            System.out.print("     ");
//        System.out.println("|——— {");

        while (getNextTokenType()!= Token.RBRACE)
        {
            spaceNum = curSpace;
//            for (int i = 0;i<spaceNum;i++)
//                System.out.print("     ");
            statementNodeInBlock = parseStatement();
            statementListInBlock.setChildNode(statementNodeInBlock);
        }
        spaceNum = curSpace;
        TreeNode rbraceNode = new TreeNode(TreeNode.RBRACE);
        treeNode.setChildNode(rbraceNode);
//        for (int i = 0;i<spaceNum;i++)
//            System.out.print("     ");
//        System.out.println("|——— }");
        skipNextToken(Token.RBRACE);
        return rootNode;
    }

    private static TreeNode parseAssignStatement() throws Exception
    {
        spaceNum++;
        int curSpaceNum = spaceNum;
        //System.out.println("|———Assign Statement:");
        TreeNode treeNode = new TreeNode(TreeNode.ASSIGN_STATEMENT);
//        for (int i = 0; i < spaceNum;i++)
//            System.out.print("     ");
        treeNode.setChildNode(variableName());
        spaceNum = curSpaceNum;
        TreeNode eqNode = new TreeNode(TreeNode.EQ);
        treeNode.setChildNode(eqNode);
//        for (int i = 0; i < spaceNum;i++)
//            System.out.print("     ");
//        System.out.println("|——— =");
        skipNextToken(Token.EQ);

        if (checkNextTokenType(Token.GetAddress))
        {
            TreeNode opNode = new TreeNode(TreeNode.GetAddress);
            treeNode.setChildNode(opNode);
//            for (int i = 0; i < spaceNum;i++)
//                System.out.print("     ");
//            System.out.println("|——— &");
            skipNextToken(Token.GetAddress);
//            for (int i = 0; i < spaceNum;i++)
//                System.out.print("     ");
            treeNode.setChildNode(variableName());
        }else if (checkNextTokenType(Token.MUL))
        {
            TreeNode opNode = new TreeNode(TreeNode.MUL);
            treeNode.setChildNode(opNode);
//            for (int i = 0; i < spaceNum;i++)
//                System.out.print("     ");
//            System.out.println("|——— *");
            skipNextToken(Token.MUL);
//            for (int i = 0; i < spaceNum;i++)
//                System.out.print("     ");
            treeNode.setChildNode(variableName());
        }else
        {
//            for (int i = 0; i < spaceNum;i++)
//                System.out.print("     ");
            treeNode.setChildNode(parseExpression());
        }
        spaceNum = curSpaceNum;
        TreeNode semiNode = new TreeNode(TreeNode.SEMICOLON);
        treeNode.setChildNode(semiNode);
//        for (int i = 0; i < spaceNum;i++)
//            System.out.print("     ");
//        System.out.println("|——— ;");
        skipNextToken(Token.SEMICOLON);
        return treeNode;
    }

    private static TreeNode parseReadStatement() throws Exception
    {
        spaceNum++;
        int curSpace = spaceNum;
//        System.out.println("|———Read Statement:");
        TreeNode treeNode = new TreeNode(TreeNode.READ_STATEMENT);
        skipNextToken(Token.READ);
        TreeNode readNode = new TreeNode(TreeNode.READ);
        treeNode.setChildNode(readNode);
//        for (int i = 0; i < spaceNum;i++)
//            System.out.print("     ");
//        System.out.println("|——— READ");
//        for (int i = 0; i < spaceNum;i++)
//            System.out.print("     ");
        treeNode.setChildNode(variableName());
        spaceNum = curSpace;
        TreeNode semiNode = new TreeNode(TreeNode.SEMICOLON);
        treeNode.setChildNode(semiNode);
//        for (int i = 0; i < spaceNum;i++)
//            System.out.print("     ");
//        System.out.println("|——— ;");
        skipNextToken(Token.SEMICOLON);
        return treeNode;
    }

    private static TreeNode parseWriteStatement() throws Exception
    {
        spaceNum++;
        int curSpace = spaceNum;
//        System.out.println("|———Write Statement:");
        TreeNode treeNode = new TreeNode(TreeNode.WRITE_STATEMENT);
        skipNextToken(Token.WRITE);
        TreeNode writeNode = new TreeNode(TreeNode.WRITE);
        treeNode.setChildNode(writeNode);
//        for (int i = 0; i < spaceNum;i++)
//            System.out.print("     ");
//        System.out.println("|——— WRITE");
//        for (int i = 0; i < spaceNum;i++)
//            System.out.print("     ");
        treeNode.setChildNode(parseExpression());
        spaceNum = curSpace;
        TreeNode semiNode = new TreeNode(TreeNode.SEMICOLON);
        treeNode.setChildNode(semiNode);
//        for (int i = 0; i < spaceNum;i++)
//            System.out.print("     ");
//        System.out.println("|——— ;");
        skipNextToken(Token.SEMICOLON);
        return treeNode;
    }

    private static TreeNode parseWhileStatement() throws Exception
    {
        spaceNum++;
        int curSpace = spaceNum;
//        System.out.println("|———While Statement:");
        TreeNode treeNode = new TreeNode(TreeNode.WHILE_STATEMENT);
        TreeNode whileNode = new TreeNode(TreeNode.WHILE);
        treeNode.setChildNode(whileNode);
//        for (int i = 0;i < spaceNum; i++)
//            System.out.print("     ");
//        System.out.println("|——— While");
        skipNextToken(Token.WHILE);
        TreeNode lparenNode = new TreeNode(TreeNode.LPAREN);
        treeNode.setChildNode(lparenNode);
//        for (int i = 0;i < spaceNum;i++)
//            System.out.print("     ");
//        System.out.println("|——— (");
        skipNextToken(Token.LPAREN);
//        for (int i = 0;i < spaceNum;i++)
//            System.out.print("     ");
        treeNode.setChildNode(parseExpression());
        spaceNum = curSpace;
        TreeNode rparenNode = new TreeNode(TreeNode.RPAREN);
        treeNode.setChildNode(rparenNode);
//        for (int i = 0;i < spaceNum;i++)
//            System.out.print("     ");
//        System.out.println("|——— )");
        skipNextToken(Token.RPAREN);
//        for (int i = 0;i < spaceNum;i++)
//            System.out.print("     ");
        treeNode.setChildNode(parseStatement());
        return treeNode;
    }

    private static TreeNode parseBreakStatement() throws Exception
    {
//        System.out.println("|———Break Statement:");
        TreeNode treeNode = new TreeNode(TreeNode.BREAK_STATEMENT);
        TreeNode breakNode = new TreeNode(TreeNode.BREAK);
        treeNode.setChildNode(breakNode);
        skipNextToken(Token.BREAK);
        TreeNode semiNode = new TreeNode(TreeNode.SEMICOLON);
        treeNode.setChildNode(semiNode);
        skipNextToken(Token.SEMICOLON);
        return treeNode;
    }

    private static TreeNode parseIfStmt() throws Exception
    {
        spaceNum++;
        int curSpace = spaceNum;
//        System.out.println("|———If Statement:");
        TreeNode treeNode = new TreeNode(TreeNode.IF_STATEMENT);
        skipNextToken(Token.IF);
        TreeNode ifNode = new TreeNode(TreeNode.IF);
        treeNode.setChildNode(ifNode);
//        for (int i = 0;i < spaceNum;i++)
//            System.out.print("     ");
//        System.out.println("|——— IF");
        skipNextToken(Token.LPAREN);
        TreeNode lparenNode = new TreeNode(TreeNode.LPAREN);
        treeNode.setChildNode(lparenNode);
//        for (int i = 0;i < spaceNum;i++)
//            System.out.print("     ");
//        System.out.println("|——— (");
//        for (int i = 0;i < spaceNum;i++)
//            System.out.print("     ");
        treeNode.setChildNode(parseExpression());
        skipNextToken(Token.RPAREN);
        spaceNum = curSpace;
        TreeNode rparenNoded = new TreeNode(TreeNode.RPAREN);
        treeNode.setChildNode(rparenNoded);
//        for (int i = 0;i < spaceNum;i++)
//            System.out.print("     ");
//        System.out.println("|——— )");
//        for (int i = 0;i < spaceNum;i++)
//            System.out.print("     ");
        treeNode.setChildNode(parseStatement());
        if (getNextTokenType() == Token.ELSE)
        {
            TreeNode elseNode = new TreeNode(TreeNode.ELSE);
            treeNode.setChildNode(elseNode);
            skipNextToken(Token.ELSE);
//            for (int i = 0;i < spaceNum;i++)
//                System.out.print("     ");
            treeNode.setChildNode(parseStatement());
        }
        return treeNode;
    }

    private static TreeNode parseReturnStatement() throws Exception
    {
        spaceNum++;
        int curSpace = spaceNum;
//        System.out.println("|——— Return Statement:");
        TreeNode treeNode = new TreeNode(TreeNode.RETURN_STATEMENT);
        skipNextToken(Token.RETURN);
        TreeNode returnNode = new TreeNode(TreeNode.RETURN);
        treeNode.setChildNode(returnNode);
//        for (int i = 0; i < spaceNum;i++)
//            System.out.print("     ");
//        System.out.println("|——— RETURN");
//        for (int i = 0; i < spaceNum;i++)
//            System.out.print("     ");
        treeNode.setChildNode(parseExpression());
        spaceNum = curSpace;
        TreeNode semiNode = new TreeNode(TreeNode.SEMICOLON);
        treeNode.setChildNode(semiNode);
//        for (int i = 0; i < spaceNum;i++)
//            System.out.print("     ");
//        System.out.println("|——— ;");
        skipNextToken(Token.SEMICOLON);
        return treeNode;
    }

    private static TreeNode parseExpression()throws Exception
    {
        spaceNum++;
        int curSpace = spaceNum;
//        System.out.println("|———Expression:");
        TreeNode treeNode = new TreeNode(TreeNode.EXPRESSION);
        treeNode.setTokenType(Token.LogicOrAndExpression);
//        for (int i = 0;i < spaceNum; i++)
//            System.out.print("     ");
        TreeNode leftChild = logicEqualExpression();
        treeNode.setChildNode(leftChild);
//        //指针赋值中的取地址符号
//        if (checkNextTokenType(Token.GetAddress))
//        {
//            spaceNum = curSpace;
//            for (int i = 0;i < spaceNum; i++)
//                System.out.print("     ");
//            System.out.println("|——— &");
//            skipNextToken(Token.GetAddress);
//            for (int i = 0;i < spaceNum; i++)
//                System.out.print("     ");
//            treeNode.setMiddleNode(variableName());
//        }
        if (checkNextTokenType(Token.OROR, Token.ANDAND))
        {
            treeNode.setChildNode(logicOperator());
            spaceNum = curSpace;
//            for (int i = 0;i < spaceNum; i++)
//                System.out.print("     ");
//            iterator.previous();
//            System.out.println("|——— " + logicOperator().getValue());
//            for (int i = 0;i < spaceNum; i++)
//                System.out.print("     ");
            treeNode.setChildNode(logicEqualExpression());
        }else
        {
            return leftChild;
        }
        return treeNode;
    }

    private static TreeNode logicEqualExpression() throws Exception
    {
        spaceNum++;
//        System.out.println("|———Logical Expression:");
        TreeNode treeNode = new TreeNode(TreeNode.LogicEqualExpression);
        treeNode.setTokenType(Token.LogicEqualExpression);
//        for (int i = 0;i < spaceNum; i++)
//            System.out.print("     ");
        TreeNode leftChild = logicNotEqualExpression();
        if (checkNextTokenType(Token.EQEQ))
        {
            treeNode.setChildNode(leftChild);
            treeNode.setChildNode(logicOperator());
//            for (int i = 0;i < spaceNum; i++)
//                System.out.print("     ");
            treeNode.setChildNode(logicNotEqualExpression());
        }else
        {
            return leftChild;
        }
        return treeNode;
    }

    private static TreeNode logicNotEqualExpression() throws Exception
    {
        int curSpace = spaceNum;
        TreeNode treeNode = new TreeNode(TreeNode.LogicNotEqualExpression);
        treeNode.setTokenType(Token.LogicNotEqualExpression);
        TreeNode leftChild = addibleExpression();
        if (checkNextTokenType(Token.NE, Token.LT, Token.GT))
        {
            treeNode.setChildNode(leftChild);
            treeNode.setChildNode(logicOperator());
            spaceNum = curSpace;
//            for (int i = 0;i < spaceNum; i++)
//                System.out.print("     ");
//            iterator.previous();
//            System.out.println("|——— "+ logicOperator().getValue());
//            for (int i = 0;i < spaceNum; i++)
//                System.out.print("     ");
            treeNode.setChildNode(addibleExpression());
        }else
        {
            return leftChild;
        }
        return treeNode;
    }

    private static TreeNode addibleExpression() throws Exception
    {
        spaceNum++;
        //这里的curSpaceNum用于使加号与Arithmetic Expression在同一级
        int curSpaceNum = spaceNum - 1;
//        System.out.println("|———Arithmetic Expression:");
        TreeNode treeNode = new TreeNode(TreeNode.AddibleExpression);
        treeNode.setTokenType(Token.AddibleExpression);
//        for (int i = 0;i < spaceNum; i++)
//            System.out.print("     ");
        TreeNode leftChild = term();
        if (checkNextTokenType(Token.ADD))
        {
            spaceNum = curSpaceNum;
            TreeNode addNode = new TreeNode(TreeNode.ADD);
            treeNode.setChildNode(addNode);
//            for (int i = 0;i < spaceNum; i++)
//                System.out.print("     ");
//            System.out.println("|——— +");
            treeNode.setChildNode(leftChild);
            treeNode.setChildNode(addibleOperator());
//            for (int i = 0;i < spaceNum; i++)
//                System.out.print("     ");
            treeNode.setChildNode(addibleExpression());
        }else if (checkNextTokenType(Token.SUB))    //?????
        {
            spaceNum = curSpaceNum;
            TreeNode subNode = new TreeNode(TreeNode.SUB);
            treeNode.setChildNode(subNode);
//            for (int i = 0;i < spaceNum; i++)
//                System.out.print("     ");
//            System.out.println("|——— -");
            treeNode.setChildNode(leftChild);
            TreeNode subOperatorNode = new TreeNode(TreeNode.OPERATOR);
            subOperatorNode.setTokenType(Token.ADD);
            treeNode.setChildNode(subOperatorNode);
//            for (int i = 0;i < spaceNum; i++)
//                System.out.print("     ");
            treeNode.setChildNode(addibleExpression());
        }else{
            return leftChild;
        }
        return treeNode;
    }

    private static TreeNode term() throws Exception
    {
        spaceNum++;
//        System.out.println("|———Term:");
        TreeNode treeNode = new TreeNode(TreeNode.TERM);
        treeNode.setTokenType(Token.TermExpression);
//        for (int i = 0;i < spaceNum; i++)
//            System.out.print("     ");
        TreeNode leftChild = notExpression();
        if (checkNextTokenType(Token.MUL, Token.DIV))
        {
//            for (int i = 0;i < spaceNum; i++)
//                System.out.print("     ");
            if (checkNextTokenType(Token.MUL))
            {
                TreeNode mulNode = new TreeNode(TreeNode.MUL);
                treeNode.setChildNode(mulNode);
//                System.out.println("|——— *");
                treeNode.setChildNode(leftChild);
                treeNode.setChildNode(multiplyOperator());
            }
            else if (checkNextTokenType(Token.DIV))
            {
                TreeNode divNode = new TreeNode(TreeNode.DIV);
                treeNode.setChildNode(divNode);
//                System.out.println("|——— /");
                treeNode.setChildNode(leftChild);
                treeNode.setChildNode(multiplyOperator());
            }
//            for (int i = 0;i < spaceNum; i++)
//                System.out.print("     ");
            treeNode.setChildNode(term());
        }else
        {
            return leftChild;
        }
        return treeNode;
    }

    private static TreeNode notExpression() throws Exception
    {
        TreeNode treeNode = new TreeNode(TreeNode.NotExpression);
        treeNode.setTokenType(Token.NotExpression);
        if (checkNextTokenType(Token.BANG))
        {
            treeNode.setChildNode(notOperator());
//            iterator.previous();
//            System.out.println("|——— "+ notOperator().getValue());
//            for (int i = 0;i < spaceNum;i++)
//                System.out.print("     ");
            treeNode.setChildNode(factor());
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
                    treeNode.setChildNode(literal());
                    break;
                case Token.LPAREN:
                    skipNextToken(Token.LPAREN);
                    treeNode = parseExpression();
                    skipNextToken(Token.RPAREN);
                    break;
                case Token.ADD:
                    currentToken = iterator.next();
                    treeNode.setChildNode(term());
                    break;
                case Token.SUB:
                    treeNode.setTokenType(Token.SUB);
                    currentToken = iterator.next();
                    treeNode.setChildNode(term());
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
//            System.out.println("|———Literal:"+ currentToken.getValue());
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
            int tokenType = currentToken.getType();
            if (tokenType == Token.ANDAND || tokenType == Token.OROR
                    || tokenType == Token.EQEQ || tokenType == Token.LT
                    || tokenType == Token.NE || tokenType == Token.GT)
            {
                TreeNode treeNode = new TreeNode(TreeNode.OPERATOR);
                treeNode.setTokenType(tokenType);
                if (tokenType == Token.ANDAND)
                    treeNode.setValue("&&");
                else if (tokenType == Token.OROR)
                    treeNode.setValue("||");
                else if (tokenType == Token.EQEQ)
                    treeNode.setValue("==");
                else if (tokenType == Token.LT)
                    treeNode.setValue("<");
                else if (tokenType == Token.NE)
                    treeNode.setValue("<>");
                else if (tokenType == Token.GT)
                    treeNode.setValue(">");
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
                treeNode.setValue("!");
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
//            System.out.println("|———Variable:" + currentToken.getValue());
            treeNode.setValue(currentToken.getValue());
        }else
            throw new Exception("line " + getNextTokenLineNo() + " : next token should be ID." );
        if (getNextTokenType() == Token.LBRACK)
        {
            skipNextToken(Token.LBRACK);
            treeNode.setChildNode(parseExpression());
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
