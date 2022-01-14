package interview.src.it344;
/**
 * @Description
 * @Author liq
 * @Date
 */
public class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        if (len == 0){
            return;
        }
        String str = s.toString();
        char temp;
        for (int i = 0; i < len / 2; i++){
            temp = s[i];
            s[i] = s[len-i-1];
            s[len-i-1] = temp;
//            s[i] = s[i] + s[len - i - 1];
//            s[len - i - 1] = s[i] - s[len - i - 1];
//            s[i] = s[i] - s[len - i - 1];
        }
        System.out.print("[");
        for (int i = 0; i < len - 1; i++){
            System.out.print("\""+s[i]+"\",");
        }
        System.out.print("\""+s[len - 1]+"\"]");
    }
}
