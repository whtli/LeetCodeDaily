package it242.isAnagram;

import java.util.Scanner;

/**
 * @author : flower48237
 * @2020/3/10 13:27
 * @title : LeetCode精选TOP面试题242.有效的字母异位词
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();

        System.out.print(solution.isAnagram(s, t));
    }
}
