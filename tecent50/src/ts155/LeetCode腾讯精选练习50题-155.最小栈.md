---
title: LeetCode腾讯精选练习50题-155.最小栈
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 栈
categories:
  - LeetCode
date: 2022-05-16 21:00:00
---


### 题目描述
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。

```bash
example
input  : ["MinStack","push","push","push","getMin","pop","top","getMin"]
         [[],[-2],[0],[-3],[],[],[],[]]
output : [null,null,null,null,-3,null,0,-2]
note   : MinStack minStack = new MinStack();
         minStack.push(-2);
         minStack.push(0);
         minStack.push(-3);
         minStack.getMin();   --> 返回 -3.
         minStack.pop();
         minStack.top();      --> 返回 0.
         minStack.getMin();   --> 返回 -2.
```

<!--more-->

### 解题思路

##### 思路1 维护最小值栈

+ 每次在元素栈中入栈一个元素之后，就在最小值栈中入栈一个当前元素栈中的最小值
+ 这样就可以在pop过程中同步变更两个栈，来保证每次geiMin获取的最小值都是当前元素栈中的最小值

+ `MinStack()`
    - 初始化元素栈 elem<Integer> 、最小值栈 min<Integer>
    - 最小值栈 min 中先入栈Integer.MAX_VALUE;
+ `void push(int val)`
    - elem 中入栈 val
    - 比较 min 的栈顶元素和 val 的大小，把小的入 min 栈
+ `void pop()` 
    - elem 栈顶元素出栈
    - min 栈顶元素也出栈
+ `int top()`
    - 获取 elem 栈顶元素值，但是栈顶元素不出栈
+ `int getMin()`
    - 获取 min 栈顶元素值，但是栈顶元素不出栈

+ 时间复杂度O(1)
+ 空间复杂度O(n)
##### 思路2 以数组为元素
+ 只维护一个元素栈，但栈中元素是数组，每次入栈的数组的形式为 [当前需要入栈的元素val, 当前栈顶数组元素中的第2个元素 和 当前元素val 中的较小者]
+ 这样就相当于把思路1中的两个栈，维护到了一个栈中，把元素值和当前最小值放到数组中整体入栈

+ `MinStack()`
    - 初始化元素栈 elem<int[]>
+ `void push(int val)`
    - 通过比较val 和 栈顶数组的第 2 个元素 得到 较小值 min
    - elem 中入栈 [val, min]，即 elem.push([val, Math.min(val, elem.peek()[1])])
+ `void pop()` 
    - elem 栈顶数组出栈
+ `int top()`
    - 获取 elem 栈顶数组中的第 1 个元素，但是栈顶数组不出栈
+ `int getMin()`
    - 获取 elem 栈顶数组中的第 2 个元素，但是栈顶元素不出栈

+ 时间复杂度O(1)
+ 空间复杂度O(n)
### 代码（Java）
**思路1代码**
```java
public class MinStack1 {

    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack1() {
        stack = new Stack<>();
        min = new Stack<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        if (val < min.peek()) {
            min.push(val);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

```
**思路2代码**
```java
public class MinStack2 {

    Stack<int[]> stack;

    public MinStack2() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.empty()){
            stack.push(new int[]{val, val});
        } else {
            stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

```
**思路2代码 非数组版**
```java
public class MinStack3 {

    Stack<Integer> stack;

    public MinStack3() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.empty()){
            stack.push(val);
            stack.push(val);
        } else {
            int min = stack.peek();
            stack.push(val);
            stack.push(Math.min(val, min));
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        int min = stack.pop();
        int top = stack.peek();
        stack.push(min);
        return top;
    }

    public int getMin() {
        return stack.peek();
    }
}
```