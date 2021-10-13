package it26.removeDuplicates;

/**
 * @author : flower48237
 * @2020/5/25 19:41
 * @title : LeetCode精选TOP面试题26.删除排序数组中的重复项
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        Solution solution = new Solution();
        int reslen = solution.removeDuplicates(nums);
        System.out.println(reslen);
        for (int i = 0; i < reslen; i ++){
            System.out.print(nums[i] + " ");
        }
    }
}
