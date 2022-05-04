package tecent50.src.ts088;


/**
 * @Description 88.合并两个有序数组
 * 给定两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：
 * 最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。
 * nums2 的长度为 n 。
 * @Author liq
 * @Date 2022/05/04
 */
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums3 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m1 = 3;
        int m2 = 3;
        Solution1 solution1 = new Solution1();
        solution1.merge(nums1, m1, nums2, nums2.length);
        for (int i : nums1) {
            System.out.print(i);
        }
        System.out.println();
        Solution2 solution2 = new Solution2();
        solution2.merge(nums3, m2, nums2, nums2.length);
        for (int i : nums3) {
            System.out.print(i);
        }
    }
}
