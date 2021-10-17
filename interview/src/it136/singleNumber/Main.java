package it136.singleNumber;

/**
 * @author : flower48237
 * @2020/2/18 22:47
 * @title : LeetCode精选TOP面试题136.只出现一次的数字
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] nums = {4,1,2,1,2};
        int res = solution.singleNumber(nums);
        System.out.print(res);
    }
}
