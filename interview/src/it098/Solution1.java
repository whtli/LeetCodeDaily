package interview.src.it098;

import java.util.ArrayList;
import java.util.List;

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
public class Solution1 {
    public List<Integer> tree = new ArrayList<Integer>();

    public boolean isValidBST(TreeNode root) {
        // 中序遍历，DFS
        dfs(root);

        for (int i = 0; i < tree.size() - 1; i++) {
            if (tree.get(i) >= tree.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        tree.add(root.val);
        dfs(root.right);
    }
}
