package interview.src.it075;

/**
 * @Description 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @Author liq
 * @Date 2021/11/04
 */
public class Solution2 {
    public void sortColors(int[] nums) {
        int length = nums.length;
        int flag0 = 0, flag2 = length - 1;
        for (int i = 0; i < flag2; i++) {
            while (i <= flag2 && nums[i] == 2) {
                nums[i] = nums[flag2];
                nums[flag2--] = 2;
            }
            if (nums[i] == 0) {
                nums[i] = nums[flag0];
                nums[flag0 ++] = 0;
            }
        }
    }
}
