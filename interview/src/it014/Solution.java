package interview.src.it014;

/**
 * @Description 14.最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Author liq
 * @Date 2021/10/17
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // solution1
        int length = strs[0].length();
        for(int k = 0; k < length; k ++){
            char ch = strs[0].charAt(k);
            for (int i = 1; i < strs.length; i++) {
                if(k == strs[i].length() || strs[i].charAt(k) != ch){
                    return strs[0].substring(0, k);
                }
            }
        }
        return strs[0];
    }
}
