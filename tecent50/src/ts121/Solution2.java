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
public class Solution2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int maxProf = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                maxProf = Math.max(prices[j] - prices[i], maxProf);
            }
        }
        return maxProf;
    }
}
