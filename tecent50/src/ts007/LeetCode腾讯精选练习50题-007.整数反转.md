---
title: LeetCode腾讯精选练习50题-007.整数反转
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数学
  - 字符串
categories:
  - LeetCode
date: 2022-05-28 17:00:00
---


### 题目描述
 * 给定一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^(31 − 1)] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
```bash
example
input  : x = -123
output : -321
input  : x = 120
output : 21
input  : x = -2147483648
output : 0
input  : x = 1534236469
output : 0
```

<!--more-->

### 解题思路
+ 因为输入数据保证在 32 位的有符号整数的范围内，所以不需要考虑像 8463847412 这种超出本身就超出范围且反转后依然超出范围的情况 
##### 思路1 字符串
+ 借助字符串`str`接收 x ，然后反转字符串`str`，并判断输入 x 的正负性、`str`与 "2147483648"、"-2147483648"的大小关系
    + 若x为正(+)，且字符串`str`大于字符串"2147483647"，超出上界，返回0
    + 若x为负(-)，且字符串`str`大于字符串"2147483648"，超出下界，返回0
    + 正常则取其Integer值并添上符号返回
+ 时间复杂度:O(n)
+ 空间复杂度:O(n)，使用了额外的等“长”字符串
##### 思路2 让步比大小
+ “让步”的意思是在数值超出32位整形范围之前就把它判断出来，即用最大值/10和最小值/10的范围作为临时上下界来防止完全反转后的越界

+ 先统一转换成正数
    + 用整形变量`res`（初始值为0）不断扩大十倍并加上当前`x%10`得到的数，然后将`x/10`去掉它的末尾数值
    + 在执行以上操作之前，先判断一下当前的`res`是否大于32位整型变量的最大值Integer.MAX_VALUE/10，若是则说明完全的反转后肯定会越界，不必继续操作，直接按要求返回0即可
    + 当x减小到0的时候，判断原始的符号位，并给结果`res`添加上，然后返回
+ 不转换正数，统一判断
    + 用整形变量`res`（初始值为0）不断扩大十倍并加上当前`x%10`得到的数，然后将`x/10`去掉它的末尾数值
    + 在执行以上操作之前，先判断一下以下两条，若满足则说明完全的反转后肯定会越界，不必继续操作，直接按要求返回0即可
        + 当前的`res`是否大于32位整型变量的最大值Integer.MAX_VALUE / 10
        + 当前的`res`是否小于32位整型变量的最小值Integer.MIN_VALUE / 10
    + 当x等于0的时候，返回`res`即可（不需要在判断符号位了）

+ 时间复杂度:O(log(n))
+ 空间复杂度:O(1)，只使用了有限个整型变量

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE){
            // 因为输入保证为32位整数，所以不需要考虑更小的数值，判断到Integer的最小值即可
            return 0;
        }
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        StringBuilder s = new StringBuilder(x + "");
        String str = s.reverse().toString();
        if (s.length() >= 10) {
            if (!flag && str.compareTo("2147483647") > 0) {
                return 0;
            }
            if (flag && str.compareTo("2147483648") > 0) {
                return 0;
            }
        }
        return flag ? -Integer.parseInt(str) : Integer.parseInt(str);
    }
}

```
**思路2代码**
```java
public class Solution2 {
    public int reverse(int x) {
        if (x < 0 && x == -x) {
            return 0;
        }
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        int y = 0;
        while (x > 0) {
            if (y > Integer.MAX_VALUE / 10) {
                return 0;
            }
            y = y * 10 + x % 10;
            x /= 10;
        }
        return flag ? -y : y;
    }
    // 以下为简化代码
    public int reverse2(int x) {
        int y = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        while (x != 0) {
            if (y > max || y < min) {
                return 0;
            }
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y;
    }
}
```