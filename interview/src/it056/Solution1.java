package interview.src.it056;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * @Author liq
 * @Date 2021/11/04
 */
public class Solution1 {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        // System.out.println(length);
        int count = 0;
        int[][] result = new int[length][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        for (int i = 0, j = 1; i < length && j <= length; i = j, j = i + 1) {
            while (j < length && intervals[i][1] >= intervals[j][0]) {
                /* if (intervals[j][1] > intervals[i][1]) {
                    intervals[i][1] = intervals[j][1];
                } */
                intervals[i][1] = Math.max(intervals[j][1] , intervals[i][1]);
                j++;
            }
            // System.out.println(intervals[i][0] + " , " + intervals[i][1]);
            result[count] = intervals[i];
            // System.out.println("current:  i = " + i + " , j = " + j);
            count++;
        }
        // System.out.println("count : " + count);
        int[][] merged = new int[count][2];
        for (int i = 0; i < count; i++) {
            merged[i] = result[i];
        }
        return merged;
    }
}
