package interview.src.it238;

/**
 * @Description 238. 除自身以外数组的乘积
 * 给定一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 不能使用除法，且在 O(n) 时间复杂度内完成此题。
 * @Author liq
 * @Date 2022/02/07
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        Solution solution = new Solution();
        int[] result = solution.productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
