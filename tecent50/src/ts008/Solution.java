package tecent50.src.ts008;

/**
 * @Description 8.字符串转换整数 (atoi)
 * 实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数 myAtoi(string s) 的算法如下：
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−2^31,  2^(31 − 1)] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^(31 − 1) 的整数应该被固定为 2^(31 − 1) 。
 * 返回整数作为最终结果。
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * @Author liq
 * @Date 2022/05/29
 */
public class Solution {
    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        // 读入字符串并丢弃无用的前导空格
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        // 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。
        // 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
        boolean flag = false;
        int i = 0;
        if (s.charAt(i) == '-') {
            flag = true;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        // 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
        // 字符串的其余部分将被忽略。
        // 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。
        // 如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
        int res = 0;
        for (; i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'; i++) {

            // 如果整数数超过 32 位有符号整数范围 [−2^31,  2^(31 − 1)] ，需要截断这个整数，使其保持在这个范围内。
            // 具体来说，小于 −231 的整数应该被固定为 −2^31 ，大于 2^(31 − 1) 的整数应该被固定为 2^(31 − 1) 。
            if (!flag) {
                if (res > Integer.MAX_VALUE / 10) {
                    return Integer.MAX_VALUE;
                } else if (res == Integer.MAX_VALUE / 10) {
                    if (s.charAt(i) >= '7') {
                        return Integer.MAX_VALUE;
                    }
                }
            }
            if (flag) {
                if (-res < Integer.MIN_VALUE / 10) {
                    return Integer.MIN_VALUE;
                } else if (-res == Integer.MIN_VALUE / 10) {
                    if (s.charAt(i) >= '8') {
                        return Integer.MIN_VALUE;
                    }
                }
            }
            res = res * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return flag ? -res : res;
    }

    public int myAtoi2(String s) {
        if (s == null) {
            return 0;
        }
        // 读入字符串并丢弃无用的前导空格
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        // 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。
        // 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
        boolean flag = false;
        int i = 0;
        if (s.charAt(i) == '-') {
            flag = true;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        // 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
        // 字符串的其余部分将被忽略。
        // 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。
        // 如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        int j = i;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            i++;
        }
        if (i == j) {
            return 0;
        }

        // 如果整数数超过 32 位有符号整数范围 [−2^31,  2^(31 − 1)] ，需要截断这个整数，使其保持在这个范围内。
        // 具体来说，小于 −231 的整数应该被固定为 −2^31 ，大于 2^(31 − 1) 的整数应该被固定为 2^(31 − 1) 。
        String tmp = s.substring(j, i);
        if (tmp.length() == 10) {
            tmp = tmp.substring(0, 10);
            if (!flag && tmp.compareTo("2147483647") >= 0) {
                return Integer.MAX_VALUE;
            }
            if (flag && tmp.compareTo("2147483648") >= 0) {
                return Integer.MIN_VALUE;
            }
        }
        if (tmp.length() > 10) {
            if (!flag) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        int res = Integer.parseInt(tmp);
        return flag ? -res : res;
    }
}
