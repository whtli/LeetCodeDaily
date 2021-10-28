package interview.src.it094;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历
 * @Author liq
 * @Date 2021/10/28
 */
public class Solution1 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        middleReader(root, list);
        return list;
    }

    private void middleReader(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        middleReader(root.left, list);
        list.add(root.val);
        middleReader(root.right, list);
    }
}
