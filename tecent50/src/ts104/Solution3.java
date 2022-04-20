package tecent50.src.ts104;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @Author liq
 * @Date 2022/04/20
 */
public class Solution3 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode tmp = queue.poll();
                size --;
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            maxDepth ++;
        }
        return maxDepth;
    }
}
