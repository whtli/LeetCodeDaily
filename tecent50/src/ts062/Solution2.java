package tecent50.src.ts062;

/**
 * @Description 62.不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * @Author liq
 * @Date 2022/09/23
 */
public class Solution2 {
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            // x和y同时前进 m - 2 次，刚好满足化简后的公式
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
