package interview.src.it378;

/**
 * @Description 378. 有序矩阵中第 K 小的元素
 * 给定一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * @Author liq
 * @Date 2022/01/14
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution2 solution = new Solution2();
        int result = solution.kthSmallest(matrix, 8);
        System.out.println("result: " + result);
    }
}
