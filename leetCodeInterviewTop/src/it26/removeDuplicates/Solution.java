package it26.removeDuplicates;

/**
 * @author : flower48237
 * @2020/5/25 19:41
 * @title : LeetCode精选TOP面试题26.删除排序数组中的重复项
 */
public class Solution {
    public int removeDuplicates(int[] nums){
        int reslen = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i-1]){
                nums[reslen ++] = nums[i];
            }
        }
        return reslen;
    }
}
