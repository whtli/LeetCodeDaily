package other.q1629;

/**
 * @Description
 * @Author liq
 * @Date 2022/04/26
 */
public class Solution2 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int resKey = 0;
        int maxTime = releaseTimes[0];
        int len = releaseTimes.length;
        for (int i = 1; i < len; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            int sub = keysPressed.charAt(i) - keysPressed.charAt(resKey);
            if (time > maxTime || (time == maxTime && sub > 0)) {
                resKey = i;
                maxTime = time;
            }
        }
        return keysPressed.charAt(resKey);
    }
}
