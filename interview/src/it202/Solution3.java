package interview.src.it202;

/**
 * @author : flower48237
 * @2020/3/16 20:38
 * @title : LeetCode��ѡTOP������202.������
 */
public class Solution3 {
    public boolean isHappy(int n) {
        // �� 3 -- Ͷ��ȡ��
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
