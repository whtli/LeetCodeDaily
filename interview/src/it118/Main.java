package interview.src.it118;

import java.util.List;

/**
 * @author : LiQiang
 * @2020/2/25 22:10
 * @title : LeetCode精选TOP面试题118.杨辉三角
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 3;
        List<List<Integer>> res =  solution.generate(x);
        System.out.print(res);
    }
}
