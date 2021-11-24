package algorithmPrimer14.src.day8.t617;

/**
 * @author liq
 * @date 2021/7/25 19:13
 * @list 20天算法刷题计划
 * @name 617. 合并二叉树
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        Solution solution = new Solution();
        solution.mergeTrees(root1, root2);
    }
}
