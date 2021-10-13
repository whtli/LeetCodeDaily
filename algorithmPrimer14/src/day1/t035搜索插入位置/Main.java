package day1.t035搜索插入位置;

/**
 * @author liq
 * @date 2021/7/17 19:13
 * @list 20天算法刷题计划
 * @name 704.二分查找
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,3,5,6};
        int target = 7;

        int result = solution.searchInsert(nums, target);
        System.out.println(result);
    }
}
