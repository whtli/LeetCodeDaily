package interview.src.it034;

/**
 * @Description 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * @Author liq
 * @Date 2021/10/31
 */
public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int length = nums.length;
        if (nums.length == 0 || target < nums[0] || target > nums[length - 1]) {
            return result;
        }
        int left = 0, right = length - 1;
        while (nums[left] < target) {
            left++;
        }
        if (nums[left] == target) {
            result[0] = left;
        }

        while (nums[right] > target) {
            right--;
        }
        if (nums[right] == target) {
            result[1] = right;
        }
        // 执行到此处，若left为-1，说明数组中没有target元素，则right一定为-1，不需要额外的判断了。
        return result;
    }
}
