package it371.getSum;

import java.util.Scanner;

/**
 * @author :
 * @2020/3/19 11:05
 * @title :
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.getSum(a,b));
    }
}
