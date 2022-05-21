package tecent50.src.ts155;

import java.util.Stack;

/**
 * @Description 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * @Author liq
 * @Date 2022/05/16
 */
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
