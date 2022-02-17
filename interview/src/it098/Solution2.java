package interview.src.it098;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 98. 验证二叉搜索树
 * 给定一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @Author liq
 * @Date 2022/02/17
 */
public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> tree = new ArrayList<Integer>();
        // 用栈模拟DFS中序遍历
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode tmp = stack.pop();
            // System.out.println(tmp.val);
            if (!tree.isEmpty() && (tmp.val <= tree.get(tree.size() - 1))) {
                return false;
            }
            tree.add(tmp.val);
            root = tmp.right;
        }
        return true;
    }
}
