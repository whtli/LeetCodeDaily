package it202.isHappy;

import java.util.Scanner;

/**
 * @author : flower48237
 * @2020/3/16 20:38
 * title : LeetCode精选TOP面试题202.快乐数
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Solution1 solution = new Solution1();
        System.out.println(solution.isHappy(n));
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isHappy(n));
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.isHappy(n));
    }
}
