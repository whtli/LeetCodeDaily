package tecent50.src.ts557;

/**
 * @Description 557. 反转字符串中的单词 III
 * 给定一个字符串 s ，需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * @Author liq
 * @Date 2022/05/13
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "Hello World!";
        String rev = solution.reverseWords(s);
        System.out.println(rev);
    }
}
