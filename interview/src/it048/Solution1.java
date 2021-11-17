package interview.src.it048;

/**
 * @Description 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 必须在 原地 旋转图像，这意味着需要直接修改输入的二维矩阵。
 * 不能使用另一个矩阵来旋转图像。
 * @Author liq
 * @Date 2021/11/17
 */
public class Solution1 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;

        // 查看原数组
        /*for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();*/

        // 主对角线翻转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 查看主对角线翻转后的数组
        /*for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();*/

        // 水平翻转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][length - j - 1];
                matrix[i][length - j - 1] = tmp;
            }
        }

        // 查看结果数组
        /*for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }*/
    }
}
