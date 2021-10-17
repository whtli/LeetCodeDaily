package algorithmPrimer14.src.day6.t003无重复字符的最长子串;

/**
 * @author liq
 * @date 2021/7/22 23:05
 * @list 20天算法刷题计划
 * @name 3. 无重复字符的最长子串
 */
public class Main {
    public static void main(String[] args) {
        String s = "";
        Solution solution = new Solution();
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
