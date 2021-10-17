package it121.maxProfit1;

/**
 * @author : flower48237
 * @2020/3/23 16:46
 * @title : LeetCode精选TOP面试题121.买卖股票的最佳时机
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1){
            return 0;
        }
        /* 法 1
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
         */

        int maxnum = prices[0], minnum = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > maxnum){
                maxnum = prices[i];
                if (maxnum - minnum > profit){
                    profit = maxnum - minnum;
                }
            }
            if (prices[i] < minnum){
                minnum = prices[i];
                maxnum = prices[i];
            }

        }
        return profit;
    }
}
