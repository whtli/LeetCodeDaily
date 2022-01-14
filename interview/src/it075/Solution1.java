package interview.src.it075;

/**
 * @Description 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * @Author liq
 * @Date 2021/11/04
 */
public class Solution1 {
    /* public void sortColors(int[] nums) {
        int length = nums.length;
        int zero = 0, two = length - 1;
        int i = 0;
        while (i <= two) {
            if (nums[i] == 0) {
                nums[i] = nums[zero];
                nums[zero++] = 0;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[two];
                nums[two--] = 2;
            } else {
                i++;
            }
        }
    } */

    /**
     * 基于上方注释内容，抽出交换数据的方法
     */
    public void sortColors(int[] nums) {
        int length = nums.length;
        int zero = 0, two = length;
        int i = 0;
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero++);
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, --two);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
