package interview.src.it103;

import java.util.List;

/**
 * @Description 103. 二叉树的锯齿形层序遍历
 * 给定二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * 即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行。
 * @Author liq
 * @Date 2022/02/19
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = solution.zigzagLevelOrder(root);
    }
}
