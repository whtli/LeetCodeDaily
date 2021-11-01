package interview.src.it162;

/**
 * @Description 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 可以假设 nums[-1] = nums[n] = -∞ 。
 * @Author liq
 * @Date 2021/11/01
 */
public class Solution2 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (right + left) / 2;
            // System.out.println(left + " , " + middle + " , "+ right);
            if (nums[middle] > nums[middle + 1]) {
                right = middle;
            } else if (nums[middle] <= nums[middle + 1]) {
                left = middle + 1;
            }
        }
        return left;
    }
}
