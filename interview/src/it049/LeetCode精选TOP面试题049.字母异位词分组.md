---
title: LeetCode精选TOP面试题049.字母异位词分组
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 字符串
  - 哈希表
  - 排序
categories:
  - LeetCode
date: 2022-02-09 17:00:00
---

### 题目描述

 * 给定一个字符串数组，将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。


```bash
example
input  : strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
output : [["bat"],["nat","tan"],["ate","eat","tea"]]
input  : strs = [""]
output : [[""]]
```

<!--more-->

### 解题思路
**思路 排序 + 哈希表**

+ 对所有字符串进行排序，可以获得有相同字母的字符串，然后把每个排序后字符串对应的原字符串归为一组即可。

+ 遍历字符串数组，用 for (String item : strings) 的方式遍历，可以不改变item本身
+ 使用字符数组 chs 获取 item ，然后对 chs 进行排序，再将排序后的 chs 放入到新的临时字符串 key 中
+ 判断 map 中是否已经存在了以key为键值的键值对
    + 若不存在则在 map 中新增以 key 为键值，以 空列表 为值的键值对
+ 为 map 中键值为 key 的键值对，进行 add 操作，将未被修改的 item 本身添加到键值对的值列表中
+ 遍历结束即可得到所有异位词分组


### 代码（Java）
```java
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List> map = new HashMap<String, List>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
```