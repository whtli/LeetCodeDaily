package tecent50.src.ts016;

/**
 * @Description 16.最接近的三数之和
 * 给定一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * 请从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * @Author liq
 * @Date 2022/06/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {-1, 2, 1, -4};
//        int[] nums = {1, 1, 1, 1};
        int[] nums = {-3, -2, -5, 3, -4};
        int target = -1;
        int closeSum1 = solution.threeSumClosest(nums, target);
        int closeSum2 = solution.threeSumClosest2(nums, target);
        System.out.println(closeSum1);
        System.out.println(closeSum2);
    }
}
