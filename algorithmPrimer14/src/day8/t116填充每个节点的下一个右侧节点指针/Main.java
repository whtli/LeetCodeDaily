package algorithmPrimer14.src.day8.t116填充每个节点的下一个右侧节点指针;

/**
 * @author liq
 * @date 2021/7/25 20:58
 * @list 20天算法刷题计划
 * @name
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        //System.out.println(root.val);
        solution.connect(root);
    }
}
