---
title: LeetCode精选TOP面试题230.二叉搜索树中第K小的元素
copyright: true
data: 2021-11-29 21:00:00
toc: true
tags: [Java,LeetCode,树,二叉树,二叉搜索树,DFS,中序遍历,面试]
categories: [LeetCode]
---

### 题目描述

 * 给定一个二叉搜索树的根节点 root ，和一个整数 k
 * 设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
```bash
example
input  : root = [3,1,4,null,2], k = 1
output : 1
note   :    3
           / \
          1   4
           \
            2
input  : root = [5,3,6,2,4,null,null,1], k = 3
output : 3
note   :         5
                / \
               3   6
              /  \
             2    4
            /
           1
```

<!--more-->

### 解题思路
**思路1 直接中序遍历全部节点**

+ 直接递归，中序遍历整个树
+ 递归过程中把节点值依次存放到列表中
+ 因为二叉搜索树的中序遍历结果是升序的，所以直接返回列表的第k个元素值即可
+ 时间复杂度：O(H+k)，H 是树的高度。在开始遍历之前，需要 O(H)到达叶结点。当树是平衡树时，时间复杂度取得最小值 O(logN+k)；当树是线性树（树中每个结点都只有一个子结点或没有子结点）时，时间复杂度取得最大值 O(N+k)。
+ 空间复杂度：O(H)，栈中最多需要存储 H 个元素。当树是平衡树时，空间复杂度取得最小值 O(logN)；当树是线性树时，空间复杂度取得最大值 O(N)。

**思路2 栈模拟中序遍历前k个节点**

+ 为减少遍历次数，优化思路是不要遍历整个的树，利用二叉搜索树的性质，遍历到目标元素时就停止
+ 用栈模拟递归过程，中序遍历前k个节点
+ 每次（假设当前是第 i 次）栈顶节点出栈，说明栈顶节点是整个树中的第 i 个小的值（二叉搜索时的中序遍历性质决定） 
+ 直接跳出遍历，返回最后一次弹出栈的节点值即可
+ 时间复杂度：O(H+k)，H 是树的高度。在开始遍历之前，需要 O(H)到达叶结点。当树是平衡树时，时间复杂度取得最小值 O(logN+k)；当树是线性树（树中每个结点都只有一个子结点或没有子结点）时，时间复杂度取得最大值 O(N+k)。
+ 空间复杂度：O(H)，栈中最多需要存储 H 个元素。当树是平衡树时，空间复杂度取得最小值 O(logN)；当树是线性树时，空间复杂度取得最大值 O(N)。

**思路3 记录子树的结点数**

+ 如果需要频繁地查找第 k 小的值，优化思路是记录下以每个结点为根结点的子树的结点数，在查找第 k 小的值时，不断缩小查找范围 
+ 令 node 等于根结点，开始搜索
+ 记 node 的左子树的结点数为 left 
+ 若 left 小于 k-1，则第 k 小的元素一定在 node 的右子树中，令 node 等于其的右子结点，k 更新为 k−left−1，继续搜索；
+ 若 left 等于 k-1，则第 k 小的元素即为 node ，结束搜索并返回 node 即可；
+ 若 left 大于 k-1，则第 k 小的元素一定在 node 的左子树中，令 node 等于其左子结点，继续搜索。
+ 时间复杂度：预处理的时间复杂度为 O(N)，其中 N 是树中结点的总数；需要遍历树中所有结点来统计以每个结点为根结点的子树的结点数。搜索的时间复杂度为 O(H)，其中 HH 是树的高度；当树是平衡树时，时间复杂度取得最小值 O(logN)；当树是线性树时，时间复杂度取得最大值 O(N)。
+ 空间复杂度：O(N)，用于存储以每个结点为根结点的子树的结点数。

**[思路3参考了LeetCode官方题解](https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/er-cha-sou-suo-shu-zhong-di-kxiao-de-yua-8o07/)**

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        // 中序遍历，DFS
        DFS(root);
        for (int i : list) {
            System.out.print(i + " ");
        }
        return list.get(k - 1);
    }

    private void DFS(TreeNode root) {
        if (root == null) {
            return;
        }
        DFS(root.left);
        list.add(root.val);
        DFS(root.right);
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public int kthSmallest(TreeNode root, int k) {
        // 用栈模拟实现中序遍历
        Stack<TreeNode> stack = new Stack<>();
        // 需要保证从最小的元素作为第一个入栈元素，所以不能在循环外把根节点压入栈，故循环的边界条件添加了||root!=null条件
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val + " ");
            k--;
            // 第k个弹出栈的节点，其值一定为第k小的
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
```
**思路3代码**
```java
public class Solution3 {
    public int kthSmallest(TreeNode root, int k) {
        MyBst myBst = new MyBst(root);
        return myBst.kthSmallest(k);
    }
}

class MyBst {
    TreeNode root;
    Map<TreeNode, Integer> nodeNumber;

    public MyBst(TreeNode root) {
        this.root = root;
        this.nodeNumber = new HashMap<TreeNode, Integer>();
        countNumber(root);
    }

    // 统计以node为根结点的子树的结点数
    private int countNumber(TreeNode node) {
        if (node == null) {
            return 0;
        }
        nodeNumber.put(node, countNumber(node.left) + countNumber(node.right) + 1);
        return nodeNumber.get(node);
    }

    // 返回二叉搜索树中第k小的元素
    public int kthSmallest(int k) {
        TreeNode node = root;
        while (node != null) {
            int left = getNumber(node.left);
            if (left == k - 1) {
                break;
            } else if (left > k - 1) {
                node = node.left;
            } else {
                node = node.right;
                k = k - left - 1;
            }
        }
        return node.val;
    }

    private int getNumber(TreeNode node) {
        return nodeNumber.getOrDefault(node, 0);
    }
}
```