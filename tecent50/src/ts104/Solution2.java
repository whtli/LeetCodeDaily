package tecent50.src.ts104;

import java.util.Stack;

/**
 * @Description 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @Author liq
 * @Date 2022/04/20
 */
public class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int curDepth = 0;
        int maxDepth = 0;
        Stack<Integer> allDepth = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            curDepth++;
            while (node != null) {
                //System.out.println(node.val);
                stack.push(node);
                allDepth.push(curDepth);
                curDepth++;
                node = node.left;
            }
            if (!stack.empty()) {
                TreeNode tmp = stack.pop();
                curDepth = allDepth.pop();
                if (curDepth > maxDepth) {
                    maxDepth = curDepth;
                }
                node = tmp.right;
            }
        }
        return maxDepth;
    }
}
