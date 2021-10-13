package day6.t567字符串的排列;

/**
 * @author liq
 * @date 2021/7/22 23:27
 * @list 20天算法刷题计划
 * @name 567. 字符串的排列
 */
public class Main {
    public static void main(String[] args) {
        //"ab"
        //"eidbaooo"
        //"hello"
        //"ooolleoooleh"
        String s1= "aabab", s2 = "eeebbbaaooo";
        Solution solution = new Solution();
        boolean result = solution.checkInclusion(s1, s2);
        System.out.println(result);
    }
}
