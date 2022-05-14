package tecent50.src.ts217;

import java.util.Arrays;

/**
 * @Description 217.存在重复元素
 * 给定一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * @Author liq
 * @Date 2022/05/11
 */
public class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
