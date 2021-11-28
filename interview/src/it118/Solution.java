package interview.src.it118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : LiQiang
 * @2020/2/25 22:09
 * @title : �������
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if(numRows < 1){ // �жϺϷ���
            return triangle;
        }
        // ��һ�е�������ֻ��һ��Ԫ�� 1
        List<Integer> first = new ArrayList<>();
        first.add(1);
        triangle.add(first);

        // ����� 2 �� n ��
        for (int rownum = 1; rownum < numRows; rownum ++){
            // �����µ�һ��
            List<Integer> newrow = new ArrayList<>();
            // ��ȡ��ǰ���е���һ��
            List<Integer> prerow = triangle.get(rownum - 1);
            // ÿһ�еĵ�һ��Ԫ���� 1, ��������
            newrow.add(1);
            // ����������ǵ��ص�
            // ÿһ�еĵ� 2 (�� ���� > 2 ʱ)�� ������- 1�� ��Ԫ�ص�ֵ, �������Ϸ������Ϸ������ĺ�
            for (int k = 1; k < rownum; k ++){
                newrow.add(prerow.get(k - 1) + prerow.get(k));
            }


            // ÿһ�е����һ��Ԫ��Ҳ�� 1,��������
            newrow.add(1);
            triangle.add(newrow);
         }
        return triangle;
    }
}
