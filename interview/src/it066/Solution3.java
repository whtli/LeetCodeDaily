package interview.src.it066;

/**
 * @Description 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 假设除了整数 0 之外，这个整数不会以零开头
 * @Author liq
 * @Date 2021/10/21
 */
public class Solution3 {
    public int[] plusOne(int[] digits) {
        // solution 3 find the last 9 from end to start
        int length = digits.length;
        int last = length - 1;
        while (last >= 0 && digits[last] == 9) {
            last--;
        }
        if (last + 1 != length) {
            if (last == -1) {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                return result;
            } else if (last != -1) {
                digits[last]++;
                for (int i = last + 1; i < length; i++) {
                    digits[i] = 0;
                }
                return digits;
            }
        } else if (last + 1 == length) {
            digits[length - 1]++;
            return digits;
        }
        return digits;
    }
}
