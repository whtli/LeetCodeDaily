package interview.src.it125;

/**
 * @Description 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 将空字符串定义为有效的回文串。
 * 1 <= s.length <= 2 * 10^5
 * 字符串 s 由 ASCII 字符组成
 * @Author liq
 * @Date 2021/10/27
 */
public class Solution3 {
    public boolean isPalindrome(String s) {
        String str = s;
        str = str.toLowerCase().trim();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                stringBuilder.append(ch);
            } else if (ch >= '0' && ch <= '9') {
                stringBuilder.append(ch);
            }
        }
        int left = 0;
        int right = stringBuilder.length() - 1;
        while (left < right) {
            if (stringBuilder.charAt(left++) != stringBuilder.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
