package it121.maxProfit1;

/**
 * @author : flower48237
 * @2020/3/23 16:46
 * @title : LeetCode精选TOP面试题121.买卖股票的最佳时机I
 */
public class Main {
    public static void main(String[] args) {
        int [] num = {2,4,1};
        Solution solution = new Solution();
        int res = solution.maxProfit(num);
        System.out.println(res);
    }
}
