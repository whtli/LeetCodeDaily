package it108.transfer;

import java.util.List;

/**
 * @author : flower48237
 * @2020/3/4 19:14
 * @title : LeetCode精选TOP面试题108.将有序数组转换为二叉搜索树
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] nums = {-10,-3,0,5,9};
        TreeNode root = solution.sortedArrayToBST(nums);
        List<Integer> list = solution.BFSByQueue(root);
        System.out.print(list);
    }

}
