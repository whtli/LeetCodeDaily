package tecent50.src.ts011;

/**
 * @Description
 * @Author liq
 * @Date 2022/10/03
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = {1, 1};
        int[] height = {4, 4, 2, 11, 0, 11, 5, 11, 13, 8};
        int maxArea = solution.maxArea(height);
        System.out.println(maxArea);
    }
}
