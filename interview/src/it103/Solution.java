package interview.src.it103;

import java.util.*;
import java.util.ArrayList;

/**
 * @Description 103. 二叉树的锯齿形层序遍历
 * 给定二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * 即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行。
 * @Author liq
 * @Date 2022/02/19
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 空树直接返回空列表
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点先入队
        queue.add(root);
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            lists.add(list);
        }
        for (int i = 0; i < lists.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(lists.get(i));
            }
            for (Integer item : lists.get(i)) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        return lists;
    }
}
