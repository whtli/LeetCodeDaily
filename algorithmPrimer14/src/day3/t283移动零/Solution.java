package algorithmPrimer14.src.day3.t283移动零;

/**
 * @author liq
 * @date 2021/7/19 10:54
 * @list 20天算法刷题计划
 * @name 283.移动零
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int tail = 0;
        int prior = 0;

        while (prior < nums.length) {
            if (nums[prior] != 0) {
                int temp = nums[tail];
                nums[tail ++] = nums[prior];
                nums[prior] = temp;
            }
            prior ++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
