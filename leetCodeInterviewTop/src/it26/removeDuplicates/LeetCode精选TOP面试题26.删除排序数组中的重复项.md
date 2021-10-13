---
title: LeetCode��ѡTOP������26.ɾ�����������е��ظ���
copyright: true
data: 2020-05-25 19:41:00
toc: true
tags: [Java,����,����,LeetCode,����]
categories: [LeetCode]
---
### ��Ŀ����
����һ���������飬����Ҫ�� ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
��Ҫʹ�ö��������ռ䣬������� ԭ�� �޸��������� ����ʹ�� O(1) ����ռ����������ɡ�
```bash
example1:
input  : [1,1,2] 
output : [1,2]
note   : ����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2�� 
```
```bash
example2:
input  : [0,0,1,1,1,2,2,3,3,4]
output : [0,1,2,3,4]
note   : ����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��
```
<!--more-->
### ����˼·
**˼·**
˫ָ�������һ��ָ��i���ڱ������飬��һ��ָ��len�����޸����顣
��ǰԪ�ص�ֵnum[i]����ǰһ��Ԫ�ص�ֵnum[i-1]����ȵ�ʱ��num[len]��ֵ����Ϊnum[i]���Դ�ʵ�ֶ�������޸ġ�

### ���루Java��

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 1;
        for (int i = 1; i < nums.length; i++){ // �±��1��ʼ��Ϊ�˷���i-1ʱ��ֹ���������
            if (nums[i] != nums[i-1]){
                nums[len ++] = nums[i];
            }
        }
        return len;
    }
}
```
