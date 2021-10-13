package it38.countAndSay;

/**
 * @author : flower48237
 * @2020/3/25 21:20
 * @title : LeetCode精选TOP面试题38.外观数列
 */
public class Solution {
    public String countAndSay(int n){
        StringBuilder str = new StringBuilder("1");
        for (int i = 2; i <= n; i ++){
            StringBuilder temp = new StringBuilder();
            int count = 1;
            char ch = str.charAt(0);
            for (int j = 1; j < str.length(); j ++){
                if (str.charAt(j) == ch) {
                    count++;
                } else {
                    temp.append("" + count + ch);
                    ch = str.charAt(j);
                    count = 1;
                }
            }
            temp.append("" + count + ch);
            str = temp;
        }
        return str.toString();
    }
}

