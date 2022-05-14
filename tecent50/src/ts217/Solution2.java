package tecent50.src.ts217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 217.存在重复元素
 * 给定一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * @Author liq
 * @Date 2022/05/11
 */
public class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums){
            if (set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
