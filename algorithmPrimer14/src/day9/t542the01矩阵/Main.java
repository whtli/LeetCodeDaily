package day9.t542the01矩阵;

/**
 * @author liq
 * @date 2021/7/26 18:54
 * @list 20天算法刷题计划
 * @name
 */
public class Main {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{0, 0, 0}, {0, 0, 0},  {0, 1, 0}};
        Solution solution = new Solution();
        int[][] result = solution.updateMatrix(mat);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }
}
