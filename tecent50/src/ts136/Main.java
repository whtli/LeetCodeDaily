package tecent50.src.ts136;

/**
 * @Description 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 算法应该具有线性时间复杂度。 可以不使用额外空间来实现吗？
 * @Author liq
 * @Date 2022/05/06
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution1 = new Solution2();
        Solution1 solution2 = new Solution1();
        int[] nums = {2,1,2};
        int res1 = solution1.singleNumber(nums);
        int res2 = solution2.singleNumber(nums);
        System.out.println(res1);
        System.out.println(res2);
    }
}
