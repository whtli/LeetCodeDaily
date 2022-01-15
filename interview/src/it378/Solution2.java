package interview.src.it378;

import java.util.Arrays;

/**
 * @Description 378. 有序矩阵中第 K 小的元素
 * 给定一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * @Author liq
 * @Date 2022/01/14
 */
public class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int count = findSmaller(matrix, mid, n);
            if (count < k) {
                left = mid + 1;
            } else  {
                right = mid;
            }
        }
        return right;
    }

    private int findSmaller(int[][] matrix, int mid, int n) {
        int count = 0;
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}