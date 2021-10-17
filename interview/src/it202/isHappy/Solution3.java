package it202.isHappy;

/**
 * @author : flower48237
 * @2020/3/16 20:38
 * @title : LeetCode精选TOP面试题202.快乐数
 */
public class Solution3 {
    public boolean isHappy(int n) {
        // 法 3 -- 投机取巧
        while (true){
            if (n < 10){
                if (n == 1 || n == 7) {
                    return true;
                }else {
                    return false;
                }
            }
            n = getSqrtSum(n);
        }
    }
    public int getSqrtSum(int num){
        int sum = 0;
        while (num > 0){
            int item = num % 10;
            sum += item * item;
            num /= 10;
        }
        return sum;
    }
}
