package tecent50.src.ts016;

import java.util.Arrays;

/**
 * @Description 16.最接近的三数之和
 * 给定一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * 请从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * @Author liq
 * @Date 2022/06/04
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        int n = nums.length;
        int bigger = Integer.MAX_VALUE;
        int smaller = Integer.MIN_VALUE;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int tmpSum = nums[i] + nums[j] + nums[k];
                if (tmpSum > target) {
                    if (tmpSum <= bigger) {
                        bigger = tmpSum;
                    }
                    k--;
                } else if (tmpSum < target) {
                    if (tmpSum >= smaller) {
                        smaller = tmpSum;
                    }
                    j++;
                } else {
                    return target;
                }
            }
        }
        if (bigger == Integer.MAX_VALUE) {
            return smaller;
        }
        if (smaller == Integer.MIN_VALUE) {
            return bigger;
        }
        int left = target - smaller;
        int right = bigger - target;
        if (left > right) {
            return bigger;
        } else {
            return smaller;
        }
    }

    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10001;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int tmpSum = nums[i] + nums[j] + nums[k];
                int cur = Math.abs(tmpSum - target);
                int old = Math.abs(best - target);
                if (cur < old) {
                    best = tmpSum;
                }
                if (tmpSum > target) {
                    k--;
                } else if (tmpSum < target) {
                    j++;
                } else {
                    return target;
                }
            }
        }
        return best;
    }
}
