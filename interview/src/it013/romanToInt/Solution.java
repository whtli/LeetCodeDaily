package interview.src.it013.romanToInt;

/**
 * @author : flower48237
 * @2020/3/4 19:15
 * explanation: LeetCode��ѡTOP������13.��������ת����
 */
public class Solution {
    public int romanToInt(String s){

        int prenum = getVal(s.charAt(0));
        int curnum = 0;

        int sum = 0;
        for (int i = 1; i < s.length(); i ++){
            curnum = getVal(s.charAt(i));

            if (prenum < curnum){
                sum = sum - prenum;
            }else {
                sum = sum + prenum;
            }

            prenum = curnum;
        }

        sum += prenum;
        return sum;
    }
    public int getVal(char ch){
        switch(ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default: return 0;
        }
    }
}
