package tecent50.src.ts070;

/**
 * @Description 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @Author liq
 * @Date 2022/05/16
 */
public class Solution2 {
    public int climbStairs(int n) {
        // 超出时间限制O(2^n)
        if (n <= 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
