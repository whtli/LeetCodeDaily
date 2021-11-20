---
title: LeetCode精选TOP面试题150.逆波兰表达式求值
copyright: true
data: 2021-11-20 21:00:00
toc: true
tags: [Java,LeetCode,栈,字符串,数组,面试]
categories: [LeetCode]
---

### 题目描述

 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。即表达式总会得出有效数值且不存在除数为 0 的情况。
 
```bash
example
input  : tokens = {"2","1","+","3","*"}
output : 9
note   : 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
input  : tokens = {"4","13","5","/","+"}
output : 6
note   : 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
input  : tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}
output : 22
note   : 该算式转化为常见的中缀算术表达式为：((10 * (6 / ((9 + 3) * -11))) + 17) + 5
```

<!--more-->

### 解题思路
**思路：栈**
+ 遇到数字之间压入栈中
+ 遇到运算符 OP，依次取栈顶两个元素Before、After
+ 然后根据 OP 完成运算，得到结果 R 重新压入栈顶
    * 需要注意的是减法操作时为 B - A，除法操作时为B / A，顺序不能颠倒
+ 结果返回栈顶元素
+ 好处：不会破坏原字符串数组
+ 时间复杂度O(n)
+ 空间复杂度O(n)

### 代码（Java）
**代码**
```java
public class Solution {
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
```
