package tecent50.src.ts020;

import java.util.Stack;

/**
 * @Description 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 1、左括号必须用相同类型的右括号闭合。
 * 2、左括号必须以正确的顺序闭合。
 * @Author liq
 * @Date 2022/05/02
 */
public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if (ch == ']' && top != '[') {
                        return false;
                    } else if (ch == ')' && top != '(') {
                        return false;
                    } else if (ch == '}' && top != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        return stack.empty();
    }
}