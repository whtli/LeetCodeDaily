package interview.src.it036;

/**
 * @Description 36. 有效的数独
 * 判断一个 9 x 9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 注意：
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 * board.length == 9; board[i].length == 9; board[i][j] 是一位数字（1-9）或者 '.'
 * @Author liq
 * @Date 2021/11/23
 */
public class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        // 用数组模拟哈希set
        boolean[][] row = new boolean[10][10];
        boolean[][] col = new boolean[10][10];
        boolean[][] area = new boolean[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                int u = ch - '0';
                int idx = i / 3 * 3 + j / 3;
                if (row[i][u] || col[j][u] || area[idx][u]){
                    return false;
                }
                row[i][u] = col[j][u] = area[idx][u] = true;
            }
        }
        return true;
    }
}