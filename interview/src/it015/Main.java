package interview.src.it015;

import java.util.List;

/**
 * @Description 15.三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有和为 0 且不重复的三元组。
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * @Author liq
 * @Date 2021/11/18
 */
public class Main {
    public static void main(String[] args) {
        // int[] nums = {-1, 0, 1, 2, -1, -4, -1, -1};
        int[] nums = {};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(nums);
        if (null != lists) {
            for (List<Integer> list : lists) {
                System.out.println(list);
            }
        }

    }
}
