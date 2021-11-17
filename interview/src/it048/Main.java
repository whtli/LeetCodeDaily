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
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        solution.rotate(matrix);

    }
}
