package interview.src.it008;

/**
 * @Description 8. 字符串转换整数 (atoi)
 * 实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数 myAtoi(string s) 的算法如下：
 * 1、读入字符串并丢弃无用的前导空格
 * 2、检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 3、读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 4、将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 5、如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 6、返回整数作为最终结果。
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
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
