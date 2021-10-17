package algorithmPrimer14.src.day4.t557反转字符串中的单词III;

/**
 * @author liq
 * @date 2021/7/21 16:00
 * @list 20天算法刷题计划
 * @name
 */
public class Solution {
    /*    public String reverseWords(String s) {
            String result = "";
            String[] words = s.split(" ");
            for (int index = 0; index < words.length; index ++) {
                char[] arr = reverse(words[index].toCharArray());
                StringBuffer str = new StringBuffer();
                for (char ch : arr) {
                    str.append(ch);
                }
                result += str + " ";
            }
            return result.substring(0, result.length() - 1);
        }
        private char[] reverse(char[] s){
            for (int i = 0; i < s.length / 2; i ++) {
                char ch = s[i];
                s[i] = s[s.length - 1 - i];
                s[s.length - 1 - i] = ch;
            }
            return s;
        }*/
    public String reverseWords(String s) {

        String result = "";
        String[] words = s.split(" ");
        for (int index = 0; index < words.length; index++) {
            StringBuffer sb = new StringBuffer(words[index]);
            result += sb.reverse() + " ";
        }
        return result.substring(0, result.length() - 1);
    }


}
