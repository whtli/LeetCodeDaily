package interview.src.it105;

/**
 * @Description 105. 从前序与中序遍历序列构造二叉树
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 * preorder 和 inorder 均无重复元素
 * @Author liq
 * @Date 2021/11/30
 */
public class Main {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        Solution solution = new Solution();
        TreeNode treeNode = solution.buildTree(preorder, inorder);

    }
}
