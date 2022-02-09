package interview.src.it238;

/**
 * @Description 238. 除自身以外数组的乘积
 * 给定一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 不能使用除法，且在 O(n) 时间复杂度内完成此题。
 * @Author liq
 * @Date 2022/02/07
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 1;
        result[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            sum *= nums[i];
            result[i + 1] = sum;
        }
        // result[nums.length - 1] = 1;
        sum = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            sum *= nums[i];
            result[i - 1] *= sum;
        }

        return result;
    }
}
