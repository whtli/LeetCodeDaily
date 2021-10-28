package interview.src.it094;

import java.util.List;

/**
 * @Description 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历
 * @Author liq
 * @Date 2021/10/28
 */
public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        Solution2 solution = new Solution2();
        List list = solution.inorderTraversal(treeNode);
        System.out.println(list);
    }
}
