package interview.src.it075;

/**
 * @Description 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @Author liq
 * @Date 2021/11/04
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {2,     0,    2,    1,    1,    1};
        solution.sortColors(nums);
        for (int item : nums) {
            System.out.println(item);
        }
    }
}
