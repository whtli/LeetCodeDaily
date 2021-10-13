package day7.t695岛屿的最大面积;

/**
 * @author liq
 * @date 2021/7/25 11:40
 * @list 20天算法刷题计划
 * @name 695. 岛屿的最大面积
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        // 行数
        int rolNum = grid.length;
        // 列数
        int colNum = grid[0].length;
        for (int i = 0; i < rolNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (grid[i][j] == 1) {
                    int tempArea = dfs(grid, i, j, rolNum, colNum);
                    maxArea = maxArea > tempArea ? maxArea : tempArea;
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int sr, int sc, int rolNum, int colNum) {
        int area = 0;

        //System.out.println(rolNum + "  &  " + colNum);
        // 对起始点进行渲染
        if (grid[sr][sc] == 1) {
            area++;
            grid[sr][sc] = 0;

            // 对起始点的上点进行判断渲染
            if (sr > 0) {
                area += dfs(grid, sr - 1, sc, rolNum, colNum);
            }
            // 对起始点的下点进行判断渲染
            if (sr < rolNum - 1) {
                area += dfs(grid, sr + 1, sc, rolNum, colNum);
            }
            // 对起始点的左点进行判断渲染
            if (sc > 0) {
                area += dfs(grid, sr, sc - 1, rolNum, colNum);
            }
            // 对起始点的右点进行判断渲染
            if (sc < colNum - 1) {
                area += dfs(grid, sr, sc + 1, rolNum, colNum);
            }
        }
        return area;
    }
}
