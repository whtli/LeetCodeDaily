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
public class Main {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        Solution2 solution2 = new Solution2();
        int[] prices = {7,2,5,1,6,4};
        int res11 = solution1.maxProfitDp1(prices);
        int res12 = solution1.maxProfitDp2(prices);
        int res2 = solution2.maxProfit(prices);
        System.out.println(res11);
        System.out.println(res12);
        System.out.println(res2);
    }
}
