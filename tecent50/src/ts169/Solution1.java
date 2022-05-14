package tecent50.src.ts169;

import java.util.Arrays;

/**
 * @Description 169.多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @Author liq
 * @Date 2022/05/14
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
