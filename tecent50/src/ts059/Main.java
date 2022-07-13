package tecent50.src.ts059;

/**
 * @Description 59. 螺旋矩阵 II
 * 给定一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * @Author liq
 * @Date 2022/07/13
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] matrix = solution.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
