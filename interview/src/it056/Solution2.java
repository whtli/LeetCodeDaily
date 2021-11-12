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
public class Solution2 {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;

        int[][] result = new int[length][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        int count = -1;
        for (int[] array : intervals) {
            if (count == -1 || array[0] > result[count][1]) {
                // 记当前遍历到的数组元素为array
                // 当result数组为空，将array添加进result
                // 或者
                // 当array的左侧区间值大于result数组最后一个元素的右侧区间值，即两个区间无重合时，将array添加进result
                result[++count] = array;
            }else {
                // 当array的左侧区间值不大于result数组最后一个元素的右侧区间值，即两个区间有重合时，更新result数组最后一个元素的右侧区间值
                result[count][1] = Math.max(array[1] , result[count][1]);
            }
        }
        // System.out.println("count : " + (count+1));
        return Arrays.copyOf(result, count + 1);
    }
}
