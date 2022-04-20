package tecent50.src.ts104;

/**
 * @Description 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * @Author liq
 * @Date 2022/04/20
 */
public class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return loop(root);
    }

    public int loop(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = 1 + loop(node.left);
        int right = 1 + loop(node.right);
        return Math.max(left, right);
    }
}
