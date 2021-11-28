package interview.src.it102;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 102. 二叉树的层序遍历
 * 给定一个二叉树，返回按 层序遍历 得到的节点值。
 * 即逐层地，从左到右访问所有节点。相同层的节点值放在一个列表中
 * @Author liq
 * @Date 2021/11/28
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode treeNode = queue.poll();

                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                System.out.print(treeNode.val + ", ");
            }
            lists.add(list);
            System.out.println();
        }

        return lists;
    }
}
