package interview.src.it125;

import java.util.Scanner;

/**
 * @Description 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 将空字符串定义为有效的回文串。
 * 1 <= s.length <= 2 * 10^5
 * 字符串 s 由 ASCII 字符组成
 * @Author liq
 * @Date 2021/10/27
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(str);
        Solution2 solution = new Solution2();
        boolean result = solution.isPalindrome(str);
        System.out.println("result : " + result);
    }
}
