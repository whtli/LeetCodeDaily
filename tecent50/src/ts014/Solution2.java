package tecent50.src.ts014;

/**
 * @Description 14.最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Author liq
 * @Date 2022/04/30
 */
public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i ++) {
            int len = strs[i].length();
            if (len < res.length()) {
                res.replace(len, res.length(), "");
            }
            for (int j = 0; j < len; j ++){
                if (j >= res.length()) {
                    break;
                }
                if (res.charAt(j) != strs[i].charAt(j)) {
                    res.replace(j, len, "");
                    break;
                }
            }
        }
        return res.toString();
    }
}
