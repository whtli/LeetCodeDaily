package day3.t167两数之和Ⅱ输入有序数组;


/**
 * @author liq
 * @date 2021/7/19 10:54
 * @list 20天算法刷题计划
 * @name 167.两数之和 II - 输入有序数组
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        Solution solution = new Solution();
        int target = 9;
        int[] result = solution.twoSum(nums, target);
    }
}
