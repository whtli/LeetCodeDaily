package it171.titleToNumber;

class Solution {
    public int titleToNumber(String s) {
        int len = s.length();
        int sum = 0;
        for (int i = 0; i < len; i++){
            sum += (s.charAt(i) - 'A' + 1) * Math.pow(26, len - i - 1);
            System.out.println(Math.pow(26, len - i - 1));
            System.out.println(sum);
        }

        return sum;
    }
}
