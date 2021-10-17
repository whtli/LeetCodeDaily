package algorithmPrimer14.src.day8.t617合并二叉树;

/**
 * @author liq
 * @date 2021/7/25 19:13
 * @list 20天算法刷题计划
 * @name 617. 合并二叉树
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val = root1.val + root2.val;
        // System.out.println(root1.val);
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
