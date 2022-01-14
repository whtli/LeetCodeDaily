package interview.src.it191;

/**
 * @author : flower48237
 * @2020/2/28 15:06
 * @title  : LeetCode��ѡTOP������191. λ1�ĸ���
 */
public class Solution {
    public int hammingWeight(int n){
        /*int count = 0;
        String str = Integer.toBinaryString(n);
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '1'){
                count ++;
            }
        }
        return count;*/
        /*int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask <<= 1;
        }
        return count;*/
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
