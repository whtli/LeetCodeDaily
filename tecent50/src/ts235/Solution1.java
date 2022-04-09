package tecent50.src.ts235;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description LeetCode腾讯精选练习50题-235.二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先的定义为：
 * 对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
 * @Author liq
 * @Date 2022/04/08
 */
public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathLeft = findPath(root, p);
        List<TreeNode> pathRight = findPath(root, q);
        /*int len = Math.max(pathLeft.size(), pathRight.size());

        for (int i = 0; i < len; i++) {
            if (i == pathLeft.size()) {
                return pathLeft.get(i - 1);
            }
            if (i == pathRight.size()) {
                return pathRight.get(i - 1);
            }
            if (pathLeft.get(i).val != pathRight.get(i).val) {
                return pathLeft.get(i - 1);
            }
        }
        return root;*/
        TreeNode res = root;
        for (int i = 0; i < pathLeft.size() && i < pathRight.size(); i++) {
            if (pathLeft.get(i).val == pathRight.get(i).val) {
                res = pathLeft.get(i);
            } else {
                break;
            }
        }
        return res;
    }

    // 记录从根节点到某一个指定节点的路径
    private List<TreeNode> findPath(TreeNode root, TreeNode node) {
        List<TreeNode> path = new ArrayList<>();
        while (node != root) {
            path.add(root);
            if (node.val < root.val) {
                root = root.left;
            } else if (node.val > root.val) {
                root = root.right;
            }
        }
        path.add(root);
        return path;
    }
}
