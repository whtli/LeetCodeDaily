package interview.src.it033;

/**
 * @Description 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * @Author liq
 * @Date 2021/10/30
 */
public class Main {
    public static void main(String[] args) {
        int[] num = {1};
        int target = 1;
        Solution solution = new Solution();
        int result = solution.search(num, target);
        System.out.println(result);
    }
}
