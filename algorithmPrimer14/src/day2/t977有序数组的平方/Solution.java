package algorithmPrimer14.src.day2.t977有序数组的平方;

import java.util.Arrays;

/**
 * @author liq
 * @date 2021/7/18 18:28
 * @list 20天算法刷题计划
 * @name
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        /* solution1 使用现有算法排序
        for (int index = 0; index < nums.length; index ++) {
            nums[index] = nums[index] * nums[index];
        }
        Arrays.sort(nums);
        */

        /*solution2 双指针比较放入*/
        int[] result = new int[nums.length];
        int left = 0, rigth = nums.length - 1;
        int index = nums.length - 1;
        while (left <= rigth) {
            int leftPow = nums[left] * nums[left];
            int rigthPow = nums[rigth] * nums[rigth];
            if (leftPow > rigthPow) {
                result[index --] = leftPow;
                left ++;
            } else {
                result[index --] = rigthPow;
                rigth --;
            }
        }

        for (int i = 0; i < result.length; i ++) {
            System.out.println(result[i]);
        }
        return result;
    }
}
