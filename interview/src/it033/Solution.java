package interview.src.it033;

/**
 * @Description 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * @Author liq
 * @Date 2021/10/30
 */
public class Solution {
    public int search(int[] nums, int target) {
        int div = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                div = i;
                break;
            }
        }
        // System.out.println(div);
        // 二分查找
        int left, right;
        int length = nums.length;
        if (nums[div] >= target && nums[0] <= target) {
            left = 0;
            right = div;
        } else if (nums[length - 1] >= target) {
            left = div + 1;
            right = length - 1;
        } else {
            return -1;
        }
        System.out.println(left + "," + right);
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            if (target == nums[middle] && left <= right) {
                return middle;
            }
            if (target > nums[middle] && left <= right) {
                left = middle + 1;
            } else if (target < nums[middle] && left <= right) {
                right = middle - 1;
            }
        }
        return -1;
    }
}
