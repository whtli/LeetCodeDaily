package interview.src.it066;

import java.math.BigDecimal;

/**
 * @Description 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 假设除了整数 0 之外，这个整数不会以零开头
 * @Author liq
 * @Date 2021/10/21
 */
public class Solution1 {
    public int[] plusOne(int[] digits) {
        // solution 1 big decimal
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            stringBuilder.append(digits[i]);
        }
        BigDecimal bigDecimal = new BigDecimal(stringBuilder.toString());
        bigDecimal = bigDecimal.add(new BigDecimal(1));
        System.out.println("big decimal:" + bigDecimal);
        String string = bigDecimal.toString();
        int[] result = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            result[i] = string.charAt(i) - '0';
        }
        return result;
    }
}
