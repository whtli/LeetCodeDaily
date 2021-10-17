package it136.singleNumber;

import java.util.Arrays;

/**
 * @author : flower48237
 * @2020/2/18 22:47
 * @title : LeetCode精选TOP面试题136.只出现一次的数字
 */
public class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1){
            return  nums[0];
        }
        Arrays.sort(nums);

        int result = -1;
        for (int i = 1; i < nums.length - 1; i ++){

            if (nums[i] != nums[i-1] && nums[i] != nums[i+1]){
                result =  nums[i];
                break;
            }

        }
        if(nums[0] != nums[1]){
            result = nums[0];
        }
        if(nums[nums.length - 1] != nums[nums.length - 2]){
            result = nums[nums.length - 1];
        }
        return  result;
    }
}
