package interview.src.it102;

/**
 * @Description 102. 二叉树的层序遍历
 * 给定一个二叉树，返回按 层序遍历 得到的节点值。
 * 即逐层地，从左到右访问所有节点。相同层的节点值放在一个列表中
 * @Author liq
 * @Date 2021/11/28
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
