package interview.src.it242;


/**
 * @author :
 * @2020/3/10 13:28
 * explanation:
 */
public class Solution {
    public boolean isAnagram(String s,String t){
        if (t.length() != s.length()){
            return false;
        }
        /*char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Arrays.sort(sarr);
        Arrays.sort(tarr);
        return Arrays.equals(sarr,tarr);*/
        int []count = new int[26];
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a'] ++;
            count[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < 26; i++){
            System.out.println(count[i]);
            if (count[i] != 0){
                return false;
            }
        }
        return true;
    }
}
