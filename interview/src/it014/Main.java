package interview.src.it014;

/**
 * @Description 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Author liq
 * @Date 2021/10/17
 */
public class Main {
    public static void main(String[] args) {
        String[] strings = {"abc", "ab", "abd"};
        Solution1 solution1 = new Solution1();
        String result1 = solution1.longestCommonPrefix(strings);
        System.out.println("result1: " + result1);
        System.out.println("=========================");
        Solution2 solution2 = new Solution2();
        String result2 = solution2.longestCommonPrefix(strings);
        System.out.println("result2: " + result2);
    }
}
