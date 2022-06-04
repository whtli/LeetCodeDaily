package tecent50.src.ts015;

import java.util.*;

/**
 * @Description 15. 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请找出所有和为 0 且不重复的三元组。
 * @Author liq
 * @Date 2022/05/30
 */
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> lists = new ArrayList<>(256);
        if (n < 3 || nums[0] > 0 || nums[n - 1] < 0) {
            return lists;
        }
        // 转换成 a + b = -c
        int i, j, k;
        for (i = 0; i < n - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            j = i + 1;
            k = n - 1;
            while (j < k) {
                int target = nums[j] + nums[k];
                if (target < -nums[i]) {
                    j++;
                } else if (target > -nums[i]) {
                    k--;
                } else {
                    lists.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]}));
                    k--;
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return lists;
    }
}
