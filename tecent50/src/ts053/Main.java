package tecent50.src.ts053;

/**
 * @Description 53.最大子数组和
 * 给定一个整数数组 nums ，请找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * @Author liq
 * @Date 2022/05/13
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        int res = solution.maxSubArray(nums);
        System.out.println(res);
    }
}
