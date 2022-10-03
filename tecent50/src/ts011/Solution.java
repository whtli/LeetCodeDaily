package tecent50.src.ts011;

/**
 * @Description
 * @Author liq
 * @Date 2022/10/03
 */
public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;

            }
        }
        return maxArea;
    }
}
