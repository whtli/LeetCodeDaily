package interview.src.it053.maxSubArray;

/**
 * @author : flower48237
 * @2020/5/24 18:02
 * @title : LeetCode��ѡTOP������53.��������
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
