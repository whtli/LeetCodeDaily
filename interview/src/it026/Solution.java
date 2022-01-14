package interview.src.it026;

/**
 * @author : flower48237
 * @2020/5/25 19:41
 * @title : LeetCode��ѡTOP������26.ɾ�����������е��ظ���
 */
public class Solution {
    public int removeDuplicates(int[] nums){
        int reslen = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i-1]){
                nums[reslen ++] = nums[i];
            }
        }
        return reslen;
    }
}
