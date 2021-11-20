package interview.src.it227;

import java.lang.String;

import java.util.*;

/**
 * @Description 227.基本计算器II
 * 给定一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * @Author liq
 * @Date 2021/11/19
 */
public class Solution2 {
    private int getRank(char c) {
        if (c == '*' || c == '/') {
            return 2;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        return 0;
    }

    public int calculate(String s) {
        Stack<Character> ops = new Stack<>();
        // 存储后缀表达式（逆波兰式）
        List<String> tokenList = new ArrayList<>();
        s = s.replaceAll(" ", "");
        int number = 0;
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                // 获取操作符之间的完整整数
                number = number * 10 + (ch - '0');
            } else {
                // 遇到操作符时，就可以把该操作符之前的数字作为新元素添加到逆波兰表达式的字符串中
                tokenList.add(number + "");
                // 数值清空
                number = 0;
                // 获取当前操作符op1的优先级
                int curRank = getRank(ch);
                // 持续对比op1和操作符栈的栈顶元素op2的优先级
                while (!ops.isEmpty() && getRank(ops.peek()) >= curRank) {
                    // 如果优先级顺序op2>op1，将操作符栈的栈顶元素弹出，做为新元素添加到逆波兰表达式数组中
                    tokenList.add(String.valueOf(ops.pop()));
                }
                // 把当前操作符压入操作符栈中
                ops.push(ch);
            }
        }
        // 最后一个数字加入到逆波兰序表达式数组中
        tokenList.add(String.valueOf(number));
        // 依次弹出操作符栈中的元素，加入到逆波兰序表达式数组中
        while (!ops.isEmpty()) {
            tokenList.add(String.valueOf(ops.pop()));
        }

        // 逆波兰式求解
        for (String string : tokenList) {
            System.out.print(string + " , ");
        }
        System.out.println();
        String[] tokens = new String[tokenList.size()];
        tokenList.toArray(tokens);
        return evalRPN(tokens);
    }

    /**
     * 对应 leetCode 150. 逆波兰表达式求值
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                int after = stack.pop();
                int before = stack.pop();
                stack.push(before - after);
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int after = stack.pop();
                int before = stack.pop();
                stack.push(before / after);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
