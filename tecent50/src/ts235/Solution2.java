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
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;
        while (true) {
            if (res.val > p.val && res.val > q.val){
                res = res.left;
            }
            else if (res.val < p.val && res.val < q.val){
                res = res.right;
            } else {
                break;
            }
        }
        return res;
    }
}
