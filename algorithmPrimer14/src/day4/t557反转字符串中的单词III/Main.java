package algorithmPrimer14.src.day4.t557反转字符串中的单词III;

/**
 * @author liq
 * @date 2021/7/21 16:00
 * @list 20天算法刷题计划
 * @name
 */
public class Main {
    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        Solution solution = new Solution();
        String result =  solution.reverseWords(str);
        System.out.println(result);
    }
}
