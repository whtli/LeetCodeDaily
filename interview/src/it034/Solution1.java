package interview.src.it034;


/**
 * @Description 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * @Author liq
 * @Date 2021/10/31
 */
public class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        int left = findIndex(nums, target);
        int right = findIndex(nums, target + 1) - 1;
        if (left > right) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    private int findIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            System.out.println(left + " , " + right);
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
