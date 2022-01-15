package interview.src.it378;

import java.util.Arrays;

/**
 * @Description 378. 有序矩阵中第 K 小的元素
 * 给定一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * @Author liq
 * @Date 2022/01/14
 */
public class Solution1 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] array = new int[n * n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[t++] = matrix[i][j];
            }
        }
        Arrays.sort(array);
        return array[k - 1];
    }
}
