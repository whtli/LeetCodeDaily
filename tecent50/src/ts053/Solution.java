package tecent50.src.ts053;

/**
 * @Description 53.最大子数组和
 * 给定一个整数数组 nums ，请找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * @Author liq
 * @Date 2022/05/13
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + pre > nums[i]) {
                nums[i] = nums[i] + pre;
            }
            pre = nums[i];
            if (max < nums[i]) {
                max = nums[i];
            }
        }
//        for (int i = 0; i < nums.length; i++){
//            System.out.print(nums[i]+ " ");
//        }
//        System.out.println();
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i] + pre, nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }
}
