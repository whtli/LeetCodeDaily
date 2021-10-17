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
        String[] strings = {"abc","ab", "abd"};
        Solution solution = new Solution();
        String result = solution.longestCommonPrefix(strings);
        System.out.println("result: " + result);
    }
}
