package interview.src.it104;

import java.util.Stack;
/**
 * @Description
 * @Author liq
 * @Date
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        // ǰ����� - ����ջ
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
