package interview.src.it104;

/**
 * @author : flower48237
 * @2020/3/4 19:14
 * @title : LeetCode��ѡTOP������104.��������������
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        int res = solution.maxDepth(root);
        System.out.println(res);

        Solution2 solution2 = new Solution2();
        int res2 = solution2.maxDepth(root);
        System.out.println(res2);
    }
}
