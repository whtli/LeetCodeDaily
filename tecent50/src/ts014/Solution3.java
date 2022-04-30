package tecent50.src.ts014;

import java.util.Arrays;

/**
 * @Description 14.最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Author liq
 * @Date 2022/04/30
 */
public class Solution3 {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder res = new StringBuilder(strs[0]);
        for (int i = 0; i < strs[0].length() && i < strs[strs.length - 1].length(); i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                res.replace(i, res.length(), "");
                break;
            }
        }
        return res.toString();
    }
}
