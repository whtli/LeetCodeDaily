package interview.src.it088;

import java.util.Arrays;

/**
 * @Description
 * @Author liq
 * @Date 2021/10/25
 */
public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
