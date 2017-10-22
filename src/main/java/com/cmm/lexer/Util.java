package com.cmm.lexer;

import com.cmm.parser.Parser;
import com.cmm.parser.TreeNode;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/10/3 0003.
 */
public class Util {

    public static LinkedList<TreeNode> getTokenListFromFile(String fileStr) throws Exception{
        FileReader fileReader;
        fileReader = new FileReader(fileStr);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileStr),"UTF-8"));
        LinkedList<Token> lexerList = Lexer.lexicalAnalyse(bufferedReader);
        LinkedList<TreeNode> parserList = Parser.syntacticAnalyse(lexerList);
        bufferedReader.close();
        fileReader.close();
        return parserList;
    }

    public static LinkedList<TreeNode> getTokenListFromKeyboardInput(BufferedReader br) throws Exception{
        LinkedList<Token> lexerList = Lexer.lexicalAnalyse(br);
        LinkedList<TreeNode> parserList = Parser.syntacticAnalyse(lexerList);
        return parserList;
    }
}
