package interview.src.it028;

/**
 * @Description 实现 strStr() 函数
 * 给定两个字符串 haystack 和 needle ，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回 -1 。
 * @Note 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 * 这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 * @Author liq
 * @Date 2021/10/24
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if (null == needle || "".equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int haystackLength = haystack.length();
        int neddleLength = needle.length();
        for (int i = 0; i + neddleLength <= haystackLength; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean flag = true;
                for (int j = 0; j < neddleLength; j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }
}
