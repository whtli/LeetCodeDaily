package interview.src.it056;

/**
 * @Description 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * @Author liq
 * @Date 2021/11/04
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] intervals = {{1, 3}, {2, 6}, {8, 16}, {15, 18}};
//        int[][] intervals = {{1, 4}, {4, 18}};
        int[][] intervals = {{1, 4}, {2, 3}};
        int[][] res = solution.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println("[" + res[i][0] + ", " + res[i][1] + "] ");
        }
    }
}
