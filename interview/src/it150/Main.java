package interview.src.it150;

/**
 * @Description 150. 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。即表达式总会得出有效数值且不存在除数为 0 的情况。
 * @Author liq
 * @Date 2021/11/20
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // String[] string = {"2","1","+","3","*"};
        // String[] string = {"4","13","5","/","+"};
        // String[] string = {"4","3","-"};
        String[] string = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int result = solution.evalRPN(string);
        System.out.println(result);
    }
}
