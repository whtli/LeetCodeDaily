package algorithmPrimer14.src.day8.t116;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liq
 * @date 2021/7/25 20:58
 * @list 20天算法刷题计划
 * @name
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        // 层次遍历，全部压入队列中
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
/*         int count = 0;
        while (!queue.isEmpty()) {
            count++;
            Node node = queue.poll();
            // System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        queue.clear();

        Node[] nodes = new Node[count];
        nodes[0] = root;
        int index = 0;
        int step = 0;
        while (index < count - 1) {
            Node node = nodes[step++];
            if (nodes[index] != null) {
                if (index < count - 1 && node.left != null) {
                    nodes[++index] = node.left;
                }
                if (index < count - 1 && node.right != null) {
                    nodes[++index] = node.right;
                }
            }
        }

        int level = 1;
        int sss = (int) (Math.log(count + 1) / Math.log(2));
        while (level <= sss) {
            for (int j = (int) Math.pow(2, level - 1) - 1; j < (int) Math.pow(2, level) - 1; j++) {
                if (j != 0 && j + 1 < (int) Math.pow(2, level) - 1) {
                    nodes[j].next = nodes[j + 1];
                }
            }
            nodes[(int) Math.pow(2, level) - 2].next = null;
            level++;
        }*/

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

        }
        queue.clear();

        return root;
    }
}
