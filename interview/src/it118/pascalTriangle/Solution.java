package it118.pascalTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LiQiang
 * @2020/2/25 22:09
 * @title : 杨辉三角
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if(numRows < 1){ // 判断合法性
            return triangle;
        }
        // 第一行单独处理，只有一个元素 1
        List<Integer> first = new ArrayList<>();
        first.add(1);
        triangle.add(first);

        // 处理第 2 到 n 行
        for (int rownum = 1; rownum < numRows; rownum ++){
            // 创建新的一行
            List<Integer> newrow = new ArrayList<>();
            // 获取当前新行的上一行
            List<Integer> prerow = triangle.get(rownum - 1);
            // 每一行的第一个元素是 1, 单独处理
            newrow.add(1);
            // 根据杨辉三角的特点
            // 每一行的第 2 (当 行数 > 2 时)到 “行数- 1” 个元素的值, 是它左上方和右上方的数的和
            for (int k = 1; k < rownum; k ++){
                newrow.add(prerow.get(k - 1) + prerow.get(k));
            }


            // 每一行的最后一个元素也是 1,单独处理
            newrow.add(1);
            triangle.add(newrow);
         }
        return triangle;
    }
}
