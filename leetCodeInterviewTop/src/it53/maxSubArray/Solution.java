package it53.maxSubArray;

/**
 * @author : flower48237
 * @2020/5/24 18:02
 * @title : LeetCode精选TOP面试题53.最大子序和
 */
public class Solution {
    public int maxSubArray(int[] nums){
        int temp = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            temp = Math.max(nums[i], temp + nums[i]);
            max = Math.max(temp, max);
        }
        return max;
    }
}
