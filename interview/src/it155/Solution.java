package interview.src.it155;
import java.util.Stack;
/**
 * @author : flower48237
 * @2020/3/30 21:54
 * @title : LeetCode��ѡTOP������155.��Сջ
 */
class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> help;
    private int min;
    public MinStack() {
        stack = new Stack<Integer>();
        help = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }

    // ��  1
    /*public void push(int x) {
        stack.add(x);
        if (help.isEmpty() == true){
            help.add(x);
        }
        else {
            help.add(x < help.peek() ? x : help.peek());
        }
    }

    public void pop() {
        if (stack.isEmpty() == true){
            return;
        }
        stack.pop();
        help.pop();
    }

    public int top() {
        if (stack.isEmpty() == true){
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if (stack.isEmpty() == true){
            return -1;
        }
        return help.peek();
    }*/

    /**
     * Solution2
     * @param x
     */
    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */