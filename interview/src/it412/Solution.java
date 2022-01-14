package interview.src.it412;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : flower48237
 * @2020/3/2 13:07
 * @title : LeetCode��ѡTOP������412. Fizz Buzz
 */
public class Solution {
    public List<String> fizzBuzz(int n){
        List<String> res = new ArrayList<String>();
        StringBuffer strbuf = new StringBuffer();
        for (int i = 1; i <= n; i++){
            if (i % 3 == 0){
                strbuf.append("Fizz");
            }
            if (i % 5 == 0){
                strbuf.append("Buzz");
            }
            if (strbuf.toString().equals("")){
                strbuf.append(i + "");
            }
            res.add(strbuf.toString());
            strbuf.delete(0,strbuf.length());
        }
        return res;
    }
}
