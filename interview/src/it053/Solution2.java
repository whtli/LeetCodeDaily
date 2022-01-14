package interview.src.it053;

/**
 * @author : flower48237
 * @2020/5/24 19:56
 * @title : LeetCode��ѡTOP������53.��������
 */
public class Solution2 {
    public int maxSubArray(int[] nums){
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] > 0){
                nums[i] += nums[i-1];

            }
            max = Math.max(nums[i], max);
        }

        return max;
    }
}
