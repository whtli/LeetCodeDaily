package tecent50.src.ts054;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 54. 螺旋矩阵
 * 给定一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @Author liq
 * @Date 2022/07/13
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int length = matrix.length;
        int width = matrix[0].length;
        int left = 0, right = width - 1, top = 0, bottom = length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            for (int j = top + 1; j <= bottom; j++) {
                list.add(matrix[j][right]);
            }
            if (left < right && top < bottom) {
                for (int p = right - 1; p >= left; p--) {
                    list.add(matrix[bottom][p]);
                }
                for (int q = bottom - 1; q > top; q--) {
                    list.add(matrix[q][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }
}
