package it387.firstUniqChar;

import java.util.Scanner;

/**
 * @author liq48237
 * @version 1.0
 * @date 2021/3/7 12:39
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int index = solution.firstUniqChar(str);
        System.out.println(index);
    }
}
