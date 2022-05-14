package tecent50.src.ts557;

/**
 * @Description 557. 反转字符串中的单词 III
 * 给定一个字符串 s ，需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * @Author liq
 * @Date 2022/05/13
 */
public class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < strs.length; i++) {
            StringBuilder t = new StringBuilder(strs[i]);
            sb.append(t.reverse().append(" "));
        }
        // 循环得到的结果，末尾会多出一个空格，所以返回的结果需要把它截取掉
        return sb.substring(0, s.length());
    }
}
