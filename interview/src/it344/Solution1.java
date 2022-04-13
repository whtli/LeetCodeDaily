package interview.src.it344;

/**
 * @Description 344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * @Author liq
 * @Date 2020/03/08
 */
public class Solution1 {
    public void reverseString(char[] s) {
        int len = s.length;
        if (len == 0) {
            return;
        }
        int i = 0;
        while (i < len / 2) {
            char temp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = temp;
            i ++;
        }
    }
}
