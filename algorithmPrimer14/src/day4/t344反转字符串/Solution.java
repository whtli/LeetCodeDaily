package algorithmPrimer14.src.day4.t344反转字符串;

/**
 * @author liq
 * @date 2021/7/21 16:00
 * @list 20天算法刷题计划
 * @name
 */
public class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i ++) {
            char ch = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = ch;
        }

        for (int i = 0; i < s.length; i ++) {
            System.out.print(s[i]);
        }
    }
}
