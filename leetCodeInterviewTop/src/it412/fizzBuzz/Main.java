package it412.fizzBuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : flower48237
 * @2020/3/2 13:07
 * @title : LeetCode精选TOP面试题412. Fizz Buzz
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        Solution solution = new Solution();
        List<String> res = solution.fizzBuzz(x);
        System.out.print(res);
    }

}
