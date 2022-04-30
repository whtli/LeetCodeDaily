package tecent50.src.ts014;

/**
 * @Description 14.最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Author liq
 * @Date 2022/04/30
 */
public class Main {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        Solution2 solution2 = new Solution2();
        Solution1 solution1 = new Solution1();
        String[] strings = {"flower","flow","flight"};
        String res3 = solution3.longestCommonPrefix(strings);
        String res2 = solution2.longestCommonPrefix(strings);
        String res1 = solution1.longestCommonPrefix(strings);
        System.out.println(res3);
        System.out.println(res2);
        System.out.println(res1);
    }
}
