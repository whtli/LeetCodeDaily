package interview.src.it036;

import java.util.HashSet;

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
public class Solution1 {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> hashSet = new HashSet<>();
        // 数字 1-9 在每一行只能出现一次
        if (!checkRow(board, hashSet)) {
            return false;
        }
        // 数字 1-9 在每一列只能出现一次
        if (!checkCol(board, hashSet)) {
            return false;
        }
        System.out.println();
        // 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次
        if (!checkBlock(board, hashSet)) {
            return false;
        }
        return true;
    }

    private boolean checkRow(char[][] board, HashSet hashSet) {
        // 数字 1-9 在每一行只能出现一次
        System.out.println("check row.");

        for (int i = 0; i < board.length; i++) {
            for (char item : board[i]) {
                if (item != '.' && hashSet.contains(item)) {
                    return false;
                }
                hashSet.add(item);
            }
            hashSet.clear();
        }
        return true;
    }

    private boolean checkCol(char[][] board, HashSet hashSet) {
        // 数字 1-9 在每一列只能出现一次
        System.out.println("check col.");

        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.' && hashSet.contains(board[i][j])) {
                    return false;
                }
                hashSet.add(board[i][j]);
            }
            hashSet.clear();
        }
        return true;
    }

    private boolean checkBlock(char[][] board, HashSet hashSet) {
        // 数字 1-9 在每一列只能出现一次
        System.out.println("check block.");

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int k = i; k < i + 3; ++k) {
                    for (int p = j; p < j + 3; ++p) {
                        if (board[k][p] != '.' && hashSet.contains(board[k][p])) {
                            return false;
                        }
                        hashSet.add(board[k][p]);
                    }
                }
                // 遍历完一个区域后清空哈希表
                hashSet.clear();
            }
        }
        return true;
    }
}
