package it283.moveZeros;

/**
 * @author : flower48237
 * @2020/3/8 21:35
 * @title : LeetCode精选TOP面试题283. 移动零
 */
public class Solution {
    public void moveZeros(int[] nums){
        /*int len = nums.length;
        if (len == 0){
            return;
        }
        int i, j = 0;
        for (i = 0; i < len; i++){
            if (nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        print(nums, len);*/

        int len = nums.length;
        if (len == 0){
            return;
        }
        int count = 0;
        for (int i = 0; i < len; i++){
            if (nums[i] != 0){
                nums[count++] = nums[i];
            }
        }
        for (int i = count; i < len; i++){
            nums[i] = 0;
        }

        print(nums, len);
    }

    public void print(int []nums, int len){
        System.out.print("[");
        for (int i = 0; i < len - 1; i ++){
            System.out.print(nums[i] + ",");
        }
        System.out.print(nums[len - 1] + "]");
    }
}
