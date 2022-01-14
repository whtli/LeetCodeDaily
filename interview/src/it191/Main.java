package interview.src.it191;

import java.util.Scanner;

/**
 * @author : flower48237
 * @2020/2/28 15:06
 * @title  : LeetCode��ѡTOP������191. λ1�ĸ���
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        int  x = in.nextInt();
        int res = solution.hammingWeight(x);
        System.out.print(res);
    }
}
