package it202.isHappy;

/**
 * @author : flower48237
 * @2020/3/16 20:38
 * @title : LeetCode精选TOP面试题202.快乐数
 */
public class Solution1 {
    public boolean isHappy(int n) {
        // 法 1 -- 快慢指针
        int slower = n;
        int faster = n;
        do {
            slower = getSqrtSum(slower);
            faster = getSqrtSum(faster);
            faster = getSqrtSum(faster);
        }while (slower != faster);

        return slower == 1;
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
