package interview.src.it102;


import java.util.List;

/**
 * @Description
 * @Author liq
 * @Date 2021/11/28
 */
public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrder(treeNode);

        System.out.println(lists);
    }
}
