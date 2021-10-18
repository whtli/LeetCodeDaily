package interview.src.it014;

/**
 * @Description 14.最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * @Author liq
 * @Date 2021/10/17
 */
public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        /**
         * solution2 divide and conquer
         */
        else {
            return divideAndConquer(strs, 0, strs.length - 1);
        }
    }

    private String divideAndConquer(String[] strings, int start, int end) {
        if (start == end) {
            return strings[start];
        } else {
            // 防止加法溢出
            int middle = (end - start) / 2 + start;
            String lcpLeft = divideAndConquer(strings, start, middle);
            String lcpRight = divideAndConquer(strings, middle + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int index = 0; index < minLength; index++) {
            if (lcpLeft.charAt(index) != lcpRight.charAt(index)) {
                return lcpLeft.substring(0, index);
            }
        }
        return lcpLeft.substring(0, minLength);
    }
}
