package interview.src.it108;

import java.util.*;
/**
 * @Description
 * @Author liq
 * @Date
 */
public class Solution {
    int[] nums;

    public TreeNode Transfer(int left, int right) {
        if (left > right){
            // �˳��ݹ�ı߽�����
            return null;
        }
        // ˼· 1 ��ʼ��ѡ���м�λ�����Ԫ����Ϊ���ڵ�
        int midloc = (left + right) / 2;

        // ˼· 2 ��ʼ��ѡ���м�λ���ұ�Ԫ����Ϊ���ڵ�
        /*int midloc = (left + right) / 2;
        if ((left + right) % 2 == 1) {
            midloc ++;
        }*/

        // ˼· 3 ��ѡ������һ���м�λ��Ԫ����Ϊ���ڵ�
        /*int midloc = (left + right) / 2;
        Random rand = new Random();
        if ((left + right) % 2 == 1){
            midloc += rand.nextInt(2);
        }*/

        // �ݹ齨��
        TreeNode root = new TreeNode(nums[midloc]);
        // ��ݹ�
        root.left = Transfer(left, midloc - 1);
        // �ҵݹ�
        root.right = Transfer(midloc + 1, right);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return Transfer(0, nums.length - 1);
    }


    public List<Integer> BFSByQueue(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //��ű��������Ȼ�󷵻�
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            /*
            ���� TreeNode �ڵ� ���߼�
             */
            result.add(treeNode.val);


            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return result;
    }
}
