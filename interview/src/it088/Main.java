package interview.src.it088;

/**
 * @Description
 * @Author liq
 * @Date 2021/10/25
 */
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        // m 和 n ，分别表示 nums1 和 nums2 中的元素数目
        int m = 3, n = 3;
        Solution2 solution = new Solution2();
        solution.merge(nums1, m, nums2, n);
        for (int i = 0; i < m + n - 1; i++) {
            System.out.print(nums1[i] + ",");
        }
        System.out.print(nums1[m + n - 1]);
    }
}
