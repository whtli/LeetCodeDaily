package interview.src.it049;

import java.util.*;

/**
 * @Description 49. 字母异位词分组
 * 给定一个字符串数组，将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * @Author liq
 * @Date 2022/02/09
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new LinkedList<>();
        Map<String, List> map = new HashMap<String, List>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());

    }
}
