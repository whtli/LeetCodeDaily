package other.q1629;

/**
 * @Description
 * @Author liq
 * @Date 2022/04/26
 */
public class Main {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] releaseTimes = {9,29,49,50};
        String keysPressed = "cbcd";
        char res = solution.slowestKey(releaseTimes, keysPressed);
        System.out.println(res);
    }
}
