package interview.src.it026;

/**
 * @author : flower48237
 * @2020/5/25 19:41
 * @title : LeetCode��ѡTOP������26.ɾ�����������е��ظ���
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        Solution solution = new Solution();
        int reslen = solution.removeDuplicates(nums);
        System.out.println(reslen);
        for (int i = 0; i < reslen; i ++){
            System.out.print(nums[i] + " ");
        }
    }
}
