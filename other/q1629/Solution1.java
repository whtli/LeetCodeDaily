package other.q1629;

/**
 * @Description
 * @Author liq
 * @Date 2022/04/26
 */
public class Solution1 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char resKey = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        int len = releaseTimes.length;
        // System.out.println("char: " + resKey + ", time: " + maxTime);
        for (int i = 1; i < len; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            // System.out.println("char: " + cur + ", time: " + time);
            // if的后半段，比较当前字符与当前最长持续时间字符的字母序大小的时候
            // 为了美观可以提前把当前字符定义在if前面，然后放到if的后半段比较，但是这样会浪费测试时间
            // 测试结果表明，提前定义运行时间为1s，不定义运行时间为0s
            // 用到的时候才比较字母序，取当前字符，用不到的时候提前定义就是浪费资源
            if (time > maxTime || (time == maxTime && keysPressed.charAt(i) > resKey)) {
                resKey = keysPressed.charAt(i);
                maxTime = time;
            }
        }
        return resKey;
    }
}
