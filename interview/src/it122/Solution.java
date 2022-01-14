package interview.src.it122;

/**
 * @author : flower48237
 * @2020/3/16 17:23
 * title : LeetCode��ѡTOP������122.������Ʊ�����ʱ��II;
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int interest = 0;

        /*  ��1
        int in = prices[0];
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > in){
                interest += prices[i] - in;
                in = prices[i];
            }else if (prices[i] < in){
                in = prices[i];
            }
        } */
        // �� 2
        for (int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i - 1]){
                interest += prices[i] - prices[i - 1];
            }
        }

        return interest;
    }
}
