package it268.missingNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : flower48237
 * @2020/3/18 21:41
 * @title : LeetCode��ѡTOP������268.ȱʧ����
 */
public class Solution {
    public int missingNumber(int[] nums) {
        /* �� 1
        int sum = 0;
        int stdsum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            stdsum += i + 1;
        }
        return stdsum - sum;*/

        /* �� 2
        Arrays.sort(nums);

        // �ж� n �Ƿ������ĩλ
        if (nums[nums.length-1] != nums.length) {
            return nums.length;
        }
        // �ж� 0 �Ƿ��������λ
        else if (nums[0] != 0) {
            return 0;
        }

        // ��ʱȱʧ������һ���� (0, n) ��
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1] + 1) {
                return nums[i-1] + 1;
            }
        }
        // δȱʧ�κ����֣���֤�����з���ֵ��
        return -1;*/

        // �� 3
        Set<Integer> set = new HashSet<Integer>();
        for (int n : nums){
            set.add(n);
        }
        for (int i = 0; i <= nums.length; i++){
            if (!set.contains(i)){
                return i;
            }
        }
        return -1;
    }

}
