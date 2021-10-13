package it155.minStack;

/**
 * @author : flower48237
 * @2020/3/30 21:54
 * @title : LeetCode精选TOP面试题155.最小栈
 */
public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   // 返回 -3.
        minStack.pop();
        minStack.top();      // 返回 0.
        minStack.getMin();   // 返回 -2.xiaba
    }
}
