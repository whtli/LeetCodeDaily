package interview.src.it104;

/**
 * @Description
 * @Author liq
 * @Date
 */
public class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        else {
            int ldepth = maxDepth(root.left);
            int rdepth = maxDepth(root.right);
            return ldepth > rdepth ? ldepth + 1 : rdepth + 1;
        }
    }
}
