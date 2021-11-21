package interview.src.it287;

import java.util.HashSet;

/**
 * @Description 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 * 提示：
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 *
 * 进阶：
 * 如何证明 nums 中至少存在一个重复的数字?
 * 设计一个线性级时间复杂度 O(n) 的解决方案
 * @Author liq
 * @Date 2021/11/21
 */
public class Solution1 {
    public int findDuplicate(int[] nums) {

        HashSet hashSet = new HashSet();
        for (int item : nums) {
            if (hashSet.contains(item)) {
                return item;
            }
            hashSet.add(item);
        }
        return 0;
    }
}
