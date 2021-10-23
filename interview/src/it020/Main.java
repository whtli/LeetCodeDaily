package interview.src.it020;

/**
 * @Description 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * @Author liq
 * @Date 2021/10/23
 */
public class Main {
    public static void main(String[] args) {
        String strings = "([)]";
        Solution solution = new Solution();
        boolean result = solution.isValid(strings);
        System.out.println("result : " + result);
    }
}
