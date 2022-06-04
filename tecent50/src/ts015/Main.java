package tecent50.src.ts015;

import java.util.List;

/**
 * @Description 15. 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请找出所有和为 0 且不重复的三元组。
 * @Author liq
 * @Date 2022/05/30
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        int[] nums = {0,1,1};

        List<List<Integer>> res1 = solution.threeSum(nums);
        List<List<Integer>> res2 = solution2.threeSum(nums);
        List<List<Integer>> res3 = solution3.threeSum(nums);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
