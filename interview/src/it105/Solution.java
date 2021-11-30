package interview.src.it105;

import java.util.Arrays;

/**
 * @Description 105. 从前序与中序遍历序列构造二叉树
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder 。请构造二叉树并返回其根节点。
 * preorder 和 inorder 均无重复元素
 * @Author liq
 * @Date 2021/11/30
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (null == preorder || preorder.length == 0) {
            return null;
        }
        int length = preorder.length;
        // 从前序遍历数组中获取每一轮的根节点
        TreeNode tree = new TreeNode(preorder[0]);

        // 从中序遍历数组中找到根的位置，以便接下来获取其左右子树
        int index = 0;
        while (index < length) {
            if (inorder[index] == tree.val) {
                break;
            }
            index++;
        }

        // 以下开始分别构建当前节点的左右子树

        // 构建左子树
        if (index > 0) {
            // 左子树不为空
            int[] leftPre = Arrays.copyOfRange(preorder, 1, index + 1);
            int[] leftIn = Arrays.copyOfRange(inorder, 0, index);
            // 递归构建左子树
            tree.left = buildTree(leftPre, leftIn);
        } else {
            // 左子树为空
            tree.left = null;
        }

        // 构建右子树
        int rlen = length - index - 1;
        if (rlen > 0) {
            // 右子树不为空
            int[] rightPre = Arrays.copyOfRange(preorder, index + 1, index + 1 + rlen);
            int[] righIn = Arrays.copyOfRange(inorder, index + 1, index + 1 + rlen);
            // 递归构建左子树
            tree.right = buildTree(rightPre, righIn);
        } else {
            // 右子树为空
            tree.right = null;
        }

        return tree;
    }
}
