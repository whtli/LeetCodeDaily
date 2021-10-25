package interview.src.it088;

import java.util.Arrays;

/**
 * @Description
 * @Author liq
 * @Date 2021/10/25
 */
public class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int length = m + n;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            nums1[--length] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (i >= 0) {
            nums1[--length] = nums1[i--];
        }
        while (j >= 0) {
            nums1[--length] = nums2[j--];
        }
    }
}
