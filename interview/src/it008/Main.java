package interview.src.it008;

/**
 * @Description
 * @Author liq
 * @Date 2021/11/05
 */
public class Main {
    public static void main(String[] args) {
        String string = "  00000000000000000";
        Solution solution = new Solution();
        int res = solution.myAtoi(string);
        System.out.println(res);

    }
}
