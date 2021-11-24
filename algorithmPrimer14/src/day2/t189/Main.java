package algorithmPrimer14.src.day2.t189;

/**
 * @author liq
 * @date 2021/7/18 18:28
 * @list 20天算法刷题计划
 * @name 189.旋转数组
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        Solution solution = new Solution();
        solution.rotate(nums, k);
    }
}
