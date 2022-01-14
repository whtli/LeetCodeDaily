package interview.src.it190;

import java.util.Scanner;

/**
 * @author : flower48237
 * @2020/3/18 21:25
 * @title : LeetCode��ѡTOP������190.�ߵ�������λ
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Solution solution = new Solution();
        int res = solution.reverseBits(num);
        System.out.println(res);
    }
}
