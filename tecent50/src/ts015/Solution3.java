package tecent50.src.ts015;

import java.util.*;

/**
 * @Description 15. 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请找出所有和为 0 且不重复的三元组。
 * @Author liq
 * @Date 2022/05/30
 */
public class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> lists = new ArrayList<>(256);
        if (n < 3 || nums[0] > 0 || nums[n - 1] < 0) {
            return lists;
        }
        // 转换成 a + b = -c
        int i, j, k;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Map<Integer, Integer>, Integer> ansHash = new HashMap<>();
        for (j = 1; j < n - 1; j++) {
            // i是中间元素，j是从0到i找元素，k是从i到n找元素
            // 即借助中间元素来缩小两侧的查找范围
            map.clear();
            for (i = 0; i < j; i++) {
                int x = nums[i] + nums[j];
                map.put(x, 1);
            }
            for (k = j + 1; k < n; k++) {
                if (k > j + 1 && nums[k] == nums[k - 1]) {
                    continue;
                }
                if (map.containsKey(-nums[k])) {
                    int a = -(nums[j] + nums[k]);
                    int b = nums[j];
                    int c = nums[k];
                    Map<Integer, Integer> t = new HashMap<>();
                    t.put(a, b);
                    if (!ansHash.containsKey(t)) {
                        ansHash.put(t, 1);
                        lists.add(Arrays.asList(new Integer[]{a, b, c}));
                    }
                }
            }
        }
        return lists;
    }
}
