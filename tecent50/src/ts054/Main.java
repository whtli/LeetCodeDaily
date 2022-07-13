package tecent50.src.ts054;

import java.util.List;

/**
 * @Description 54. 螺旋矩阵
 * 给定一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @Author liq
 * @Date 2022/07/13
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = solution.spiralOrder(matrix);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
