package interview.src.it034;

/**
 * @Description 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * @Author liq
 * @Date 2021/10/31
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1};
        Solution1 solution = new Solution1();
        int target = 0;
        int[] result = solution.searchRange(nums, target);
        System.out.println(result[0] + " , " + result[1]);
    }
}
