package algorithmPrimer14.src.day3.t167;

/**
 * @author liq
 * @date 2021/7/19 10:54
 * @list 20天算法刷题计划
 * @name 167.两数之和 II - 输入有序数组
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            if (numbers[left] + numbers[right] == target){
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (numbers[left] + numbers[right] > target) {
                -- right;
            } else {
                ++ left;
            }
        }
        System.out.println(result[0]+", "+ result[1]);
        return result;
    }
}
