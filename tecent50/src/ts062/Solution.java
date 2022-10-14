package tecent50.src.ts062;

/**
 * @Description 62.不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * @Author liq
 * @Date 2022/09/23
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] pathNum = new int[m][n];
        /*
        for (int j = 0; j < n; j++) {
            pathNum[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            pathNum[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathNum[i][j] = pathNum[i - 1][j] + pathNum[i][j - 1];
            }
        }
        */

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    pathNum[i][j] = 1;
                } else {
                    pathNum[i][j] = pathNum[i - 1][j] + pathNum[i][j - 1];
                }

            }
        }
        /* 打印动态规划得到的二维数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(pathNum[i][j] + "\t");
            }
            System.out.println();
        }
        */
        return pathNum[m - 1][n - 1];
    }
}
