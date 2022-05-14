package tecent50.src.ts169;

import java.util.*;

/**
 * @Description 169.多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @Author liq
 * @Date 2022/05/14
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i : nums){
            int cnt = map.containsKey(i) ? map.get(i) + 1 : 1;
            map.put(i, cnt);
        }
        int max = map.firstKey();
        for (Integer key : map.keySet()) {
            // System.out.println("key= " + key + " and value= " + map.get(key));
            if (map.get(key) > map.get(max)){
                max = key;
            }
        }
        return max;
    }
}
