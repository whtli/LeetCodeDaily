package interview.src.it066;

/**
 * @Description 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 假设除了整数 0 之外，这个整数不会以零开头
 * @Author liq
 * @Date 2021/10/21
 */
public class Solution2 {
    public int[] plusOne(int[] digits) {
        // solution 2 compute one by one
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < digits.length; i ++) {
            stringBuilder.append(digits[i]);
        }
        int add = stringBuilder.charAt(stringBuilder.length() - 1) - '0' + 1;
        if (add != 10) {
            stringBuilder.setCharAt(stringBuilder.length() - 1,String.valueOf(add).charAt(0));
        } else {
            if (stringBuilder.length() == 1) {
                int[] result = {1,0};
                return result;
            } else if (stringBuilder.length() >= 1){
                stringBuilder.setCharAt(stringBuilder.length() - 1,'0');
                for (int j = stringBuilder.length() - 2; j >= 0; j --) {
                    add = stringBuilder.charAt(j) - '0' + 1;
                    if (add == 10) {
                        stringBuilder.setCharAt(j, '0');
                        continue;
                    } else {
                        stringBuilder.setCharAt(j, String.valueOf(add).charAt(0));
                        break;
                    }
                }
            }
        }
        if(add == 10){
            int[] result = new int[stringBuilder.length() + 1];
            result[0] = 1;
            for (int k = 1; k < result.length; k ++) {
                result[k] = stringBuilder.charAt(k - 1) - '0';
                System.out.print(result[k]);
            }
            return result;
        } else {
            int[] result = new int[stringBuilder.length()];
            for (int k = 0; k < result.length; k ++) {
                result[k] = stringBuilder.charAt(k) - '0';
                System.out.print(result[k]);
            }
            return result;
        }
    }
}
