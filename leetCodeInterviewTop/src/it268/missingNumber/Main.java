package it268.missingNumber;

/**
 * @author : flower48237
 * @2020/3/18 21:41
 * @title : LeetCode精选TOP面试题268.缺失数字
 */
public class Main {
    public static void main(String[] args) {
        int [] nums = {3, 0, 2};
        Solution solution = new Solution();
        int res = solution.missingNumber(nums);
        System.out.println(res);
    }
}
