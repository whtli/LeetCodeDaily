package interview.src.it073;

/**
 * @Description 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素原地都设为 0 。
 * @Author liq
 * @Date 2021/12/30
 */
public class Main {
    public static void main(String[] args) {
        int[][] nums = {{-4,-2147483648,6,-7,0},{-8,6,-8,-6,0},{2147483647,2,-9,-6,-10}};
        System.out.println("init---------");
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < nums[0].length; j ++) {
                System.out.print(nums[i][j] + "\t          ");
            }
            System.out.println();
        }
        //Solution1 solution = new Solution1();
        Solution2 solution = new Solution2();
        solution.setZeroes(nums);
        System.out.println("result  ---------");
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < nums[0].length; j ++) {
                System.out.print(nums[i][j] + "\t          ");
            }
            System.out.println();
        }
    }
}
