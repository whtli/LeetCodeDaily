---
title: LeetCode精选TOP面试题227.基本计算器II
copyright: true
data: 2021-11-19 21:00:00
toc: true
tags: [Java,LeetCode,栈,字符串,面试]
categories: [LeetCode]
---

### 题目描述

 * 给定一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 
```bash
example
input  : s = "3+2*2"
output : 7
input  : s = "3+2*2"
output : 1
input  : s = " 3+5 / 2 "
output : 5
```

<!--more-->

### 解题思路
**思路1：栈**

+ 基本规则 ： 乘除优先于加减计算
+ 用变量 sign 记录每个数字之前的运算符，设置默认初值0，给第一个数字设置前缀+号
+ 遍历字符串，每次从当前位置开始往后取出一个连续整数时，根据 符号（sign） 来决定计算方式，借助 **栈** 保存整数：
    - 加、减号后的数字，直接压入栈中
    - 乘、除号后的数字，与栈顶元素计算，并将栈顶元素替换为计算后的结果
+ 遍历完字符串 s 后，将栈中元素累加，即为该字符串表达式的值

+ 时间复杂度：O(n) 
+ 空间复杂度：O(n) 

**思路2：逆波兰式**
+ 遇到不同字符的处理逻辑与思路1相同
+ 只不过在遍历过程中增加了将原表达式转为逆波兰式的步骤
+ 然后使用逆波兰表达式求解的思路，同leetCode 150 

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        // 个人认为以下两步（Step1、Step2）对s的操作为投机取巧，仅方便处理，会改变原字符串。
        // 若不改变字符串s，注释 // ⭐ 处 应为 if((!isDigit && s[i] != ' ' ) || i == length - 1)

        // Step1：去除所有空格
        // 若不去除所有空格，也可在代码注释 // ⭐ 处将 else 改为 if(!isDigit && s[i] != ' ' )
        s = s.replaceAll(" ", "");
        // Step2：在数组末尾添加一个“+”号方便结束，任意负号都可以
        // 若不添加末尾符合，也可在代码注释 // ⭐ 处将 else 改为 if(!isDigit || i == length - 1)
        s = s + "+";

        // 用变量 sign 记录每个数字 前面的 运算符，给第一个数字默认设置前缀+号
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
            } else { // ⭐
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
```
**思路2代码**
```java
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
```