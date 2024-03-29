package tecent50.src.ts020;

/**
 * @Description 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 1、左括号必须用相同类型的右括号闭合。
 * 2、左括号必须以正确的顺序闭合。
 * @Author liq
 * @Date 2022/05/02
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "()";
        boolean res = solution.isValid(str);
        System.out.println(res);
    }
}
