package interview.src.it073;

/**
 * @Description 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素原地都设为 0 。
 * @Author liq
 * @Date 2021/12/30
 */
public class Solution2 {
    // 辅助数组
    public void setZeroes(int[][] matrix) {
        boolean[] flagRow = new boolean[matrix.length];
        boolean[] flagCol = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    flagRow[i] = true;
                    flagCol[j] = true;
                }
            }
        }

        System.out.println("set zero---------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (flagRow[i] || flagCol[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
