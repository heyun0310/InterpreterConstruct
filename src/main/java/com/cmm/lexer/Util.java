package com.cmm.lexer;

import com.cmm.parser.Parser;
import com.cmm.parser.TreeNode;

import java.io.*;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/10/3 0003.
 */
public class Util {

    public static TreeNode getTokenListFromFile(String fileStr) throws Exception{
        FileReader fileReader;
        fileReader = new FileReader(fileStr);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileStr),"UTF-8"));
        LinkedList<Token> lexerList = Lexer.lexicalAnalyse(bufferedReader);
        TreeNode rootNode = Parser.syntacticAnalyse(lexerList);
        bufferedReader.close();
        fileReader.close();
        return rootNode;
    }

    public static TreeNode getTokenListFromKeyboardInput(BufferedReader br) throws Exception{
        LinkedList<Token> lexerList = Lexer.lexicalAnalyse(br);
        TreeNode rootNode = Parser.syntacticAnalyse(lexerList);
        return rootNode;
    }
}
