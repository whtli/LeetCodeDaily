package interview.src.it078;

import java.util.List;

/**
 * @Description
 * @Author liq
 * @Date 2021/10/29
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Solution solution = new Solution();
        List<List<Integer>> result = solution.subsets(nums);
        for (List list : result) {
            System.out.println(list);
        }
    }
}
