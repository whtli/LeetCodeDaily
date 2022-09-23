package tecent50.src.ts062;

/**
 * @Description
 * @Author liq
 * @Date 2022/09/23
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] pathNum = new int[m][n];
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
        /*for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(pathNum[i][j] + "\t");
            }
            System.out.println();
        }*/
        return pathNum[m - 1][n - 1];
    }
}
