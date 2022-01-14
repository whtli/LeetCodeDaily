package interview.src.it230;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k
 * 设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @Author liq
 * @Date 2021/11/29
 */
public class Solution3 {
    public int kthSmallest(TreeNode root, int k) {
        MyBst myBst = new MyBst(root);
        return myBst.kthSmallest(k);
    }
}

class MyBst {
    TreeNode root;
    Map<TreeNode, Integer> nodeNumber;

    public MyBst(TreeNode root) {
        this.root = root;
        this.nodeNumber = new HashMap<TreeNode, Integer>();
        countNumber(root);
    }

    /**
     * 统计以node为根结点的子树的结点数
     * @param node
     * @return
     */
    private int countNumber(TreeNode node) {
        if (node == null) {
            return 0;
        }
        nodeNumber.put(node, countNumber(node.left) + countNumber(node.right) + 1);
        return nodeNumber.get(node);
    }

    /**
     * 返回二叉搜索树中第k小的元素
     * @param k
     * @return
     */
    public int kthSmallest(int k) {
        TreeNode node = root;
        while (node != null) {
            int left = getNumber(node.left);
            if (left == k - 1) {
                break;
            } else if (left > k - 1) {
                node = node.left;
            } else {
                node = node.right;
                k = k - left - 1;
            }
        }
        return node.val;
    }

    private int getNumber(TreeNode node) {
        return nodeNumber.getOrDefault(node, 0);
    }
}
