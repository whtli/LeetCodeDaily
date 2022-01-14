package interview.src.it013;

import java.util.Scanner;

/**
 * @author : flower48237
 * @2020/3/4 19:14
 * explanation: LeetCode��ѡTOP������13.��������ת����
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
