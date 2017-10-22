import com.cmm.ANTLR.CMinusMinusLexer;
import com.cmm.ANTLR.CMinusMinusParser;
import com.cmm.lexer.Token;
import com.cmm.lexer.Util;
import com.cmm.parser.TreeNode;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ANTLRInputStream;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {

    public static void ANTLRrun(InputStream expr) throws Exception{

        //对每一个输入的字符串，构造一个 ANTLRStringStream 流 in
        ANTLRInputStream in = new ANTLRInputStream(expr);

        //用 in 构造词法分析器 lexer，词法分析的作用是产生记号
        CMinusMinusLexer lexer = new CMinusMinusLexer(in);

        //用词法分析器 lexer 构造一个记号流 tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //再使用 tokens 构造语法分析器 parser,至此已经完成词法分析和语法分析的准备工作
        CMinusMinusParser parser = new CMinusMinusParser(tokens);

        //最终调用语法分析器的规则 prog，完成对表达式的验证
        parser.prog();
    }

    public static void main(String[] args) throws Exception{

//        String[] testStr={
//                "2",
//                "a+b+3",
//                "(a-b)+3",
//                "a+(b*3"
//        };

        File directory = new File("");//设定为当前文件夹
        try{
            System.out.println(directory.getCanonicalPath());//获取标准的路径
            System.out.println(directory.getAbsolutePath());//获取绝对路径
        }catch(Exception e){

        }

        String inputFile = ".\\src\\main\\resources\\test.txt";
        InputStream inputStream = System.in;

        if ( inputFile != null )
            inputStream = new FileInputStream(inputFile);

        //ANTLRrun(inputStream);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose way of input ( 1: Keyboard input 2: File )");
        String string = scanner.nextLine();
        System.out.print(string);
        char[] chars = string.toCharArray();
        char c = chars[0];
        LinkedList<TreeNode> treeNodes = new LinkedList<TreeNode>();

        switch (c){
            case '1':
                String str = "";
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Please enter your expression.");
                str = bufferedReader.readLine();
                byte[] by = str.getBytes();
                InputStream is = new ByteArrayInputStream(by);
                InputStreamReader isr = new InputStreamReader(is);
                bufferedReader = new BufferedReader(isr);
                treeNodes = Util.getTokenListFromKeyboardInput(bufferedReader);
                break;
            case '2':
                System.out.println(" ");
                treeNodes = Util.getTokenListFromFile(inputFile);
                break;
        }
//        for(TreeNode treeNode : treeNodes) {
//            System.out.println(treeNode.toStringWithLine());
//        }



//        for (String s:testStr){
//            System.out.println("Input expr:"+s);
//            run(s);
//        }
    }
}