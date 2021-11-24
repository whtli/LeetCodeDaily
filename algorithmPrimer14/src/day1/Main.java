package algorithmPrimer14.src.day1;

import java.util.Scanner;

/**
 * @author liq
 * @date 2021/7/17 19:13
 * @list 20天算法刷题计划
 * @name 704.二分查找
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int result = solution.firstBadVersion(n);
        System.out.println(result);

    }
}
