package day6.t567字符串的排列;

import java.util.*;

/**
 * @author liq
 * @date 2021/7/22 23:27
 * @list 20天算法刷题计划
 * @name 567. 字符串的排列
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
/*        if (s1.length() > s2.length()) {
            return false;
        }
        // 判断：第一个字符串的排列之一是第二个字符串的子串
        int[] arrays1 = new int[26];

        int length = s1.length();
        for (int j = 0; j < length; j++) {
            ++arrays1[s1.charAt(j) - 'a'];
        }
        StringBuilder subString = new StringBuilder();

        for (int i = 0; i < s2.length(); i++) {
            int[] arrays2 = new int[26];
            subString.replace(0, length, "");
            int end = i + length;
            if (end > s2.length()) {
                return false;
            }
            subString.append(s2, i, end);
            for (int j = 0; j < length; j++) {
                ++arrays2[subString.charAt(j) - 'a'];
            }

            boolean flag = true;
            for (int index = 0; index < 26 && flag; index++) {
                if (arrays1[index] != arrays2[index]) {
                    flag = false;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;*/
        // 官方题解
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; ++i) {
            --cnt[s1.charAt(i) - 'a'];
        }
        int left = 0;
        for (int right = 0; right < m; ++right) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;

    }
}
