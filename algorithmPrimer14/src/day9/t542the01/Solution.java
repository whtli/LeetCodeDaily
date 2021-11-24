package algorithmPrimer14.src.day9.t542the01;

/**
 * @author liq
 * @date 2021/7/26 18:54
 * @list 20天算法刷题计划
 * @name
 */
public class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rowNum = mat.length;
        int colNum = mat[0].length;
        int[][] distinct = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (mat[i][j] == 0) {
                    distinct[i][j] = 0;
                } else {
                    distinct[i][j] = getDistinct(mat, i, j, rowNum, colNum);
                }
            }
        }
        return distinct;
    }

    private int getDistinct(int[][] mat, int sr, int sc, int rowNum, int colNum) {
        int upDistinct = 0;
        int downDistinct = 0;
        int leftDistinct = 0;
        int rightDistinct = 0;

        if (mat[sr][sc] == 0) {
            return 1;
        }
        else {
            if (sr > 0) {
                upDistinct += getDistinct(mat, sr - 1, sc, rowNum, colNum);
            }
            if (sr < rowNum - 1) {
                downDistinct += getDistinct(mat, sr + 1, sc, rowNum, colNum);
            }
            if (sc > 0) {
                leftDistinct += getDistinct(mat, sr, sc - 1, rowNum, colNum);
            }
            if (sc < colNum - 1) {
                rightDistinct += getDistinct(mat, sr, sc + 1, rowNum, colNum);
            }
        }


        int minDistinct = 0;
        minDistinct = upDistinct < downDistinct ? upDistinct : downDistinct;
        minDistinct = minDistinct < leftDistinct ? minDistinct : leftDistinct;
        minDistinct = minDistinct < rightDistinct ? minDistinct : rightDistinct;
        return minDistinct;
    }
}
