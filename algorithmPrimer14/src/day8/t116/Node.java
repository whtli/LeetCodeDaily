package algorithmPrimer14.src.day8.t116;

/**
 * @author liq
 * @date 2021/7/25 20:58
 * @list 20天算法刷题计划
 * @name
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
