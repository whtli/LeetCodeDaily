package interview.src.it230;

/**
 * @Description 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k
 * 设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @Author liq
 * @Date 2021/11/29
 */
public class Main {
    public static void main(String[] args) {
        /*TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);*/
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(1);

        Solution3 solution = new Solution3();
        int result = solution.kthSmallest(treeNode, 3);
        System.out.println("result : " + result);
    }
}
