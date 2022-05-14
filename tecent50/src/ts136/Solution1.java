package tecent50.src.ts136;

import java.util.Arrays;

/**
 * @Description 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 算法应该具有线性时间复杂度。 可以不使用额外空间来实现吗？
 * @Author liq
 * @Date 2022/05/06
 */
public class Solution1 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}