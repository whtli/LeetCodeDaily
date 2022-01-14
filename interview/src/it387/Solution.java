package interview.src.it387;

import java.util.*;

/**
 * @author liq48237
 * @version 1.0
 * @date 2021/3/7 12:42
 */
public class Solution {
    public int firstUniqChar(String s) {
        int location = 0;
        HashSet<Character> findElement = new HashSet<>(s.length());
        for (int index = 0; index < s.length(); index ++){
            if (!findElement.contains(s.charAt(index))){
                //System.out.println(s.charAt(index));
                findElement.add(s.charAt(index));
            }
        }
        List list = new ArrayList(findElement);
        char targetElement = (char) list.get(0);
        for (location = 0; location < s.length(); location ++){
            if (s.charAt(location) == targetElement){
                break;
            }
        }
        return location;
    }
}
