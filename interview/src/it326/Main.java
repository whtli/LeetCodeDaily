package interview.src.it326;

import java.util.Scanner;

/**
 * @Description 326. 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 若是，返回 true ；否则，返回 false 。
 * @Author liq
 * @Date 2021/10/20
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();
        int number = in.nextInt();
        boolean result = solution.isPowerOfThree(number);
        System.out.println("result : " + result);
    }
}
