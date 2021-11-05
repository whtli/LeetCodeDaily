package interview.src.it008;

/**
 * @Description 8. 字符串转换整数 (atoi)
 * @Author liq
 * @Date 2021/11/05
 */
public class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 去空格
        String string = s.trim();
        if (string.length() == 0) {
            return 0;
        }
        int length = string.length();
        // 获取正负号
        int symbol = 1;
        if (string.charAt(0) == '-') {
            symbol = -1;
        }

        int index = 0;
        if (symbol == -1 || string.charAt(0) == '+') {
            index = 1;
        }
        System.out.println("symbol : " + symbol);
        System.out.println("index : " + index);
        StringBuilder stringBuilder = new StringBuilder();
        while (index < length && string.charAt(index) >= '0' && string.charAt(index) <= '9') {
            stringBuilder.append(string.charAt(index));
            index++;
        }
        System.out.println("stringBuilder : " + stringBuilder);
        if (stringBuilder.length() == 0) {
            return 0;
        }
        int i = 0;
        while (i < stringBuilder.length() && stringBuilder.charAt(i++) == '0') ;
        String input = stringBuilder.toString().substring(i - 1);
        long number;
        if (input.length() > 10) {
            number = Long.parseLong(input.substring(0, 11));
        } else {
            number = Long.parseLong(input);
        }

        System.out.println("number : " + number);
        System.out.println("Math.pow(2, 31) : " + ((int) (Math.pow(2, 31)) - 1));
        System.out.println(number > (int) (Math.pow(2, 31) - 1));
        if (symbol == 1 && number > ((int) (Math.pow(2, 31)) - 1)) {
            System.out.println("out top");
            return 2147483647;
        }
        if (symbol == -1 && -number < -((int) (Math.pow(2, 31)) + 1)) {
            System.out.println("out bottom");
            return -2147483648;
        }
        return (int) (symbol * number);
    }
}
