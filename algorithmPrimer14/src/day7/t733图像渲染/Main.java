package day7.t733图像渲染;

/**
 * @author liq
 * @date 2021/7/23 21:10
 * @list 20天算法刷题计划
 * @name 733. 图像渲染
 */
public class Main {
    public static void main(String[] args) {
        int[][] image = new int[][]{{0, 0, 0}, {0, 1, 1}};
        Solution solution = new Solution();
        solution.floodFill(image, 1, 1, 1);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j ++) {
               System.out.print(image[i][j]);
            }
            System.out.println();
        }
    }
}
