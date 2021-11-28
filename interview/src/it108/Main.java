package interview.src.it108;

import java.util.List;

/**
 * @author : flower48237
 * @2020/3/4 19:14
 * @title : LeetCode��ѡTOP������108.����������ת��Ϊ����������
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] nums = {-10,-3,0,5,9};
        TreeNode root = solution.sortedArrayToBST(nums);
        List<Integer> list = solution.BFSByQueue(root);
        System.out.print(list);
    }

}
