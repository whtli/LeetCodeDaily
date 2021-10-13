package it13.romanToInt;

import java.util.Scanner;

/**
 * @author : flower48237
 * @2020/3/4 19:14
 * explanation: LeetCode精选TOP面试题13.罗马数字转整数
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new  Solution();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int res = solution.romanToInt(str);
        System.out.print(res);
    }
}
