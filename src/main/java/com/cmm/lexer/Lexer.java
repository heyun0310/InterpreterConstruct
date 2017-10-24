package com.cmm.lexer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/10/3 0003.
 */
public class Lexer {

    private static BufferedReader bufferedReader;
    private static int currentPos;
    private static char currentChar;
    private static int lineNo;

    public static LinkedList<Token> lexicalAnalyse(BufferedReader br) throws IOException{

        lineNo = 1;
        bufferedReader = br;
        LinkedList<Token> tokenLinkedList = new LinkedList<Token>();
        StringBuilder stringBuilder = new StringBuilder();
        readChar();

        while (currentPos != -1){
            //当尚未到达文件尾
            if (currentChar == '\n'|| currentChar == '\r' || currentChar == '\t'
                                    || currentChar == '\f' || currentChar == ' '){
                readChar();
                continue;
            }
            switch (currentChar){
                // 读入一个字符即可判断的符号
                case '(':
                    tokenLinkedList.add(new Token(Token.LPAREN, lineNo));
                    readChar();
                    continue;

                case ')':
                    tokenLinkedList.add(new Token(Token.RPAREN, lineNo));
                    readChar();
                    continue;
                case '[':
                    tokenLinkedList.add(new Token(Token.LBRACK, lineNo));
                    readChar();
                    continue;
                case ']':
                    tokenLinkedList.add(new Token(Token.RBRACK, lineNo));
                    readChar();
                    continue;
                case '{':
                    tokenLinkedList.add(new Token(Token.LBRACE, lineNo));
                    readChar();
                    continue;
                case '}':
                    tokenLinkedList.add(new Token(Token.RBRACE, lineNo));
                    readChar();
                    continue;

                case ',':
                    tokenLinkedList.add(new Token(Token.COMMA, lineNo));
                    readChar();
                    continue;
                case ';':
                    tokenLinkedList.add(new Token(Token.SEMICOLON, lineNo));
                    readChar();
                    continue;

                case '+':
                    tokenLinkedList.add(new Token(Token.ADD, lineNo));
                    readChar();
                    continue;
                case '-':
                    tokenLinkedList.add(new Token(Token.SUB, lineNo));
                    readChar();
                    continue;
                case '*':
                    tokenLinkedList.add(new Token(Token.MUL, lineNo));
                    readChar();
                    continue;

                case '!':
                    tokenLinkedList.add(new Token(Token.BANG, lineNo));
                    readChar();
                    continue;

                case '>':
                    tokenLinkedList.add(new Token(Token.GT, lineNo));
                    readChar();
                    continue;
            }

            if (currentChar == '/'){
                //判断是多行注释/单行注释/除号
                readChar();
                if (currentChar == '*'){
                    //多行注释
                    readChar();
                    while (true){
                        //循环用于滤过注释内的内容
                        if (currentChar == '*'){
                            readChar();
                            if (currentChar == '/'){
                                //tokenLinkedList.add(new Token(Token.Comment, lineNo));
                                readChar();
                                break;
                            }
                        }else {
                            readChar();
                        }
                    }
                    continue;
                }else if(currentChar == '/'){
                    //单行注释
                    //tokenLinkedList.add(new Token(Token.LineComment, lineNo));
                    while (currentChar != '\n'){
                        readChar();
                    }
                    continue;
                }else {
                    //除号
                    tokenLinkedList.add(new Token(Token.DIV, lineNo));
                    continue;
                }
            }else if (currentChar == '='){
                //判断赋值号/等号
                readChar();
                if (currentChar == '='){
                    //等号
                    tokenLinkedList.add(new Token(Token.EQEQ, lineNo));
                    readChar();
                }else {
                    //赋值号
                    tokenLinkedList.add(new Token(Token.EQ, lineNo));
                }
                continue;
            }else if (currentChar == '<'){
                readChar();
                if (currentChar == '>'){
                    tokenLinkedList.add(new Token(Token.NE, lineNo));
                    readChar();
                }else {
                    tokenLinkedList.add(new Token(Token.LT, lineNo));
                }
                continue;
            }else if (currentChar == '|'){
                readChar();
                if (currentChar == '|'){
                    tokenLinkedList.add(new Token(Token.OROR, lineNo));
                }
                continue;
            }else if (currentChar == '&'){
                readChar();
                if (currentChar == '&'){
                    tokenLinkedList.add(new Token(Token.ANDAND, lineNo));
                }
                continue;
            }

            //识别数字
            if (currentChar >= '0' && currentChar <= '9'){
                boolean isReal = false;
                while ((currentChar >= '0' && currentChar <= '9') || currentChar == '.'){
                    if (currentChar == '.'){
                        if (isReal){
                            break;
                        }else {
                            isReal = true;
                        }
                    }
                    stringBuilder.append(currentChar);
                    readChar();
                }
                if (isReal){
                    tokenLinkedList.add(new Token(Token.RealNumber, stringBuilder.toString(), lineNo));
                }else {
                    tokenLinkedList.add(new Token(Token.Integer, stringBuilder.toString(), lineNo));
                }
                stringBuilder.delete(0, stringBuilder.length());
                continue;
            }

            //识别字符组成的标识符，关键字和ID（由数字、字母和下划线组成的串，
            // 但必须以字母开头、且不能以下划线结尾的串）
            if ((currentChar >= 'a' && currentChar <= 'z')
                    || (currentChar >= 'A' && currentChar <= 'Z')){
                while ((currentChar >= 'a' && currentChar <='z')
                        ||(currentChar >= 'A' && currentChar <= 'Z')
                        ||(currentChar >= '0' &&currentChar <= '9')
                        || currentChar == '_'){
                    stringBuilder.append(currentChar);
                    readChar();
                }
                //如果最后一个字符是‘_’，清空stringBuilder
                if (stringBuilder.charAt(stringBuilder.length()-1) == '_'){
                    stringBuilder.delete(0,stringBuilder.length());
                }

                Token token = new Token(lineNo);
                String stringBuilderString = stringBuilder.toString();

                if (stringBuilderString.equals("if")){
                    token.setType(Token.IF);
                }else if (stringBuilderString.equals("else")){
                    token.setType(Token.ELSE);
                }else if (stringBuilderString.equals("while")){
                    token.setType(Token.WHILE);
                }else if (stringBuilderString.equals("break")){
                    token.setType(Token.BREAK);
                }else if (stringBuilderString.equals("read")){
                    token.setType(Token.READ);
                }else if (stringBuilderString.equals("int")){
                    token.setType(Token.INT);
                }else if (stringBuilderString.equals("real")){
                    token.setType(Token.REAL);
                }else if (stringBuilderString.equals("write")){
                    token.setType(Token.WRITE);
                }else if (stringBuilderString.equals("return")){
                    token.setType(Token.RETURN);
                } else {
                    token.setType(Token.ID);
                    token.setValue(stringBuilderString);
                }
                stringBuilder.delete(0,stringBuilder.length());
                tokenLinkedList.add(token);
                continue;
            }
            readChar();
        }
        return tokenLinkedList;
    }

    private static void readChar() throws IOException{

        //从输入流中读取数据的下一个字节，返回0到255范围内的int字节值。
        // 如果因为已经到达流末尾而没有可用的字节，则返回-1
        currentPos = bufferedReader.read();
        currentChar = (char)currentPos;

        if (currentChar == '\n'){
            lineNo++;
        }
    }

}
