---
    title: LeetCode腾讯精选练习50题-20.有效的括号
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 字符串
  - 栈
categories:
  - LeetCode
date: 2022-05-02 17:00:00
---


### 题目描述

 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 1、左括号必须用相同类型的右括号闭合。
 * 2、左括号必须以正确的顺序闭合。

```bash
example
input  : s = "()[]{}"
output : true
input  : s = "([)]"
output : false
input  : s = "{[]}"
output : true
```

<!--more-->

### 解题思路

+ 借助栈
+ 遍历字符串
    - 遇到左括号则入栈
    - 遇到右括号则判断栈顶元素是否可以与之配对成功
        - 若配对成功则弹出栈顶元素
        - 若配对失败则返回false
+ 遍历结束后判断栈是否为空
    - 若栈空说明全部可以匹配成功，整体是有效的括号，返回true
    - 若栈不空说明左括号有多余的，整体不是有效的括号，返回false
+ 时间复杂度：O(n)，n为字符串长度
+ 空间复杂度：O(n)，n为字符串长度

+ 可将配对元素抽出统一放到Map中，当题目扩展之后，可以简化后续遍历判断过程的代码书写（见代码Solution2），相应的，空间复杂度会随着可配对元素总数m增加，形式为O(n + m)

### 代码（Java）
```java
public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
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
```
```java
public class Solution2 {
    public boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }
        // 将配对元素抽出，如果题目拓展为不仅仅判断括号是否有效匹配
        // 如在此基础上增加了<与>可配对等等，先使用Map将配对元素定义出来可以简化后续判断过程的书写
        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.empty() || map.get(ch) != stack.peek()) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.empty();
    }
}
```