package algorithmPrimer14.src.day1;

/**
 * @author liq
 * @date 2021/7/17 19:13
 * @list 20天算法刷题计划
 * @name 704.二分查找
 */
public class Solution {
    public int firstBadVersion(int n) {
        if (n == 0) {
            return -1;
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (middle == 0/*isBadVersion(middle)*/){
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}
