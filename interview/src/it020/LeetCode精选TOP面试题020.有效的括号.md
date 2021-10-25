---
title: LeetCode精选TOP面试题20.有效的括号
copyright: true
data: 2021-10-23 21:00:00
toc: true
tags: [Java,LeetCode,字符匹配,字符串,面试]
categories: [LeetCode]
---
### 题目描述
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * ①左括号必须用相同类型的右括号闭合。
 * ②左括号必须以正确的顺序闭合。
```bash
example
input  : s = "()"
output : true
input  : s = "()[]{}"
output : true
input  : s = "([)]"
output : false
input  : s = "(]"
output : false
```
<!--more-->
### 解题思路
**借助栈**
+ 遍历字符串数组
+ 遇到左括号直接入栈
+ 遇到右括号
    + 若栈为空：直接返回false
    + 若栈不为空：获取栈顶元素是否为与其配对的左括号
        - 若匹配则栈顶元素出栈，继续循环
        - 若不匹配则返回false
### 代码（Java）
```java
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (s.charAt(i) == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (s.charAt(i) == '}') {
                if (stack.empty() || stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}

```
