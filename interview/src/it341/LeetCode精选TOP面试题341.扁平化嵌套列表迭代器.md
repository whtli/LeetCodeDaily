---
title: LeetCode精选TOP面试题341.扁平化嵌套列表迭代器
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 栈
  - 队列
  - DFS
categories:
  - LeetCode
date: 2022-03-01 22:00:00
---


### 题目描述

 * 给定一个嵌套的整数列表 nestedList 。
 * 每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。
 * 实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
 *
 * 实现扁平迭代器类 NestedIterator ：
 * NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。
 * int next() 返回嵌套列表的下一个整数。
 * boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。
 * 
 * 代码将会用下述伪代码检测：
 ```bash
 initialize iterator with nestedList
 res = []
 while iterator.hasNext()
     append iterator.next() to the end of res
 return res
 ```
 * 如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。

```bash
example
input  : nestedList = [[1,1],2,[1,1]]
output : [1,1,2,1,1]
input  : nestedList = [1,[4,[6]]]
output : [1,4,6]
```

<!--more-->

### 解题思路

+ 本质上与树的遍历相同，嵌套列表可看作一棵树，其中数值元素就是叶子节点，列表元素就是非叶子节点
+ nestedList = [[1,1],2,[1,1]] 可画图为
    ```bash
      nestedList
       /   |   \
    list1  2   list2
     / \        / \
    1   1      1   1
    ```
+ nestedList = [1,[4,[6]]] 可画图为
    ```bash
      nestedList
        /   \
       1   list2
            / \
           4  list3
              /
             6
    ```

**思路1 队列+DFS+递归**

+ NestedIterator(List<NestedInteger> nestedList)：
    + 调用自定义的 深度优先搜索函数 dfs()，把输入的 nestedList 遍历一遍，并把所有数值元素逐个添加到队列 queue 中

+ hasNext()：
    + 调用isEmpty()方法判断队列 queue 是否为空，
    + 若不为空则仍然存在待迭代的整数，返回 true ；否则，返回 false 
    
+ next()： 
    + 调用hashNext()判断是否存在下一个 整数，
    + 若存在，队列的队首元素并返回，若不存在则返回 -1。

+ dfs(List<NestedInteger> nestedList):
    遍历 nestedList，如果是整数，则把该整数添加到队列末尾，如果是列表 list，则递归调用dfs，传入参数为当前列表 list

**思路2 栈+递归**

+ NestedIterator(List<NestedInteger> nestedList)：
    + 调用自定义的 pushStack() 方法，倒序遍历列表 nestedList，实现列表元素入栈

+ hasNext()：
    + 若当前栈空，则返回false
    + 否则判断栈顶元素是否为整数
        + 若是整数则返回true
        + 若是列表则将栈顶列表 item 弹出栈，后续操作同 NestedIterator，然后递归调用 hasNext() 本身
    
+ next()： 
    + 调用hashNext()判断是否存在下一个 整数，
    + 若存在，弹出栈顶元素并返回，若不存在则返回 -1。
    
+ pushStack(List<NestedInteger> nestedList):
    + 倒序遍历列表 nestedList，把当前列表元素（不考虑其类型为Integer还是List）依次到栈顶

### 代码（Java）
**思路1代码**
```java
public class NestedIterator1 implements Iterator<Integer> {
    private Deque<Integer> queue = new ArrayDeque<>();

    private void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                queue.addLast(nest.getInteger());
            } else {
                dfs(nest.getList());
            }
        }
    }

    public NestedIterator1(List<NestedInteger> nestedList) {
        dfs(nestedList);
    }

    @Override
    public Integer next() {
        return hasNext() ? queue.pollFirst() : -1;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
```
**思路2代码**
```java
public class NestedIterator2 implements Iterator<Integer> {
    private Stack<NestedInteger> stack = new Stack<>();

    private void pushStack(List<NestedInteger> list) {
        for (int index = list.size() - 1; index >= 0; index--) {
            stack.add(list.get(index));
        }
    }

    public NestedIterator2(List<NestedInteger> nestedList) {
        pushStack(nestedList);
    }

    @Override
    public Integer next() {
        return hasNext() ? stack.pop().getInteger() : -1;
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        } else {
            NestedInteger item = stack.peek();
            if (item.isInteger()) {
                return true;
            } else {
                item = stack.pop();
                List<NestedInteger> list = item.getList();
                pushStack(list);
                return hasNext();
            }
        }
    }
}
```