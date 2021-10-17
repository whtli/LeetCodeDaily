package it104.maxDepth;

import java.util.Stack;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        // «∞–Ú±È¿˙ - ΩË÷˙’ª
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> remDeep = new Stack<Integer>();

        TreeNode tmp = root;
        int maxDepth = 0,curDepth = 0;

        // stack.add(tmp);
        // curDepth ++;
        // remDeep.add(curDepth);
        curDepth ++ ;
        while (!stack.isEmpty() || tmp != null){
            while (tmp != null){
                stack.add(tmp);
                remDeep.add(curDepth);
                tmp = tmp.left;
                curDepth ++;
            }
            tmp = stack.pop();
            curDepth = remDeep.pop();
            if (tmp.right == null && tmp.left == null){
                if (curDepth > maxDepth){
                    maxDepth = curDepth;
                }
            }
            tmp = tmp.right;
            curDepth ++;
        }
        return maxDepth;
    }
}
