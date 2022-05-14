package tecent50.src.ts217;

/**
 * @Description 217.存在重复元素
 * 给定一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 * @Author liq
 * @Date 2022/05/11
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution1 solution = new Solution1();
        boolean res = solution.containsDuplicate(nums);
        System.out.println(res);
    }
}
