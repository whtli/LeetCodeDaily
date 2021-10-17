package it122.maxProfit2;

/**
 * @author : flower48237
 * @2020/3/16 17:23
 * title : LeetCode精选TOP面试题122.买卖股票的最佳时机II;
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int interest = 0;

        /*  法1
        int in = prices[0];
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > in){
                interest += prices[i] - in;
                in = prices[i];
            }else if (prices[i] < in){
                in = prices[i];
            }
        } */
        // 法 2
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i - 1]){
                interest += prices[i] - prices[i - 1];
            }
        }

        return interest;
    }
}
