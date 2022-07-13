package tecent50.src.ts059;

/**
 * @Description 59. 螺旋矩阵 II
 * 给定一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * @Author liq
 * @Date 2022/07/13
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int[][] matrix = new int[n][n];
        int c = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = c++;
            }
            for (int j = top + 1; j <= bottom; j++) {
                matrix[j][right] = c++;
            }
            for (int p = right - 1; p >= left; p--) {
                matrix[bottom][p] = c++;
            }
            for (int q = bottom - 1; q > top; q--) {
                matrix[q][left] = c++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }
}
