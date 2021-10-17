package algorithmPrimer14.src.day2.t189旋转数组;

import java.util.Arrays;
import java.util.zip.ZipInputStream;

/**
 * @author liq
 * @date 2021/7/18 18:28
 * @list 20天算法刷题计划
 * @name 189.旋转数组
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }

        reserve(nums, 0, nums.length - 1);
        reserve(nums, 0, k - 1);
        reserve(nums, k, nums.length - 1);
    }

    private int[] reserve(int[] nums, int left, int right){
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
        return nums;
    }
}
