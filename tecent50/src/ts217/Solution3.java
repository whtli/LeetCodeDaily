package tecent50.src.ts217;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 217.存在重复元素
 * 给定一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * @Author liq
 * @Date 2022/05/11
 */
public class Solution3 {
    public boolean containsDuplicate(int[] nums) {
        // 会超出时间限制
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++) {
                if (j != i && nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
