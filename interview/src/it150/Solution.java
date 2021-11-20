package interview.src.it150;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Description 150. 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。即表达式总会得出有效数值且不存在除数为 0 的情况。
 * @Author liq
 * @Date 2021/11/20
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        List<String> ops = Arrays.asList("+", "-", "*", "/");
        for (String s : tokens) {
            if (ops.contains(s)) {
                stack.push(calculate(s, stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

    private int calculate(String op, int x, int y) {
        switch (op){
            case "+" :
                return y + x;
            case "-":
                return y - x;
            case "*" :
                return y * x;
            case "/":
                return y / x;
        }
        return 0;
    }
}
