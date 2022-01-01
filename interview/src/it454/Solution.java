package interview.src.it454;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 454. 四数相加 II
 * 给定四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * @Author liq
 * @Date 2022/01/01
 */
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                hashmap.put(num1 + num2, hashmap.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                if (hashmap.containsKey(- num3 - num4)) {
                    result += hashmap.get(- num3 - num4);
                }
            }
        }
        return result;
    }
}
