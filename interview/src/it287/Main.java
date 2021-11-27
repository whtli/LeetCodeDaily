package interview.src.it287;

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
 * <p>
 * 进阶：
 * 如何证明 nums 中至少存在一个重复的数字?
 * 设计一个线性级时间复杂度 O(n) 的解决方案
 * @Author liq
 * @Date 2021/11/21
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {2, 5, 4, 6, 9, 3, 8, 9, 7, 1};
        //int[] nums = {1, 3, 4, 2, 2};
        // int[] nums = {1, 1};
        int result = solution.findDuplicate(nums);
        System.out.println("result : " + result);
    }
}
