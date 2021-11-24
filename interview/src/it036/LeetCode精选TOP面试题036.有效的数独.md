---
title: LeetCode精选TOP面试题036.有效的数独
copyright: true
data: 2021-11-23 21:00:00
toc: true
tags: [Java,LeetCode,数组,哈希表,矩阵]
categories: [LeetCode]
---

### 题目描述

 * 判断一个 9 x 9 的数独是否有效。一个有效的数独（部分已被填充，空白格用 '.' 表示）不一定是可解的，只需要根据以下规则，验证已经填入的数字是否有效即可。
 * (1)数字 1-9 在每一行只能出现一次。
 * (2)数字 1-9 在每一列只能出现一次。
 * (3)数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * board.length == 9; board[i].length == 9; board[i][j]是数字（1-9）或 '.'
 
```bash
example
input  : board =     {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                     ,{'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                     ,{'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                     ,{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                     ,{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                     ,{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                     ,{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                     ,{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                     ,{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};                                                                                                                               
output : true
input  : board =     {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                     ,{'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                     ,{'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                     ,{'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                     ,{'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                     ,{'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                     ,{'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                     ,{'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                     ,{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};   
output : false
```

<!--more-->

### 解题思路
**思路1 暴力**
* 直接按照题目的三个要求，进行不同的有效性判定
* 摘出三个函数，分别来满足这三个要求
* checkRow() 数字 1-9 在每一行只能出现一次。
    + 按行遍历，哈希表contains()方法判定
* checkCol() 数字 1-9 在每一列只能出现一次。
    + 按列遍历，哈希表contains()方法判定
* checkBlock() 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    + 按下标规律，四重循环，挨个遍历9个面积为3 × 3的中型方格，哈希表contains()方法判定

**思路2 数组模拟HashSet**
* 定义三个数组，分别用于模拟可判断“行”、“列”、“3×3方格”是否存在重复元素的哈希Set：row[][]、col[][]、area[][]
* 还是要考虑下标规律，双重循环即可，比思路1写起来简洁
* 以 i，j，u，idx 分别表示当前访问元素的 行下标、列下标、元素值、3×3方格标号（从左到右，从上到下，依次编号为 0 ~ 8）
* 行模拟，是指判断 row[i][u] 是否为true，若为true，说明第 i 行已经有值为 u 的元素出现过了，所以重复指向了 row[i][u]
* 列模拟，是指判断 col[j][u] 是否为true，若为true，说明第 j 列已经有值为 u 的元素出现过了，所以重复指向了 col[j][u]
* 3×3方格模拟，是指判断 area[idx][u] 是否为true，若为true，说明第 idx 个方格已经有值为 u 的元素出现过了，所以重复指向了 area[idx][u]
* 在上述三个模拟过程中
    + 若遇到三者存在一个是true，即可判断为无效的数独；
    + 三者都为false时，把三者都置为true，表明在 第i行、第j列、第idx个3×3方格，已经有值为 u 的元素出现过了

### 代码（Java）
**思路1代码**
```java
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
```
**思路2代码**
```java
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
```