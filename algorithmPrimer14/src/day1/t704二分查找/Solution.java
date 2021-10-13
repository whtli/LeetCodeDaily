package day1.t704二分查找;

/**
 * @author liq
 * @date 2021/7/17 19:13
 * @list 20天算法刷题计划
 * @name 704.二分查找
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int result = -1;
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }
        return result;
    }
}
