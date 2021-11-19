package interview.src.it227;

import java.util.Stack;

/**
 * @Description 227.基本计算器II
 * 给定一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * @Author liq
 * @Date 2021/11/19
 */
public class Solution1 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        // 去除所有空格
        s = s.replaceAll(" ", "");
        s = s + "+";
        // 用变量 sign 记录每个数字！！！前面！！！的运算符，给第一个数字默认设置前缀+号
        // 以 3 + 2 * 2 为例，实际处理将其当作 + 3 + 2 * 2 ，便于完成循环过程中的数值处理逻辑
        char sign = '+';
        // 提前设置preNumber的初始值为0，可以防止字符串第一个字符为 负号（-）时的处理逻辑混乱
        // 开头遇到负号也可以把-preNumber = 0先压入栈中
        int preNumber = 0;
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            boolean isDigit = Character.isDigit(s.charAt(i));
            if (isDigit) {
                preNumber = preNumber * 10 + s.charAt(i) - '0';
            } else {
                // 若读到一个运算符A，按照前一个运算符B的格式对A和B之间的数字进行处理，然后压入栈中
                // 处理完该数字后，更新 sign 为当前遍历的字符。
                switch (sign) {
                    // 加号：将数字压入栈；
                    case '+':
                        stack.push(preNumber);
                        break;
                    // 减号：将数字的相反数压入栈；
                    case '-':
                        stack.push(-preNumber);
                        break;
                    // 乘号：计算栈顶元素与数字的乘积，并将栈顶元素替换为计算结果。
                    case '*':
                        stack.push(stack.pop() * preNumber);
                        break;
                    // 除号：计算栈顶元素与数字的商，并将栈顶元素替换为计算结果。
                    case '/':
                        stack.push(stack.pop() / preNumber);
                        break;
                    default:
                        break;
                }
                sign = s.charAt(i);
                preNumber = 0;
            }
        }
        int ans = 0;
        // 栈中元素累加即为该字符串表达式的值
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
