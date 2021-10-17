package it268.missingNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : flower48237
 * @2020/3/18 21:41
 * @title : LeetCode精选TOP面试题268.缺失数字
 */
public class Solution {
    public int missingNumber(int[] nums) {
        /* 法 1
        int sum = 0;
        int stdsum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            stdsum += i + 1;
        }
        return stdsum - sum;*/

        /* 法 2
        Arrays.sort(nums);

        // 判断 n 是否出现在末位
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // 判断 0 是否出现在首位
        else if (nums[0] != 0) {
            return 0;
        }

        // 此时缺失的数字一定在 (0, n) 中
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1] + 1) {
                return nums[i-1] + 1;
            }
        }
        // 未缺失任何数字（保证函数有返回值）
        return -1;*/

        // 法 3
        Set<Integer> set = new HashSet<Integer>();
        for (int n : nums){
            set.add(n);
        }
        for (int i = 0; i <= nums.length; i++){
            if (!set.contains(i)){
                return i;
            }
        }
        return -1;
    }

}
