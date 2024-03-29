package tecent50.src.ts062;

/**
 * @Description 62.不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * @Author liq
 * @Date 2022/09/23
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res1 = solution.uniquePaths(7, 3);
        System.out.println(res1);
        Solution2 solution2 = new Solution2();
        int res2 = solution2.uniquePaths(3, 3);
        System.out.println(res2);
    }
}
