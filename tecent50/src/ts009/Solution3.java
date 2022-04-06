package tecent50.src.ts009;

/**
 * @Description 9. 回文数
 * 给定一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 进阶：不将整数转为字符串来解决这个问题
 * @Author liq
 * @Date 2022/04/06
 */
public class Solution3 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0) && x != 0) {
            return false;
        }
        int rightHalf = 0;
        int y = x;
        while (y > rightHalf) {
            rightHalf = rightHalf * 10 + y % 10;
            y /= 10;
        }
        // 前者是偶数位数，后者是奇数位数
        return y == rightHalf || y == rightHalf / 10;
    }
}
