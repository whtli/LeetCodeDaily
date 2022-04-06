package tecent50.src.ts009;

/**
 * @Description 9. 回文数
 * 给定一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 进阶：不将整数转为字符串来解决这个问题
 * @Author liq
 * @Date 2022/04/06
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution3 solution2 = new Solution3();
        Solution2 solution3 = new Solution2();
        int number = 121;
        boolean res1 = solution1.isPalindrome(number);
        boolean res2 = solution2.isPalindrome(number);
        boolean res3 = solution3.isPalindrome(number);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
