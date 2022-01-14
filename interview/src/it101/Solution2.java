package interview.src.it101;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :
 * @2020/4/4 9:12
 * @title :
 */
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        // �� 2 -- ����
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null){
                continue;
            }
            if (p == null || q == null){
                return false;
            }
            if (p.val != q.val){
                return false;
            }
            queue.add(p.left);
            queue.add(q.right);
            queue.add(p.right);
            queue.add(q.left);

        }
        return true;
    }
}
