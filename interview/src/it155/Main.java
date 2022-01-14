package interview.src.it155;

/**
 * @author : flower48237
 * @2020/3/30 21:54
 * @title : LeetCode��ѡTOP������155.��Сջ
 */
public class Main {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   // ���� -3.
        minStack.pop();
        minStack.top();      // ���� 0.
        minStack.getMin();   // ���� -2.xiaba
    }
}
