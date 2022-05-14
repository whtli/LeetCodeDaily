package tecent50.src.ts121;

/**
 * @Description 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算所能获取的最大利润。
 * 返回可以从这笔交易中获取的最大利润。
 * 如果不能获取任何利润，返回 0 。
 * @Author liq
 * @Date 2022/05/15
 */
public class Solution1 {
    public int maxProfitDp1(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            // dp[i] = Math.max(prices[i] - minPrice, dp[i - 1]);
            // minPrice = Math.min(minPrice, prices[i]);
            if (prices[i] - minPrice > dp[i - 1]) {
                dp[i] = prices[i] - minPrice;
            } else {
                dp[i] = dp[i - 1];
            }
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
            // System.out.print(dp[i] + " ");
        }
        return dp[n - 1];
    }

    // DP2为动态规划的简化，放弃额外的数组记录，只维护一个最大利润变量，是从DP衍生而来的
    public int maxProfitDp2(int[] prices) {
        int len = prices.length;
        int maxProfile = 0;
        int minPrice = prices[0];
        for (int i = 1; i < len; i++) {
            // maxProfile = Math.max(prices[i] - minPrice, maxProfile);
            // minPrice = Math.min(minPrice, prices[i]);
            if (prices[i] - minPrice > maxProfile) {
                maxProfile = prices[i] - minPrice;
            }
            if (minPrice > prices[i]){
                minPrice = prices[i];
            }
        }
        return maxProfile;
    }
}
