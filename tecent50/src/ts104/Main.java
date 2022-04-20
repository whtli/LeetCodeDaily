package tecent50.src.ts104;

/**
 * @Description
 * @Author liq
 * @Date 2022/04/20
 */
public class Main {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        Solution1 solution = new Solution1();
        int depth = solution.maxDepth(root);
        System.out.println("depth1 : " + depth);

        Solution2 solution2 = new Solution2();
        int depth2 = solution2.maxDepth(root);
        System.out.println("depth2 : " + depth2);
        Solution3 solution3 = new Solution3();
        int depth3 = solution3.maxDepth(root);
        System.out.println("depth3 : " + depth3);
    }
}
