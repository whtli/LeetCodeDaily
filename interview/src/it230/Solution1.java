package interview.src.it230;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k
 * 设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @Author liq
 * @Date 2021/11/29
 */
public class Solution1 {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        // 中序遍历，DFS
        DFS(root);
        for (int i : list) {
            System.out.print(i + " ");
        }
        return list.get(k - 1);
    }

    private void DFS(TreeNode root) {
        if (root == null) {
            return;
        }
        DFS(root.left);
        list.add(root.val);
        DFS(root.right);
    }
}
