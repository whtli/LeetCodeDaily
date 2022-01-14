package interview.src.it242;

import java.util.Scanner;

/**
 * @author : flower48237
 * @2020/3/10 13:27
 * @title : LeetCode��ѡTOP������242.��Ч����ĸ��λ��
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
