package it108.transfer;

import java.util.*;

public class Solution {
    int[] nums;

    public TreeNode Transfer(int left, int right) {
        if (left > right){
            // 退出递归的边界条件
            return null;
        }
        // 思路 1 ：始终选择中间位置左边元素作为根节点
        int midloc = (left + right) / 2;

        // 思路 2 ：始终选择中间位置右边元素作为根节点
        /*int midloc = (left + right) / 2;
        if ((left + right) % 2 == 1) {
            midloc ++;
        }*/

        // 思路 3 ：选择任意一个中间位置元素作为根节点
        /*int midloc = (left + right) / 2;
        Random rand = new Random();
        if ((left + right) % 2 == 1){
            midloc += rand.nextInt(2);
        }*/

        // 递归建树
        TreeNode root = new TreeNode(nums[midloc]);
        root.left = Transfer(left, midloc - 1);   // 左递归
        root.right = Transfer(midloc + 1, right);  // 右递归
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

        //存放遍历结果，然后返回
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            /*
            处理 TreeNode 节点 的逻辑
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
