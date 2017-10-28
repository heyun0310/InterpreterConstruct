package com.cmm.parser;

import com.cmm.parser.Parser;

public class TraverseTree {

    private static int heightInTree = 0;

    public void visitTree(TreeNode rootNode, int level)
    {
        rootNode.printNode(rootNode.getNodeType());
        if (!rootNode.childrenList.isEmpty())
        {
            int i = 0;
            ++level;
            for (; i < rootNode.childrenList.size(); i++)
            {
                TreeNode treeNode = rootNode.childrenList.get(i);
               for (int j = 0; j< level; j++) {
                   System.out.print("    ");
               }
                visitTree(treeNode, level);
            }
        }
    }
}
