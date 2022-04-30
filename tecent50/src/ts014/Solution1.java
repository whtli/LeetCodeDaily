package tecent50.src.ts014;

/**
 * @Description 14.最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Author liq
 * @Date 2022/04/30
 */
public class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        int minLen = 201;
        for (String s : strs) {
            if (s.length() < minLen) {
                minLen = s.length();
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char ch = strs[0].charAt(i);
            boolean flag = true;
            for (String s : strs) {
                if (ch != s.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            res.append(ch);

        }
        return res.toString();
        /*
        StringBuilder res = new StringBuilder(strs[0]);
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (String s : strs) {
                if (i == s.length() || ch != s.charAt(i)) {
                    return res.substring(0, i);
                }
            }
        }
        return res.toString();
        */
    }
}