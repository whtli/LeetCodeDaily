package interview.src.it162;

/**
 * @Description
 * @Author liq
 * @Date 2021/11/01
 */
public class Solution1 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}
