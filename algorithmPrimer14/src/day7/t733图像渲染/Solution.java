package day7.t733图像渲染;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * @author liq
 * @date 2021/7/23 21:10
 * @list 20天算法刷题计划
 * @name 733. 图像渲染
 */
public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 行数
        int rolNum = image.length;
        // 列数
        int colNum = image[0].length;
        //System.out.println(rolNum + "  &  " + colNum);
        // 对起始点进行渲染
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        image[sr][sc] = newColor;
        // 对起始点的上点进行判断渲染
        if (sr > 0 && image[sr - 1][sc] == oldColor) {
            floodFill(image, sr - 1, sc, newColor);
        }
        // 对起始点的下点进行判断渲染
        if (sr < rolNum - 1 && image[sr + 1][sc] == oldColor) {
            floodFill(image, sr + 1, sc, newColor);
        }
        // 对起始点的左点进行判断渲染
        if (sc > 0 && image[sr][sc - 1] == oldColor) {
            floodFill(image, sr, sc - 1, newColor);
        }
        // 对起始点的右点进行判断渲染
        if (sc < colNum - 1 && image[sr][sc + 1] == oldColor) {
            floodFill(image, sr, sc + 1, newColor);
        }
        return image;
    }
}
