package it169.majorityElement;

import java.util.Arrays;

/**
 * @author : flower48237
 * @2020/3/3 21:56
 * @title : LeetCode��ѡTOP������169.����Ԫ��
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length/2];
    }
}
