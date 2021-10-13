package it53.maxSubArray;

/**
 * @author : flower48237
 * @2020/5/24 18:02
 * @title : LeetCode精选TOP面试题53.最大子序和
 */
public class Main {
    public static void main(String[] args) {
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};

        Solution solution = new Solution();
        int res = solution.maxSubArray(nums);
        System.out.println(res);

        Solution2 solution2 = new Solution2();
        int res2 = solution.maxSubArray(nums);
        System.out.println(res2);
    }
}
