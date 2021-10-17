package algorithmPrimer14.src.day7.t695岛屿的最大面积;

/**
 * @author liq
 * @date 2021/7/25 11:40
 * @list 20天算法刷题计划
 * @name 695. 岛屿的最大面积
 */
public class Main {
    public static void main(String[] args) {
        int[][] image = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};


        Solution solution = new Solution();
        int result = solution.maxAreaOfIsland(image);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(image[i][j]);
            }
            System.out.println();
        }
        System.out.println(result);
    }
}
