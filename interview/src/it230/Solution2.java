package interview.src.it230;

import java.util.*;

/**
 * @Description 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k
 * 设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @Author liq
 * @Date 2021/11/29
 */
public class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        // 用栈模拟实现中序遍历
        Stack<TreeNode> stack = new Stack<>();
        // 需要保证从最小的元素作为第一个入栈元素，所以不能在循环外把根节点压入栈，故循环的边界条件添加了||root!=null条件
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val + " ");
            k--;
            // 第k个弹出栈的节点，其值一定为第k小的
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
