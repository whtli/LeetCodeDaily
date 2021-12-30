package interview.src.it073;

/**
 * @Description 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素原地都设为 0 。
 * @Author liq
 * @Date 2021/12/30
 */
public class Solution1 {
    public void setZeroes(int[][] matrix) {
        boolean flagRow = false;
        boolean flagCol = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                flagRow = true;
            }
        }
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] == 0) {
                flagCol = true;
            }
        }
        System.out.println("flagRow : " + flagRow);
        System.out.println("flagCol : " + flagCol);

        System.out.println("set flag---------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t          ");
            }
            System.out.println();
        }

        System.out.println("set zero---------");
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t          ");
            }
            System.out.println();
        }

        System.out.println("judge first ---------");
        if (flagRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (flagCol) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }

    }
}
