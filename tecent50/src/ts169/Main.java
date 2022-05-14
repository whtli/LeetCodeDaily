package tecent50.src.ts169;

/**
 * @Description 169.多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @Author liq
 * @Date 2022/05/14
 */
public class Main {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] nums = {2,1,2,1,3,3,3,3,3};
        int res = solution.majorityElement(nums);
        System.out.println(res);
    }
}
