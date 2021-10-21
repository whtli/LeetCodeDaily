package interview.src.it066;

/**
 * @Description 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 假设除了整数 0 之外，这个整数不会以零开头
 * @Author liq
 * @Date 2021/10/21
 */
public class Main {
    public static void main(String[] args) {
        int[] digits = {2,9,9};
        Solution3 solution = new Solution3();
        int[] result = solution.plusOne(digits);
        System.out.println();
        for (int i = 0; i < result.length; i ++) {
            System.out.print(result[i]);
        }
    }
}
