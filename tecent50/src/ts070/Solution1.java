package tecent50.src.ts070;

/**
 * @Description 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @Author liq
 * @Date 2022/05/16
 */
public class Solution1 {
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // 不借助dp数组的写法
    public int climbStairs2(int n){
        int p = 0;
        int q = 1;
        int r = p + q;
        for (int i = 2; i <= n; i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
