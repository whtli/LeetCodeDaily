package interview.src.it202;

import java.util.HashSet;

/**
 * @author : flower48237
 * @2020/3/16 20:38
 * @title : LeetCode��ѡTOP������202.������
 */
public class Solution2 {
    public boolean isHappy(int n) {
        // �� 2 -- ����HashSet
        HashSet<Integer> hashset = new HashSet<Integer>();
        hashset.add(n);

        if (n == 1){
            return true;
        }
        while (n != 1){
            n = getSqrtSum(n);
            if (hashset.contains(n)){
                return false;
            }
            hashset.add(n);
        }
        return true;
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
